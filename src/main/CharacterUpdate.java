package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Character Updating class.
 * 
 */

public class CharacterUpdate {

	/** Wizard search result constant */
	private static final int WIZARD_FOUND = 1;

	/** Warrior search result constant */
	private static final int WARRIOR_FOUND = 2;

	/** No search result constant */
	private static final int NO_MATCH_FOUND = 0;

	/** Input constant */
	private static final String EMPTY_STRING = "";

	/** Input constant */
	private static final String URL_IMAGE = "U";

	/** Input constant */
	private static final String NAME = "N";

	/** Input constant */
	private static final String LIFE = "V";

	/** Input constant */
	private static final String ATTACK_POWER = "F";

	/** Input constant */
	private static final String RETURN = "R";

	/**
	 * Search by name through the characters lists and allow to update found
	 * character informations.
	 *
	 * @param warriors the ArrayList containing Warriors Objects.
	 * @param wizards  the ArrayList containing Wizards Objects.
	 * @param scanner  a Scanner Object used to get inputs.
	 *
	 */
	public static void characterUpdate(ArrayList<Warrior> warriors, ArrayList<Wizard> wizards, Scanner scanner) {

		/** Search result, index of found object */
		int result_index;

		/** Integer input */
		int int_input;

		/** Search result array, contains [match_status, match_index] */
		int[] result_match_index = new int[2];

		/** Search result, match type (Warrior/Wizard/None) */
		int match_found = NO_MATCH_FOUND;

		while (true) {

			System.out.println("Quel personnage souhaitez-vous modifier ? Valider un champ vide pour quitter.");
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

				System.out.println(
						"Quel champ souhaitez-vous modifier ?\n(N)om\n(V)ie\n(F)orce d'attaque\n(U)rl d'image\n(R)etour");
				input = scanner.nextLine();

				if (input.equals(RETURN)) {
					System.out.println("Retour.");

				} else if (input.equals(NAME)) {

					System.out.println("Entrez un nouveau nom :");
					input = scanner.nextLine();

					if (match_found == WIZARD_FOUND) {
						wizards.get(result_index).setName(input);

					} else if (match_found == WARRIOR_FOUND) {
						warriors.get(result_index).setName(input);
					}

				} else if (input.equals(LIFE)) {

					System.out.println("Entrez une nouvelle valeur de vie :");
					int_input = scanner.nextInt();

					if (match_found == WIZARD_FOUND) {
						wizards.get(result_index).setLife(int_input);

					} else if (match_found == WARRIOR_FOUND) {
						warriors.get(result_index).setLife(int_input);
					}
					scanner.nextLine();

				} else if (input.equals(ATTACK_POWER)) {

					System.out.println("Entrez une nouvelle valeur de puissance d'attaque :");
					int_input = scanner.nextInt();

					if (match_found == WIZARD_FOUND) {
						wizards.get(result_index).setAttackPower(int_input);

					} else if (match_found == WARRIOR_FOUND) {
						warriors.get(result_index).setAttackPower(int_input);
					}
					scanner.nextLine();

				} else if (input.equals(URL_IMAGE)) {
					System.out.println("Entrez une nouvelle URL d'image :");
					input = scanner.nextLine();

					if (match_found == WIZARD_FOUND) {
						wizards.get(result_index).setImageUrl(input);

					} else if (match_found == WARRIOR_FOUND) {
						warriors.get(result_index).setImageUrl(input);
					}
				}
			}
			System.out.println("Modification enregistrée !");
		}
	}
}
