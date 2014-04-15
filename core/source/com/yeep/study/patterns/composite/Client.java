package com.yeep.study.patterns.composite;

public class Client
{
  public static void main(String[] args)
  {
    MenuComponent rootMenu = new Menu("RootMenu");
    MenuComponent fileMenu = new Menu("File");
    MenuComponent toolsMenu = new Menu("Tools");
    MenuComponent toolsBarMenu = new Menu("Tools Bar");

    rootMenu.add(fileMenu);
    rootMenu.add(toolsMenu);

    fileMenu.add(new MenuItem("Open"));
    fileMenu.add(new MenuItem("Save"));
    fileMenu.add(new MenuItem("Save As"));

    toolsMenu.add(new MenuItem("Windows Update"));
    toolsMenu.add(toolsBarMenu);

    toolsBarMenu.add(new MenuItem("Links"));
    toolsBarMenu.add(new MenuItem("Standard Bar"));

    rootMenu.print();
  }
}