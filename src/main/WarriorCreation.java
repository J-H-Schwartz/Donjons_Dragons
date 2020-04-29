package main;

import java.io.IOException;

public class WarriorCreation extends CharacterCreation {

	private static void charInfosPrint(Warrior warrior) {
		System.out.println("Création du personnage " + warrior.getName() + " Life : " + warrior.getLife()
				+ " Attack power : " + warrior.getAttackPower());
	}

	private static void charImageDisplay(Warrior warrior) {
		// Tries to display image pointed by URL.
		try {
			new DisplayImage(warrior.getImageUrl());
		} catch (IOException DisplayException) {
			// If fail, print image error.
			System.out.println("Image loading failed");
		}
	}

	public static Warrior warriorCreation(String name, int life, int attack_force) {
		Warrior warrior;
		// Tries to create new Warrior object with all parameters.
		try {
			warrior = new Warrior(name, life, attack_force);
		} catch (Exception warrior_constructor_exception_1) {
			System.out.println(
					"Création échouée. Entrée de vie/force d'attaque invalide.\nEssai avec le paramètre nom uniquement.\nValeurs de vie et de force par défaut. Vous pourrez modifier votre personnage par la suite.");
			// If fail, tries to create new Warrior object with name parameter.
			try {
				warrior = new Warrior(name);
			} catch (Exception warrior_constructor_exception_2) {
				System.out.println(
						"Création échouée. Nom invalide.\n Création avec paramètres par défaut. Vous pourrez modifier votre personnage par la suite.");
				// If fail, creates new Warrior object without parameter.
				warrior = new Warrior();
			}
		}
		
		// Display image pointed by URL
		charImageDisplay(warrior);
		charInfosPrint(warrior);
		return warrior;
	}
}
