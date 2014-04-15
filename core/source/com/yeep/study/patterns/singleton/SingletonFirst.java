package com.yeep.study.patterns.singleton;

public class SingletonFirst
{
  // Define a static instance
  private static SingletonFirst instance = new SingletonFirst();

  private SingletonFirst()
  {
  }

  // provide the method for outer classes
  public static SingletonFirst getInstance()
  {
    return instance;
  }
}
