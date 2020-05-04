package main;

/**
 * Potion object Data class.
 * 
 */
public class Potion implements PotionClassInterface {

	/** Potion object name */
	private String name;

	/** Potion object effect */
	private int effect;

	public Potion() {
		this("Small health potion", 1);
	}

	public Potion(String nameArg, int healthArg) {
		name = nameArg;
		effect = healthArg;
	}

	@Override
	public void setName(String newName) {
		this.name = newName;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setLife(int newEffect) {
		this.effect = newEffect;
	}

	@Override
	public int getLife() {
		return this.effect;
	}
}
