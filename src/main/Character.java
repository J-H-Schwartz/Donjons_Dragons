package main;

/**
 * Character abstract SuperClass
 *
 */
abstract class Character implements CharacterClassInterface {

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

	/** Character object Racial Spell */
	protected RacialSpellInterface racialSpell;

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
		this.life = newLife;
	}

	@Override
	public int getLife() {
		return this.life;
	}

	@Override
	public void setAttackPower(int newAttackPower) {
		this.attackPower = newAttackPower;
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
}
