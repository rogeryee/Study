package com.yeep.study.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite Node of Menu Tree
 */
public class Menu extends MenuComponent
{
  private String name;
  private List<MenuComponent> menuComponents;

  public Menu(String name)
  {
    this.name = name;
    this.menuComponents = new ArrayList<MenuComponent>();
  }

  public void add(MenuComponent component)
  {
    if(this.menuComponents != null)
      this.menuComponents.add(component);
  }

  public void remove(MenuComponent component)
  {
    if(this.menuComponents != null)
      this.menuComponents.remove(component);
  }

  public void print()
  {
    System.out.println("This is a menu : " + this.name);
    if(this.menuComponents != null)
    {
      for(MenuComponent menuComponent : this.menuComponents)
      {
        menuComponent.print();
      }
    }
  }
}
