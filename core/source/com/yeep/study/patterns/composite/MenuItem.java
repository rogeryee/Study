package com.yeep.study.patterns.composite;

/**
 * Lead node of Menu Tree
 */
public class MenuItem extends MenuComponent
{
  private String name;

  public MenuItem(String name)
  {
    this.name = name;
  }

  public void print()
  {
    System.out.println("This is a menuItem : " + name);
  }
}
