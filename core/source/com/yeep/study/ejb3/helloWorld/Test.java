package com.yeep.study.ejb3.helloWorld;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.yeep.study.ejb3.util.ContextLoader;

public class Test
{
	public static void main(String[] args)
	{
		System.out.println(testRemoteInterfaceByInitialPropertiesContext("TestRemote"));
	}

	/**
	 * Test the Lemote interface by using Properties to get Context
	 * @param name
	 * @return
	 */
	public static String testRemoteInterfaceByInitialPropertiesContext(String name)
	{
		try
		{
			InitialContext ctx = ContextLoader.getInitialPropertiesContext();
			HelloWorld helloWorld = (HelloWorld) ctx.lookup("HelloWorld/remote");
			return helloWorld.sayHello(name);
		}
		catch (NamingException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Test the remote interface by using JNDI.properties file to get Context
	 * @param name
	 * @return
	 */
	public static String testEJBByInitialJNDIContext(String name)
	{
		try
		{
			InitialContext ctx = ContextLoader.getInitialJNDIFileContext();
			HelloWorld helloWorld = (HelloWorld) ctx.lookup("HelloWorld/remote");
			return helloWorld.sayHello(name);
		}
		catch (NamingException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
