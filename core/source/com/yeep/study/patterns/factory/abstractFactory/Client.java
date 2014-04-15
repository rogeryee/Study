package com.yeep.study.patterns.factory.abstractFactory;

public class Client
{
  public static void main(String[] args)
  {
    PizzaStore shStore = new SHPizzaStore();
    shStore.createDough();
    shStore.createSauce();

    PizzaStore bjStore = new BJPizzaStore();
    bjStore.createDough();
    bjStore.createSauce();
  }
}
