package main;

public class Warrior {
	private String name;
	private int life;
	private int attack_power;
	private int max_life = 10;
	private int min_life = 5;
	private int max_attack_power = 10;
	private int min_attack_power = 5;
	private String image_url = "./medias/DwarfWarrior.png";
	Weapon weapon;
	Shield shield;
	
	public String toString() {
		return "Personnage " + this.name + " Life : " + this.life + " Attack Power : " + this.attack_power + " Weapon : " + this.weapon.getName() + " Shield : " + this.shield.getName();
	}

	public Warrior() {
		this.name = "Undefined";
		this.life = 10;
		this.attack_power = 5;
		this.weapon = new Weapon();
		this.shield = new Shield();
	}

	public Warrior(String name_arg) {
		this.name = name_arg;
		this.life = 10;
		this.attack_power = 5;
		this.weapon = new Weapon();
		this.shield = new Shield();
	}
	
	public Warrior(String name_arg, int life_arg, int attack_power_arg) {
		if (min_life > life_arg || max_life < life_arg || min_attack_power > attack_power_arg || max_attack_power < attack_power_arg){
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.name = name_arg;
		this.life = life_arg;
		this.attack_power = attack_power_arg;
		this.weapon = new Weapon();
		this.shield = new Shield();
	}
	
	void setName(String new_name) {
		this.name = new_name;
	}
	
	String getName() {
		return this.name;
	}
	
	void setLife(int new_life) {
		this.life = new_life;
	}
	
	int getLife() {
		return this.life;
	}
	
	void setAttackPower(int new_attack_power) {
		this.attack_power = new_attack_power;
	}
	
	int getAttackPower() {
		return this.attack_power;
	}
	
	void setImageUrl(String new_image_url) {
		this.image_url = new_image_url;
	}
	
	String getImageUrl() {
		return this.image_url;
	}
}