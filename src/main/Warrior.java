package main;

/**
 * Warrior object Data class.
 * 
 */
public class Warrior extends Character implements WarriorClassInterface {

	/** Warrior max life constant */
	static final int WARRIOR_MAX_LIFE = 10;

	/** Warrior min life constant */
	static final int WARRIOR_MIN_LIFE = 5;

	/** Warrior max Attack power constant */
	static final int WARRIOR_MAX_ATTACK_POWER = 10;

	/** Warrior max Attack power constant */
	static final int WARRIOR_MIN_ATTACK_POWER = 5;

	/** Warrior object Weapon object */
	public WeaponClassInterface weapon;

	/** Warrior object Shield object */
	public ShieldClassInterface shield;

	public Warrior() {
		this("Undefined", WARRIOR_MIN_LIFE, WARRIOR_MIN_ATTACK_POWER, "D");
	}

	public Warrior(String nameArg) {
		this(nameArg, WARRIOR_MIN_LIFE, WARRIOR_MIN_ATTACK_POWER, "D");
	}

	public Warrior(String nameArg, int lifeArg, int attackPowerArg, String raceChoice) {
		super(raceChoice);
		if (nameArg.isEmpty() || WARRIOR_MIN_LIFE > lifeArg || WARRIOR_MAX_LIFE < lifeArg
				|| WARRIOR_MIN_ATTACK_POWER > attackPowerArg || WARRIOR_MAX_ATTACK_POWER < attackPowerArg) {
			throw new IllegalArgumentException("Invalid Parameters.");
		}
		this.className = "Warrior";
		this.name = nameArg;
		this.life = lifeArg;
		this.attackPower = attackPowerArg;
		this.weapon = new Weapon();
		this.shield = new Shield();
		if (raceChoice.equals("D")) {
			this.imageUrl = "./medias/DwarfWarrior.png";
		} else if (raceChoice.equals("E")) {
			this.imageUrl = "./medias/ElveWarrior.png";
		}
	}

	@Override
	public String toString() {
		return "Personnage " + this.name + " " + this.raceName + " " + this.className + "\nLife : " + this.life
				+ " Attack Power : " + this.attackPower + " Weapon : " + this.weapon.getName() + " Shield : "
				+ this.shield.getName();
	}
}