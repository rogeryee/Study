package com.yeep.study.patterns.singleton;

public class SingletonSecond
{
  private static SingletonSecond instance = null;

  private SingletonSecond()
  {
  }

  // Should be marked synchronized
  public static synchronized SingletonSecond getInstance()
  {
    if(instance == null)
      instance = new SingletonSecond();
    return instance;
  }

}
