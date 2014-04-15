package com.yeep.study.spring.sample.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yeep.study.spring.sample.action.TxSampleAction;

/**
 * Test class for Spring v1.0 transaction declaration sample
 * 
 * @author Roger.Yee
 */
public class TxSampleTest
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		TxSampleAction txSample = (TxSampleAction) ctx.getBean("txSampleAction");

		System.out.println("### Transaction Sample Test Start ### \r\n");

		txSample.userLogicAddUser("Test User 001", "Shanghai", "Aspen Tech");

		System.out.println("### Transaction Sample Test End ### \r\n");
	}
}
