package com.yeep.study.swing.component;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRootPane;


public class RootPaneSample
{
	public static void main(String[] args)
	{
		RootPaneSample sample = new RootPaneSample();
		sample.init();
	}

	/**
	 * initialize the sample
	 */
	public void init()
	{
		/**************************** 1.JRootPane - 1 *********************************/
		JFrame frame1 = new JFrame( );
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JRootPane rootPane1 = frame1.getRootPane( );         
    Container contentPane1 = rootPane1.getContentPane( ); 
    contentPane1.add(new JButton("JRootPane Sample"));  
    
    frame1.pack( );
    frame1.setVisible(true);
    
    /**************************** 2.JRootPane - 2 *********************************/
		JFrame frame2 = new JFrame( );
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    JRootPane rootPane2 = frame2.getRootPane( );

    // Create a menu bar
    JMenuBar menuBar = new JMenuBar( );
    JMenu menu = new JMenu("Menu");
    menuBar.add(menu);
    menu.add("Sub-Menu-1");
    menu.add("Sub-Menu-2");
    rootPane2.setJMenuBar(menuBar);

    // Add a button to the content pane.
    rootPane2.getContentPane( ).add(new JButton("Hello World"));
    
    frame2.pack( );
    frame2.setVisible(true);
	}
}
