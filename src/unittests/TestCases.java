package unittests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import characters.Character;
import characters.Warrior;
import gameboard.BoardCase;
import gameboard.GenerateBoard;

class TestCases {

	static final int BOARD_SIZE = 64;

	@Test
	void testWarriorCreationFields() {
		Warrior warrior = new Warrior("Bob", 5, 10, "D");

		assertTrue(warrior.getName().equals("Bob"));
		assertTrue(warrior.getLife() == 5);
		assertTrue(warrior.getAttackPower() == 10);
		assertTrue(warrior.getRaceName().equals("Dwarf"));
	}

	@Test
	void testBoardGeneration() {
		ArrayList<BoardCase> board = new ArrayList<BoardCase>();
		Scanner scanner = new Scanner(System.in);
		GenerateBoard boardgen = new GenerateBoard();
		board = boardgen.generateBoard(board, scanner);
		// Pour plateau de 64 cases
		assertEquals(BOARD_SIZE, board.size());
	}

	@Test
	void testSearchResult() {
		ArrayList<Character> board = new ArrayList<Character>();
		Warrior warrior = new Warrior("Bob", 5, 10, "D");
		board.add(warrior);

		assertEquals("Bob", board.get(0).getName());

	}

}
