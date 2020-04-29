package main;

public class Weapon {
	String name;
	int damage;
	
	public Weapon() {
		name = "Stick";
		damage = 1;
	}
	
	public Weapon(String name_arg) {
		name = name_arg;
		damage = 5;
	}
}
