package com.yeep.study.spring.sample.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

import com.yeep.study.spring.sample.exception.LogicException;

/**
 * Log the info
 *
 * @author Roger.Yee
 */
public class LogInfoAdvice implements ThrowsAdvice
{
    private static final Logger log = Logger.getLogger(LogInfoAdvice.class);

    /**
     * This method is handle for the LogicException
     *
     * @param ex
     */
    public void afterThrowing(Method method, Object args, Object target, LogicException ex)
    {
        System.out.println("This is the function afterThrowing of Class LogInfoAdvice to handle the LogicException.\r\n");
    }
}
