package main;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterSearch extends MainMenu{
	private static final int WIZARD_FOUND = 1;
	private static final int WARRIOR_FOUND = 2;
	private static final int NO_MATCH_FOUND = 0;
	
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
		} else if (result_match_index[0] == WIZARD_FOUND) {
			System.out.println(wizards.get(result_match_index[1]).toString());			
		}
	}
	
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
