package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Character Updating class.
 * 
 */

public class CharacterUpdate implements SearchConstInterface, CharacterConstInterface {

	public interface CharacterUpdateInterface {
		/** Input constant */
		static final String URL_IMAGE = "U";
		/** Input constant */
		static final String NAME = "N";
		/** Input constant */
		static final String LIFE = "V";
		/** Input constant */
		static final String ATTACK_POWER = "F";
		/** Input constant */
		static final String RETURN = "R";
	}

	private CharacterUpdate() {
	}

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
		int result_index = 0;

		/** Integer input */
		int int_input = 0;

		/** Search result array, contains [match_status, match_index] */
		int[] result_match_index = new int[2];

		/** Search result, match type (Warrior/Wizard/None) */
		int match_found = NO_MATCH_FOUND;

		while (true) {

			String input = askForCharacterName(scanner);

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

				input = askForUpdateFieldSelection(scanner);

				if (input.equals(CharacterUpdateInterface.RETURN)) {
					System.out.println("Retour.");

				} else if (input.equals(CharacterUpdateInterface.NAME)) {

					updateName(warriors, wizards, scanner, result_index, match_found);

				} else if (input.equals(CharacterUpdateInterface.LIFE)) {

					updateLife(warriors, wizards, scanner, result_index, int_input, match_found);

				} else if (input.equals(CharacterUpdateInterface.ATTACK_POWER)) {

					updateAttackPower(warriors, wizards, scanner, result_index, int_input, match_found);

				} else if (input.equals(CharacterUpdateInterface.URL_IMAGE)) {

					udpateImageURL(warriors, wizards, scanner, result_index, match_found);
				}
			}
			System.out.println("Modification enregistrée !");
		}
	}

	/**
	 * Asks for which field to update on the found character.
	 * 
	 * @param scanner Scanner object to get Input
	 * @return String containing the selected field
	 */
	private static String askForUpdateFieldSelection(Scanner scanner) {
		String input;
		System.out.println(
				"Quel champ souhaitez-vous modifier ?\n(N)om\n(V)ie\n(F)orce d'attaque\n(U)rl d'image\n(R)etour");
		input = scanner.nextLine();
		return input;
	}

	/**
	 * Asks for which character to update.
	 * 
	 * @param scanner Scanner object to get Input
	 * @return String containing the character name in order to research.
	 */
	private static String askForCharacterName(Scanner scanner) {
		System.out.println("Quel personnage souhaitez-vous modifier ? Valider un champ vide pour quitter.");
		String input = scanner.nextLine();
		return input;
	}

	/**
	 * Updates the selected character's ImageURL.
	 * 
	 * @param warriors     ArrayList object containing warriors objects
	 * @param wizards      ArrayList object containing wizards objects
	 * @param scanner      Scanner object to get Input of the new URL.
	 * @param result_index index of the found character
	 * @param match_found  ArrayList of the found character
	 */
	private static void udpateImageURL(ArrayList<Warrior> warriors, ArrayList<Wizard> wizards, Scanner scanner,
			int result_index, int match_found) {
		String input;
		System.out.println("Entrez une nouvelle URL d'image :");
		input = scanner.nextLine();

		if (match_found == WIZARD_FOUND) {
			wizards.get(result_index).setImageUrl(input);

		} else if (match_found == WARRIOR_FOUND) {
			warriors.get(result_index).setImageUrl(input);
		}
	}

	/**
	 * Updates the selected character's attack power.
	 * 
	 * @param warriors     ArrayList object containing warriors objects
	 * @param wizards      ArrayList object containing wizards objects
	 * @param scanner      Scanner object to get Input of the new attack power.
	 * @param result_index index of the found character
	 * @param match_found  ArrayList of the found character
	 */
	private static void updateAttackPower(ArrayList<Warrior> warriors, ArrayList<Wizard> wizards, Scanner scanner,
			int result_index, int int_input, int match_found) {
		boolean AP_ok = false;
		while (!AP_ok) {
			System.out.println("Entrez une nouvelle valeur de puissance d'attaque (Warrior: 5 à 10, Wizard 8 à 15):");
			try {
				int_input = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Mauvais format d'entrée. Recommencez.");
				continue;
			}
			if (match_found == WIZARD_FOUND) {
				if (Math.min(WIZARD_MAX_ATTACK_POWER, Math.max(int_input, WIZARD_MIN_ATTACK_POWER)) == int_input) {
					wizards.get(result_index).setAttackPower(int_input);
					AP_ok = true;
				} else {
					System.out.println("Paramètre invalide, recommencez.");
				}
			} else if (match_found == WARRIOR_FOUND) {
				if (Math.min(WARRIOR_MAX_ATTACK_POWER, Math.max(int_input, WARRIOR_MIN_ATTACK_POWER)) == int_input) {
					warriors.get(result_index).setAttackPower(int_input);
					AP_ok = true;
				} else {
					System.out.println("Paramètre invalide, recommencez.");
				}
			}
			scanner.nextLine();
		}
	}

	/**
	 * Updates the selected character's life.
	 * 
	 * @param warriors     ArrayList object containing warriors objects
	 * @param wizards      ArrayList object containing wizards objects
	 * @param scanner      Scanner object to get Input of the new life.
	 * @param result_index index of the found character
	 * @param match_found  ArrayList of the found character
	 */
	private static void updateLife(ArrayList<Warrior> warriors, ArrayList<Wizard> wizards, Scanner scanner,
			int result_index, int int_input, int match_found) {
		boolean life_ok = false;
		while (!life_ok) {
			System.out.println("Entrez une nouvelle valeur de vie (Warrior: 5 à 10, Wizard 3 à 6):");
			try {
				int_input = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Mauvais format d'entrée. Recommencez.");
				continue;
			}
			if (match_found == WIZARD_FOUND) {
				if (Math.min(WIZARD_MAX_LIFE, Math.max(int_input, WIZARD_MIN_LIFE)) == int_input) {
					wizards.get(result_index).setLife(int_input);
					life_ok = true;
				} else {
					System.out.println("Paramètre invalide, recommencez.");
				}
			} else if (match_found == WARRIOR_FOUND) {
				if (Math.min(WARRIOR_MAX_LIFE, Math.max(int_input, WARRIOR_MIN_LIFE)) == int_input) {
					warriors.get(result_index).setLife(int_input);
					life_ok = true;
				} else {
					System.out.println("Paramètre invalide, recommencez.");
				}
			}
			scanner.nextLine();
		}
	}

	/**
	 * Updates the selected character's name.
	 * 
	 * @param warriors     ArrayList object containing warriors objects
	 * @param wizards      ArrayList object containing wizards objects
	 * @param scanner      Scanner object to get Input of the new name.
	 * @param result_index index of the found character
	 * @param match_found  ArrayList of the found character
	 */
	private static void updateName(ArrayList<Warrior> warriors, ArrayList<Wizard> wizards, Scanner scanner,
			int result_index, int match_found) {
		String input;
		System.out.println("Entrez un nouveau nom :");
		input = scanner.nextLine();

		if (match_found == WIZARD_FOUND) {
			wizards.get(result_index).setName(input);

		} else if (match_found == WARRIOR_FOUND) {
			warriors.get(result_index).setName(input);
		}
	}
}
