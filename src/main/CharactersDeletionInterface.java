package main;

import java.util.ArrayList;
import java.util.Scanner;

public interface CharactersDeletionInterface {

	/**
	 * Search by name through the characters lists and deletes selected character.
	 *
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param scanner        a Scanner Object used to get inputs.
	 *
	 */
	void characterDeletion(ArrayList<Character> charactersList, Scanner scanner);

}