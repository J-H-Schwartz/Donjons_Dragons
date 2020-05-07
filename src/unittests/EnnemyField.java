package unittests;

import characters.Warrior;

public class EnnemyField implements Field{
	
	private int damage;
	
	public EnnemyField(int i) {
		this.damage = i;
	}

	public void open(Warrior warrior) {
		warrior.setLife(warrior.getLife() - damage); 
		
	}

}
