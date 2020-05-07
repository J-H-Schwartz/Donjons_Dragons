package menus;

import characters.Wizard;

public interface WizardCreationInterface {

	/**
	 * Creates new Wizard object with the given valid parameters.
	 *
	 * @param name         object name.
	 * @param life         object life.
	 * @param attackForce object attack force.
	 * @return Wizard returns a new Wizard Object.
	 */
	Wizard wizardCreation(String name, int life, int attackForce, String race);

}