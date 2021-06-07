package com.bullywiihacks.mw3;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.util.regex.PatternSyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.SwingConstants;

import com.bullywiihacks.mw3.data.NamesAndValues;
import com.bullywiihacks.mw3.utils.ListUtils;

@SuppressWarnings("serial")
public class GraphicalUserInterface extends JFrame implements NamesAndValues
{
	boolean dummy = assignAll();

	RandomAccessFile pathWriter;

	String applicationTitle = "MW3 Wii Custom Create-A-Class v4.0",
			copyright = "Copyright © 2012 - 2014\nBully@WiiPlaza Productions";

	String[] customClassNames = { "1st Public Class", "2nd Public Class",
			"3rd Public Class", "4th Public Class", "5th Public Class",
			"6th Public Class", "7th Public Class", "8th Public Class",
			"9th Public Class", "10th Public Class", "11th Public Class",
			"12th Public Class", "13th Public Class", "14th Public Class",
			"15th Public Class", "1st Private Class", "2nd Private Class",
			"3rd Private Class", "4th Private Class", "5th Private Class" };

	int classOffset = 0x62, startAddress = 0x933DA3F4;

	JFileChooser fileChooser;

	// Check Boxes
	JCheckBox primaryweaponcheckbox = new JCheckBox("Primary Weapon");
	JCheckBox primaryattachment1checkbox = new JCheckBox("1st Attachment");
	JCheckBox primaryattachment2checkbox = new JCheckBox("2nd Attachment");
	JCheckBox primarycamocheckbox = new JCheckBox("Camo");
	JCheckBox primaryproficiencycheckbox = new JCheckBox("Proficiency");
	JCheckBox primaryreticlecheckbox = new JCheckBox("Reticle");

	JCheckBox secondaryweaponcheckbox = new JCheckBox("Secondary Weapon");
	JCheckBox secondaryattachment1checkbox = new JCheckBox("1st Attachment");
	JCheckBox secondaryattachment2checkbox = new JCheckBox("2nd Attachment");
	JCheckBox secondarycamocheckbox = new JCheckBox("Camo");
	JCheckBox secondaryproficiencycheckbox = new JCheckBox("Proficiency");
	JCheckBox secondaryreticlecheckbox = new JCheckBox("Reticle");

	JCheckBox lethalgrenadecheckbox = new JCheckBox("Lethal Grenade");

	JCheckBox firstperkcheckbox = new JCheckBox("Perks");

	JCheckBox streaksetcheckbox = new JCheckBox("Active Package");

	JCheckBox tacticalgrenadecheckbox = new JCheckBox("Tactical Grenade");
	JCheckBox classnamecheckbox = new JCheckBox("Class Name");

	JCheckBox deathstreakcheckbox = new JCheckBox("Deathstreak");

	JCheckBox firstassaultcheckbox = new JCheckBox("Assault Streaks");

	JCheckBox firstsupportcheckbox = new JCheckBox("Support Streaks");

	JCheckBox firstspecialistcheckbox = new JCheckBox("Specialist Streaks");

	JCheckBox earlyspecialiststreakcheckbox = new JCheckBox("Required Points");

	// Drop-Down Menus
	JComboBox<?> customclassbox = new JComboBox<Object>(customClassNames);

	JComboBox<Object> primaryweaponbox = new JComboBox<Object>(
			ListUtils.getNames(primWeapons));
	JComboBox<?> primaryattachment1box = new JComboBox<Object>(
			primaryattachmentnamesarray);
	JComboBox<?> primaryattachment2box = new JComboBox<Object>(
			primaryattachmentnamesarray);
	JComboBox<?> primarycamobox = new JComboBox<Object>(camonamesarray);
	JComboBox<?> primaryproficiencybox = new JComboBox<Object>(
			proficiencynamesarray);
	JComboBox<?> primaryreticlebox = new JComboBox<Object>(reticlenamesarray);

	JComboBox<?> secondaryweaponbox = new JComboBox<Object>(
			ListUtils.getNames(secWeapons));
	JComboBox<?> secondaryattachment1box = new JComboBox<Object>(
			attachmentnamesarray);
	JComboBox<?> secondaryattachment2box = new JComboBox<Object>(
			attachmentnamesarray);
	JComboBox<?> secondarycamobox = new JComboBox<Object>(
			new String[] { "NONE" });
	JComboBox<?> secondaryproficiencybox = new JComboBox<Object>(
			proficiencynamesarray);
	JComboBox<?> secondaryreticlebox = new JComboBox<Object>(reticlenamesarray);

	JComboBox<?> lethalgrenadebox = new JComboBox<Object>(deadlygrenadesarray);

	JComboBox<?> firstperkbox = new JComboBox<Object>(firstPerkSlot);
	JComboBox<?> secondperkbox = new JComboBox<Object>(secondperknamesarray);
	JComboBox<?> thirdperkbox = new JComboBox<Object>(thirdperknamesarray);

	JComboBox<?> streaksetbox = new JComboBox<Object>(strikepackagenamesarray);

	JComboBox<?> tacticalgrenadebox = new JComboBox<Object>(
			tacticalgrenadesarray);

	JComboBox<?> deathstreakbox = new JComboBox<Object>(deathstreakNames);

	JComboBox<?> firstassaultbox = new JComboBox<Object>(pointstreakNames);
	JComboBox<?> secondassaultbox = new JComboBox<Object>(pointstreakNames);
	JComboBox<?> thirdassaultbox = new JComboBox<Object>(pointstreakNames);

	JComboBox<?> firstsupportbox = new JComboBox<Object>(pointstreakNames);
	JComboBox<?> secondsupportbox = new JComboBox<Object>(pointstreakNames);
	JComboBox<?> thirdsupportbox = new JComboBox<Object>(pointstreakNames);

	JComboBox<?> firstspecialistbox = new JComboBox<Object>(
			pointstreaknamesarray);
	JComboBox<?> secondspecialistbox = new JComboBox<Object>(
			pointstreaknamesarray);
	JComboBox<?> thirdspecialistbox = new JComboBox<Object>(
			pointstreaknamesarray);

	// Text Area
	JTextArea outputcodearea = new JTextArea(8, 25);

	// Text Fields
	JTextField classNameField = new JTextField(8);

	JTextField specialiststreak1 = new JTextField(1);
	JTextField specialiststreak2 = new JTextField(1);
	JTextField specialiststreak3 = new JTextField(1);

	// Scroll Bars
	JScrollPane scroller = new JScrollPane(outputcodearea);
	JLabel picturelabel = new JLabel(new ImageIcon(
			"images/MW3CustomCreateAClass.jpg"));

	// Buttons
	JButton generatecodebutton = new JButton(new ImageIcon(
			GraphicalUserInterface.class
					.getResource("/images/Generate Code.jpg")));
	JButton informationbutton = new JButton(
			new ImageIcon(
					GraphicalUserInterface.class
							.getResource("/images/Information.jpg")));
	JButton resetselectionbutton = new JButton(new ImageIcon(
			GraphicalUserInterface.class.getResource("/images/Reset.jpg")));
	JButton tickallcheckboxesbutton = new JButton(new ImageIcon(
			GraphicalUserInterface.class.getResource("/images/Tick all.jpg")));
	JButton whatworksbutton = new JButton(new ImageIcon(
			GraphicalUserInterface.class.getResource("/images/What works.jpg")));
	JButton loadbutton = new JButton(new ImageIcon(
			GraphicalUserInterface.class.getResource("/images/Open.jpg")));
	JButton savebutton = new JButton(new ImageIcon(
			GraphicalUserInterface.class.getResource("/images/Save.jpg")));
	JButton donatebutton = new JButton(new ImageIcon(
			GraphicalUserInterface.class.getResource("/images/Donate.jpg")));
	JButton youtubebutton = new JButton(new ImageIcon(
			GraphicalUserInterface.class.getResource("/images/YouTube.jpg")));
	JButton bwhbutton = new JButton(new ImageIcon(
			GraphicalUserInterface.class
					.getResource("/images/BullyWiiHacks.jpg")));
	JButton untickAllButton = new JButton(new ImageIcon(
			GraphicalUserInterface.class.getResource("/images/Untick all.jpg")));

