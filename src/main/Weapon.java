package main;

/**
 * Weapon object Data class.
 * 
 */
public class Weapon implements WeaponClassInterface {

	/** Weapon object name */
	private String name;

	/** Weapon object effect */
	private int damage;

	public Weapon() {
		this("Stick", 1);
	}

	public Weapon(String nameArg, int damageArg) {
		name = nameArg;
		damage = damageArg;
	}

	@Override
	public void setName(String newName) {
		this.name = newName;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setDamage(int newDamage) {
		this.damage = newDamage;
	}

	@Override
	public int getDamage() {
		return this.damage;
	}
}