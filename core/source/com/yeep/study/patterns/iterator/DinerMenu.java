package com.yeep.study.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class DinerMenu implements Menu
{
  private List menu;

  // Constructor
  public DinerMenu()
  {
    this.menu = new ArrayList();
  }

  // Add menu item
  public void add(Object object)
  {
    if(this.menu != null && object != null)
      this.menu.add(object);
  }

  /**
   * Return Iterator
   *
   * @return
   */
  public Iterator getIterator()
  {
    return new MenuIterator(this.menu);
  }
}
