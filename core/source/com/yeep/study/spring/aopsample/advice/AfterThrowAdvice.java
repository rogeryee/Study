package com.yeep.study.spring.aopsample.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * This a advice class of AOP AfterThrowAdvice
 * We must implement this method to handle the exception thrown in program.
 * public void afterThrow...( [Method method,] [Object args,] [Object target,] Throwable throwable );
 * The first three parameters is optional not required.
 *
 * @author Roger.Yee
 */
public class AfterThrowAdvice implements ThrowsAdvice
{
    /**
     * This method is handle for the ClassCastException
     *
     * @param ex
     */
    public void afterThrowing(Method method,Object args,Object target,ClassCastException ex)
    {
        System.out.println("This is the function afterThrowing of Class AfterThrowAdvice to handle the ClassCastException.\r\n");

        System.out.println("System threw an ArrayIndexOutOfBoundsException, the info of it is: " + ex.getMessage());
        System.out.println("The method threw this exception is: " + method);
        System.out.println("The parameters of this method is: " + args);
        System.out.println("The target of this method is: " + target);        
    }

    /**
     * This method is handle for the ArrayIndexOutOfBoundsException
     *
     * @param ex
     */
    public void afterThrowing(ArrayIndexOutOfBoundsException ex)
    {
        System.out.println("This is the function afterThrowing of Class AfterThrowAdvice to handle the ArrayIndexOutOfBoundsException.\r\n");

        System.out.println("System threw an ArrayIndexOutOfBoundsException, the info of it is: " + ex.getMessage());
    }

}
