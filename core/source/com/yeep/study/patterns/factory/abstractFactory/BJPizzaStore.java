package com.yeep.study.patterns.factory.abstractFactory;

public class BJPizzaStore implements PizzaStore
{
  public Dough createDough()
  {
    return new ThickDough();
  }

  public Sauce createSauce()
  {
    return new MarinaraSauce();
  }
}
