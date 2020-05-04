package main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Character Search class.
 * 
 */
public class CharacterSearch implements CharacterSearchInterface {

	/**
	 * Displays Character Object Image.
	 *
	 * @param character the Character object from which you want to show image.
	 *
	 */
	private void charImageDisplay(CharacterClassInterface character) {
		// Tries to display image pointed by URL.
		try {
			new DisplayImage(character.getImageUrl());
		} catch (IOException DisplayException) {
			// If fail, print image error.
			System.out.println("Image loading failed");
		}
	}

	/**
	 * Get inputs in order to search character by name and display infos + image.
	 *
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param scanner        a Scanner Object used to get inputs.
	 *
	 */
	@Override
	public void search(ArrayList<Character> charactersList, Scanner scanner) {
		/** Search result array, contains [match_status, match_index] */
		int resultIndex;

		System.out.println("Entrez le nom du personnage recherché. Valider un champ vide pour quitter.");
		String input = scanner.nextLine();

		if (input.equals("")) {
			System.out.println("Retour au menu précédent.");
			return;
		}
		resultIndex = characterSearch(charactersList, input);

		if (resultIndex != -1) {
			System.out.println(charactersList.get(resultIndex).toString());
			charImageDisplay(charactersList.get(resultIndex));
			System.out.println("Son sort racial est : " + charactersList.get(resultIndex).getRacialSpell().getName()
					+ " dont l'effet est :");
			try {
				charactersList.get(resultIndex).getRacialSpell().activateRacialSpell();
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (resultIndex == -1) {
			System.out.println("Ce personnage n'existe pas.");
		}
	}

	/**
	 * Search character object by name.
	 *
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param search         search input String.
	 *
	 * @return integer index of matching object.
	 */
	@Override
	public int characterSearch(ArrayList<Character> charactersList, String search) {
		int result = -1;
		for (int index = 0; index < charactersList.size(); index++) {
			if (charactersList.get(index).getName().equals(search)) {
				result = index;
			}
		}
		return result;
	}
}
