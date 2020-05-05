package main;

/**
 * Wizard object Data class.
 * 
 */
public class Wizard extends Character implements WizardClassInterface {

	/** Wizard max life constant */
	static final int WIZARD_MAX_LIFE = 6;

	/** Wizard min life constant */
	static final int WIZARD_MIN_LIFE = 3;

	/** Wizard max Attack power constant */
	static final int WIZARD_MAX_ATTACK_POWER = 15;

	/** Wizard min Attack power constant */
	static final int WIZARD_MIN_ATTACK_POWER = 8;
	/** Wizard object Spell object */
	public Spell spell;

	/** Wizard object Potion object */
	public Potion potion;

	public Wizard() {
		this("Undefined", WIZARD_MIN_LIFE, WIZARD_MIN_ATTACK_POWER, "D");
	}

	public Wizard(String nameArg) {
		this(nameArg, WIZARD_MIN_LIFE, WIZARD_MIN_ATTACK_POWER, "D");
	}

	public Wizard(String nameArg, int lifeArg, int attackPowerArg, String raceChoice) {
		super(raceChoice);
		if (nameArg.isEmpty() || WIZARD_MIN_LIFE > lifeArg || WIZARD_MAX_LIFE < lifeArg
				|| WIZARD_MIN_ATTACK_POWER > attackPowerArg || WIZARD_MAX_ATTACK_POWER < attackPowerArg) {
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.className = "Wizard";
		this.name = nameArg;
		this.life = lifeArg;
		this.attackPower = attackPowerArg;
		this.spell = new Spell();
		this.potion = new Potion();
		if (raceChoice.equals("D")) {
			this.imageUrl = "./medias/DwarfWizard.png";
		} else if (raceChoice.equals("E")) {
			this.imageUrl = "./medias/ElveWizard.png";
		}
	}

	@Override
	public String toString() {
		return "Personnage " + this.name + " " + this.raceName + " " + this.className + "\nLife : " + this.life
				+ " Attack Power : " + this.attackPower + " Weapon : " + this.spell.getName() + " Shield : "
				+ this.potion.getName();
	}
}
