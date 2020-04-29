package main;

/**
 * Spell object Data class.
 * 
 */
public class Spell {
	
	/** Spell object name */
	private String name;
	
	/** Spell object effect */
	private int damage;

	public Spell() {
		name = "Spark";
		damage = 1;
	}

	public Spell(String name_arg, int damage_arg) {
		name = name_arg;
		damage = damage_arg;
	}

	public void setName(String new_name) {
		this.name = new_name;
	}

	public String getName() {
		return this.name;
	}

	public void setDamage(int new_damage) {
		this.damage = new_damage;
	}

	public int getDamage() {
		return this.damage;
	}
}
