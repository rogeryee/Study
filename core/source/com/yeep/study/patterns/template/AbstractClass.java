package com.yeep.study.patterns.template;

public abstract class AbstractClass
{
  // Template Method
  public void templateMethod()
  {
    primitiveOperation1();
    primitiveOperation2();
  }

  abstract void primitiveOperation1();

  abstract void primitiveOperation2();
}
