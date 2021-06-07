package com.bullywiihacks.mw3.utils;

public class Pair<Name, Value>
{
	private Name name;
	private Value value;

	public Pair(Name name, Value value)
	{
		this.name = name;
		this.value = value;
	}

	public Name getName()
	{
		return name;
	}

	public Value getValue()
	{
		return value;
	}
}