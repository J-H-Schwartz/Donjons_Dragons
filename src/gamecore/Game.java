package gamecore;

import java.util.ArrayList;
import java.util.Scanner;

import characters.Character;
import gameboard.BoardCase;
import gameboard.GenerateBoard;
import main.GetRandomInt;
import menus.CharacterCreation;
import menus.CharacterSearch;

public class Game {
	public void gameSession(ArrayList<BoardCase> board, ArrayList<Character> charactersList, Scanner scanner) {
		String characterName;
		int characterIndex;
		Character selectedChar;
		if (charactersList.size() == 0) {
			System.out.println("Vous devez avoir créé au moins un personnage avant de pouvoir jouer.");
			CharacterCreation newCharCreation = new CharacterCreation();
			newCharCreation.characterCreation(charactersList, scanner);
		} else if (board.size() == 0) {
			System.out.println("Vous devez avoir généré un plateau pour pouvoir jouer.");
			GenerateBoard newBoardGeneration = new GenerateBoard();
			board = newBoardGeneration.generateBoard(board, scanner);
		}
		// Selection de personnage.
		System.out.println("Tapez le nom de votre personnage");
		characterName = scanner.nextLine();
		CharacterSearch search = new CharacterSearch();
		characterIndex = search.characterSearch(charactersList, characterName);
		if (characterIndex == -1) {
			System.out.println("Ce personnage n'existe pas.");
			return;
		}
		selectedChar = charactersList.get(characterIndex);
		System.out.println(String.format(
				"Vous avez choisi %s, %s %s\nVie: %d, Puissance: %d\nMain droite: %s, Main gauche: %s",
				selectedChar.getName(), selectedChar.getRaceName(), selectedChar.getClassName(), selectedChar.getLife(),
				selectedChar.getAttackPower(), selectedChar.getRightHand(), selectedChar.getLeftHand()));
		// Lancement de la partie.
		// Tant que index position < taille board
		String gameSelection;
		String[] caseDescription;
		int dice;
		while (selectedChar.getBoardPosition() < (board.size() - 1) && selectedChar.getLife() > 0) {
			System.out.println("Que voulez-vous faire ?\n(L)ancer le dé\n(A)bandonner");
			gameSelection = scanner.nextLine();
			if (gameSelection.equals("A")) {
				selectedChar.setBoardPosition(-1);
				System.out.println("Partie abandonnée.");
				return;
			} else if (gameSelection.equals("L")) {
				dice = GetRandomInt.getRandomInt(6) + 1;
				if (selectedChar.getBoardPosition() + dice > (board.size() - 1)) {
					System.out.println(String.format(
							"Vous lancez le dé et faites un %d.\nVous dépassez le nombre de cases et attérissez directement\nsur la dernière case.",
							dice));
					selectedChar.setBoardPosition(board.size() - 1);
				} else {
					System.out.println(String.format("Vous lancez le dé et avancez de %d cases.", dice));
					selectedChar.setBoardPosition(selectedChar.getBoardPosition() + dice);
				}
				System.out.println("Vous tombez sur la case n°" + selectedChar.getBoardPosition());
				if (board.get(selectedChar.getBoardPosition()).getCaseStatus() == 0) {
					System.out.println("Cette case est vide.");
				} else {
					caseDescription = board.get(selectedChar.getBoardPosition()).getContains().split("-");
					System.out.println(String.format("Cette case contient un %s ! C'est un %s %s", caseDescription[0],
							caseDescription[0], caseDescription[1]));
					if (caseDescription[0].equals("Bonus") && caseDescription[1].equals("Vie")) {
						System.out.println(String.format("Ce bonus de Vie augmente votre vie de %s (limitée à 10).", caseDescription[2]));
						selectedChar.setLife(selectedChar.getLife() + Integer.parseInt(caseDescription[2]));
					} else if (caseDescription[0].equals("Bonus") && caseDescription[1].equals("Attaque")) {
						System.out.println(String.format("Ce bonus d'Attaque augmente votre vie de %s (limitée à 10).", caseDescription[2]));
						selectedChar.setAttackPower(Integer.parseInt(caseDescription[2]));
					} else if (caseDescription[0].equals("Ennemi")) {
						System.out.println(String.format("Ce %s vous attaque et réduit vos points de vie de %s.", caseDescription[1], caseDescription[2]));
						selectedChar.setLife(selectedChar.getLife() - Integer.parseInt(caseDescription[2]));
					}
				}
			}
		}
		selectedChar.setBoardPosition(-1);
		if (selectedChar.getLife() <= 0) {
			System.out.println("Partie perdue, votre personnage a été décedé par la mort.");
			selectedChar.setLife(10);
		} else {
		System.out.println("Vous êtes arrivé à la fin du voyage, bravo aventurier !");
		}
	}
}
