package com.yeep.study.spring.aopsample.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * This a advice class of AOP BeforeAdvice
 *
 * @author Roger.Yee
 */
public class BeforeAdvice implements MethodBeforeAdvice
{

    public void before(Method method, Object[] args, Object target)
            throws Throwable
    {

        System.out.println("This is the Function before of BeforeAdvice.\r\n");

    }

}
