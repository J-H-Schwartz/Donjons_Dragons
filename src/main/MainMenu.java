package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main menu class.
 * 
 */

public class MainMenu {

	/** Warriors ArrayList Object */
	private static ArrayList<Warrior> warriors = new ArrayList<Warrior>();

	/** Wizards ArrayList Object */
	private static ArrayList<Wizard> wizards = new ArrayList<Wizard>();

	/**
	 * Program main menu.
	 * 
	 */
	public static void mainMenu() {

		/** Scanner Object to get input */
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println(
					"(R)echercher personnage\n(L)ister personnages\n(C)réer personnage\n(M)odifier personnage\n(Q)uitter");
			String input = scanner.nextLine();
			if (input.equals("C")) {
				CharacterCreation.characterCreation(warriors, wizards, scanner);
			} else if (input.equals("R")) {
				CharacterSearch.search(warriors, wizards, scanner);
			} else if (input.equals("M")) {
				CharacterUpdate.characterUpdate(warriors, wizards, scanner);
			} else if (input.equals("L")) {
				CharactersListShow.characterShow(warriors, wizards, scanner);
			} else if (input.equals("Q")) {
				System.out.println("Programme terminé.");
				break;
			} else {
				System.out.println("Commande non reconnue. Recommencez.");
			}
		}
		scanner.close();
	}
}
