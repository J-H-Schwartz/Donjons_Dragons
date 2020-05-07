package menus;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

/**
 * Character Creation class.
 * 
 */
public class CharacterCreation implements CharacterCreationInterface {

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
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param scanner        a Scanner Object used to get inputs.
	 *
	 */
	@Override
	public void characterCreation(ArrayList<Character> charactersList, Scanner scanner) {
//		WindowedIHM.createAndShowGUI("C", charactersList);
//		String input = WindowedIHM.sendMessage();
//		String[] splittedInput = input.split("-");
//		String charSelection = splittedInput[0];
//		String raceSelection = splittedInput[1];
		 //Gets Character Selection Input
		String charSelection = getCharClassSelection(scanner);
		if (charSelection.equals(QUIT)) {
			return;
		}
		// Gets Race Selection Input
		String raceSelection = getRaceSelection(scanner);

		// Gets Name Selection Input
		String nameSelection = getNameSelection(scanner);

		// Gets Life Selection Input
		int lifeSelection = askForLife(scanner);

		// Gets Attack_power Selection Input
		int attackPowerSelection = askForAttackPower(scanner);

//		WindowedIHM.createAndShowGUI("C2", charactersList);
//		String input2 = WindowedIHM.sendMessage();
//		String[] splittedInput2 = input2.split("-");
//		String nameSelection = splittedInput2[0];
//		int lifeSelection = Integer.parseInt(splittedInput2[1]);
//		int attackPowerSelection = Integer.parseInt(splittedInput2[2]);
		if (nameSelection.equals(QUIT)) {
			return;
		}
		// Creates selected char with input parameters.
		if (charSelection.equals(WAR)) {
			WarriorCreationInterface warrior_creation = new WarriorCreation();
			warrior = warrior_creation.warriorCreation(nameSelection, lifeSelection, attackPowerSelection,
					raceSelection);
			// Add new Warrior to characters ArrayList
			charactersList.add(warrior);
		} else if (charSelection.equals(WIZ)) {
			WizardCreationInterface wizard_creation = new WizardCreation();
			wizard = wizard_creation.wizardCreation(nameSelection, lifeSelection, attackPowerSelection, raceSelection);
			// Add new Wizard to characters ArrayList
			charactersList.add(wizard);
		}
		System.out.println("Personnage créé !");
		// Empty scanner return.
		// scanner.nextLine();
	}

	/**
	 * Gets input name from user.
	 * 
	 * @param scanner Scanner objet for input.
	 * 
	 * @return String object used as name parameter for character creation.
	 */
	private static String getNameSelection(Scanner scanner) {
		System.out.println("Entrez un nom : ");
		String name_selection = scanner.nextLine();
		return name_selection;
	}

	/**
	 * Gets input Race from user.
	 * 
	 * @param scanner Scanner objet for input.
	 * 
	 * @return String object used as Race parameter for character creation.
	 */
	private static String getRaceSelection(Scanner scanner) {
		String race_selection = "";
		while (!race_selection.equals("D") && !race_selection.equals("E")) {
			System.out.println("Quelle race voulez-vous choisir pour votre personne ? (D)warf ou (E)lfe");
			race_selection = scanner.nextLine();
		}
		return race_selection;
	}

	/**
	 * Gets input class from user.
	 * 
	 * @param scanner Scanner objet for input.
	 * 
	 * @return String object used as class parameter for character creation..
	 */
	private static String getCharClassSelection(Scanner scanner) {
		System.out.println("Quel personnage souhaitez-vous créer ? (W)arrior or Wizar(D) ou (Q)uitter");
		String char_selection = scanner.nextLine();
		return char_selection;
	}

	/**
	 * Gets input life from user.
	 * 
	 * @param scanner Scanner objet for input.
	 * 
	 * @return Int used as Life parameter for character creation..
	 */
	private static int askForLife(Scanner scanner) {
		// Gets Life Selection Input
		System.out.println("Entrez le maximum de points de vie (5-10) : ");
		try {
			return scanner.nextInt();
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("Mauvais format d'entrée.");
			return 0;
		}
	}

	/**
	 * Gets input attack power from user.
	 * 
	 * @param scanner Scanner objet for input.
	 * 
	 * @return Int used as attack power parameter for character creation..
	 */
	private static int askForAttackPower(Scanner scanner) {
		// Gets Attack Power Selection Input
		System.out.println("Entrez les points d'attaque (5-10) : ");
		try {
			return scanner.nextInt();
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("Mauvais format d'entrée.");
			return 0;
		}
	}
}
