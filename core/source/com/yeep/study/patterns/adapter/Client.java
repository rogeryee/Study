package com.yeep.study.patterns.adapter;

public class Client
{
  public static void main(String[] args)
  {
    Duck duck = new ChinaDuck();
    duck.fly();
    duck.quack();

    Duck turkey = new TurkeyObjectAdapter(new ChinaTurkey());
    turkey.quack();
    turkey.fly();

    Duck d = new TurkeyClassAdapter();
    d.fly();
    d.quack();
  }
}
