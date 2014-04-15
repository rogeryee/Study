package com.yeep.gwt.study.sample.helloWorld.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 * Author: Roger Yi
 */
public class HelloWorld implements EntryPoint
{
  public void onModuleLoad()
  {
    // Using Log4j
    GWT.log("HelloWorld Initializing", null);

    // Create Constants
    final HelloWorldConstants constants =
        (HelloWorldConstants) GWT.create(HelloWorldConstants.class);

    // Create Welcome Button and Label
    final Button welcomeBtn = new Button(constants.ButtonItemWelcome());
    final Label welcomeLabel = new Label("");

    // Define the Button Event Listener
    welcomeBtn.addClickListener(new ClickListener()
    {
      public void onClick(Widget sender)
      {
        if(welcomeLabel.getText().equals(""))
        {
          welcomeLabel.setText(constants.WelcomeContent());
        }
        else
          welcomeLabel.setText("");
      }
    });

    // Add button and label to HTML
    RootPanel.get("slot1").add(welcomeBtn);
    RootPanel.get("slot2").add(welcomeLabel);

    // Create Menu
    MenuBar mainMenu = new MenuBar();
    MenuBar helpMenu = new MenuBar(true);
    MenuBar aboutMenu = new MenuBar(true);

    helpMenu.addItem(constants.MenuItemAbout(), new MenuCommand());
    mainMenu.addItem(constants.MenuItemHelp(), helpMenu);

    // Add Menu to HTML
    RootPanel.get().add(mainMenu);
  }

  /**
   * Menu Item Command
   */
  public class MenuCommand implements Command
  {
    public void execute()
    {
      Window.alert("Menu Item Clicked");
    }
  }
}
