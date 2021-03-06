package menus;

import java.util.ArrayList;
import java.util.Scanner;

import characters.Character;

public interface CharacterCreationInterface {

	/**
	 * Get inputs in order to create new characters.
	 *
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param scanner        a Scanner Object used to get inputs.
	 *
	 */
	void characterCreation(ArrayList<Character> charactersList, Scanner scanner);

}