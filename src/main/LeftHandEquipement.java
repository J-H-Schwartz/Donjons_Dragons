package main;

/**
 * Left hand Equipement SuperClass
 *
 */
abstract class LeftHandEquipement implements LeftHandEquipementInterface {
	
	protected String name;
	protected int effect;
	
	public LeftHandEquipement(String nameArg, int effectArg) {
		name = nameArg;
		effect = effectArg;
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
	public void setEffect(int newEffect) {
		this.effect = newEffect;
	}

	@Override
	public int getEffect() {
		return this.effect;
	}
}
