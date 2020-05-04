package main;

/**
 * Wizard object Data class.
 * 
 */
public class Wizard extends Race implements SearchConstInterface, CharacterConstInterface {

	/** Wizard object Spell object */
	public Spell spell;

	/** Wizard object Potion object */
	public Potion potion;

	public Wizard() {
		this("Undefined", WIZARD_MIN_LIFE, WIZARD_MIN_ATTACK_POWER, "D");
	}

	public Wizard(String name_arg) {
		this(name_arg, WIZARD_MIN_LIFE, WIZARD_MIN_ATTACK_POWER, "D");
	}

	public Wizard(String name_arg, int life_arg, int attack_power_arg, String race_choice) {
		super(race_choice);
		if (name_arg.equals(EMPTY_STRING) || WIZARD_MIN_LIFE > life_arg || WIZARD_MAX_LIFE < life_arg
				|| WIZARD_MIN_ATTACK_POWER > attack_power_arg || WIZARD_MAX_ATTACK_POWER < attack_power_arg) {
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.class_name = "Wizard";
		this.name = name_arg;
		this.life = life_arg;
		this.attack_power = attack_power_arg;
		this.spell = new Spell();
		this.potion = new Potion();
		if (race_choice.equals("D")) {
			this.image_url = "./medias/DwarfWizard.png";
		} else if (race_choice.equals("E")) {
			this.image_url = "./medias/ElveWizard.png";
		}
	}
	
	@Override
	public String toString() {
		return "Personnage " + this.name + " " + this.race_name + " " + this.class_name + "\nLife : " + this.life
				+ " Attack Power : " + this.attack_power + " Weapon : " + this.spell.getName() + " Shield : "
				+ this.potion.getName();
	}
}
