package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Character Deletion Class.
 *
 */
public class CharactersDeletion {
	/** Wizard search result constant */
	private static final int WIZARD_FOUND = 1;

	/** Warrior search result constant */
	private static final int WARRIOR_FOUND = 2;

	/** No search result constant */
	private static final int NO_MATCH_FOUND = 0;

	/** Input constant */
	private static final String EMPTY_STRING = "";

	/**
	 * Search by name through the characters lists and deletes selected character.
	 *
	 * @param warriors the ArrayList containing Warriors Objects.
	 * @param wizards  the ArrayList containing Wizards Objects.
	 * @param scanner  a Scanner Object used to get inputs.
	 *
	 */
	public static void characterDeletion(ArrayList<Warrior> warriors, ArrayList<Wizard> wizards, Scanner scanner) {

		/** Search result, index of found object */
		int result_index;

		/** Search result array, contains [match_status, match_index] */
		int[] result_match_index = new int[2];

		/** Search result, match type (Warrior/Wizard/None) */
		int match_found = NO_MATCH_FOUND;

		while (true) {

			System.out.println("Quel personnage souhaitez-vous supprimer ? Valider un champ vide pour quitter.");
			String input = scanner.nextLine();

			if (input.equals(EMPTY_STRING)) {
				System.out.println("Retour au menu précédent.");
				break;
			}

			result_match_index = CharacterSearch.characterSearch(wizards, warriors, input);
			match_found = result_match_index[0];
			result_index = result_match_index[1];

			if (match_found == NO_MATCH_FOUND) {
				System.out.println("Aucun personnage avec ce nom n'a été trouvé.");
				continue;
			} else {
				deleteCharacter(warriors, wizards, scanner, result_index, match_found);
			}
		}
	}

	private static void deleteCharacter(ArrayList<Warrior> warriors, ArrayList<Wizard> wizards, Scanner scanner,
			int result_index, int match_found) {
		String input;
		boolean confirmation_command_ok = false;
		while (!confirmation_command_ok) {

			System.out.println("Confirmer la suppression ? OUI ou NON");
			input = scanner.nextLine();

			if (input.equals("OUI")) {

				if (match_found == WIZARD_FOUND) {
					wizards.remove(result_index);

				} else if (match_found == WARRIOR_FOUND) {
					warriors.remove(result_index);
				}

				System.out.println("Personnage supprimé !");
				confirmation_command_ok = true;

			} else if (input.equals("NON")) {

				System.out.println("Opération annulée.");
				confirmation_command_ok = true;

			} else {
				System.out.println("Commande non reconnue.");
			}
		}
	}
}
