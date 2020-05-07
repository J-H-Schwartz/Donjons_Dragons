package gameboard;

import ennemies.Ennemi;
import ennemies.EnnemiChicken;
import ennemies.EnnemiGoblin;
import ennemies.EnnemiOgre;
import ennemies.EnnemiOrc;
import ennemies.EnnemiTroll;
import main.GetRandomInt;

public class BoardCaseEnnemy extends BoardCase {
	private Ennemi ennemi;
	
	public BoardCaseEnnemy(int id) {
		super(id);
		this.caseStatus = 1;
		
		int randEnnemy = GetRandomInt.getRandomInt(5);
		if (randEnnemy == 0) {
			this.contains = "Ennemi-Goblin-1";
			this.ennemi = new EnnemiGoblin();
		} else if (randEnnemy == 1) {
			this.contains = "Ennemi-Orc-2";
			this.ennemi = new EnnemiOrc();
		} else if (randEnnemy == 2) {
			this.contains = "Ennemi-Troll-3";
			this.ennemi = new EnnemiTroll();
		} else if (randEnnemy == 3) {
			this.contains = "Ennemi-Ogre-4";
			this.ennemi = new EnnemiOgre();
		} else if (randEnnemy == 4) {
			this.contains = "Ennemi-Chicken-5";
			this.ennemi = new EnnemiChicken();
		}
	}

	/**
	 * @return the ennemi
	 */
	public Ennemi getEnnemi() {
		return ennemi;
	}

	/**
	 * @param ennemi the ennemi to set
	 */
	public void setEnnemi(Ennemi ennemi) {
		this.ennemi = ennemi;
	}
}
