package main;

interface CharacterClassInterface {

	void setName(String newName);

	String getName();

	void setLife(int newLife);

	int getLife();

	void setAttackPower(int newAttackPower);

	int getAttackPower();

	void setImageUrl(String newImageUrl);

	String getImageUrl();

	String getClassName();

	void setClassName(String className);

	RacialSpellInterface getRacialSpell();

	void setRacialSpell(RacialSpellInterface racialSpell);

	String getRaceName();

	void setRaceName(String raceName);

}