package main;

public interface WarriorCreationInterface {

	/**
	 * Creates new Warrior object with the given valid parameters.
	 *
	 * @param name        object name.
	 * @param life        object life.
	 * @param attackForce object attack force.
	 * @return Warrior returns a new Warrior Object.
	 */
	Warrior warriorCreation(String name, int life, int attackForce, String race);

}