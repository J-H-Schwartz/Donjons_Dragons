package main;

import javax.swing.*;

//for layout managers and more
import java.awt.event.*; //for action events
import java.net.MalformedURLException;

public class WindowedIHM extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton b1, b2, b3, b4, b5, b6;
	static String input = "";
	static JFrame frame;

	public WindowedIHM(String menu_choice) {
		frame.setSize(700, 450);
		if (menu_choice.equals("C")) {
			ImageIcon dwarfWarriorImg = createImageIcon(
					"file:/home/jonathan/Desktop/Repositories/eclipse-workspace/Donjons_Dragons/medias/DwarfWarrior.png");
			ImageIcon dwarfWizardImg = createImageIcon(
					"file:/home/jonathan/Desktop/Repositories/eclipse-workspace/Donjons_Dragons/medias/DwarfWizard.png");
			ImageIcon elveWarriorImg = createImageIcon(
					"file:/home/jonathan/Desktop/Repositories/eclipse-workspace/Donjons_Dragons/medias/ElveWarrior.png");
			ImageIcon elveWizardImg = createImageIcon(
					"file:/home/jonathan/Desktop/Repositories/eclipse-workspace/Donjons_Dragons/medias/ElveWizard.png");

			b1 = new JButton("Dwarf Warrior", dwarfWarriorImg);
			b1.setVerticalTextPosition(AbstractButton.BOTTOM);
			b1.setHorizontalTextPosition(AbstractButton.CENTER);
			b1.setMnemonic(KeyEvent.VK_D);
			b1.setActionCommand("WD");

			b2 = new JButton("Dwarf Wizard", dwarfWizardImg);
			b2.setVerticalTextPosition(AbstractButton.BOTTOM);
			b2.setHorizontalTextPosition(AbstractButton.CENTER);
			b2.setMnemonic(KeyEvent.VK_M);
			b2.setActionCommand("DD");

			// Use the default text position of CENTER, TRAILING (RIGHT).
			b3 = new JButton("Elve Warrior", elveWarriorImg);
			b3.setVerticalTextPosition(AbstractButton.BOTTOM);
			b3.setHorizontalTextPosition(AbstractButton.CENTER);
			b3.setMnemonic(KeyEvent.VK_E);
			b3.setActionCommand("WE");

			b4 = new JButton("Elve Wizard", elveWizardImg);
			b4.setVerticalTextPosition(AbstractButton.BOTTOM);
			b4.setHorizontalTextPosition(AbstractButton.CENTER);
			b4.setMnemonic(KeyEvent.VK_U);
			b4.setActionCommand("DE");

			// Listen for actions on buttons 1 and 3.
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					input = "Q-Q";
				}
			});

			b1.setToolTipText("Click here to create a Dwarf Warrior.");
			b2.setToolTipText("Click here to create a Dwarf Wizard.");
			b3.setToolTipText("Click here to create a Elve Warrior.");
			b4.setToolTipText("Click here to create a Elve Wizard.");
			// Add Components to this container, using the default FlowLayout.
			add(b1);
			add(b2);
			add(b3);
			add(b4);
		} else if (menu_choice.equals("M")) {
			b1 = new JButton("Création de personnage");
			b1.setVerticalTextPosition(AbstractButton.CENTER);
			b1.setHorizontalTextPosition(AbstractButton.CENTER);
			b1.setMnemonic(KeyEvent.VK_D);
			b1.setActionCommand("MC");

			b2 = new JButton("Modification de personnage");
			b2.setVerticalTextPosition(AbstractButton.CENTER);
			b2.setHorizontalTextPosition(AbstractButton.CENTER);
			b2.setMnemonic(KeyEvent.VK_M);
			b2.setActionCommand("MM");

			// Use the default text position of CENTER, TRAILING (RIGHT).
			b3 = new JButton("Suppression de personnage");
			b3.setVerticalTextPosition(AbstractButton.CENTER);
			b3.setHorizontalTextPosition(AbstractButton.CENTER);
			b3.setMnemonic(KeyEvent.VK_E);
			b3.setActionCommand("MS");

			b4 = new JButton("Recherche de personnage");
			b4.setVerticalTextPosition(AbstractButton.CENTER);
			b4.setHorizontalTextPosition(AbstractButton.CENTER);
			b4.setMnemonic(KeyEvent.VK_U);
			b4.setActionCommand("MR");

			b5 = new JButton("Lister personnages");
			b5.setVerticalTextPosition(AbstractButton.CENTER);
			b5.setHorizontalTextPosition(AbstractButton.CENTER);
			b5.setMnemonic(KeyEvent.VK_U);
			b5.setActionCommand("ML");

			b6 = new JButton("Quitter");
			b6.setVerticalTextPosition(AbstractButton.CENTER);
			b6.setHorizontalTextPosition(AbstractButton.CENTER);
			b6.setMnemonic(KeyEvent.VK_U);
			b6.setActionCommand("QQ");

			// Listen for actions on buttons 1 and 3.
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			b6.addActionListener(this);
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					input = "Q-Q";
				}
			});

			b1.setToolTipText("Créer un nouveau personnage.");
			b2.setToolTipText("Modifier un personnage existant.");
			b3.setToolTipText("Supprimer un personnage existant.");
			b4.setToolTipText("Rechercher un personnage existant.");
			b5.setToolTipText("Lister tout les personnages.");
			b6.setToolTipText("Quitter le programme.");
			// Add Components to this container, using the default FlowLayout.
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			add(b5);
			add(b6);
		}
	}

	public void actionPerformed(ActionEvent e) {
		// Creation Menu
		if ("WD".equals(e.getActionCommand())) {
			input = "W-D";

		} else if ("DD".equals(e.getActionCommand())) {
			input = "D-D";

		} else if ("WE".equals(e.getActionCommand())) {
			input = "W-E";

		} else if ("DE".equals(e.getActionCommand())) {
			input = "D-E";

			// Main Menu
		} else if ("MC".equals(e.getActionCommand())) {
			input = "M-C";
		} else if ("MM".equals(e.getActionCommand())) {
			input = "M-M";
		} else if ("MS".equals(e.getActionCommand())) {
			input = "M-S";
		} else if ("MR".equals(e.getActionCommand())) {
			input = "M-R";
		} else if ("ML".equals(e.getActionCommand())) {
			input = "M-L";
		} else if ("QQ".equals(e.getActionCommand())) {
			input = "Q-Q";
		}
	}

	public static String sendMessage() {
		while (input.isEmpty()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String result = input;
		input = "";
		frame.dispose();
		return result;
	}

	/**
	 * Returns an ImageIcon, or null if the path was invalid.
	 * 
	 * @throws MalformedURLException
	 */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL;
		try {
			imgURL = new java.net.URL(path);
		} catch (MalformedURLException e) {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
		return new ImageIcon(imgURL);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event-dispatching thread.
	 */
	public static void createAndShowGUI(String menu_choice) {
		if (menu_choice.equals("C")) {
			// Create and set up the window.
			frame = new JFrame("Character Selection");
		} else if (menu_choice.equals("M")) {
			frame = new JFrame("Character Manager Main Menu");
		}
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// Create and set up the content pane.
		WindowedIHM newContentPane = new WindowedIHM(menu_choice);
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

}
