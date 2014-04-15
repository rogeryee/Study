package com.yeep.study.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * A Util for managering the session factory of Hibernate
 * 
 * @author Roger.Yee
 */
public class HibernateUtil
{
	private static final SessionFactory sessionFactory;

	static
	{
		try
		{
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration cfg = new Configuration().configure();
			sessionFactory = cfg.buildSessionFactory();
		}
		catch (Throwable ex)
		{
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
