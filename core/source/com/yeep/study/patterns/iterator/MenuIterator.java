package com.yeep.study.patterns.iterator;

import java.util.List;

/**
 * Concrete iterator of menu
 */
public class MenuIterator implements Iterator
{
  private List menuItems;
  int position = 0;

  // Constructor
  public MenuIterator(List menuItems)
  {
    this.menuItems = menuItems;
  }

  public boolean hasNext()
  {
    if(this.menuItems == null || this.menuItems.size() == 0) return false;

    return this.position < this.menuItems.size();
  }

  public Object next()
  {
    Object menuItem = null;

    if(this.menuItems != null)
      menuItem = this.menuItems.get(this.position);

    this.position++;
    return menuItem;
  }
}
