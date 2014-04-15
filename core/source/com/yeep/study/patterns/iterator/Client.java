package com.yeep.study.patterns.iterator;

public class Client
{
  public static void main(String[] args)
  {
    Menu menu = new DinerMenu();
    menu.add(new MenuItem("1", "Pork"));
    menu.add(new MenuItem("2", "Beef"));
    menu.add(new MenuItem("3", "Beer"));

    Iterator iterator = menu.getIterator();
    while(iterator.hasNext())
    {
      MenuItem menuItem = (MenuItem) iterator.next();
      System.out.println(menuItem.getId() + " : " + menuItem.getName());
    }
  }
}