	public GraphicalUserInterface()
	{
		setResizable(false);
		setTitle(applicationTitle);
		setSize(1143, 625);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("images/Icon.jpg")));
		getContentPane().setLayout(null);
		customclassbox.setBounds(832, 302, 132, 22);
		customclassbox.setBackground(Color.RED);
		getContentPane().add(customclassbox);
		primaryweaponcheckbox.setBounds(6, 7, 129, 23);

		getContentPane().add(primaryweaponcheckbox);
		primaryweaponbox.setBounds(163, 7, 191, 22);
		primaryweaponbox.setBackground(Color.GREEN);
		getContentPane().add(primaryweaponbox);
		primaryweaponbox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (((String) primaryweaponbox.getSelectedItem()).contains("#"))
				{
					primaryweaponbox.setSelectedIndex(0);
				}
			}
		});
		primaryattachment1checkbox.setBounds(6, 33, 117, 23);

		getContentPane().add(primaryattachment1checkbox);
		primaryattachment1box.setBounds(163, 33, 145, 22);
		primaryattachment1box.setBackground(Color.gray);
		getContentPane().add(primaryattachment1box);
		primaryattachment2checkbox.setBounds(6, 59, 141, 23);

		getContentPane().add(primaryattachment2checkbox);
		primaryattachment2box.setBounds(163, 59, 145, 22);
		primaryattachment2box.setBackground(Color.gray);
		getContentPane().add(primaryattachment2box);
		primarycamocheckbox.setBounds(6, 85, 91, 23);

		getContentPane().add(primarycamocheckbox);
		primarycamobox.setBounds(163, 85, 116, 22);
		primarycamobox.setBackground(Color.MAGENTA);
		getContentPane().add(primarycamobox);
		primaryproficiencycheckbox.setBounds(6, 140, 117, 23);

		getContentPane().add(primaryproficiencycheckbox);
		primaryproficiencybox.setBounds(163, 140, 145, 22);
		primaryproficiencybox.setBackground(Color.white);
		getContentPane().add(primaryproficiencybox);
		primaryreticlecheckbox.setBounds(6, 111, 97, 23);

		getContentPane().add(primaryreticlecheckbox);
		primaryreticlebox.setBounds(163, 111, 89, 22);
		primaryreticlebox.setBackground(Color.ORANGE);
		getContentPane().add(primaryreticlebox);
		secondaryweaponcheckbox.setBounds(360, 7, 145, 23);

		getContentPane().add(secondaryweaponcheckbox);
		secondaryweaponbox.setBounds(521, 7, 191, 22);
		secondaryweaponbox.setBackground(Color.GREEN);
		getContentPane().add(secondaryweaponbox);
		secondaryweaponbox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (((String) secondaryweaponbox.getSelectedItem())
						.contains("#"))
				{
					secondaryweaponbox.setSelectedIndex(0);
				}
			}
		});
		secondaryattachment1checkbox.setBounds(360, 33, 132, 23);

		getContentPane().add(secondaryattachment1checkbox);
		secondaryattachment1box.setBounds(521, 33, 157, 22);
		secondaryattachment1box.setBackground(Color.gray);
		getContentPane().add(secondaryattachment1box);
		secondaryattachment2checkbox.setBounds(360, 59, 129, 23);

		getContentPane().add(secondaryattachment2checkbox);
		secondaryattachment2box.setBounds(521, 59, 157, 22);
		secondaryattachment2box.setBackground(Color.gray);
		getContentPane().add(secondaryattachment2box);
		secondarycamocheckbox.setBounds(360, 85, 107, 23);

		getContentPane().add(secondarycamocheckbox);
		secondarycamobox.setBounds(520, 85, 116, 22);
		secondarycamobox.setBackground(Color.MAGENTA);
		getContentPane().add(secondarycamobox);
		secondaryproficiencycheckbox.setBounds(361, 140, 131, 23);

		getContentPane().add(secondaryproficiencycheckbox);
		secondaryproficiencybox.setBounds(521, 140, 145, 22);
		secondaryproficiencybox.setBackground(Color.white);
		getContentPane().add(secondaryproficiencybox);
		secondaryreticlecheckbox.setBounds(360, 111, 111, 23);

		getContentPane().add(secondaryreticlecheckbox);
		secondaryreticlebox.setBounds(521, 112, 89, 22);
		secondaryreticlebox.setBackground(Color.ORANGE);
		getContentPane().add(secondaryreticlebox);
		lethalgrenadecheckbox.setBounds(732, 7, 139, 23);

		getContentPane().add(lethalgrenadecheckbox);
		lethalgrenadebox.setBounds(877, 7, 133, 22);
		lethalgrenadebox.setBackground(Color.BLACK);
		getContentPane().add(lethalgrenadebox);
		firstperkcheckbox.setBounds(6, 185, 65, 23);

		getContentPane().add(firstperkcheckbox);
		firstperkbox.setBounds(158, 185, 150, 22);
		firstperkbox.setBackground(Color.YELLOW);
		getContentPane().add(firstperkbox);
		secondperkbox.setBounds(158, 218, 150, 22);
		secondperkbox.setBackground(Color.YELLOW);
		getContentPane().add(secondperkbox);
		thirdperkbox.setBounds(158, 251, 150, 22);
		thirdperkbox.setBackground(Color.YELLOW);
		getContentPane().add(thirdperkbox);
		streaksetcheckbox.setBounds(732, 85, 135, 23);

		getContentPane().add(streaksetcheckbox);
		streaksetbox.setBounds(877, 85, 97, 22);
		streaksetbox.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(streaksetbox);
		tacticalgrenadecheckbox.setBounds(732, 33, 139, 23);

		getContentPane().add(tacticalgrenadecheckbox);
		tacticalgrenadebox.setBounds(877, 33, 164, 22);
		tacticalgrenadebox.setBackground(Color.BLACK);
		getContentPane().add(tacticalgrenadebox);
		classnamecheckbox.setBounds(732, 59, 115, 23);

		getContentPane().add(classnamecheckbox);
		classNameField.setHorizontalAlignment(SwingConstants.CENTER);
		classNameField.setBounds(877, 60, 97, 20);
		getContentPane().add(classNameField);
		classNameField.setDocument(new PlainDocument()
		{
			@Override
			public void insertString(int offset, String input,
					AttributeSet attributeSet) throws BadLocationException
			{
				if (getLength() + input.length() <= 12)
				{
					super.insertString(offset, input, attributeSet);
				} else
				{
					JOptionPane.showMessageDialog(rootPane,
							"Class names can not be longer than 12 letters!",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		deathstreakcheckbox.setBounds(360, 302, 107, 23);

		getContentPane().add(deathstreakcheckbox);
		deathstreakbox.setBounds(515, 302, 121, 22);
		deathstreakbox.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(deathstreakbox);
		firstassaultcheckbox.setBounds(360, 185, 145, 23);

		getContentPane().add(firstassaultcheckbox);
		firstassaultbox.setBounds(515, 185, 229, 22);
		firstassaultbox.setBackground(Color.BLUE);
		getContentPane().add(firstassaultbox);
		secondassaultbox.setBounds(515, 218, 229, 22);
		secondassaultbox.setBackground(Color.BLUE);
		getContentPane().add(secondassaultbox);
		thirdassaultbox.setBounds(515, 251, 229, 22);
		thirdassaultbox.setBackground(Color.BLUE);
		getContentPane().add(thirdassaultbox);
		firstsupportcheckbox.setBounds(762, 185, 129, 23);

		getContentPane().add(firstsupportcheckbox);
		firstsupportbox.setBounds(897, 185, 230, 22);
		firstsupportbox.setBackground(Color.CYAN);
		getContentPane().add(firstsupportbox);
		secondsupportbox.setBounds(897, 218, 230, 22);
		secondsupportbox.setBackground(Color.CYAN);
		getContentPane().add(secondsupportbox);
		thirdsupportbox.setBounds(897, 251, 230, 22);
		thirdsupportbox.setBackground(Color.CYAN);
		getContentPane().add(thirdsupportbox);
		firstspecialistcheckbox.setBounds(6, 302, 117, 23);

		getContentPane().add(firstspecialistcheckbox);
		firstspecialistbox.setBounds(129, 302, 213, 22);
		firstspecialistbox.setBackground(Color.pink);
		getContentPane().add(firstspecialistbox);
		secondspecialistbox.setBounds(129, 332, 213, 22);
		secondspecialistbox.setBackground(Color.pink);
		getContentPane().add(secondspecialistbox);
		thirdspecialistbox.setBounds(129, 365, 213, 22);
		thirdspecialistbox.setBackground(Color.pink);
		getContentPane().add(thirdspecialistbox);
		earlyspecialiststreakcheckbox.setBounds(6, 404, 145, 23);

		getContentPane().add(earlyspecialiststreakcheckbox);
		specialiststreak1.setBounds(163, 404, 14, 20);
		getContentPane().add(specialiststreak1);
		specialiststreak2.setBounds(187, 404, 14, 20);
		getContentPane().add(specialiststreak2);
		specialiststreak3.setBounds(210, 404, 14, 20);
		getContentPane().add(specialiststreak3);
		picturelabel.setBounds(1153, 185, -1, -1);

		// Picture
		getContentPane().add(picturelabel);
		outputcodearea.setTabSize(5);
		outputcodearea.setText("");
		scroller.setBounds(780, 404, 279, 182);

		// Code Area
		getContentPane().add(scroller);
		outputcodearea.setBackground(Color.GREEN);

		outputcodearea.setText(copyright);
		generatecodebutton.setBounds(855, 330, 95, 63);

		// Buttons
		generatecodebutton.setToolTipText("Generate the code");
		getContentPane().add(generatecodebutton);
		resetselectionbutton.setBounds(213, 526, 95, 63);
		resetselectionbutton
				.setToolTipText("Reset all selections and code box");
		getContentPane().add(resetselectionbutton);
		tickallcheckboxesbutton.setBounds(323, 526, 95, 63);
		tickallcheckboxesbutton.setToolTipText("Tick all check boxes");
		getContentPane().add(tickallcheckboxesbutton);
		informationbutton.setBounds(531, 526, 91, 63);
		informationbutton
				.setToolTipText("Receive information about this program");
		getContentPane().add(informationbutton);
		whatworksbutton.setBounds(113, 526, 95, 63);
		whatworksbutton.setToolTipText("Read what you can combine");
		getContentPane().add(whatworksbutton);
		savebutton.setBounds(289, 476, 83, 39);
		savebutton.setToolTipText("Save your creations");
		getContentPane().add(savebutton);
		loadbutton.setBounds(182, 476, 97, 39);
		loadbutton.setToolTipText("Load your saved creations");
		getContentPane().add(loadbutton);
		donatebutton.setBounds(569, 452, 175, 63);
		donatebutton.setToolTipText("Donate to the author of this program");
		getContentPane().add(donatebutton);
		youtubebutton.setBounds(8, 452, 155, 65);
		youtubebutton.setToolTipText("Visit the authors YouTube channel");
		getContentPane().add(youtubebutton);
		bwhbutton.setBounds(382, 450, 175, 65);
		bwhbutton.setToolTipText("Visit my personal website");
		getContentPane().add(bwhbutton);
		untickAllButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent actionPerformed)
			{
				primaryweaponcheckbox.setSelected(false);
				primaryattachment1checkbox.setSelected(false);
				primaryattachment2checkbox.setSelected(false);
				primarycamocheckbox.setSelected(false);
				primaryproficiencycheckbox.setSelected(false);
				primaryreticlecheckbox.setSelected(false);

				secondaryweaponcheckbox.setSelected(false);
				secondaryattachment1checkbox.setSelected(false);
				secondaryattachment2checkbox.setSelected(false);
				secondarycamocheckbox.setSelected(false);
				secondaryproficiencycheckbox.setSelected(false);
				secondaryreticlecheckbox.setSelected(false);

				lethalgrenadecheckbox.setSelected(false);

				firstperkcheckbox.setSelected(false);

				streaksetcheckbox.setSelected(false);

				tacticalgrenadecheckbox.setSelected(false);
				classnamecheckbox.setSelected(false);

				deathstreakcheckbox.setSelected(false);

				firstassaultcheckbox.setSelected(false);

				firstsupportcheckbox.setSelected(false);

				firstspecialistcheckbox.setSelected(false);

				earlyspecialiststreakcheckbox.setSelected(false);
			}
		});
		untickAllButton.setToolTipText("Untick all checkboxes");
		untickAllButton.setBounds(428, 526, 95, 63);

		getContentPane().add(untickAllButton);

		try
		{
			pathWriter = new RandomAccessFile("path.txt", "rw");
		} catch (FileNotFoundException e3)
		{
			e3.printStackTrace();
		}

		fileChooser = getFileChooser();

		informationbutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane
						.showMessageDialog(
								rootPane,
								"Tick at least one option, select an item from the list and generate the class mod gecko cheat code by clicking the 'code' button!",
								"Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		generatecodebutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if ((primaryweaponcheckbox.isSelected())
						|| (primaryattachment1checkbox.isSelected())
						|| (primaryattachment2checkbox.isSelected())
						|| (primarycamocheckbox.isSelected())
						|| (primaryproficiencycheckbox.isSelected())
						|| (primaryreticlecheckbox.isSelected())
						|| (secondaryweaponcheckbox.isSelected())
						|| (secondaryattachment1checkbox.isSelected())
						|| (secondaryattachment2checkbox.isSelected())
						|| (secondarycamocheckbox.isSelected())
						|| (secondaryproficiencycheckbox.isSelected())
						|| (secondaryreticlecheckbox.isSelected())
						|| (lethalgrenadecheckbox.isSelected())
						|| (firstperkcheckbox.isSelected())
						|| (streaksetcheckbox.isSelected())
						|| (tacticalgrenadecheckbox.isSelected())
						|| (classnamecheckbox.isSelected())
						|| (deathstreakcheckbox.isSelected())
						|| (firstassaultcheckbox.isSelected())
						|| (firstsupportcheckbox.isSelected())
						|| (firstspecialistcheckbox.isSelected())
						|| (earlyspecialiststreakcheckbox.isSelected()))
				{
					// Code Start
					int j = customclassbox.getSelectedIndex();
					outputcodearea.setText(customClassNames[j]
							+ " Modifier [Bully@WiiPlaza]");

					// Custom Class Part
					outputcodearea.append("\n" + "201D2644 FFFFFFFA");
					outputcodearea.append("\n"
							+ "4A000000 "
							+ Integer.toHexString(
									(startAddress + customclassbox
											.getSelectedIndex() * classOffset))
									.toUpperCase());

					// Primary Weapon Part
					if (primaryweaponcheckbox.isSelected())
					{
						int i = primaryweaponbox.getSelectedIndex();
						outputcodearea.append("\n" + "10000000 000000"
								+ ListUtils.getValues(primWeapons)[i]);
					}

					// Primary attachment 1
					if (primaryattachment1checkbox.isSelected())
					{
						int s = primaryattachment1box.getSelectedIndex();
						outputcodearea.append("\n" + "10000002 000000");

						if ((primaryweaponbox.getSelectedItem() == "STRIKER"
								|| primaryweaponbox.getSelectedItem() == "USAS12"
								|| primaryweaponbox.getSelectedItem() == "KSG 12"
								|| primaryweaponbox.getSelectedItem() == "SPAS-12"
								|| primaryweaponbox.getSelectedItem() == "AA-12"
								|| primaryweaponbox.getSelectedItem() == "USAS12"
								|| primaryweaponbox.getSelectedItem() == "BARRET .50"
								|| primaryweaponbox.getSelectedItem() == "L118A"
								|| primaryweaponbox.getSelectedItem() == "DRAGUNOV"
								|| primaryweaponbox.getSelectedItem() == "AS50"
								|| primaryweaponbox.getSelectedItem() == "RSASS" || primaryweaponbox
								.getSelectedItem() == "MSR")
								& primaryattachment1box.getSelectedItem() == "SILENCER")
							outputcodearea.append("13");

						else if (primaryattachment1box.getSelectedItem() == "SILENCER")
							outputcodearea
									.append(primaryattachmentvaluesarray[s]);

						if ((primaryweaponbox.getSelectedItem() == "M4A1" || primaryweaponbox
								.getSelectedItem() == "M16A4")
								& primaryattachment1box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea.append("0E");

						else if ((primaryweaponbox.getSelectedItem() == "AK-47")
								& primaryattachment1box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea.append("0F");

						else if (primaryattachment1box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea
									.append(primaryattachmentvaluesarray[s]);

						if (!(primaryattachment1box.getSelectedItem() == "SILENCER" || primaryattachment1box
								.getSelectedItem() == "GRENADE LAUNCHER"))
							outputcodearea
									.append(primaryattachmentvaluesarray[s]);
					}

					// Primary attachment 2
					if (primaryattachment2checkbox.isSelected())
					{
						int s = primaryattachment2box.getSelectedIndex();
						outputcodearea.append("\n" + "10000004 000000");

						if ((primaryweaponbox.getSelectedItem() == "STRIKER"
								|| primaryweaponbox.getSelectedItem() == "USAS12"
								|| primaryweaponbox.getSelectedItem() == "KSG 12"
								|| primaryweaponbox.getSelectedItem() == "SPAS-12"
								|| primaryweaponbox.getSelectedItem() == "AA-12"
								|| primaryweaponbox.getSelectedItem() == "USAS12"
								|| primaryweaponbox.getSelectedItem() == "BARRET .50"
								|| primaryweaponbox.getSelectedItem() == "L118A"
								|| primaryweaponbox.getSelectedItem() == "DRAGUNOV"
								|| primaryweaponbox.getSelectedItem() == "AS50"
								|| primaryweaponbox.getSelectedItem() == "RSASS" || primaryweaponbox
								.getSelectedItem() == "MSR")
								& primaryattachment2box.getSelectedItem() == "SILENCER")
							outputcodearea.append("13");

						else if (primaryattachment2box.getSelectedItem() == "SILENCER")
							outputcodearea
									.append(primaryattachmentvaluesarray[s]);

						if ((primaryweaponbox.getSelectedItem() == "M4A1" || primaryweaponbox
								.getSelectedItem() == "M16A4")
								& primaryattachment2box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea.append("0E");

						else if ((primaryweaponbox.getSelectedItem() == "AK-47")
								& primaryattachment2box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea.append("0F");

						else if (primaryattachment2box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea
									.append(primaryattachmentvaluesarray[s]);

						if (!(primaryattachment2box.getSelectedItem() == "SILENCER" || primaryattachment2box
								.getSelectedItem() == "GRENADE LAUNCHER"))
							outputcodearea
									.append(primaryattachmentvaluesarray[s]);
					}

					// Primary camo
					if (primarycamocheckbox.isSelected())
					{
						int e1 = primarycamobox.getSelectedIndex();
						outputcodearea.append("\n" + "10000006 000000"
								+ camovaluesarray[e1]);
					}
					if (primaryproficiencycheckbox.isSelected())
					{
						int f = primaryproficiencybox.getSelectedIndex();
						outputcodearea.append("\n" + "10000008 000000"
								+ proficiencyvaluesarray[f]);
					}
					if (primaryreticlecheckbox.isSelected())
					{
						int g = primaryreticlebox.getSelectedIndex();
						outputcodearea.append("\n" + "1000000A 000000"
								+ reticlevaluesarray[g]);
					}

					// Secondary Weapon Part
					if (secondaryweaponcheckbox.isSelected())
					{
						int h = secondaryweaponbox.getSelectedIndex();
						outputcodearea.append("\n" + "1000000C 000000"
								+ ListUtils.getValues(secWeapons)[h]);
					}

					// Secondary attachment 1
					if (secondaryattachment1checkbox.isSelected())
					{
						int s = secondaryattachment1box.getSelectedIndex();
						outputcodearea.append("\n" + "1000000E 000000");

						// --------------------------------------------------------------------

						if ((secondaryweaponbox.getSelectedItem() == "STRIKER"
								|| secondaryweaponbox.getSelectedItem() == "USAS12"
								|| secondaryweaponbox.getSelectedItem() == "KSG 12"
								|| secondaryweaponbox.getSelectedItem() == "SPAS-12"
								|| secondaryweaponbox.getSelectedItem() == "AA-12"
								|| secondaryweaponbox.getSelectedItem() == "USAS12"
								|| secondaryweaponbox.getSelectedItem() == "BARRET .50"
								|| secondaryweaponbox.getSelectedItem() == "L118A"
								|| secondaryweaponbox.getSelectedItem() == "DRAGUNOV"
								|| secondaryweaponbox.getSelectedItem() == "AS50"
								|| secondaryweaponbox.getSelectedItem() == "RSASS" || secondaryweaponbox
								.getSelectedItem() == "MSR")
								& secondaryattachment1box.getSelectedItem() == "SILENCER")
							outputcodearea.append("13");

						else if ((secondaryweaponbox.getSelectedItem() == "FMG9"
								|| secondaryweaponbox.getSelectedItem() == "MP9"
								|| secondaryweaponbox.getSelectedItem() == "SCORPION"
								|| secondaryweaponbox.getSelectedItem() == "G18"
								|| secondaryweaponbox.getSelectedItem() == "USP .45"
								|| secondaryweaponbox.getSelectedItem() == "P99"
								|| secondaryweaponbox.getSelectedItem() == "MP412"
								|| secondaryweaponbox.getSelectedItem() == ".44 MAGNUM"
								|| secondaryweaponbox.getSelectedItem() == "FIVE-SEVEN" || secondaryweaponbox
								.getSelectedItem() == "DESERT EAGLE")
								& secondaryattachment1box.getSelectedItem() == "SILENCER")
							outputcodearea.append("12");

						else if (secondaryattachment1box.getSelectedItem() == "SILENCER")
							outputcodearea.append(attachmentvaluesarray[s]);

						// --------------------------------------------------------------------

						if ((secondaryweaponbox.getSelectedItem() == "M4A1" || secondaryweaponbox
								.getSelectedItem() == "M16A4")
								& secondaryattachment1box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea.append("0E");

						else if ((secondaryweaponbox.getSelectedItem() == "AK-47")
								& secondaryattachment1box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea.append("0F");

						else if (secondaryattachment1box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea.append(attachmentvaluesarray[s]);

						// --------------------------------------------------------------------

						if (!(secondaryattachment1box.getSelectedItem() == "SILENCER" || secondaryattachment1box
								.getSelectedItem() == "GRENADE LAUNCHER"))
							outputcodearea.append(attachmentvaluesarray[s]);
					}

					// Secondary attachment 2
					if (secondaryattachment2checkbox.isSelected())
					{
						int s = secondaryattachment2box.getSelectedIndex();
						outputcodearea.append("\n" + "10000010 000000");

						// --------------------------------------------------------------------

						if ((secondaryweaponbox.getSelectedItem() == "STRIKER"
								|| secondaryweaponbox.getSelectedItem() == "USAS12"
								|| secondaryweaponbox.getSelectedItem() == "KSG 12"
								|| secondaryweaponbox.getSelectedItem() == "SPAS-12"
								|| secondaryweaponbox.getSelectedItem() == "AA-12"
								|| secondaryweaponbox.getSelectedItem() == "USAS12"
								|| secondaryweaponbox.getSelectedItem() == "BARRET .50"
								|| secondaryweaponbox.getSelectedItem() == "L118A"
								|| secondaryweaponbox.getSelectedItem() == "DRAGUNOV"
								|| secondaryweaponbox.getSelectedItem() == "AS50"
								|| secondaryweaponbox.getSelectedItem() == "RSASS" || secondaryweaponbox
								.getSelectedItem() == "MSR")
								& secondaryattachment2box.getSelectedItem() == "SILENCER")
							outputcodearea.append("13");

						else if ((secondaryweaponbox.getSelectedItem() == "FMG9"
								|| secondaryweaponbox.getSelectedItem() == "MP9"
								|| secondaryweaponbox.getSelectedItem() == "SCORPION"
								|| secondaryweaponbox.getSelectedItem() == "G18"
								|| secondaryweaponbox.getSelectedItem() == "USP .45"
								|| secondaryweaponbox.getSelectedItem() == "P99"
								|| secondaryweaponbox.getSelectedItem() == "MP412"
								|| secondaryweaponbox.getSelectedItem() == ".44 MAGNUM"
								|| secondaryweaponbox.getSelectedItem() == "FIVE-SEVEN" || secondaryweaponbox
								.getSelectedItem() == "DESERT EAGLE")
								& secondaryattachment2box.getSelectedItem() == "SILENCER")
							outputcodearea.append("12");

						else if (secondaryattachment2box.getSelectedItem() == "SILENCER")
							outputcodearea.append(attachmentvaluesarray[s]);

						// --------------------------------------------------------------------

						if ((secondaryweaponbox.getSelectedItem() == "M4A1" || secondaryweaponbox
								.getSelectedItem() == "M16A4")
								& secondaryattachment2box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea.append("0E");

						else if ((secondaryweaponbox.getSelectedItem() == "AK-47")
								& secondaryattachment2box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea.append("0F");

						else if (secondaryattachment2box.getSelectedItem() == "GRENADE LAUNCHER")
							outputcodearea.append(attachmentvaluesarray[s]);

						// --------------------------------------------------------------------

						if (!(secondaryattachment2box.getSelectedItem() == "SILENCER" || secondaryattachment2box
								.getSelectedItem() == "GRENADE LAUNCHER"))
							outputcodearea.append(attachmentvaluesarray[s]);
					}
					if (secondarycamocheckbox.isSelected())
					{
						int m = secondarycamobox.getSelectedIndex();
						outputcodearea.append("\n" + "10000012 000000"
								+ camovaluesarray[m]);
					}
					if (secondaryproficiencycheckbox.isSelected())
					{
						int n = secondaryproficiencybox.getSelectedIndex();
						outputcodearea.append("\n" + "10000014 000000"
								+ proficiencyvaluesarray[n]);
					}
					if (secondaryreticlecheckbox.isSelected())
					{
						int o = secondaryreticlebox.getSelectedIndex();
						outputcodearea.append("\n" + "10000016 000000"
								+ reticlevaluesarray[o]);
					}

					// Other Code Stuff
					if (lethalgrenadecheckbox.isSelected())
					{
						int p = lethalgrenadebox.getSelectedIndex();
						outputcodearea.append("\n" + "10000018 000000"
								+ deadlygrenadevaluesarray[p]);
					}

					if (firstperkcheckbox.isSelected())
					{
						int q = firstperkbox.getSelectedIndex();
						outputcodearea.append("\n" + "1000001A 000000"
								+ firstPerkSlotValues[q]);

						int ü = secondperkbox.getSelectedIndex();
						outputcodearea.append("\n" + "1000001C 000000"
								+ secondperkvaluesarray[ü]);

						int ä = thirdperkbox.getSelectedIndex();
						outputcodearea.append("\n" + "1000001E 000000"
								+ thirdperkvaluesarray[ä]);
					}

					if (streaksetcheckbox.isSelected())
					{
						int ö = streaksetbox.getSelectedIndex();
						outputcodearea.append("\n" + "10000022 000000"
								+ strikepackagevaluesarray[ö]);
					}

					if (tacticalgrenadecheckbox.isSelected())
					{
						int y = tacticalgrenadebox.getSelectedIndex();
						outputcodearea.append("\n" + "10000024 000000"
								+ tacticalgrenadevaluesarray[y]);
					}

					if (classnamecheckbox.isSelected())
					{
						outputcodearea.append("\n" + "16000028" + " "
								+ "0000000C");

						if (classNameField.getText().length() == 0)
						{
							outputcodearea.append("\n" + "00000000" + " "
									+ "00000000");
							outputcodearea.append("\n" + "00000000" + " "
									+ "00000000");
						} else
						{
							outputcodearea.append("\n");
						}
						String text = classNameField.getText();
						int zähler1 = 0;
						int zähler2 = 0;
						for (int i = 0; i < text.length(); i++)
						{
							char c = text.charAt(i);
							String hexstr = Integer.toHexString(c);
							outputcodearea.append(hexstr.toUpperCase());
							zähler1++;
							zähler2++;

							if (zähler2 == 8)
							{
								outputcodearea.append("\n");
								zähler2 = 0;
								zähler1 = 0;
							}

							if (zähler1 == 4)
							{
								outputcodearea.append(" ");
								zähler1 = 0;
							}
						}

						if (classNameField.getText().length() == 1)
						{
							outputcodearea.append("000000" + " " + "00000000");
							outputcodearea.append("\n" + "00000000" + " "
									+ "00000000");
						}

						if (classNameField.getText().length() == 2)
						{
							outputcodearea.append("0000" + " " + "00000000");
							outputcodearea.append("\n" + "00000000" + " "
									+ "00000000");
						}

						if (classNameField.getText().length() == 3)
						{
							outputcodearea.append("00" + " " + "00000000");
							outputcodearea.append("\n" + "00000000" + " "
									+ "00000000");
						}

						if (classNameField.getText().length() == 4)
						{
							outputcodearea.append("00000000");
							outputcodearea.append("\n" + "00000000" + " "
									+ "00000000");
						}

						if (classNameField.getText().length() == 5)
						{
							outputcodearea.append("000000");
							outputcodearea.append("\n" + "00000000" + " "
									+ "00000000");
						}

						if (classNameField.getText().length() == 6)
						{
							outputcodearea.append("0000");
							outputcodearea.append("\n" + "00000000" + " "
									+ "00000000");
						}

						if (classNameField.getText().length() == 7)
						{
							outputcodearea.append("00");
							outputcodearea.append("\n" + "00000000" + " "
									+ "00000000");
						}

						if (classNameField.getText().length() == 8)
						{
							outputcodearea
									.append("00000000" + " " + "00000000");
						}

						if (classNameField.getText().length() == 9)
						{
							outputcodearea.append("000000" + " " + "00000000");
						}

						if (classNameField.getText().length() == 10)
						{
							outputcodearea.append("0000" + " " + "00000000");
						}

						if (classNameField.getText().length() == 11)
						{
							outputcodearea.append("00" + " " + "00000000");
						}

						if (classNameField.getText().length() == 12)
						{
							outputcodearea.append("00000000");
						}
					}

					if (deathstreakcheckbox.isSelected())
					{
						int x = deathstreakbox.getSelectedIndex();
						outputcodearea.append("\n" + "1000003D 000000"
								+ deathstreakValues[x]);
					}

					if (firstassaultcheckbox.isSelected())
					{
						int z = firstassaultbox.getSelectedIndex();
						outputcodearea.append("\n" + "1000003F 000000"
								+ pointstreakValues[z]);

						int ab = secondassaultbox.getSelectedIndex();
						outputcodearea.append("\n" + "10000041 000000"
								+ pointstreakValues[ab]);

						int cd = thirdassaultbox.getSelectedIndex();
						outputcodearea.append("\n" + "10000043 000000"
								+ pointstreakValues[cd]);
					}

					if (firstsupportcheckbox.isSelected())
					{
						int ef = firstsupportbox.getSelectedIndex();
						outputcodearea.append("\n" + "10000045 000000"
								+ pointstreakValues[ef]);

						int gh = secondsupportbox.getSelectedIndex();
						outputcodearea.append("\n" + "10000047 000000"
								+ pointstreakValues[gh]);

						int ij = thirdsupportbox.getSelectedIndex();
						outputcodearea.append("\n" + "10000049 000000"
								+ pointstreakValues[ij]);
					}

					if (firstspecialistcheckbox.isSelected())
					{
						int ir = firstspecialistbox.getSelectedIndex();
						outputcodearea.append("\n" + "1000004B 000000"
								+ pointstreakvaluesarray[ir]);

						int ig = secondspecialistbox.getSelectedIndex();
						outputcodearea.append("\n" + "1000004D 000000"
								+ pointstreakvaluesarray[ig]);

						int ia = thirdspecialistbox.getSelectedIndex();
						outputcodearea.append("\n" + "1000004F 000000"
								+ pointstreakvaluesarray[ia]);
					}

					try
					{
						if (earlyspecialiststreakcheckbox.isSelected())
						{
							outputcodearea.append("\n"
									+ "10000051 0000000"
									+ Integer.toHexString(
											Integer.parseInt((specialiststreak1
													.getText()))).toUpperCase());
							outputcodearea.append("\n"
									+ "10000055 0000000"
									+ Integer.toHexString(
											Integer.parseInt((specialiststreak2
													.getText()))).toUpperCase());
							outputcodearea.append("\n"
									+ "10000059 0000000"
									+ Integer.toHexString(
											Integer.parseInt((specialiststreak3
													.getText()))).toUpperCase());
						}
					} catch (Exception s)
					{
						JOptionPane
								.showMessageDialog(
										rootPane,
										"Please fill out all three specialist streak required points boxes with numbers!",
										"Error", JOptionPane.ERROR_MESSAGE);
					}

					// Code Ending
					outputcodearea.append("\n" + "E0000000 80008000");
					outputcodearea.append("\n"
							+ "*Credits to MasterQ, Jester, Mitch & Koala*");

					Clipboard cb = Toolkit.getDefaultToolkit()
							.getSystemClipboard();
					StringSelection stringSelection = new StringSelection(
							outputcodearea.getText());
					cb.setContents(stringSelection, stringSelection);

					JOptionPane
							.showMessageDialog(
									rootPane,
									"Code saved to the clipboard!\n\nRemember: Click the 'What works?' button for more information about what you can get to work in a match!\n",
									"Information",
									JOptionPane.INFORMATION_MESSAGE);

				} else
				{
					JOptionPane.showMessageDialog(rootPane,
							"You need to check at least one option!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		tickallcheckboxesbutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				primaryweaponcheckbox.setSelected(true);
				primaryattachment1checkbox.setSelected(true);
				primaryattachment2checkbox.setSelected(true);
				primarycamocheckbox.setSelected(true);
				primaryproficiencycheckbox.setSelected(true);
				primaryreticlecheckbox.setSelected(true);

				secondaryweaponcheckbox.setSelected(true);
				secondaryattachment1checkbox.setSelected(true);
				secondaryattachment2checkbox.setSelected(true);
				secondarycamocheckbox.setSelected(true);
				secondaryproficiencycheckbox.setSelected(true);
				secondaryreticlecheckbox.setSelected(true);

				lethalgrenadecheckbox.setSelected(true);

				firstperkcheckbox.setSelected(true);

				streaksetcheckbox.setSelected(true);

				tacticalgrenadecheckbox.setSelected(true);
				classnamecheckbox.setSelected(true);

				deathstreakcheckbox.setSelected(true);

				firstassaultcheckbox.setSelected(true);

				firstsupportcheckbox.setSelected(true);

				firstspecialistcheckbox.setSelected(true);

				earlyspecialiststreakcheckbox.setSelected(true);
			}
		});

		whatworksbutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane
						.showMessageDialog(
								rootPane,
								"Everything that you can legitly choose in the game, additionally the following...\n\n- Two attachments on primary and / or secondary gun\n- Any proficiency on primary and / or secondary gun\n- Assault streaks mixed with support streaks\n- Extended mags on Desert Eagle\n- Predator Missle and / or Osprey Gunner (does nothing) on specialist package\n- A custom amount of points to earn each perk\n- M.O.A.B. on support or assault, but turns out as Assault Drone Airdrop\n\nIf you still feel like experimenting, your class may not work.\nPlease report bugs or requests to 'Bully@WiiPlaza'.",
								"Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		resetselectionbutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				customclassbox.setSelectedIndex(0);

				primaryweaponbox.setSelectedIndex(0);
				primaryattachment1box.setSelectedIndex(0);
				primaryattachment2box.setSelectedIndex(0);
				primarycamobox.setSelectedIndex(0);
				primaryproficiencybox.setSelectedIndex(0);
				primaryreticlebox.setSelectedIndex(0);

				secondaryweaponbox.setSelectedIndex(0);
				secondaryattachment1box.setSelectedIndex(0);
				secondaryattachment2box.setSelectedIndex(0);
				secondarycamobox.setSelectedIndex(0);
				secondaryproficiencybox.setSelectedIndex(0);
				secondaryreticlebox.setSelectedIndex(0);

				lethalgrenadebox.setSelectedIndex(0);

				firstperkbox.setSelectedIndex(0);
				secondperkbox.setSelectedIndex(0);
				thirdperkbox.setSelectedIndex(0);

				streaksetbox.setSelectedIndex(0);

				tacticalgrenadebox.setSelectedIndex(0);

				deathstreakbox.setSelectedIndex(0);

				firstassaultbox.setSelectedIndex(0);
				secondassaultbox.setSelectedIndex(0);
				thirdassaultbox.setSelectedIndex(0);

				firstsupportbox.setSelectedIndex(0);
				secondsupportbox.setSelectedIndex(0);
				thirdsupportbox.setSelectedIndex(0);

				firstspecialistbox.setSelectedIndex(0);
				secondspecialistbox.setSelectedIndex(0);
				thirdspecialistbox.setSelectedIndex(0);

				classNameField.setText("");

				outputcodearea.setText(copyright);

				specialiststreak1.setText("");
				specialiststreak2.setText("");
				specialiststreak3.setText("");

				primaryweaponcheckbox.setSelected(false);
				primaryattachment1checkbox.setSelected(false);
				primaryattachment2checkbox.setSelected(false);
				primarycamocheckbox.setSelected(false);
				primaryproficiencycheckbox.setSelected(false);
				primaryreticlecheckbox.setSelected(false);

				secondaryweaponcheckbox.setSelected(false);
				secondaryattachment1checkbox.setSelected(false);
				secondaryattachment2checkbox.setSelected(false);
				secondarycamocheckbox.setSelected(false);
				secondaryproficiencycheckbox.setSelected(false);
				secondaryreticlecheckbox.setSelected(false);

				lethalgrenadecheckbox.setSelected(false);
				classnamecheckbox.setSelected(false);

				firstperkcheckbox.setSelected(false);

				streaksetcheckbox.setSelected(false);

				tacticalgrenadecheckbox.setSelected(false);

				deathstreakcheckbox.setSelected(false);

				firstassaultcheckbox.setSelected(false);

				firstsupportcheckbox.setSelected(false);

				firstspecialistcheckbox.setSelected(false);

				earlyspecialiststreakcheckbox.setSelected(false);
			}
		});

		firstperkbox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (firstperkbox.getSelectedItem() == "HARDLINE"
						|| secondperkbox.getSelectedItem() == "HARDLINE"
						|| thirdperkbox.getSelectedItem() == "HARDLINE"
						|| firstspecialistbox.getSelectedItem() == "HARDLINE"
						|| secondspecialistbox.getSelectedItem() == "HARDLINE"
						|| thirdspecialistbox.getSelectedItem() == "HARDLINE")
				{
					specialiststreak1.setText("2");
					specialiststreak2.setText("3");
					specialiststreak3.setText("4");
				} else
				{
					specialiststreak1.setText("1");
					specialiststreak2.setText("2");
					specialiststreak3.setText("3");
				}
			}
		});

		secondperkbox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (firstperkbox.getSelectedItem() == "HARDLINE"
						|| secondperkbox.getSelectedItem() == "HARDLINE"
						|| thirdperkbox.getSelectedItem() == "HARDLINE"
						|| firstspecialistbox.getSelectedItem() == "HARDLINE"
						|| secondspecialistbox.getSelectedItem() == "HARDLINE"
						|| thirdspecialistbox.getSelectedItem() == "HARDLINE")
				{
					specialiststreak1.setText("2");
					specialiststreak2.setText("3");
					specialiststreak3.setText("4");
				} else
				{
					specialiststreak1.setText("1");
					specialiststreak2.setText("2");
					specialiststreak3.setText("3");
				}
			}
		});

		thirdperkbox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (firstperkbox.getSelectedItem() == "HARDLINE"
						|| secondperkbox.getSelectedItem() == "HARDLINE"
						|| thirdperkbox.getSelectedItem() == "HARDLINE"
						|| firstspecialistbox.getSelectedItem() == "HARDLINE"
						|| secondspecialistbox.getSelectedItem() == "HARDLINE"
						|| thirdspecialistbox.getSelectedItem() == "HARDLINE")
				{
					specialiststreak1.setText("2");
					specialiststreak2.setText("3");
					specialiststreak3.setText("4");
				} else
				{
					specialiststreak1.setText("1");
					specialiststreak2.setText("2");
					specialiststreak3.setText("3");
				}
			}
		});

		firstspecialistbox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (firstperkbox.getSelectedItem() == "HARDLINE"
						|| secondperkbox.getSelectedItem() == "HARDLINE"
						|| thirdperkbox.getSelectedItem() == "HARDLINE"
						|| firstspecialistbox.getSelectedItem() == "HARDLINE"
						|| secondspecialistbox.getSelectedItem() == "HARDLINE"
						|| thirdspecialistbox.getSelectedItem() == "HARDLINE")
				{
					specialiststreak1.setText("2");
					specialiststreak2.setText("3");
					specialiststreak3.setText("4");
				} else
				{
					specialiststreak1.setText("1");
					specialiststreak2.setText("2");
					specialiststreak3.setText("3");
				}
			}
		});

		secondspecialistbox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (firstperkbox.getSelectedItem() == "HARDLINE"
						|| secondperkbox.getSelectedItem() == "HARDLINE"
						|| thirdperkbox.getSelectedItem() == "HARDLINE"
						|| firstspecialistbox.getSelectedItem() == "HARDLINE"
						|| secondspecialistbox.getSelectedItem() == "HARDLINE"
						|| thirdspecialistbox.getSelectedItem() == "HARDLINE")
				{
					specialiststreak1.setText("2");
					specialiststreak2.setText("3");
					specialiststreak3.setText("4");
				} else
				{
					specialiststreak1.setText("1");
					specialiststreak2.setText("2");
					specialiststreak3.setText("3");
				}
			}
		});

		thirdspecialistbox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (firstperkbox.getSelectedItem() == "HARDLINE"
						|| secondperkbox.getSelectedItem() == "HARDLINE"
						|| thirdperkbox.getSelectedItem() == "HARDLINE"
						|| firstspecialistbox.getSelectedItem() == "HARDLINE"
						|| secondspecialistbox.getSelectedItem() == "HARDLINE"
						|| thirdspecialistbox.getSelectedItem() == "HARDLINE")
				{
					specialiststreak1.setText("2");
					specialiststreak2.setText("3");
					specialiststreak3.setText("4");
				} else
				{
					specialiststreak1.setText("1");
					specialiststreak2.setText("2");
					specialiststreak3.setText("3");
				}
			}
		});

		savebutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				FileWriter writer = null;

				try
				{
					// If we confirm saving to a file
					if (fileChooser.showSaveDialog(rootPane) == JFileChooser.APPROVE_OPTION)
					{
						// Append file suffix if not given
						if (!fileChooser.getSelectedFile().getName()
								.toUpperCase().endsWith(".MW3"))
							fileChooser.setSelectedFile(new File(fileChooser
									.getSelectedFile().getAbsolutePath()
									+ ".mw3"));
						try
						{
							// Remember path to that folder
							if (!fileChooser.getCurrentDirectory().equals(null))
							{
								pathWriter.seek(0);

								pathWriter.writeBytes(fileChooser
										.getSelectedFile().getParentFile()
										.getName());
							}
						} catch (IOException e3)
						{
							e3.printStackTrace();
						}

						// Prepare writing to that file
						writer = new FileWriter(fileChooser.getSelectedFile());
					}

					writer.write((String) customclassbox.getSelectedItem());
					writer.write("*");

					writer.write((String) primaryweaponbox.getSelectedItem());
					writer.write("*");
					writer.write((String) primaryattachment1box
							.getSelectedItem());
					writer.write("*");
					writer.write((String) primaryattachment2box
							.getSelectedItem());
					writer.write("*");
					writer.write((String) primarycamobox.getSelectedItem());
					writer.write("*");
					writer.write((String) primaryproficiencybox
							.getSelectedItem());
					writer.write("*");
					writer.write((String) primaryreticlebox.getSelectedItem());
					writer.write("*");

					writer.write((String) secondaryweaponbox.getSelectedItem());
					writer.write("*");
					writer.write((String) secondaryattachment1box
							.getSelectedItem());
					writer.write("*");
					writer.write((String) secondaryattachment2box
							.getSelectedItem());
					writer.write("*");
					writer.write((String) secondarycamobox.getSelectedItem());
					writer.write("*");
					writer.write((String) secondaryproficiencybox
							.getSelectedItem());
					writer.write("*");
					writer.write((String) secondaryreticlebox.getSelectedItem());
					writer.write("*");

					writer.write((String) lethalgrenadebox.getSelectedItem());
					writer.write("*");

					writer.write(classNameField.getText());
					writer.write("*");

					writer.write((String) firstperkbox.getSelectedItem());
					writer.write("*");
					writer.write((String) secondperkbox.getSelectedItem());
					writer.write("*");
					writer.write((String) thirdperkbox.getSelectedItem());
					writer.write("*");

					writer.write((String) streaksetbox.getSelectedItem());
					writer.write("*");

					writer.write((String) tacticalgrenadebox.getSelectedItem());
					writer.write("*");

					writer.write((String) deathstreakbox.getSelectedItem());
					writer.write("*");

					writer.write((String) firstassaultbox.getSelectedItem());
					writer.write("*");
					writer.write((String) secondassaultbox.getSelectedItem());
					writer.write("*");
					writer.write((String) thirdassaultbox.getSelectedItem());
					writer.write("*");

					writer.write((String) firstsupportbox.getSelectedItem());
					writer.write("*");
					writer.write((String) secondsupportbox.getSelectedItem());
					writer.write("*");
					writer.write((String) thirdsupportbox.getSelectedItem());
					writer.write("*");

					writer.write((String) firstspecialistbox.getSelectedItem());
					writer.write("*");
					writer.write((String) secondspecialistbox.getSelectedItem());
					writer.write("*");
					writer.write((String) thirdspecialistbox.getSelectedItem());
					writer.write("*");

					writer.write(specialiststreak1.getText());
					writer.write("*");
					writer.write(specialiststreak2.getText());
					writer.write("*");
					writer.write(specialiststreak3.getText());
					writer.write("*");

					if (primaryweaponcheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");
					if (primaryattachment1checkbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");
					if (primaryattachment2checkbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");
					if (primarycamocheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");
					if (primaryproficiencycheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");
					if (primaryreticlecheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");

					if (secondaryweaponcheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");
					if (secondaryattachment1checkbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");
					if (secondaryattachment2checkbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");
					if (secondarycamocheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");
					if (secondaryproficiencycheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");
					if (secondaryreticlecheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");

					if (lethalgrenadecheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");

					if (firstperkcheckbox.isSelected())
					{
						writer.write("true");
						writer.write("*");
						writer.write("true");
						writer.write("*");
						writer.write("true");
					} else
					{
						writer.write("false");
						writer.write("*");
						writer.write("false");
						writer.write("*");
						writer.write("false");
					}

					writer.write("*");

					if (streaksetcheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");

					if (tacticalgrenadecheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");

					if (classnamecheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");

					if (deathstreakcheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");

					if (firstassaultcheckbox.isSelected())
					{
						writer.write("true");
						writer.write("*");
						writer.write("true");
						writer.write("*");
						writer.write("true");
					} else
					{
						writer.write("false");
						writer.write("*");
						writer.write("false");
						writer.write("*");
						writer.write("false");
					}

					writer.write("*");

					if (firstsupportcheckbox.isSelected())
					{
						writer.write("true");
						writer.write("*");
						writer.write("true");
						writer.write("*");
						writer.write("true");
					} else
					{
						writer.write("false");
						writer.write("*");
						writer.write("false");
						writer.write("*");
						writer.write("false");
					}

					writer.write("*");

					if (firstspecialistcheckbox.isSelected())
					{
						writer.write("true");
						writer.write("*");
						writer.write("true");
						writer.write("*");
						writer.write("true");
					}

					else
					{
						writer.write("false");
						writer.write("*");
						writer.write("false");
						writer.write("*");
						writer.write("false");
					}

					writer.write("*");

					if (earlyspecialiststreakcheckbox.isSelected())
						writer.write("true");
					else
						writer.write("false");
					writer.write("*");

					writer.flush();
					writer.close();

					JOptionPane.showMessageDialog(rootPane,
							"File saved successfully!", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}

				catch (NullPointerException n)
				{
					n.printStackTrace();
				}

				catch (IOException o)
				{
					o.printStackTrace();
					JOptionPane.showMessageDialog(rootPane,
							"Error saving file!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		loadbutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String buffer = "";
				String readFromFile = "";
				BufferedReader reader = null;
				String[] selectionFromFile = null;

				// Display file selection window
				fileChooser.showOpenDialog(rootPane);

				try
				{
					reader = new BufferedReader(new FileReader(fileChooser
							.getSelectedFile()));
				} catch (FileNotFoundException f)
				{
					f.printStackTrace();
				}

				try
				{
					// Read entire file into string
					while ((readFromFile = reader.readLine()) != null)
						buffer = buffer.concat(readFromFile);
				} catch (IOException e1)
				{
					e1.printStackTrace();
				}

				try
				{
					// Split after every * in the file
					selectionFromFile = buffer.split("\\*");
				} catch (PatternSyntaxException e2)
				{
					e2.printStackTrace();
				}

				int index = 0;

				try
				{
					customclassbox.setSelectedItem(selectionFromFile[index++]);

					primaryweaponbox
							.setSelectedItem(selectionFromFile[index++]);
					primaryattachment1box
							.setSelectedItem(selectionFromFile[index++]);
					primaryattachment2box
							.setSelectedItem(selectionFromFile[index++]);
					primarycamobox.setSelectedItem(selectionFromFile[index++]);
					primaryproficiencybox
							.setSelectedItem(selectionFromFile[index++]);
					primaryreticlebox
							.setSelectedItem(selectionFromFile[index++]);

					secondaryweaponbox
							.setSelectedItem(selectionFromFile[index++]);
					secondaryattachment1box
							.setSelectedItem(selectionFromFile[index++]);
					secondaryattachment2box
							.setSelectedItem(selectionFromFile[index++]);
					secondarycamobox
							.setSelectedItem(selectionFromFile[index++]);
					secondaryproficiencybox
							.setSelectedItem(selectionFromFile[index++]);
					secondaryreticlebox
							.setSelectedItem(selectionFromFile[index++]);

					lethalgrenadebox
							.setSelectedItem(selectionFromFile[index++]);
					classNameField.setText(selectionFromFile[index++]);

					firstperkbox.setSelectedItem(selectionFromFile[index++]);
					secondperkbox.setSelectedItem(selectionFromFile[index++]);
					thirdperkbox.setSelectedItem(selectionFromFile[index++]);

					streaksetbox.setSelectedItem(selectionFromFile[index++]);

					tacticalgrenadebox
							.setSelectedItem(selectionFromFile[index++]);

					deathstreakbox.setSelectedItem(selectionFromFile[index++]);

					firstassaultbox.setSelectedItem(selectionFromFile[index++]);
					secondassaultbox
							.setSelectedItem(selectionFromFile[index++]);
					thirdassaultbox.setSelectedItem(selectionFromFile[index++]);

					firstsupportbox.setSelectedItem(selectionFromFile[index++]);
					secondsupportbox
							.setSelectedItem(selectionFromFile[index++]);
					thirdsupportbox.setSelectedItem(selectionFromFile[index++]);

					firstspecialistbox
							.setSelectedItem(selectionFromFile[index++]);
					secondspecialistbox
							.setSelectedItem(selectionFromFile[index++]);
					thirdspecialistbox
							.setSelectedItem(selectionFromFile[index++]);

					specialiststreak1.setText(selectionFromFile[index++]);
					specialiststreak2.setText(selectionFromFile[index++]);
					specialiststreak3.setText(selectionFromFile[index++]);

					primaryweaponcheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));
					primaryattachment1checkbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));
					primaryattachment2checkbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));
					primarycamocheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));
					primaryproficiencycheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));
					primaryreticlecheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));

					secondaryweaponcheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));
					secondaryattachment1checkbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));
					secondaryattachment2checkbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));
					secondarycamocheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));
					secondaryproficiencycheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));
					secondaryreticlecheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));

					lethalgrenadecheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));
					classnamecheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));

					firstperkcheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));

					streaksetcheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));

					tacticalgrenadecheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));

					deathstreakcheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));

					firstassaultcheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));

					firstsupportcheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));

					firstspecialistcheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));

					earlyspecialiststreakcheckbox.setSelected(Boolean
							.parseBoolean(selectionFromFile[index++]));

					JOptionPane.showMessageDialog(rootPane,
							"File loaded successfully!", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1)
				{
					e1.printStackTrace();
				}

				finally
				{
					try
					{
						reader.close();
					} catch (IOException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});

		donatebutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				openUrl("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=DN644F3DPVGZ6");
			}
		});

		youtubebutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				openUrl("http://adf.ly/BuhQm");
			}
		});

		bwhbutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				openUrl("http://adf.ly/BwiXw");
			}
		});

		Runtime.getRuntime().addShutdownHook(new Thread()
		{
			@Override
			public void run()
			{
				try
				{
					pathWriter.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public void openUrl(String url)
	{
		if (java.awt.Desktop.isDesktopSupported())
		{
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if (desktop.isSupported(java.awt.Desktop.Action.BROWSE))
			{
				java.net.URI uri = null;
				try
				{
					uri = new java.net.URI(url);
				} catch (URISyntaxException e1)
				{
					e1.printStackTrace();
				}
				try
				{
					desktop.browse(uri);
				}

				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		}
	}

	public JFileChooser getFileChooser()
	{
		JFileChooser fileChooser = new JFileChooser();

		// Allow files only
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		// .mw3 files only
		fileChooser.setFileFilter(new FileNameExtensionFilter(
				"MW3 class files", "mw3"));

		try
		{
			// Try accessing saved path
			fileChooser.setCurrentDirectory(new File(new File("")
					.getAbsolutePath() + "/" + pathWriter.readLine()));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return fileChooser;
	}
}
