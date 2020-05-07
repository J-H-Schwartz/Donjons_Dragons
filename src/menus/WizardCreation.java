package menus;

import characters.Wizard;

/**
 * Wizards creation class.
 * 
 */

public class WizardCreation implements WizardCreationInterface {

	/**
	 * Displays Wizard Object infos in console.
	 * 
	 * @param wizard
	 * 
	 */
	private void charInfosPrint(Wizard wizard) {
		System.out.println("Création du personnage " + wizard.getName() + " " + wizard.getClassName() + " "
				+ wizard.getRaceName() + "\nLife : " + wizard.getLife() + " Attack power : "
				+ wizard.getAttackPower());
	}

	/**
	 * Creates new Wizard object with the given valid parameters.
	 *
	 * @param name         object name.
	 * @param life         object life.
	 * @param attackForce object attack force.
	 * @return Wizard returns a new Wizard Object.
	 */
	@Override
	public Wizard wizardCreation(String name, int life, int attackForce, String race) {
		// Tries to create new Wizard object with all parameters.
		Wizard wizard;
		try {
			wizard = new Wizard(name, life, attackForce, race);
		} catch (IllegalArgumentException wizardConstructorException_1) {
			System.out.println(
					"Création échouée. Entrée de vie/force d'attaque invalide.\nEssai avec le paramètre nom uniquement.\nValeurs de vie et de force par défaut. Vous pourrez modifier votre personnage par la suite.");
			// If fail, tries to create new Wizard object with name parameter.
			try {
				wizard = new Wizard(name);
			} catch (IllegalArgumentException wizardConstructorException_2) {
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
