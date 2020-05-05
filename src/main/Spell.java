package main;

/**
 * Spell object Data class.
 * 
 */
public class Spell extends RightHandEquipement {

	public Spell() {
		this("Spark", 1);
	}

	public Spell(String nameArg, int effectArg) {
		this.name = nameArg;
		this.effect = effectArg;
	}

}
