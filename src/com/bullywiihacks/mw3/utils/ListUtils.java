package com.bullywiihacks.mw3.utils;

import java.util.List;

public class ListUtils
{
	public static String[] getNames(List<Pair<String, String>> list)
	{
		String[] names = new String[list.size()];
		
		for(int i = 0; i < list.size(); i++)			
		{
			names[i] = list.get(i).getName();
		}
		
		return names;
	}
	
	public static String[] getValues(List<Pair<String, String>> list)
	{
		String[] values = new String[list.size()];
		
		for(int i = 0; i < list.size(); i++)			
		{
			values[i] = list.get(i).getValue();
		}
		
		return values;
	}
}