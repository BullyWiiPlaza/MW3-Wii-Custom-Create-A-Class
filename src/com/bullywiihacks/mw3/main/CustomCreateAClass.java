package com.bullywiihacks.mw3.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.bullywiihacks.mw3.GraphicalUserInterface;

public class CustomCreateAClass
{
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}

		new GraphicalUserInterface().setVisible(true);
	}
}