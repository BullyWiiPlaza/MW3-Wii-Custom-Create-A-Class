package com.bullywiihacks.mw3.main;

import java.io.File;

import com.bullywiihacks.mw3.data.NamesAndValues;

public class Testing implements NamesAndValues
{
	public Testing()
	{
		System.out.println(new File("").getAbsolutePath());

//		assignAll();
//
//		for(int i = 0; i < primWeapons.size(); i++)
//		{
//			System.out.println(primWeapons.get(i).getName());
//		}
	}

	public static void main(String[] args)
	{
		new Testing();
	}
}