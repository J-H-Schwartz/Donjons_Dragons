package main;

/**
 * Warrior object Data class.
 * 
 */
public class Warrior extends Race implements SearchConstInterface, CharacterConstInterface {

	/** Warrior object Weapon object */
	public Weapon weapon;

	/** Warrior object Shield object */
	public Shield shield;

	public Warrior() {
		this("Undefined", WARRIOR_MIN_LIFE, WARRIOR_MIN_ATTACK_POWER, "D");
	}

	public Warrior(String name_arg) {
		this(name_arg, WARRIOR_MIN_LIFE, WARRIOR_MIN_ATTACK_POWER, "D");
	}

	public Warrior(String name_arg, int life_arg, int attack_power_arg, String race_choice) {
		super(race_choice);
		if (name_arg.equals(EMPTY_STRING) || WARRIOR_MIN_LIFE > life_arg || WARRIOR_MAX_LIFE < life_arg
				|| WARRIOR_MIN_ATTACK_POWER > attack_power_arg || WARRIOR_MAX_ATTACK_POWER < attack_power_arg) {
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.class_name = "Warrior";
		this.name = name_arg;
		this.life = life_arg;
		this.attack_power = attack_power_arg;
		this.weapon = new Weapon();
		this.shield = new Shield();
		if (race_choice.equals("D")) {
			this.image_url = "./medias/DwarfWarrior.png";
		} else if (race_choice.equals("E")) {
			this.image_url = "./medias/ElveWarrior.png";
		}
	}

	@Override
	public String toString() {
		return "Personnage " + this.name + " " + this.race_name + " " + this.class_name + "\nLife : " + this.life
				+ " Attack Power : " + this.attack_power + " Weapon : " + this.weapon.getName() + " Shield : "
				+ this.shield.getName();
	}
}