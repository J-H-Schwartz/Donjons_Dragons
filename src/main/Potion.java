package main;

/**
 * Potion object Data class.
 * 
 */
public class Potion {

	/** Potion object name */
	private String name;

	/** Potion object effect */
	private int health_increase;

	public Potion() {
		name = "Small Health Potion";
		health_increase = 1;
	}

	public Potion(String name_arg, int health_arg) {
		name = name_arg;
		health_increase = health_arg;
	}

	public void setName(String new_name) {
		this.name = new_name;
	}

	public String getName() {
		return this.name;
	}

	public void setLife(int new_health_increase) {
		this.health_increase = new_health_increase;
	}

	public int getLife() {
		return this.health_increase;
	}
}
