package menus;

import java.util.ArrayList;
import java.util.Scanner;

import characters.Character;
import gameboard.BoardCase;
import gameboard.GenerateBoard;
import gamecore.Game;

/**
 * Main menu class.
 * 
 */

public class MainMenu {
	
	/** Input constant */
	static final String CREATION = "C";
	/** Input constant */
	static final String GENERATE = "G";
	/** Input constant */
	static final String PLAY = "N";
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
	
	private ArrayList<Character> charactersList;
	private ArrayList<BoardCase> board;
	
	public MainMenu() {
		charactersList = new ArrayList<Character>();
		board = new ArrayList<BoardCase>();
	}
	
	public ArrayList<Character> getCharactersList() {
		return charactersList;
	}

	/**
	 * Program main menu.
	 * 
	 */
	public void mainMenu() {

		/** Scanner Object to get input */
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String menuSelection = askForMenuSelection(scanner);
//			WindowedIHM.createAndShowGUI("M", charactersList);
//			String menuSelection = WindowedIHM.sendMessage();
//			String[] splittedInput = menuSelection.split("-");
//			menuSelection = splittedInput[1];
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
				WindowedIHM.createAndShowGUI("L", charactersList);
				WindowedIHM.sendMessage();

			} else if (menuSelection.equals(PLAY)) {
				Game gameSession = new Game();
				gameSession.gameSession(board, charactersList, scanner);
			
			} else if (menuSelection.equals(GENERATE)) {
				
				GenerateBoard generate = new GenerateBoard();
				board = generate.generateBoard(board, scanner);

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
	private static String askForMenuSelection(Scanner scanner) {
		System.out.println(
				"(R)echercher personnage\n(L)ister personnages\n(C)réer personnage\n(M)odifier personnage\n(S)upprimer personnage\n(G)énérer un plateau de jeu\n(N)ouvelle Partie\n(Q)uitter");
		String input = scanner.nextLine();
		return input;
	}
}
