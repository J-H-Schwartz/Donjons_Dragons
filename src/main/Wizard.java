package main;

/**
 * Wizard object Data class.
 * 
 */
public class Wizard extends Character implements WizardClassInterface {

	/** Wizard max life constant */
	static final int WIZARD_MAX_LIFE = 10;

	/** Wizard min life constant */
	static final int WIZARD_MIN_LIFE = 5;

	/** Wizard max Attack power constant */
	static final int WIZARD_MAX_ATTACK_POWER = 10;

	/** Wizard min Attack power constant */
	static final int WIZARD_MIN_ATTACK_POWER = 5;

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
		this.rightHand = new Spell();
		this.leftHand = new Potion();
		if (raceChoice.equals("D")) {
			this.imageUrl = "./medias/DwarfWizard.png";
		} else if (raceChoice.equals("E")) {
			this.imageUrl = "./medias/ElveWizard.png";
		}
	}

	@Override
	public String toString() {
		return "Personnage " + this.name + " " + this.raceName + " " + this.className + "\nLife : " + this.life
				+ " Attack Power : " + this.attackPower + " Weapon : " + this.rightHand.getName() + " Shield : "
				+ this.leftHand.getName();
	}

	/**
	 * @return the spell
	 */
	public RightHandEquipement getSpell() {
		return rightHand;
	}

	/**
	 * @param spell the spell to set
	 */
	public void setSpell(Spell spell) {
		this.rightHand = spell;
	}

	/**
	 * @return the potion
	 */
	public LeftHandEquipement getPotion() {
		return leftHand;
	}

	/**
	 * @param potion the potion to set
	 */
	public void setPotion(Potion potion) {
		this.leftHand = potion;
	}
}
