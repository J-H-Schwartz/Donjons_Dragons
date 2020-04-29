package main;

public class Weapon {
	private String name;
	private int damage;
	
	public Weapon() {
		name = "Stick";
		damage = 1;
	}
	
	public Weapon(String name_arg, int damage_arg) {
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