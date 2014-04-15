package com.yeep.study.patterns.singleton;

// This pattern is not recommend
public class SingletonThird
{
  private volatile static SingletonThird instance = null;

  private SingletonThird()
  {
  }

  public static SingletonThird getInstance()
  {
    if(instance == null)
    {
      synchronized(SingletonThird.class)
      {
        if(instance == null)
          instance = new SingletonThird();
      }
    }
    return instance;
  }

}
