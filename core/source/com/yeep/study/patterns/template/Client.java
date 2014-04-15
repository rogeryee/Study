package com.yeep.study.patterns.template;

public class Client
{
  public static void main(String [] args)
  {
    AbstractClass class1 = new ConcreteClassOne();
    class1.templateMethod();

    AbstractClass class2 = new ConcreteClassTwo();
    class2.templateMethod();
  }
}
