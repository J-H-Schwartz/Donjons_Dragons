package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class WindowedIHM implements ActionListener {
	protected JButton b1, b2, b3, b4, b5, b6;
	protected JTextField tf1, tf2, tf3;
	static JLabel tf1_label, tf2_label, tf3_label;
	static String input = "";
	static JFrame frame;
	static JPanel newContentPane;
	static String text;
	static String name_input = "";
	static String life_input = "";
	static String ap_input = "";
	static boolean name_ok = false;
	static boolean life_ok = false;
	static boolean ap_ok = false;

	public WindowedIHM(String menu_choice) {
		if (menu_choice.equals("C")) {
			buildCreationFrame1();
		} else if (menu_choice.equals("C2")) {
			buildCreationFrame2();
		} else if (menu_choice.equals("L")) {
			buildListFrame();
		} else if (menu_choice.equals("M")) {
			buildMainMenuFrame();
		}
	}

	private void buildMainMenuFrame() {
		newContentPane = new JPanel(new GridLayout(0, 2));
		newContentPane.setBackground(Color.BLACK);
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
			@Override
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
		newContentPane.add(b1);
		newContentPane.add(b2);
		newContentPane.add(b3);
		newContentPane.add(b4);
		newContentPane.add(b5);
		newContentPane.add(b6);
	}

	private void buildListFrame() {
		newContentPane = new JPanel(new GridBagLayout());
		newContentPane.setBackground(Color.BLACK);
		GridBagConstraints c1 = new GridBagConstraints();

		GridBagConstraints c3 = new GridBagConstraints();

		String[] column_names = { "Nom", "Race", "Classe", "Pts de Vie", "Pts d'Attaque" };
		DefaultTableModel tblModel = new DefaultTableModel(column_names, 0);
		JTable characters_table = new JTable(tblModel);
		characters_table.setFillsViewportHeight(true);

		ArrayList<Character> charactersList = MainMenu.getWCharactersList();
		charactersList.sort(new CharactersListClassSorter());
		for (int i = 0; i < charactersList.size(); i++) {
			String name = charactersList.get(i).getName();
			String race_name = charactersList.get(i).getRaceName();
			String class_name = charactersList.get(i).getClassName();
			String life_pts = Integer.toString(charactersList.get(i).getLife());
			String ap_pts = Integer.toString(charactersList.get(i).getAttackPower());
			Object[] data = { name, race_name, class_name, life_pts, ap_pts };
			tblModel.addRow(data);
		}

		JScrollPane scroll_pane_war = new JScrollPane();

		c1.weightx = 1;
		c1.weighty = 1;
		c1.gridheight = 5;
		c1.gridx = 0;
		c1.gridy = 1;
		c1.anchor = GridBagConstraints.NORTHWEST;
		c1.fill = GridBagConstraints.BOTH;
		scroll_pane_war.setViewportView(characters_table);
		newContentPane.add(scroll_pane_war, c1);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				input = "Q-Q";
			}
		});

		b2 = new JButton("Cancel");
		b2.setVerticalTextPosition(AbstractButton.CENTER);
		b2.setHorizontalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic(KeyEvent.VK_D);
		b2.setActionCommand("C2CAN");
		b2.addActionListener(this);
		c3.weightx = 1;
		c3.weighty = 0.05;
		c3.gridheight = 1;
		c3.gridwidth = 2;
		c3.gridx = 0;
		c3.gridy = 6;
		c3.anchor = GridBagConstraints.SOUTHWEST;
		c3.fill = GridBagConstraints.BOTH;
		newContentPane.add(b2, c3);
	}

	private void buildCreationFrame2() {
		newContentPane = new JPanel(new GridBagLayout());
		newContentPane.setBackground(Color.DARK_GRAY);
		GridBagConstraints c = new GridBagConstraints();

		tf1 = new JTextField(20);
		tf1.setPreferredSize(new Dimension(200, 30));
		tf1.setHorizontalAlignment(JTextField.CENTER);
		tf1.setActionCommand("tf1_valid");
		tf1.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent e) {
				warn();
			}

			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {
				text = tf1.getText();
				if (text.length() > 20) {
					JOptionPane.showMessageDialog(null, "Error: 20 chars max.", "Error Message",
							JOptionPane.ERROR_MESSAGE);
				} else {
					name_input = text;
				}
			}
		});
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		newContentPane.add(tf1, c);

		JLabel name_label = new JLabel("Entrez un nom (20 caractères maximum): ");
		name_label.setLabelFor(tf1);
		name_label.setHorizontalAlignment(SwingConstants.RIGHT);
		name_label.setForeground(Color.YELLOW);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.EAST;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		newContentPane.add(name_label, c);

		tf2 = new JTextField(2);
		tf2.setPreferredSize(new Dimension(200, 30));
		tf2.setHorizontalAlignment(JTextField.CENTER);
		tf2.setActionCommand("tf2_valid");
		tf2.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}

			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {
				text = tf2.getText();
				if (!text.isEmpty()) {
					try {
						if (Integer.parseInt(text) < 5 || Integer.parseInt(text) > 10) {
							JOptionPane.showMessageDialog(null, "Error: Life must be between 5 and 10.",
									"Error Message", JOptionPane.ERROR_MESSAGE);
						} else {
							life_input = text;
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error: Life must be a number.", "Error Message",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		newContentPane.add(tf2, c);

		JLabel life_label = new JLabel("Entrez la valeur de vie (5 à 10): ");
		life_label.setLabelFor(tf2);
		life_label.setHorizontalAlignment(SwingConstants.RIGHT);
		life_label.setForeground(Color.YELLOW);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.EAST;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		newContentPane.add(life_label, c);

		tf3 = new JTextField(2);
		tf3.setPreferredSize(new Dimension(200, 30));
		tf3.setHorizontalAlignment(JTextField.CENTER);
		tf3.setActionCommand("tf3_valid");
		tf3.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}

			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {
				text = tf3.getText();
				if (!text.isEmpty()) {
					try {
						if (Integer.parseInt(text) < 5 || Integer.parseInt(text) > 10) {
							JOptionPane.showMessageDialog(null, "Error: AP must be between 5 and 10.",
									"Error Message", JOptionPane.ERROR_MESSAGE);
						} else {
							ap_input = text;
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error: AP must be a number.", "Error Message",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		newContentPane.add(tf3, c);

		JLabel ap_label = new JLabel("Entrez la valeur de puissance d'attaque (5 à 10): ");
		ap_label.setLabelFor(tf3);
		ap_label.setHorizontalAlignment(SwingConstants.RIGHT);
		ap_label.setForeground(Color.YELLOW);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.EAST;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		newContentPane.add(ap_label, c);

		b1 = new JButton("Validate");
		b1.setVerticalTextPosition(AbstractButton.CENTER);
		b1.setHorizontalTextPosition(AbstractButton.CENTER);
		b1.setMnemonic(KeyEvent.VK_D);
		b1.setActionCommand("C2VAL");
		b1.addActionListener(this);
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 50;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		newContentPane.add(b1, c);

		b2 = new JButton("Cancel");
		b2.setVerticalTextPosition(AbstractButton.CENTER);
		b2.setHorizontalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic(KeyEvent.VK_D);
		b2.setActionCommand("C2CAN");
		b2.addActionListener(this);
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 50;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		newContentPane.add(b2, c);

		Font myFont = new Font("SansSerif", Font.PLAIN, 20);
		Color myColor = Color.YELLOW;
		TitledBorder titledBorder = BorderFactory.createTitledBorder(null, "Character Creation Menu",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, myFont, myColor);
		newContentPane.setBorder(titledBorder);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				input = "Q-0-0";
			}
		});
	}

	private void buildCreationFrame1() {
		newContentPane = new JPanel(new GridLayout(0, 4));
		newContentPane.setBackground(Color.BLACK);
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
			@Override
			public void windowClosing(WindowEvent e) {
				input = "Q-Q";
			}
		});

		b1.setToolTipText("Click here to create a Dwarf Warrior.");
		b2.setToolTipText("Click here to create a Dwarf Wizard.");
		b3.setToolTipText("Click here to create a Elve Warrior.");
		b4.setToolTipText("Click here to create a Elve Wizard.");
		// Add Components to this container, using the default FlowLayout.
		newContentPane.add(b1);
		newContentPane.add(b2);
		newContentPane.add(b3);
		newContentPane.add(b4);
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

			// C2 Validation
		} else if ("C2VAL".equals(e.getActionCommand())) {
			if (!name_input.isEmpty() && !life_input.isEmpty() && !ap_input.isEmpty()) {
				input = name_input + "-" + life_input + "-" + ap_input;
				JOptionPane.showMessageDialog(null, "New Character created !", "Character Creation",
						JOptionPane.INFORMATION_MESSAGE);
				name_input = "";
				life_input = "";
				ap_input = "";
			}
		} else if ("C2CAN".equals(e.getActionCommand())) {
			input = "Q-0-0";

			// C2 Validation
		}
	}

	public static String sendMessage() {
		while (input.isEmpty()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
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
		ImageIcon top_babkg = createImageIcon(
				"file:/home/jonathan/Desktop/Repositories/eclipse-workspace/Donjons_Dragons/medias/banner.png");
		JLabel top = new JLabel();
		top.setIcon(top_babkg);
		if (menu_choice.equals("C")) {
			// Create and set up the window.
			frame = new JFrame("Character Selection");
		} else /* if(menu_choice.equals("M")) */ {
			frame = new JFrame("Character Manager Main Menu");
		}
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setSize(new Dimension(800, 600));
		// Create and set up the content pane.
		new WindowedIHM(menu_choice);
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(top, BorderLayout.NORTH);
		frame.getContentPane().add(newContentPane, BorderLayout.CENTER);

		// Display the window.

		frame.setVisible(true);
	}
}
