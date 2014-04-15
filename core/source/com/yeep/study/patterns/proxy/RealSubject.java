package com.yeep.study.patterns.proxy;

/**
 * Real Subject
 */
public class RealSubject implements Subject
{
  public void operation()
  {
    System.out.println("This is RealSubject's operation");
  }
}
