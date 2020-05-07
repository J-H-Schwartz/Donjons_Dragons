package gameboard;

import main.GetRandomInt;

public class BoardCaseUpgrade extends BoardCase {
	String upgradeEffect;
	
	public BoardCaseUpgrade(int id) {
		super(id);
		this.caseStatus = 2;
		int randBonus = GetRandomInt.getRandomInt(5);
		if (randBonus == 0) {
			this.contains = "Bonus-Vie-1";			
		} else if (randBonus == 1) {
			this.contains = "Bonus-Vie-2";
		} else if (randBonus == 2) {
			this.contains = "Bonus-Vie-3";
		} else if (randBonus == 3) {
			this.contains = "Bonus-Attaque-1";
		} else if (randBonus == 4) {
			this.contains = "Bonus-Attaque-2";
		}
	}
}
