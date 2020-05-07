package gamecore;

public abstract class Ennemi {
	String name;
	int life;
	int attackPower;
	
	public Ennemi(String name, int life, int attackPower) {
		this.name = name;
		this.life = life;
		this.attackPower = attackPower;
	}
}
