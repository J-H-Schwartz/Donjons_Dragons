package main;

import java.util.ArrayList;
import java.util.Scanner;

public interface CharacterUpdateInterface {

	/**
	 * Search by name through the characters lists and allow to update found
	 * character informations.
	 *
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param scanner        a Scanner Object used to get inputs.
	 *
	 */
	void characterUpdate(ArrayList<Character> charactersList, Scanner scanner);

}