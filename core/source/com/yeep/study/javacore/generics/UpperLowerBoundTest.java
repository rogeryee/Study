package com.yeep.study.javacore.generics;

import java.util.ArrayList;
import java.util.List;

public class UpperLowerBoundTest
{
	public void upperBound(List<? extends A> list, A a)
	{
		// list.add(a); // Compile error， since we can not know the type of list can contain a element of type A
		list.add(null);// Compile successfully
	}

	// Solution for upper bound
	public <T extends A> void upperBound2(List<T> list, T t)
	{
		list.add(t);
	}

	public void lowerBound(List<? super B> list)
	{
		list.add(new B());
		// B b = list.get(0); // Compile error
	}

	public static void main(String[] args)
	{
		UpperLowerBoundTest test = new UpperLowerBoundTest();

		// Upper bound test
		List<B> listUpper = new ArrayList<B>();
		test.upperBound(listUpper, new A());

		test.upperBound2(listUpper, new B());

		// lower bound test
		List<A> listLower = new ArrayList<A>();
		listLower.add(new A());
		test.lowerBound(listLower);
	}
}

/*
 * Class inheritance : 
 * A ------ B ---- C 
 *     | 
 *     |--- D
 */

class A
{
}

class B extends A
{
}

class C extends B
{
}

class D extends A
{
}
