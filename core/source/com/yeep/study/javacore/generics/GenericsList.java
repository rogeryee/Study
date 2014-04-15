package com.yeep.study.javacore.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Generics Class Sample.
 * <p>
 * This Class is used as a Generics Type
 */
public class GenericsList<T>
{
	private List<T> list;

	// Constructor
	public GenericsList()
	{
		this.list = new ArrayList<T>();
	}

	// Public Methods

	/**
	 * Add element to list
	 * 
	 * @param e
	 */
	public void add(T e)
	{
		if (this.list == null || e == null)
			return;

		this.list.add(e);
	}

	public T get(int index)
	{
		if (this.list == null)
			return null;

		return this.list.get(index);
	}
}
