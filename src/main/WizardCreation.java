package main;

/**
 * Wizards creation class.
 * 
 */

public class WizardCreation {

	/**
	 * Displays Wizard Object infos in console.
	 * 
	 * @param wizard
	 * 
	 */
	private void charInfosPrint(Wizard wizard) {
		System.out.println("Création du personnage " + wizard.getName() + " " + wizard.getClass_name() + " "
				+ wizard.getRace_name() + "\nLife : " + wizard.getLife() + " Attack power : "
				+ wizard.getAttackPower());
	}

	/**
	 * Creates new Wizard object with the given valid parameters.
	 *
	 * @param name         object name.
	 * @param life         object life.
	 * @param attack_force object attack force.
	 * @return Wizard returns a new Wizard Object.
	 */
	public Wizard wizardCreation(String name, int life, int attack_force, String race) {
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
		charInfosPrint(wizard);
		return wizard;
	}
}
