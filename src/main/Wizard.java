package main;

public class Wizard {
	String name;
	int life;
	int attack_power;
	String image_url = "./medias/ElveWizard.png";
	Spell spell;
	String potion;
	private int max_life = 6;
	private int min_life = 3;
	private int max_attack_power = 15;
	private int min_attack_power = 8;

	public String toString() {
		return "Personnage " + this.name + " Life : " + this.life + " Attack Power : " + this.attack_power + " " + this.potion;
	}

	public Wizard() {
		this.name = "Undefined";
		this.life = 6;
		this.attack_power = 8;
		this.spell = new Spell();
		this.potion = "No Shield equipped.";
	}

	public Wizard(String name_arg) {
		this.name = name_arg;
		this.life = 6;
		this.attack_power = 8;
		this.spell = new Spell();
		this.potion = "No Shield equipped.";
	}

	public Wizard(String name_arg, int life_arg, int attack_power_arg) {
		if (min_life > life_arg || max_life < life_arg || min_attack_power > attack_power_arg
				|| max_attack_power < attack_power_arg) {
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.name = name_arg;
		this.life = life_arg;
		this.attack_power = attack_power_arg;
		this.spell = new Spell();
		this.potion = "No Potion equipped.";
	}
}
