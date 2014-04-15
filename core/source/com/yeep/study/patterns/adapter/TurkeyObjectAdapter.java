package com.yeep.study.patterns.adapter;

/**
 * The Object Adapter for Turkey
 */
public class TurkeyObjectAdapter implements Duck
{
  private Turkey turkey;

  public TurkeyObjectAdapter(Turkey turkey)
  {
    this.turkey = turkey;
  }

  // Adapte gobble to quack
  public void quack()
  {
    turkey.gobble();
  }

  public void fly()
  {
    turkey.fly();
  }
}
