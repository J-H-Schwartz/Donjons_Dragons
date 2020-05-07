package characters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RacialSpell implements RacialSpellInterface {
	private String name;
	private Method spellMethod;

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
	@Override
	public void activateRacialSpell()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.spellMethod.invoke(null);
	}

	/**
	 * Affects different methods to the spell_method Object basing on the race
	 * choice.
	 * 
	 * @param raceChoice String object containing race input from CharacterCreation
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public RacialSpell(String raceChoice) throws NoSuchMethodException, SecurityException {
		if (raceChoice.equals("D")) {
			this.name = "Berserk";
			spellMethod = RacialSpell.class.getMethod("dwarfBerserk");
		} else if (raceChoice.equals("E")) {
			this.name = "Heal";
			spellMethod = RacialSpell.class.getMethod("elveHeal");
		}
	}

	@Override
	public String getName() {
		return name;
	}

}
