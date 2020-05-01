package main;

import java.io.IOException;

/**
 * Wizards creation class.
 * 
 */

public class WizardCreation {

	private WizardCreation() {
	}

	/**
	 * Displays Wizard Object infos in console.
	 * 
	 * @param wizard
	 * 
	 */
	private static void charInfosPrint(Wizard wizard) {
		System.out.println("Création du personnage " + wizard.getName() + " " + wizard.getClass_name() + " "
				+ wizard.getRace_name() + "\nLife : " + wizard.getLife() + " Attack power : "
				+ wizard.getAttackPower());
	}

	/**
	 * Displays Wizard Object Image.
	 *
	 * @param wizard the object from which you want to show image.
	 *
	 */
	private static void charImageDisplay(Wizard wizard) {
		// Tries to display image pointed by URL.
		try {
			new DisplayImage(wizard.getImageUrl());
		} catch (IOException DisplayException) {
			// If fail, print image error.
			System.out.println("Image loading failed");
		}
	}

	/**
	 * Creates new Wizard object with the given valid parameters.
	 *
	 * @param name         object name.
	 * @param life         object life.
	 * @param attack_force object attack force.
	 * @return Wizard returns a new Wizard Object.
	 */
	public static Wizard wizardCreation(String name, int life, int attack_force, String race) {
		// Tries to create new Wizard object with all parameters.
		Wizard wizard;
		try {
			wizard = new Wizard(name, life, attack_force, race);
		} catch (IllegalArgumentException wizard_constructor_exception_1) {
			System.out.println(
					"Création échouée. Entrée de vie/force d'attaque invalide.\nEssai avec le paramètre nom uniquement.\nValeurs de vie et de force par défaut. Vous pourrez modifier votre personnage par la suite.");
			// If fail, tries to create new Wizard object with name parameter.
			try {
				wizard = new Wizard(name);
			} catch (IllegalArgumentException wizard_constructor_exception_2) {
				System.out.println(
						"Création échouée. Entrée de vie/force d'attaque invalide.\nEssai avec le paramètre nom uniquement.\nValeurs de vie et de force par défaut. Vous pourrez modifier votre personnage par la suite.");
				// If fail, creates new Wizard object without parameter.
				wizard = new Wizard();
			}
		}

		// Display image pointed by URL and infos.
		charImageDisplay(wizard);
		charInfosPrint(wizard);
		return wizard;
	}
}
