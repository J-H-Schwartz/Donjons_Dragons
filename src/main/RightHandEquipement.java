package main;

/**
 * Right hand Equipement SuperClass
 *
 */
abstract class RightHandEquipement implements RightHandEquipementInterface {
	
	protected String name;
	protected int effect;
	
	public RightHandEquipement(String nameArg, int effectArg) {
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
