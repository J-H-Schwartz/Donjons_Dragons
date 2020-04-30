package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Character Creation class.
 * 
 */

abstract class CharacterCreation {
	/** Input constant */
	private static final String WAR = "W";

	/** Input constant */
	private static final String WIZ = "D";

	/** Input constant */
	private static final String QUIT = "Q";

	/** Wizard object for creation */
	private static Wizard wizard;

	/** Warrior object for creation */
	private static Warrior warrior;

	/**
	 * Get inputs in order to create new characters.
	 *
	 * @param warriors the ArrayList containing Warriors Objects.
	 * @param wizards  the ArrayList containing Wizards Objects.
	 * @param scanner  a Scanner Object used to get inputs.
	 *
	 */
	public static void characterCreation(ArrayList<Warrior> warriors, ArrayList<Wizard> wizards, Scanner scanner) {
		/** Life input var */
		int life_selection;
		/** Attack power input var */
		int attack_power_selection;

		// Gets Character Selection Input
		System.out.println("Quel personnage souhaitez-vous créer ? (W)arrior or Wizar(D) ou (Q)uitter");
		String char_selection = scanner.nextLine();
		if (char_selection.equals(QUIT)) {
			return;
		}
		// Gets Name Selection Input
		System.out.println("Entrez un nom : ");
		String name_selection = scanner.nextLine();

		// Gets Life Selection Input
		System.out.println("Entrez le maximum de points de vie (Warrior: 5-10, Wizard: 3-6) : ");
		try {
			life_selection = scanner.nextInt();
		} catch (Exception inputMismatchException) {
			System.out.println("Mauvais format d'entrée.");
			life_selection = 0;
		}

		// Gets Attack Power Selection Input
		System.out.println("Entrez les points d'attaque (Warrior: 5-10, Wizard: 8-15) : ");
		try {
			attack_power_selection = scanner.nextInt();
		} catch (Exception inputMismatchException) {
			System.out.println("Mauvais format d'entrée.");
			attack_power_selection = 0;
		}

		// Creates selected char with input parameters.
		if (char_selection.equals(WAR)) {
			warrior = WarriorCreation.warriorCreation(name_selection, life_selection, attack_power_selection);
			// Add new Warrior to warriors ArrayList
			warriors.add(warrior);
		} else if (char_selection.equals(WIZ)) {
			wizard = WizardCreation.wizardCreation(name_selection, life_selection, attack_power_selection);
			// Add new Wizard to wizards ArrayList
			wizards.add(wizard);
		}
		// Empty scanner return.
		scanner.nextLine();
	}
}
