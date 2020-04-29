package main;

public class Spell {
	String name;
	int damage;
	
	public Spell() {
		name = "Spark";
		damage = 1;
	}
	
	public Spell(String name_arg, int damage_arg) {
		name = name_arg;
		damage = damage_arg;
	}
	
	void setName(String new_name) {
		this.name = new_name;
	}
	
	String getName() {
		return this.name;
	}
	
	void setDamage(int new_damage) {
		this.damage = new_damage;
	}
	
	int getDamage() {
		return this.damage;
	}
}
