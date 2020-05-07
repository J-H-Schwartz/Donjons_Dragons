package gameboard;

import java.util.ArrayList;
import java.util.Scanner;

import main.GetRandomInt;

public class GenerateBoard {

	public ArrayList<BoardCase> generateBoard(ArrayList<BoardCase> board, Scanner scanner){
		int caseNumber = 0;
		System.out.println(
				"Combien de cases doit comporter le plateau ?");
		caseNumber = scanner.nextInt();
		scanner.nextLine();
		int randomCase = 0;
		for (int i = 0; i < caseNumber; i++) {
			randomCase = GetRandomInt.getRandomInt(3);
			if (randomCase == 0) {
				board.add(new BoardCase(i));
			} else if (randomCase == 1) {
				board.add(new BoardCaseEnnemy(i));
			} else if (randomCase == 2) {
				board.add(new BoardCaseUpgrade(i));
			}
		}
		System.out.println(String.format("Plateau de %d cases généré !", caseNumber));
		return board;
	}
}
