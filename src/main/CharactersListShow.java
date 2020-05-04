package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Character Listing class.
 * 
 */

public class CharactersListShow implements CharactersListShowInterface {

	/**
	 * Shows List from selected type (Wizards/Warriors).
	 *
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param scanner  Scanner Objet to get inputs.
	 *
	 */
	public void characterShow(ArrayList<Character> charactersList, Scanner scanner) {
		charactersList.sort(new CharactersListClassSorter());
		System.out.println("Liste de Personnages :");
		System.out.println(charactersList.stream().map(Object::toString).collect(Collectors.joining("\n")));
	}
}
