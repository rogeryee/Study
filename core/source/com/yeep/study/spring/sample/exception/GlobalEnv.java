package com.yeep.study.spring.sample.exception;

/**
 * Global Environment
 *
 * @author Roger.Yee
 */
public class GlobalEnv
{
    private static boolean isError = false;


    public static boolean isError()
    {
        return isError;
    }

    public static void clean()
    {
        isError = false;
    }

    public static void error()
    {
        isError = true;
    }
}
