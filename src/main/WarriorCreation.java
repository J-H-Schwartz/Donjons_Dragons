package main;

/**
 * Warrior creation class.
 * 
 */

public class WarriorCreation implements WarriorCreationInterface {

	/**
	 * Displays Warrior Object infos in console.
	 * 
	 * @param warrior
	 * 
	 */
	private void charInfosPrint(Warrior warrior) {
		System.out.println("Création du personnage " + warrior.getName() + " " + warrior.getClassName() + " "
				+ warrior.getRaceName() + "\nLife : " + warrior.getLife() + " Attack power : "
				+ warrior.getAttackPower());
	}

	/**
	 * Creates new Warrior object with the given valid parameters.
	 *
	 * @param name        object name.
	 * @param life        object life.
	 * @param attackForce object attack force.
	 * @return Warrior returns a new Warrior Object.
	 */
	@Override
	public Warrior warriorCreation(String name, int life, int attackForce, String race) {
		Warrior warrior;
		// Tries to create new Warrior object with all parameters.
		try {
			warrior = new Warrior(name, life, attackForce, race);
		} catch (IllegalArgumentException warriorConstructorException_1) {
			System.out.println(
					"Création échouée. Entrée de vie/force d'attaque invalide.\nEssai avec le paramètre nom uniquement.\nValeurs de vie et de force par défaut. Vous pourrez modifier votre personnage par la suite.");
			// If fail, tries to create new Warrior object with name parameter.
			try {
				warrior = new Warrior(name);
			} catch (IllegalArgumentException warriorConstructorException_2) {
				System.out.println(
						"Création échouée. Nom invalide.\n Création avec paramètres par défaut. Vous pourrez modifier votre personnage par la suite.");
				// If fail, creates new Warrior object without parameter.
				warrior = new Warrior();
			}
		}

		// Display image pointed by URL and infos.
		charInfosPrint(warrior);
		return warrior;
	}
}
