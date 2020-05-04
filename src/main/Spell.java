package main;

/**
 * Spell object Data class.
 * 
 */
public class Spell implements SpellClassInterface {
	
	/** Spell object name */
	private String name;
	
	/** Spell object effect */
	private int damage;

	public Spell() {
		this("Spark", 1);
	}

	public Spell(String name_arg, int damageArg) {
		name = name_arg;
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
