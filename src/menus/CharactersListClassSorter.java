package menus;

import java.util.Comparator;

import characters.Character;

/**
 * CharactersList Class Name Sorter.
 * 
 */
public class CharactersListClassSorter implements Comparator<Character>, CharactersListSClassSorterInterface {

	@Override
	public int compare(Character char1, Character char2) {
		return char1.getClassName().compareToIgnoreCase(char2.getClassName());
	}
}
