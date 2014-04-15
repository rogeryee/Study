package com.yeep.study.spring.sample.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.yeep.study.spring.sample.exception.GlobalEnv;
import com.yeep.study.spring.sample.exception.LogicException;

/**
 * Validate the submit by Service
 *
 * @author Roger.Yee
 */
public class ValidationAdvice implements MethodInterceptor
{
    private static final Logger log = Logger.getLogger(ValidationAdvice.class);

    /**
     * @param invocation
     * @return
     * @throws Throwable
     */
    public Object invoke(MethodInvocation invocation) throws Throwable
    {
        System.out.println("This is the function afterAdvice of Class ValidationAdvice to handle the validation.\r\n");

        Object ret = null;

        ret = invocation.proceed();

        // If there have an Error while the Validation,then throws a LogicException
        // Maybe the LogicException will cause the roll-back according to the applicationContext. 
        if (GlobalEnv.isError())
        {
            GlobalEnv.clean();
            throw new LogicException("Exception from Validation Advice");
        }

        return ret;
    }
}