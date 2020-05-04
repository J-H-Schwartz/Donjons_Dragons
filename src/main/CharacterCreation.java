package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Character Creation class.
 * 
 */

public class CharacterCreation {

	/** Input constant */
	private static final String WAR = "W";

	/** Input constant */
	private static final String WIZ = "D";

	/** Input constant */
	private static final String QUIT = "Q";

	/** Wizard object for creation */
	private Wizard wizard;

	/** Warrior object for creation */
	private Warrior warrior;

	/**
	 * Get inputs in order to create new characters.
	 *
	 * @param warriors the ArrayList containing Warriors Objects.
	 * @param wizards  the ArrayList containing Wizards Objects.
	 * @param scanner  a Scanner Object used to get inputs.
	 *
	 */
	public void characterCreation(ArrayList<Warrior> warriors, ArrayList<Wizard> wizards, Scanner scanner) {
		WindowedIHM.createAndShowGUI("C");
		String input = WindowedIHM.sendMessage();
		String[] input_parts = input.split("-");
		String char_selection = input_parts[0];
		String race_selection = input_parts[1];
		// Gets Character Selection Input
//		String char_selection = getCharClassSelection(scanner);
		if (char_selection.equals(QUIT)) {
			return;
		}
//		// Gets Race Selection Input
//		String race_selection = getRaceSelection(scanner);

		// Gets Name Selection Input
//		String name_selection = getNameSelection(scanner);
//
//		// Gets Life Selection Input
//		int life_selection = askForLife(scanner);
//
//		// Gets Attack_power Selection Input
//		int attack_power_selection = askForAttackPower(scanner);

		WindowedIHM.createAndShowGUI("C2");
		String input2 = WindowedIHM.sendMessage();
		String[] input_parts2 = input2.split("-");
		String name_selection = input_parts2[0];
		int life_selection = Integer.parseInt(input_parts2[1]);
		int attack_power_selection = Integer.parseInt(input_parts2[2]);
		if (name_selection.equals(QUIT)) {
			return;
		}
		// Creates selected char with input parameters.
		if (char_selection.equals(WAR)) {
			WarriorCreation warrior_creation = new WarriorCreation();
			warrior = warrior_creation.warriorCreation(name_selection, life_selection, attack_power_selection,
					race_selection);
			// Add new Warrior to warriors ArrayList
			warriors.add(warrior);
		} else if (char_selection.equals(WIZ)) {
			WizardCreation wizard_creation = new WizardCreation();
			wizard = wizard_creation.wizardCreation(name_selection, life_selection, attack_power_selection,
					race_selection);
			// Add new Wizard to wizards ArrayList
			wizards.add(wizard);
		}
		// Empty scanner return.
	//	scanner.nextLine();
	}

	/**
	 * Gets input name from user.
	 * 
	 * @param scanner Scanner objet for input.
	 * 
	 * @return String object used as name parameter for character creation.
	 */
//	private static String getNameSelection(Scanner scanner) {
//		System.out.println("Entrez un nom : ");
//		String name_selection = scanner.nextLine();
//		return name_selection;
//	}

	/**
	 * Gets input Race from user.
	 * 
	 * @param scanner Scanner objet for input.
	 * 
	 * @return String object used as Race parameter for character creation.
	 */
//	private static String getRaceSelection(Scanner scanner) {
//		String race_selection = "";
//		while (!race_selection.equals("D") && !race_selection.equals("E")) {
//			System.out.println("Quelle race voulez-vous choisir pour votre personne ? (D)warf ou (E)lfe");
//			race_selection = scanner.nextLine();
//		}
//		return race_selection;
//	}

	/**
	 * Gets input class from user.
	 * 
	 * @param scanner Scanner objet for input.
	 * 
	 * @return String object used as class parameter for character creation..
	 */
//	private static String getCharClassSelection(Scanner scanner) {
//		System.out.println("Quel personnage souhaitez-vous créer ? (W)arrior or Wizar(D) ou (Q)uitter");
//		String char_selection = scanner.nextLine();
//		return char_selection;
//	}

	/**
	 * Gets input life from user.
	 * 
	 * @param scanner Scanner objet for input.
	 * 
	 * @return Int used as Life parameter for character creation..
	 */
//	private static int askForLife(Scanner scanner) {
//		// Gets Life Selection Input
//		System.out.println("Entrez le maximum de points de vie (Warrior: 5-10, Wizard: 3-6) : ");
//		try {
//			return scanner.nextInt();
//		} catch (InputMismatchException inputMismatchException) {
//			System.out.println("Mauvais format d'entrée.");
//			return 0;
//		}
//	}

	/**
	 * Gets input attack power from user.
	 * 
	 * @param scanner Scanner objet for input.
	 * 
	 * @return Int used as attack power parameter for character creation..
	 */
//	private static int askForAttackPower(Scanner scanner) {
//		// Gets Attack Power Selection Input
//		System.out.println("Entrez les points d'attaque (Warrior: 5-10, Wizard: 8-15) : ");
//		try {
//			return scanner.nextInt();
//		} catch (InputMismatchException inputMismatchException) {
//			System.out.println("Mauvais format d'entrée.");
//			return 0;
//		}
//	}
}
