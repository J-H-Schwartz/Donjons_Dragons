package main;

import java.util.ArrayList;
import java.util.Scanner;

public interface CharacterSearchInterface {

	/**
	 * Get inputs in order to search character by name and display infos + image.
	 *
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param scanner        a Scanner Object used to get inputs.
	 *
	 */
	void search(ArrayList<Character> charactersList, Scanner scanner);

	/**
	 * Search character object by name.
	 *
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param search         search input String.
	 *
	 * @return integer index of matching object.
	 */
	int characterSearch(ArrayList<Character> charactersList, String search);

}