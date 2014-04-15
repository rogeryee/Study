package com.yeep.study.patterns.factory.factoryMethod;

public abstract class PizzaStore
{
  public static final String PIZZA_TYPE_CHEESE = "CHEESE";
  public static final String PIZZA_TYPE_VEGGLE = "VEGGLE";
  
  // Public Methods
  public Pizza orderPizza(String type)
  {
    Pizza pizza = createPizza(type);

    pizza.cook();

    return pizza;
  }

  protected abstract Pizza createPizza(String type);
}
