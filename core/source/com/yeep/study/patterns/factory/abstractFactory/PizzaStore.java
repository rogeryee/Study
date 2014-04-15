package com.yeep.study.patterns.factory.abstractFactory;

public interface PizzaStore
{
  public Dough createDough();

  public Sauce createSauce();
}
