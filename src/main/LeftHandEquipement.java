package main;

abstract class LeftHandEquipement implements LeftHandEquipementInterface {
	
	protected String name;
	protected int effect;
	
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
