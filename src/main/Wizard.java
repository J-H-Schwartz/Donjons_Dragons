package main;

public class Wizard {
	private String name;
	private int life;
	private int attack_power;
	private int max_life = 6;
	private int min_life = 3;
	private int max_attack_power = 15;
	private int min_attack_power = 8;
	private String image_url = "./medias/ElveWizard.png";
	Spell spell;
	Potion potion;

	public String toString() {
		return "Personnage " + this.name + " Life : " + this.life + " Attack Power : " + this.attack_power + " " + this.spell.getName() + " Potion : " + this.potion.getName();
	}

	public Wizard() {
		this.name = "Undefined";
		this.life = 6;
		this.attack_power = 8;
		this.spell = new Spell();
		this.potion = new Potion();
	}

	public Wizard(String name_arg) {
		if (name_arg.equals("")){
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.name = name_arg;
		this.life = 6;
		this.attack_power = 8;
		this.spell = new Spell();
		this.potion = new Potion();
	}

	public Wizard(String name_arg, int life_arg, int attack_power_arg) {
		if (name_arg.equals("") || min_life > life_arg || max_life < life_arg || min_attack_power > attack_power_arg
				|| max_attack_power < attack_power_arg) {
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.name = name_arg;
		this.life = life_arg;
		this.attack_power = attack_power_arg;
		this.spell = new Spell();
		this.potion = new Potion();
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
