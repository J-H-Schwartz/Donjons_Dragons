package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RacialSpell {
	private String name;
	private Method spell_method;

	/**
	 * Test method for Reflect Callback May be implemented with real statements
	 * later.
	 */
	public static void elveHeal() {
		System.out.println("Heals 1 life point");
	}

	/**
	 * Test method for Reflect Callback May be implemented with real statements
	 * later.
	 */
	public static void dwarfBerserk() {
		System.out.println("Hit twice");
	}

	/**
	 * Callback to run the spell_method selected Method.
	 * 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public void activateRacialSpell()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.spell_method.invoke(null);
	}

	/**
	 * Affects different methods to the spell_method Object basing on the race
	 * choice.
	 * 
	 * @param race_choice String object containing race input from CharacterCreation
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public RacialSpell(String race_choice) throws NoSuchMethodException, SecurityException {
		if (race_choice.equals("D")) {
			this.name = "Berserk";
			spell_method = RacialSpell.class.getMethod("dwarfBerserk");
		} else if (race_choice.equals("E")) {
			this.name = "Heal";
			spell_method = RacialSpell.class.getMethod("elveHeal");
		}
	}

	public String getName() {
		return name;
	}

}
