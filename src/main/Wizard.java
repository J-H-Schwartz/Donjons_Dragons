package main;

/**
 * Wizard object Data class.
 * 
 */
public class Wizard extends Race{
	
	private String class_name;
	
	/** Wizard object name */
	private String name;

	/** Wizard object life */
	private int life;

	/** Wizard object Attack power */
	private int attack_power;

	/** Empty string constant */
	private static final String EMPTY_STRING = "";

	/** Wizard max life constant */
	private static final int MAX_LIFE = 6;

	/** Wizard min life constant */
	private static final int MIN_LIFE = 3;

	/** Wizard max Attack power constant */
	private static final int MAX_ATTACK_POWER = 15;

	/** Wizard min Attack power constant */
	private static final int MIN_ATTACK_POWER = 8;

	/** Wizard object Image url */
	private String image_url;

	/** Wizard object Spell object */
	public Spell spell;

	/** Wizard object Potion object */
	public Potion potion;

	@Override
	public String toString() {
		return "Personnage " + this.name + " " + this.getRace_name() + " " + this.class_name + "\nLife : " + this.life + " Attack Power : " + this.attack_power + " "
				+ this.spell.getName() + " Potion : " + this.potion.getName();
	}

	public Wizard() {
		this("Undefined", MIN_LIFE, MIN_ATTACK_POWER, "D");
	}

	public Wizard(String name_arg) {
		this(name_arg, MIN_LIFE, MIN_ATTACK_POWER, "D");
	}

	public Wizard(String name_arg, int life_arg, int attack_power_arg, String race_choice) {
		super(race_choice);
		if (name_arg.equals(EMPTY_STRING) || MIN_LIFE > life_arg || MAX_LIFE < life_arg
				|| MIN_ATTACK_POWER > attack_power_arg || MAX_ATTACK_POWER < attack_power_arg) {
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.class_name = "Wizard";
		this.name = name_arg;
		this.life = life_arg;
		this.attack_power = attack_power_arg;
		this.spell = new Spell();
		this.potion = new Potion();
		if(race_choice.equals("D")) {
			this.image_url = "./medias/DwarfWizard.png";
		} else if (race_choice.equals("E")) {
			this.image_url = "./medias/ElveWizard.png";
		}
	}

	public String getRaceName() {
		return this.getRace_name();
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

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	@Override
	public RacialSpell getRacial_spell() {
		return racial_spell;
	}
	
	@Override
	public void setRacial_spell(RacialSpell racial_spell) {
		this.racial_spell = racial_spell;
	}

	@Override
	public String getRace_name() {
		return race_name;
	}

	@Override
	public void setRace_name(String race_name) {
		this.race_name = race_name;
	}
}
