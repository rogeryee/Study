package com.yeep.study.spring.aopsample.service;

/**
 * @author Roger.Yee
 */
public interface AdviceService
{
    public void testBeforeAndAfterAndAroundExcetion();

    public void testThrowAdviceByClassCastException() throws ClassCastException;

    public void testThrowAdviceByArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException;
}
