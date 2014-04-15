package com.yeep.study.ejb3.util;

import java.util.Properties;

import javax.naming.InitialContext;

public class ContextLoader
{
	//JNDI上下文 方式一   
	public static InitialContext getInitialPropertiesContext() throws javax.naming.NamingException
	{

		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

		//EJB容器的ip   
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");

		//EJB容器端口,默认为：3700   
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		InitialContext ic = new InitialContext(props);
		return ic;
	}

	/**  
	 * JNDI上下文 方式二读配置文件 文件为：jndi.properties  
	 *  
	 * @return  
	 * @throws javax.naming.NamingException  
	 */
	public static InitialContext getInitialJNDIFileContext() throws javax.naming.NamingException
	{
		return new InitialContext();
	}
}
