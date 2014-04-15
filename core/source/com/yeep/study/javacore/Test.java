package com.yeep.study.javacore;

import java.util.HashMap;
import java.util.Map;

public class Test
{
	public void testMethod1() throws CheckedException
	{
		throw new CheckedException("A Checked Exception is thrown");
	}

	public void testMethod2() throws CheckedException
	{
		testMethod1();
	}

	public void testMethod3()
	{
		throw new NullPointerException("A Runtime Exception is thrown");
	}
	
	public void testMethod4() throws CheckedException
	{
		System.out.println("test method 4");
	}

	public static void main(String[] args)
	{		
		Test test = new Test();
		try
		{
			test.testMethod1();
		}
		catch (CheckedException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			test.testMethod3();
		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			test.testMethod4();
		}
		catch (CheckedException e)
		{
			System.out.println("Exception here");
			e.printStackTrace();
		}
	}
}

class CheckedException extends Exception
{
	public CheckedException(String msg)
	{
		super(msg);
	}
}


interface Animal
{
    public void eat();
}
