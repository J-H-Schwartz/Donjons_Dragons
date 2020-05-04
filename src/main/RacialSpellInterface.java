package main;

import java.lang.reflect.InvocationTargetException;

public interface RacialSpellInterface {

	/**
	 * Callback to run the spell_method selected Method.
	 * 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	void activateRacialSpell() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	String getName();

}