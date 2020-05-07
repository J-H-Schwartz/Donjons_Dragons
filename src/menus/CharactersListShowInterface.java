package menus;

import java.util.ArrayList;
import java.util.Scanner;

import characters.Character;

public interface CharactersListShowInterface {
	
	/**
	 * Shows List from selected type (Wizards/Warriors).
	 *
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param scanner  Scanner Objet to get inputs.
	 *
	 */
	void characterShow(ArrayList<Character> charactersList, Scanner scanner);
}