package com.yeep.study.spring.sample.exception;

/**
 * Exception of Logic Validation in Business role
 *
 * @author Roger.Yee
 */
public class LogicException extends RuntimeException
{

    public LogicException(String msg)
    {
        super(msg);
    }
}
