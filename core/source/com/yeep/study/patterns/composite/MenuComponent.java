package com.yeep.study.patterns.composite;

/**
 * The Super level of Menu Tree
 */
public abstract class MenuComponent
{
  public abstract void print();

  public void add(MenuComponent component) {}

  public void remove(MenuComponent component) {}
}
