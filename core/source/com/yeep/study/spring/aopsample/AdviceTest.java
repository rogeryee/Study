package com.yeep.study.spring.aopsample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.yeep.study.spring.aopsample.service.AdviceService;

/**
 * This class is test for AOP Advice
 * 
 * @author Roger.Yee
 */
public class AdviceTest
{

	/** */
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"core/source/com/yeep/study/spring/aopsample/applicationContext_Advice.xml");

		AdviceService adviceService = (AdviceService) ctx.getBean("adviceSample");

		// test for beforeAdvice,aroundAdvice,afterRunningAdvice
		adviceService.testBeforeAndAfterAndAroundExcetion();

		// test for afterThrowAdvice
		// throw ArrayIndexOutOfBoundsException
		// adviceService.testThrowAdviceByArrayIndexOutOfBoundsException();

		// throw ClassCastException
		adviceService.testThrowAdviceByClassCastException();
	}

}
