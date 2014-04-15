package com.yeep.study.patterns.factory.simpleFactory;

public class PizzaStore
{
  public static final String PIZZA_TYPE_CHEESE = "CHEESE";
  public static final String PIZZA_TYPE_VEGGLE = "VEGGLE";

  /*
   * Order Pizza 
   */
  public Pizza orderPizza(String type)
  {
    Pizza pizza = createPizza(type);

    pizza.cook();

    return pizza;
  }

  /**
   * Create Pizza for each type
   *
   * @param type Type of Pizza
   * @return Pizza Object
   */
  public Pizza createPizza(String type)
  {
    Pizza pizza = null;

    if(PIZZA_TYPE_CHEESE.equalsIgnoreCase(type))
      pizza = new CheesePizza();
    else if(PIZZA_TYPE_VEGGLE.equalsIgnoreCase(type))
      pizza = new VegglePizza();

    return pizza;
  }
}
