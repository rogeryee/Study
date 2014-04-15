package com.yeep.study.patterns.adapter;

public class ChinaTurkey implements Turkey
{
  public void gobble()
  {
    System.out.println("ChinaTurkey gobble!!!");
  }

  public void fly()
  {
    System.out.println("ChinaTurkey quack!!!");
  }
}
