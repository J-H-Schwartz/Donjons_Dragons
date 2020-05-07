package menus;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

/**
 * Character Updating class.
 * 
 */

public class CharacterUpdate implements CharacterUpdateInterface {

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

	/**
	 * Search by name through the characters lists and allow to update found
	 * character informations.
	 *
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param scanner        a Scanner Object used to get inputs.
	 *
	 */
	@Override
	public void characterUpdate(ArrayList<Character> charactersList, Scanner scanner) {

		/** Search result, index of found object */
		int resultIndex = 0;

		/** Integer input */
		int intInput = 0;

		while (true) {

			String input = askForCharacterName(scanner);

			if (input.isEmpty()) {
				System.out.println("Retour au menu précédent.");
				break;
			}

			CharacterSearchInterface charSearch = new CharacterSearch();
			resultIndex = charSearch.characterSearch(charactersList, input);

			if (resultIndex == -1) {
				System.out.println("Aucun personnage avec ce nom n'a été trouvé.");
				continue;

			} else {

				input = askForUpdateFieldSelection(scanner);

				if (input.equals(RETURN)) {
					System.out.println("Retour.");

				} else if (input.equals(NAME)) {

					updateName(charactersList, scanner, resultIndex);

				} else if (input.equals(LIFE)) {

					updateLife(charactersList, scanner, resultIndex, intInput);

				} else if (input.equals(ATTACK_POWER)) {

					updateAttackPower(charactersList, scanner, resultIndex, intInput);

				} else if (input.equals(URL_IMAGE)) {

					udpateImageURL(charactersList, scanner, resultIndex);
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
	private String askForUpdateFieldSelection(Scanner scanner) {
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
	private String askForCharacterName(Scanner scanner) {
		System.out.println("Quel personnage souhaitez-vous modifier ? Valider un champ vide pour quitter.");
		String input = scanner.nextLine();
		return input;
	}

	/**
	 * Updates the selected character's ImageURL.
	 * 
	 * @param charactersList ArrayList object containing Character objects
	 * @param scanner        Scanner object to get Input of the new URL.
	 * @param resultIndex    index of the found character
	 * @param matchFound     ArrayList of the found character
	 */
	private void udpateImageURL(ArrayList<Character> charactersList, Scanner scanner, int resultIndex) {
		String input;
		System.out.println("Entrez une nouvelle URL d'image :");
		input = scanner.nextLine();

		charactersList.get(resultIndex).setImageUrl(input);

	}

	/**
	 * Updates the selected character's attack power.
	 * 
	 * @param charactersList ArrayList object containing Character objects
	 * @param scanner        Scanner object to get Input of the new attack power.
	 * @param resultIndex    index of the found character
	 * @param matchFound     ArrayList of the found character
	 */
	private void updateAttackPower(ArrayList<Character> charactersList, Scanner scanner, int resultIndex,
			int intInput) {
		boolean AP_ok = false;
		while (!AP_ok) {

			System.out.println("Entrez une nouvelle valeur de puissance d'attaque (Warrior: 5 à 10, Wizard 8 à 15):");
			try {
				intInput = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Mauvais format d'entrée. Recommencez.");
				continue;
			}

			if (charactersList.get(resultIndex).getClassName().equals("Wizard")) {

				if (Math.min(Wizard.WIZARD_MAX_ATTACK_POWER,
						Math.max(intInput, Wizard.WIZARD_MIN_ATTACK_POWER)) == intInput) {

					charactersList.get(resultIndex).setAttackPower(intInput);
					AP_ok = true;

				} else {
					System.out.println("Paramètre invalide, recommencez.");
				}

			} else if (charactersList.get(resultIndex).getClassName().equals("Warrior")) {

				if (Math.min(Warrior.WARRIOR_MAX_ATTACK_POWER,
						Math.max(intInput, Warrior.WARRIOR_MIN_ATTACK_POWER)) == intInput) {

					charactersList.get(resultIndex).setAttackPower(intInput);
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
	 * @param charactersList ArrayList object containing Character objects
	 * @param scanner        Scanner object to get Input of the new life.
	 * @param resultIndex    index of the found character
	 * @param matchFound     ArrayList of the found character
	 */
	private void updateLife(ArrayList<Character> charactersList, Scanner scanner, int resultIndex, int intInput) {
		boolean life_ok = false;
		while (!life_ok) {

			System.out.println("Entrez une nouvelle valeur de vie (Warrior: 5 à 10, Wizard 3 à 6):");
			try {
				intInput = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Mauvais format d'entrée. Recommencez.");
				continue;
			}

			if (charactersList.get(resultIndex).getClassName().equals("Wizard")) {

				if (Math.min(Wizard.WIZARD_MAX_LIFE, Math.max(intInput, Wizard.WIZARD_MIN_LIFE)) == intInput) {

					charactersList.get(resultIndex).setLife(intInput);
					life_ok = true;

				} else {
					System.out.println("Paramètre invalide, recommencez.");
				}

			} else if (charactersList.get(resultIndex).getClassName().equals("Warrior")) {

				if (Math.min(Warrior.WARRIOR_MAX_LIFE, Math.max(intInput, Warrior.WARRIOR_MIN_LIFE)) == intInput) {

					charactersList.get(resultIndex).setLife(intInput);
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
	 * @param charactersList ArrayList object containing Character objects
	 * @param scanner        Scanner object to get Input of the new name.
	 * @param result_index   index of the found character
	 *
	 */
	private void updateName(ArrayList<Character> charactersList, Scanner scanner, int result_index) {
		String input;
		System.out.println("Entrez un nouveau nom :");
		input = scanner.nextLine();
		charactersList.get(result_index).setName(input);
	}
}
