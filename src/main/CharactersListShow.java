package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Character Listing class.
 * 
 */

abstract class CharactersListShow {

	/**
	 * Shows List from selected type (Wizards/Warriors).
	 *
	 * @param warriors the ArrayList containing Warriors Objects.
	 * @param wizards  the ArrayList containing Wizards Objects.
	 * @param scanner  Scanner Objet to get inputs.
	 *
	 */
	public static void characterShow(ArrayList<Warrior> warriors, ArrayList<Wizard> wizards, Scanner scanner) {

		System.out.println("Quelle liste souhaitez vous consulter ?\n(W)arriors\nWizar(D)s");
		String input = scanner.nextLine();

		if (input.equals("W")) {
			System.out.println("Liste de Warriors :");
//			for(int i=0; i < warriors.size(); i++){
//	            System.out.println( warriors.get(i).getName());
//	        }
			System.out.println(warriors.stream().map(Object::toString).collect(Collectors.joining("\n")));
		} else if (input.equals("D")) {
			System.out.println("Liste de Wizards :");
//			for (int i = 0; i < wizards.size(); i++) {
//				System.out.println(wizards.get(i).getName());
//			}
			System.out.println(wizards.stream().map(Object::toString).collect(Collectors.joining("\n")));
		} else {
			System.out.println("Cette liste n'existe pas.");
		}
	}
}
