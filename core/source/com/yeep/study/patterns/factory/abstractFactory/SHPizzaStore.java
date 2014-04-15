package com.yeep.study.patterns.factory.abstractFactory;

public class SHPizzaStore implements PizzaStore
{
  public Dough createDough()
  {
    return new ThinDough();
  }

  public Sauce createSauce()
  {
    return new PlumSauce();
  }
}
