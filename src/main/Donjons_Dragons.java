package main;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class Donjons_Dragons {

	public static void main(String[] args) {
		ArrayList<Warrior> warriors = new ArrayList<Warrior>();
		ArrayList<Wizard> wizards = new ArrayList<Wizard>();
		int warriors_number = 0;
		int wizards_number = 0;
		int life_selection;
		int attack_power_selection;
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Quel personnage souhaitez-vous créer ? (W)arrior or Wizar(D) ou (Q)uitter");
			String char_selection = scanner.nextLine();
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
			String name_selection = scanner.nextLine();
			System.out.println("Entrez le maximum de points de vie (Warrior: 5-10, Wizard: 3-6) : ");
			try {
				life_selection = scanner.nextInt();
			} catch (Exception inputMismatchException) {
				System.out.println("Mauvais format d'entrée.");
				life_selection = 0;
			}
			System.out.println("Entrez les points d'attaque (Warrior: 5-10, Wizard: 8-15) : ");
			try {
				attack_power_selection = scanner.nextInt();
			} catch (Exception inputMismatchException) {
				System.out.println("Mauvais format d'entrée.");
				attack_power_selection = 0;
			}
			if (name_selection.equals("")) {
				if (char_selection.equals("W")) {
					Warrior warrior = new Warrior();
					System.out.println("Création du personnage guerrier" + warrior.getName());
					warriors.add(warriors_number, warrior);
					try {
						new DisplayImage(warrior.getImageUrl());
					} catch (IOException e) {
						System.out.println("Image loading failed");
					}
					++warriors_number;
				} else if (char_selection.equals("D")) {
					Wizard wizard = new Wizard();
					System.out.println("Création du personnage sorcier" + wizard.getName());
					wizards.add(wizards_number, wizard);
					try {
						new DisplayImage(wizard.getImageUrl());
					} catch (IOException e) {
						System.out.println("Image loading failed");
					}
					++wizards_number;
				}
			} else if (!name_selection.equals("") && (life_selection == 0 || attack_power_selection == 0)) {
				if (char_selection.equals("W")) {
					Warrior warrior = new Warrior(name_selection);
					System.out.println("Création du personnage guerrier" + warrior.getName());
					warriors.add(warriors_number, warrior);
					try {
						new DisplayImage(warrior.getImageUrl());
					} catch (IOException e) {
						System.out.println("Image loading failed");
					}
					++warriors_number;
				} else if (char_selection.equals("D")) {
					Wizard wizard = new Wizard(name_selection);
					System.out.println("Création du personnage sorcier" + wizard.getName());
					wizards.add(wizards_number, wizard);
					try {
						new DisplayImage(wizard.getImageUrl());
					} catch (IOException e) {
						System.out.println("Image loading failed");
					}
					++wizards_number;
				}
			} else if (!name_selection.equals("") && (life_selection != 0 && attack_power_selection != 0)) {
				try {
					if (char_selection.equals("W")) {
						Warrior warrior = new Warrior(name_selection, life_selection, attack_power_selection);
						System.out.println("Création du personnage " + warrior.getName() + " Life = " + warrior.getLife() + " Attack power : " + warrior.getAttackPower());
						warriors.add(warriors_number, warrior);
						try {
							new DisplayImage(warrior.getImageUrl());
						} catch (IOException e) {
							System.out.println("Image loading failed");
						}
						++warriors_number;
					} else if (char_selection.equals("D")) {
						Wizard wizard = new Wizard(name_selection, life_selection, attack_power_selection);
						System.out.println("Création du personnage " + wizard.getName() + " Life : " + wizard.getLife() + " Attack power : " + wizard.getAttackPower());
						wizards.add(wizards_number, wizard);
						try {
							new DisplayImage(wizard.getImageUrl());
						} catch (IOException e) {
							System.out.println("Image loading failed");
						}
						++wizards_number;
					}
				} catch (Exception IllegalArgumentException) {
					System.out.println("Argument de vie ou d'attaque invalide.");
					if (char_selection.equals("W")) {
						Warrior warrior = new Warrior(name_selection);
						System.out.println("Création du personnage " + warrior.getName());
						warriors.add(warriors_number, warrior);
						try {
							new DisplayImage(warrior.getImageUrl());
						} catch (IOException e) {
							System.out.println("Image loading failed");
						}
						++warriors_number;
					} else if (char_selection.equals("D")) {
						Wizard wizard = new Wizard(name_selection);
						System.out.println("Création du personnage sorcier " + wizard.getName());
						wizards.add(wizards_number, wizard);
						try {
							new DisplayImage(wizard.getImageUrl());
						} catch (IOException e) {
							System.out.println("Image loading failed");
						}
						++wizards_number;
					}
				}
			}
			System.out.println(warriors.toString());
			System.out.println(wizards.toString());
		}
	}
}
