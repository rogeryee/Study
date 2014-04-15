package com.yeep.study.patterns.adapter;

public class ChinaDuck implements Duck
{
  public void quack()
  {
    System.out.println("ChinaDuck quack!!!");
  }

  public void fly()
  {
    System.out.println("ChinaDuck fly!!!");
  }
}
