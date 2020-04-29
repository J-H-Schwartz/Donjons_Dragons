package main;

import java.io.IOException;

public class WizardCreation extends CharacterCreation {
	
	private static void charInfosPrint(Wizard wizard) {
		System.out.println("Création du personnage " + wizard.getName() + " Life : " + wizard.getLife()
				+ " Attack power : " + wizard.getAttackPower());
	}

	private static void charImageDisplay(Wizard wizard) {
		// Tries to display image pointed by URL.
		try {
			new DisplayImage(wizard.getImageUrl());
		} catch (IOException DisplayException) {
			// If fail, print image error.
			System.out.println("Image loading failed");
		}
	}
	
	public static Wizard wizardCreation(String name, int life, int attack_force) {
		// Tries to create new Wizard object with all parameters.
		Wizard wizard;
		try {
			wizard = new Wizard(name, life, attack_force);
		} catch (Exception wizard_constructor_exception_1) {
			System.out.println(
					"Création échouée. Entrée de vie/force d'attaque invalide.\nEssai avec le paramètre nom uniquement.\nValeurs de vie et de force par défaut. Vous pourrez modifier votre personnage par la suite.");
			// If fail, tries to create new Wizard object with name parameter.
			try {
				wizard = new Wizard(name);
			} catch (Exception wizard_constructor_exception_2) {
				System.out.println(
						"Création échouée. Entrée de vie/force d'attaque invalide.\nEssai avec le paramètre nom uniquement.\nValeurs de vie et de force par défaut. Vous pourrez modifier votre personnage par la suite.");
				// If fail, creates new Wizard object without parameter.
				wizard = new Wizard();
			}
		}

		// Display image pointed by URL
		charImageDisplay(wizard);
		charInfosPrint(wizard);
		return wizard;
	}

	
}
