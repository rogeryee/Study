package com.yeep.study.spring.aopsample.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * This a advice class of AOP AfterAdvice
 *
 * @author Roger.Yee
 */
public class AfterAdvice implements AfterReturningAdvice
{

    public void afterReturning(Object returnValue, Method method,
                               Object[] args, Object target) throws Throwable
    {
        System.out.println("This is the function afterReturning of Class AfterAdvice.\r\n");
    }


}
