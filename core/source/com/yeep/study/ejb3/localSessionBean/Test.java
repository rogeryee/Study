package com.yeep.study.ejb3.localSessionBean;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.yeep.study.ejb3.util.ContextLoader;

public class Test
{
	public static void main(String[] args)
	{
		System.out.println(testLocalInterfaceByInitialPropertiesContext("TestLocal"));
	}

	/**
	 * Test the Lemote interface by using Properties to get Context
	 * @param name
	 * @return
	 */
	public static String testLocalInterfaceByInitialPropertiesContext(String name)
	{
		try
		{
			InitialContext ctx = ContextLoader.getInitialPropertiesContext();
			HelloWorld helloWorld = (HelloWorld) ctx.lookup("HelloWorld/local");
			return helloWorld.sayHello(name);
		}
		catch (NamingException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
