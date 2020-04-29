package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CharacterCreation {
	private ArrayList<Warrior> warriors = new ArrayList<Warrior>();
	private ArrayList<Wizard> wizards = new ArrayList<Wizard>();
	private int warriors_number = 0;
	private int wizards_number = 0;
	private String name_selection;
	private String char_selection;
	private int life_selection;
	private int attack_power_selection;
	private Wizard wizard;
	private Warrior warrior;

	void wizardCreation(String name, int life, int attack_force) {
		try {
			this.wizard = new Wizard(name, life, attack_force);
		} catch (Exception wizard_constructor_exception_1) {
			try {
				this.wizard = new Wizard(name);
			} catch (Exception wizard_constructor_exception_2) {
				this.wizard = new Wizard();
			}
		}
		try {
			new DisplayImage(this.wizard.getImageUrl());
		} catch (IOException e) {
			System.out.println("Image loading failed");
		}
		System.out.println("Création du personnage " + this.wizard.getName() + " Life : " + this.wizard.getLife()
				+ " Attack power : " + this.wizard.getAttackPower());
		this.wizards.add(this.wizards_number, this.wizard);
	}

	void warriorCreation(String name, int life, int attack_force) {
		try {
			this.warrior = new Warrior(name, life, attack_force);
		} catch (Exception wizard_constructor_exception_1) {
			try {
				this.warrior = new Warrior(name);
			} catch (Exception wizard_constructor_exception_2) {
				this.warrior = new Warrior();
			}
		}
		try {
			new DisplayImage(this.warrior.getImageUrl());
		} catch (IOException e) {
			System.out.println("Image loading failed");
		}
		System.out.println("Création du personnage " + this.warrior.getName() + " Life : " + this.warrior.getLife()
				+ " Attack power : " + this.warrior.getAttackPower());
		this.warriors.add(this.warriors_number, this.warrior);
	}

	void characterCreation() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Quel personnage souhaitez-vous créer ? (W)arrior or Wizar(D) ou (Q)uitter");
			this.char_selection = scanner.nextLine();
			if (char_selection.equals("Q")) {
				scanner.close();
				System.out.println("Programme quitté.");
				break;
			}
			if (!char_selection.equals("W") && !char_selection.equals("D")) {
				System.out.println("Commande non reconnue.");
				continue;
			}
			System.out.println("Entrez un nom : ");
			this.name_selection = scanner.nextLine();
			System.out.println("Entrez le maximum de points de vie (Warrior: 5-10, Wizard: 3-6) : ");
			try {
				this.life_selection = scanner.nextInt();
			} catch (Exception inputMismatchException) {
				System.out.println("Mauvais format d'entrée.");
				this.life_selection = 0;
			}
			System.out.println("Entrez les points d'attaque (Warrior: 5-10, Wizard: 8-15) : ");
			try {
				this.attack_power_selection = scanner.nextInt();
			} catch (Exception inputMismatchException) {
				System.out.println("Mauvais format d'entrée.");
				this.attack_power_selection = 0;
			}
			if (char_selection.equals("W")) {
				this.warriorCreation(this.name_selection, this.life_selection, this.attack_power_selection);
			} else if (char_selection.equals("D")) {
				this.wizardCreation(this.name_selection, this.life_selection, this.attack_power_selection);
			}
			System.out.println(warriors.toString());
			System.out.println(wizards.toString());
		}
	}
}
