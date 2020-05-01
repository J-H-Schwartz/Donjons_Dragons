package main;

abstract class Race {
	
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

	abstract RacialSpell getRacial_spell();

	abstract void setRacial_spell(RacialSpell racial_spell);

	abstract String getRace_name();

	abstract void setRace_name(String race_name);
}
