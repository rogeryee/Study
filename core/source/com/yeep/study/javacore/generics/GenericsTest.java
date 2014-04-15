package com.yeep.study.javacore.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class for testing Generics
 */
public class GenericsTest
{
	public static void main(String[] args)
	{
		/** 1. Simple Generics definition* */
		List<Integer> integerList = new ArrayList<Integer>();
		integerList.add(new Integer(1));
		integerList.add(new Integer(2));
		integerList.add(new Integer(3));
		// integerList.add(new String("Another Element")); // It will be error

		Integer integer = integerList.get(0); // No need to cast to Integer type

		/** 2. Generics in inheritance* */
		List<String> stringList = new ArrayList<String>();
		// List<Object> objectList = stringList;// It will be error

		/** 3. The Generics Class * */
		// Define the element which will be pushed to List
		GenericsList<Integer> genericsList = new GenericsList<Integer>();
		genericsList.add(new Integer(1));
		// list.add(new String("Another Element")); // It will be error

		/** 4. Using Wildcards for Generics * */
		Collection<Object> objectCollection = new ArrayList<Object>();
		objectCollection.add(new Object());

		Collection<String> stringCollection = new ArrayList<String>();
		stringCollection.add("1");

		printObjectWithoutWildcards(objectCollection);
		// printObjectWithoutWildcards(stringCollection);// It will error

		printObjectWithWildcards(objectCollection);
		printObjectWithWildcards(stringCollection);

		printStringWithWildcards(stringCollection);

		/** 5. Using Generics Method **/
		printObjectWithGenericsMethod(stringCollection);
		
	}

	/**
	 * The method used Generics to loop the collection without using wildcards
	 * 
	 * @param c
	 */
	private static void printObjectWithoutWildcards(Collection<Object> c)
	{
		for (Object o : c)
		{
			System.out.println(o);
		}
	}

	/**
	 * The method used Generics to loop the collection using wildcard
	 * 
	 * @param c
	 */
	private static void printObjectWithWildcards(Collection<?> c)
	{
		for (Object o : c)
		{
			System.out.println(o);
		}
	}

	/**
	 * The method used Generics to loop the collection using wildcard
	 * 
	 * @param c the collection contains object which must extends String
	 */
	private static void printStringWithWildcards(Collection<? extends String> c)
	{
		for (String s : c)
		{
			System.out.println(s);
		}
	}

	/**
	 * The method used generics method
	 * 
	 * @param <T>
	 * @param c
	 */
	private static <T extends String> void printObjectWithGenericsMethod(Collection<T> c)
	{
		for (T o : c)
		{
			System.out.println(o);
		}
	}

}
