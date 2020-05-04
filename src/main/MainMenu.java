package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main menu class.
 * 
 */

public class MainMenu {

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
	
	private static ArrayList<Character> charactersList = new ArrayList<Character>();
	
	public static ArrayList<Character> getWCharactersList() {
		return charactersList;
	}

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
			String menuSelection = WindowedIHM.sendMessage();
			String[] splittedInput = menuSelection.split("-");
			menuSelection = splittedInput[1];
			if (menuSelection.equals(CREATION)) {
				CharacterCreationInterface charCreate = new CharacterCreation();
				charCreate.characterCreation(charactersList, scanner);

			} else if (menuSelection.equals(RESEARCH)) {
				CharacterSearchInterface charSearch = new CharacterSearch();
				charSearch.search(charactersList, scanner);

			} else if (menuSelection.equals(UPDATE)) {
				CharacterUpdateInterface charUpdate = new CharacterUpdate();
				charUpdate.characterUpdate(charactersList, scanner);

			} else if (menuSelection.equals(LIST)) {
//				CharactersListShow charShow = new CharactersListShow();
//				charShow.characterShow(charactersList, scanner);
				WindowedIHM.createAndShowGUI("L");
				WindowedIHM.sendMessage();

			} else if (menuSelection.equals(DELETE)) {
				CharactersDeletionInterface charDel = new CharactersDeletion();
				charDel.characterDeletion(charactersList, scanner);

			} else if (menuSelection.equals(QUIT)) {
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
