package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main menu class.
 * 
 */

public class MainMenu {

	private interface MainMenuConst {
		/** Input constant */
		static final String CREATION = "C";
		/** Input constant */
		static final String RESEARCH = "R";
		/** Input constant */
		static final String UPDATE = "M";
		/** Input constant */
		static final String LIST = "L";
		/** Input constant */
		static final String DELETE = "S";
		/** Input constant */
		static final String QUIT = "Q";
	}

	/** Warriors ArrayList Object */
	private static ArrayList<Warrior> warriors = new ArrayList<Warrior>();

	/** Wizards ArrayList Object */
	private static ArrayList<Wizard> wizards = new ArrayList<Wizard>();

	private MainMenu() {
	}

	/**
	 * Program main menu.
	 * 
	 */
	public static void mainMenu() {

		/** Scanner Object to get input */
		Scanner scanner = new Scanner(System.in);

		while (true) {
			// String input = askForMenuSelection(scanner);
			WindowedIHM.createAndShowGUI("M");
			String input = WindowedIHM.sendMessage();
			String[] split_input = input.split("-");
			input = split_input[1];
			if (input.equals(MainMenuConst.CREATION)) {
				CharacterCreation.characterCreation(warriors, wizards, scanner);

			} else if (input.equals(MainMenuConst.RESEARCH)) {
				CharacterSearch.search(warriors, wizards, scanner);

			} else if (input.equals(MainMenuConst.UPDATE)) {
				CharacterUpdate.characterUpdate(warriors, wizards, scanner);

			} else if (input.equals(MainMenuConst.LIST)) {
				CharactersListShow.characterShow(warriors, wizards, scanner);

			} else if (input.equals(MainMenuConst.DELETE)) {
				CharactersDeletion.characterDeletion(warriors, wizards, scanner);

			} else if (input.equals(MainMenuConst.QUIT)) {
				System.out.println("Programme terminé.");
				break;

			} else {
				System.out.println("Commande non reconnue. Recommencez.");
			}
		}
		scanner.close();
	}

	/**
	 * Asks for menu selection.
	 * 
	 * @param scanner Scanner object to get selection input.
	 * @return String object containing selection input.
	 */
//	private static String askForMenuSelection(Scanner scanner) {
//		System.out.println(
//				"(R)echercher personnage\n(L)ister personnages\n(C)réer personnage\n(M)odifier personnage\n(S)upprimer personnage\n(Q)uitter");
//		String input = scanner.nextLine();
//		return input;
//	}
}
