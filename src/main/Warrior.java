package main;

/**
 * Warrior object Data class.
 * 
 */
public class Warrior {
	private String name;
	private int life;
	private int attack_power;
	private static final String EMPTY_STRING = "";
	private static final int MAX_LIFE = 10;
	private static final int MIN_LIFE = 5;
	private static final int MAX_ATTACK_POWER = 10;
	private static final int MIN_ATTACK_POWER = 5;
	private String image_url = "./medias/DwarfWarrior.png";
	public Weapon weapon;
	public Shield shield;

	public String toString() {
		return "Personnage " + this.name + " Life : " + this.life + " Attack Power : " + this.attack_power
				+ " Weapon : " + this.weapon.getName() + " Shield : " + this.shield.getName();
	}

	public Warrior() {
		this.name = "Undefined";
		this.life = 10;
		this.attack_power = 5;
		this.weapon = new Weapon();
		this.shield = new Shield();
	}

	public Warrior(String name_arg) {
		if (name_arg.equals(EMPTY_STRING)) {
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.name = name_arg;
		this.life = 10;
		this.attack_power = 5;
		this.weapon = new Weapon();
		this.shield = new Shield();
	}

	public Warrior(String name_arg, int life_arg, int attack_power_arg) {
		if (name_arg.equals(EMPTY_STRING) || MIN_LIFE > life_arg || MAX_LIFE < life_arg
				|| MIN_ATTACK_POWER > attack_power_arg || MAX_ATTACK_POWER < attack_power_arg) {
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.name = name_arg;
		this.life = life_arg;
		this.attack_power = attack_power_arg;
		this.weapon = new Weapon();
		this.shield = new Shield();
	}

	public void setName(String new_name) {
		this.name = new_name;
	}

	public String getName() {
		return this.name;
	}

	public void setLife(int new_life) {
		this.life = new_life;
	}

	public int getLife() {
		return this.life;
	}

	public void setAttackPower(int new_attack_power) {
		this.attack_power = new_attack_power;
	}

	public int getAttackPower() {
		return this.attack_power;
	}

	public void setImageUrl(String new_image_url) {
		this.image_url = new_image_url;
	}

	public String getImageUrl() {
		return this.image_url;
	}
}