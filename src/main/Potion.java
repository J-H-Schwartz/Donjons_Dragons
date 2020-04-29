package main;

public class Potion {
	private String name;
	private int health_increase;
	
	public Potion() {
		name = "Small Health Potion";
		health_increase = 1;
	}
	
	public Potion(String name_arg, int health_arg) {
		name = name_arg;
		health_increase = health_arg;
	}
	
	void setName(String new_name) {
		this.name = new_name;
	}
	
	String getName() {
		return this.name;
	}
	
	void setLife(int new_health_increase) {
		this.health_increase = new_health_increase;
	}
	
	int getLife() {
		return this.health_increase;
	}
}
