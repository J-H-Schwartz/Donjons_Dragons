package main;

public class Warrior {
	String name;
	int life;
	int attack_power;
	String image_url = "./medias/DwarfWarrior.png";
	Weapon weapon;
	String shield;
	private int max_life = 10;
	private int min_life = 5;
	private int max_attack_power = 10;
	private int min_attack_power = 5;
	
	public String toString() {
		return "Personnage " + this.name + " Life : " + this.life + " Attack Power : " + this.attack_power + " " + this.shield + " Weapon : " + this.weapon.name;
	}

	public Warrior() {
		this.name = "Undefined";
		this.life = 10;
		this.attack_power = 5;
		this.weapon = new Weapon();
		this.shield = "No Shield equipped.";
	}

	public Warrior(String name_arg) {
		this.name = name_arg;
		this.life = 10;
		this.attack_power = 5;
		this.weapon = new Weapon();
		this.shield = "No Shield equipped.";
	}
	
	public Warrior(String name_arg, int life_arg, int attack_power_arg) {
		if (min_life > life_arg || max_life < life_arg || min_attack_power > attack_power_arg || max_attack_power < attack_power_arg){
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.name = name_arg;
		this.life = life_arg;
		this.attack_power = attack_power_arg;
		this.weapon = new Weapon();
		this.shield = "No Shield equipped.";
	}
}