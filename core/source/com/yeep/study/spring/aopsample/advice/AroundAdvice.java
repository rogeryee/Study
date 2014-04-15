package com.yeep.study.spring.aopsample.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * This a adivce class of AOP RoundAdvice
 *
 * @author Roger.Yee
 */
public class AroundAdvice implements MethodInterceptor
{
    public Object invoke(MethodInvocation invocation) throws Throwable
    {
        System.out.println("This is the function invoke of Class AroundAdvice.\r\n");

        Object result = null;

        result = invocation.proceed();

        return result;
    }
}
