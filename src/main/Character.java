package main;

/**
 * Character abstract SuperClass
 *
 */
public abstract class Character implements CharacterClassInterface {

	/** Character class name */
	protected String className;

	/** Character object name */
	protected String name;

	/** Character object life */
	protected int life;

	/** Character object Attack Power */
	protected int attackPower;

	/** Character object Image url */
	protected String imageUrl;

	/** Character object Race Name */
	protected String raceName;

	/** Warrior object Weapon object */
	protected RightHandEquipement rightHand;

	/** Warrior object Shield object */
	protected LeftHandEquipement leftHand;

	/** Character object Racial Spell */
	protected RacialSpellInterface racialSpell;

	protected int boardPosition;

	public Character(String raceChoice) {
		if (raceChoice.equals("D")) {
			this.setRaceName("Dwarf");
			try {
				this.setRacialSpell(new RacialSpell("D"));
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (raceChoice.equals("E")) {
			this.setRaceName("Elve");
			try {
				this.setRacialSpell(new RacialSpell("E"));
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		boardPosition = -1;
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
	public void setLife(int newLife) {
		if (newLife > 10) {
			this.life = 10;
		} else if (newLife < 0) {
			this.life = 0;
		} else {
			this.life = newLife;
		}
	}

	@Override
	public int getLife() {
		return this.life;
	}

	@Override
	public void setAttackPower(int newAttackPower) {
		if (newAttackPower > 10) {
			this.attackPower = 10;
		} else {
			this.attackPower = newAttackPower;
		}
	}

	@Override
	public int getAttackPower() {
		return this.attackPower;
	}

	@Override
	public void setImageUrl(String newImageUrl) {
		this.imageUrl = newImageUrl;
	}

	@Override
	public String getImageUrl() {
		return this.imageUrl;
	}

	@Override
	public String getClassName() {
		return className;
	}

	@Override
	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public RacialSpellInterface getRacialSpell() {
		return racialSpell;
	}

	@Override
	public void setRacialSpell(RacialSpellInterface racialSpell) {
		this.racialSpell = racialSpell;
	}

	@Override
	public String getRaceName() {
		return raceName;
	}

	@Override
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	/**
	 * @return the rightHand
	 */
	public RightHandEquipement getRightHand() {
		return rightHand;
	}

	/**
	 * @param rightHand the rightHand to set
	 */
	public void setRightHand(RightHandEquipement rightHand) {
		this.rightHand = rightHand;
	}

	/**
	 * @return the leftHand
	 */
	public LeftHandEquipement getLeftHand() {
		return leftHand;
	}

	/**
	 * @param leftHand the leftHand to set
	 */
	public void setLeftHand(LeftHandEquipement leftHand) {
		this.leftHand = leftHand;
	}

	/**
	 * @return the boardPosition
	 */
	public int getBoardPosition() {
		return boardPosition;
	}

	/**
	 * @param boardPosition the boardPosition to set
	 */
	public void setBoardPosition(int boardPosition) {
		this.boardPosition = boardPosition;
	}
}
