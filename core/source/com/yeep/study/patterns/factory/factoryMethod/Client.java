package com.yeep.study.patterns.factory.factoryMethod;

public class Client
{
  public static void main(String[] args)
  {
    PizzaStore shStore = new SHPizzaStore();
    Pizza shCheesePizza = shStore.orderPizza("CHEESE");
    Pizza shVegglePizza = shStore.orderPizza("VEGGLE");

    PizzaStore bjStore = new BJPizzaStore();
    Pizza bjCheesePizza = bjStore.orderPizza("CHEESE");
    Pizza bjVegglePizza = bjStore.orderPizza("VEGGLE");
  }
}
