package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RacialSpell {
	private String name;
	private Method spell_method;
	
	public static void elveHeal() {
		System.out.println("Heals 1 life point");
	}

	public static void dwarfBerserk() {
		System.out.println("Hit twice");
	}
	
	public void activateRacialSpell() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.spell_method.invoke(null);
	}
	
	public RacialSpell(String race_choice) throws NoSuchMethodException, SecurityException{
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
