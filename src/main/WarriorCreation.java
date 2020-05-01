package main;

/**
 * Warrior creation class.
 * 
 */

public class WarriorCreation {

	private WarriorCreation() {
	}

	/**
	 * Displays Warrior Object infos in console.
	 * 
	 * @param warrior
	 * 
	 */
	private static void charInfosPrint(Warrior warrior) {
		System.out.println("Création du personnage " + warrior.getName() + " " + warrior.getClass_name() + " "
				+ warrior.getRace_name() + "\nLife : " + warrior.getLife() + " Attack power : "
				+ warrior.getAttackPower());
	}

	/**
	 * Creates new Warrior object with the given valid parameters.
	 *
	 * @param name         object name.
	 * @param life         object life.
	 * @param attack_force object attack force.
	 * @return Warrior returns a new Warrior Object.
	 */
	public static Warrior warriorCreation(String name, int life, int attack_force, String race) {
		Warrior warrior;
		// Tries to create new Warrior object with all parameters.
		try {
			warrior = new Warrior(name, life, attack_force, race);
		} catch (IllegalArgumentException warrior_constructor_exception_1) {
			System.out.println(
					"Création échouée. Entrée de vie/force d'attaque invalide.\nEssai avec le paramètre nom uniquement.\nValeurs de vie et de force par défaut. Vous pourrez modifier votre personnage par la suite.");
			// If fail, tries to create new Warrior object with name parameter.
			try {
				warrior = new Warrior(name);
			} catch (IllegalArgumentException warrior_constructor_exception_2) {
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
