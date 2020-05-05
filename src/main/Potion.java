package main;

/**
 * Potion object Data class.
 * 
 */
public class Potion extends LeftHandEquipement {
	
	public Potion() {
		this("Small health potion", 1);
	}

	public Potion(String nameArg, int effectArg) {
		name = nameArg;
		effect = effectArg;
	}

}
