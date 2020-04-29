package main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Character Search class.
 * 
 */

public class CharacterSearch {
	private static final int WIZARD_FOUND = 1;
	private static final int WARRIOR_FOUND = 2;
	private static final int NO_MATCH_FOUND = 0;

	/**
	 * Displays Warrior Object Image.
	 *
	 * @param warrior the object from which you want to show image.
	 *
	 * @return None this method has no return.
	 */
	private static void charImageDisplay(Warrior warrior) {
		// Tries to display image pointed by URL.
		try {
			new DisplayImage(warrior.getImageUrl());
		} catch (IOException DisplayException) {
			// If fail, print image error.
			System.out.println("Image loading failed");
		}
	}

	/**
	 * Displays Wizard Object Image.
	 *
	 * @param wizard the object from which you want to show image.
	 *
	 * @return None this method has no return.
	 */
	private static void charImageDisplay(Wizard wizard) {
		// Tries to display image pointed by URL.
		try {
			new DisplayImage(wizard.getImageUrl());
		} catch (IOException DisplayException) {
			// If fail, print image error.
			System.out.println("Image loading failed");
		}
	}

	/**
	 * Get inputs in order to search character by name and display infos + image.
	 *
	 * @param warriors the ArrayList containing Warriors Objects.
	 * @param wizards  the ArrayList containing Wizards Objects.
	 * @param scanner  a Scanner Object used to get inputs.
	 *
	 * @return None this method has no return.
	 */
	public static void search(ArrayList<Warrior> warriors, ArrayList<Wizard> wizards, Scanner scanner) {
		int[] result_match_index = new int[2];
		System.out.println("Entrez le nom du personnage recherché. Valider un champ vide pour quitter.");
		String input = scanner.nextLine();
		if (input.equals("")) {
			System.out.println("Retour au menu précédent.");
			return;
		}
		result_match_index = CharacterSearch.characterSearch(wizards, warriors, input);
		if (result_match_index[0] == WARRIOR_FOUND) {
			System.out.println(warriors.get(result_match_index[1]).toString());
			charImageDisplay(warriors.get(result_match_index[1]));
		} else if (result_match_index[0] == WIZARD_FOUND) {
			System.out.println(wizards.get(result_match_index[1]).toString());
			charImageDisplay(wizards.get(result_match_index[1]));
		}
	}

	/**
	 * Search character object by name.
	 *
	 * @param warriors the ArrayList containing Warriors Objects.
	 * @param wizards  the ArrayList containing Wizards Objects.
	 * @param search   search input String.
	 *
	 * @return Array of 2 ints containing match type (warrior/wizard) and index of
	 *         matching object.
	 */
	public static int[] characterSearch(ArrayList<Wizard> wizards, ArrayList<Warrior> warriors, String search) {
		int[] result_match_index = new int[2];
		for (int match_index = 0; match_index < wizards.size(); match_index++) {
			if (wizards.get(match_index).getName().equals(search)) {
				result_match_index[0] = WIZARD_FOUND;
				result_match_index[1] = match_index;
				return result_match_index;
			}
		}
		for (int match_index = 0; match_index < warriors.size(); match_index++) {
			if (warriors.get(match_index).getName().equals(search)) {
				result_match_index[0] = WARRIOR_FOUND;
				result_match_index[1] = match_index;
				return result_match_index;
			}
		}
		result_match_index[0] = NO_MATCH_FOUND;
		result_match_index[1] = -1;
		return result_match_index;
	}
}
