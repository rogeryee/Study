package com.yeep.study.spring.aopsample.service;

/**
 * This class implement the IStudent Interface
 *
 * @author Roger.Yee
 */
public class AdviceServiceImpl implements AdviceService
{

    public void testBeforeAndAfterAndAroundExcetion()
    {
        System.out.println("Enter testBeforeAndAfterAndAroundExcetion().");
    }

    public void testThrowAdviceByClassCastException() throws ClassCastException
    {
        System.out.println("Enter testThrowAdviceByClassCastException().");

        Object obj = new Integer("100");
        String str = (String) obj;
    }

    public void testThrowAdviceByArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException
    {
        System.out.println("Enter testThrowAdviceByArrayIndexOutOfBoundsException().");

        int[] array = new int[]{1, 2, 3, 4, 5};
        array[10] = 100;
    }
}
