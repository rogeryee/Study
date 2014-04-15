package com.yeep.study.patterns.adapter;

/**
 * The Class Adapter for Turkey
 */
public class TurkeyClassAdapter implements Duck,Turkey
{
  public void quack()
  {
    System.out.println("TurkeyClassAdapter quack");
  }

  public void gobble()
  {
    System.out.println("TurkeyClassAdapter gobble");
  }

  public void fly()
  {
    System.out.println("TurkeyClassAdapter fly");
  }
}
