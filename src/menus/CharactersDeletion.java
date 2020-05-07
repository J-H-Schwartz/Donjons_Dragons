package menus;

import java.util.ArrayList;
import java.util.Scanner;

import characters.Character;

/**
 * Character Deletion Class.
 *
 */
public class CharactersDeletion implements CharactersDeletionInterface {

	/**
	 * Search by name through the characters lists and deletes selected character.
	 *
	 * @param charactersList the ArrayList containing Character Objects.
	 * @param scanner        a Scanner Object used to get inputs.
	 *
	 */
	@Override
	public void characterDeletion(ArrayList<Character> charactersList, Scanner scanner) {

		/** Search result, index of found object */
		int resultIndex;

		while (true) {

			System.out.println("Quel personnage souhaitez-vous supprimer ? Valider un champ vide pour quitter.");
			String input = scanner.nextLine();

			if (input.isEmpty()) {
				System.out.println("Retour au menu précédent.");
				break;
			}

			CharacterSearchInterface charSearch = new CharacterSearch();
			resultIndex = charSearch.characterSearch(charactersList, input);

			if (resultIndex == -1) {
				System.out.println("Aucun personnage avec ce nom n'a été trouvé.");
				continue;
			} else {
				deleteCharacter(charactersList, scanner, resultIndex);
			}
		}
	}

	/**
	 * Asks for Deletion confirmation and deletes characters. s
	 * 
	 * @param charactersList ArrayList of Character characters
	 * @param scanner        Scanner object used to get Confirmation Input.
	 * @param resultIndex    index of found character in one of ArrayLists
	 */
	private void deleteCharacter(ArrayList<Character> charactersList, Scanner scanner, int resultIndex) {
		String input;
		boolean confirmationCommandOk = false;
		while (!confirmationCommandOk) {

			System.out.println("Confirmer la suppression ? OUI ou NON");
			input = scanner.nextLine();

			if (input.equals("OUI")) {

				charactersList.remove(resultIndex);
				System.out.println("Personnage supprimé !");
				confirmationCommandOk = true;

			} else if (input.equals("NON")) {

				System.out.println("Opération annulée.");
				confirmationCommandOk = true;

			} else {
				System.out.println("Commande non reconnue.");
			}
		}
	}
}
