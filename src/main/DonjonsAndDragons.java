package main;

import menus.MainMenu;

/**
 * Main game class, program Entry point.
 * 
 */
public class DonjonsAndDragons {
	
	/**
	 * Calls program Main menu.
	 * 
	 */
	public static void main(String[] args) {
		MainMenu dndSession = new MainMenu();
		dndSession.mainMenu();
	}
}
