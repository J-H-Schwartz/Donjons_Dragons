package main;

abstract class Race {

	/** Warrior class name */
	protected String class_name;

	/** Warrior object name */
	protected String name;

	/** Warrior object life */
	protected int life;

	/** Warrior object Attack Power */
	protected int attack_power;

	/** Warrior object Image url */
	protected String image_url;

	protected String race_name;
	protected RacialSpell racial_spell;

	public Race(String race_choice) {
		if (race_choice.equals("D")) {
			this.setRace_name("Dwarf");
			try {
				this.setRacial_spell(new RacialSpell("D"));
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (race_choice.equals("E")) {
			this.setRace_name("Elve");
			try {
				this.setRacial_spell(new RacialSpell("E"));
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setName(String new_name) {
		this.name = new_name;
	}

	public String getName() {
		return this.name;
	}

	public void setLife(int new_life) {
		this.life = new_life;
	}

	public int getLife() {
		return this.life;
	}

	public void setAttackPower(int new_attack_power) {
		this.attack_power = new_attack_power;
	}

	public int getAttackPower() {
		return this.attack_power;
	}

	public void setImageUrl(String new_image_url) {
		this.image_url = new_image_url;
	}

	public String getImageUrl() {
		return this.image_url;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public RacialSpell getRacial_spell() {
		return racial_spell;
	}

	public void setRacial_spell(RacialSpell racial_spell) {
		this.racial_spell = racial_spell;
	}

	public String getRace_name() {
		return race_name;
	}

	public void setRace_name(String race_name) {
		this.race_name = race_name;
	}
}
