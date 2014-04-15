package com.yeep.study.swing.component;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ButtonSample
{
	public static void main(String[] args)
	{
		ButtonSample sample = new ButtonSample();
		sample.init();
	}

	/**
	 * initialize the sample
	 */
	public void init()
	{
		// create main panel
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel(new GridLayout(4, 1));

		/**************************** 1.JButton *********************************/
		JButton jbutton = new JButton("JButton-Sample");
		jbutton.setSize(10, 10);
		jbutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				System.out.println("JButton-ActionEvent!");
			}
		});
		jbutton.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ev)
			{
				System.out.println("JButton-ItemEvent!");
			}
		});
		jbutton.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent ev)
			{
				System.out.println("JButton-ChangeEvent!");
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(jbutton);
		mainPanel.add(buttonPanel);

		/**************************** 2.JToggleButton *********************************/
		JToggleButton jtoggleButton = new JToggleButton("JToggleButton-Sample");
		jtoggleButton.setSize(30, 15);
		jtoggleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				System.out.println("JToggleButton-ActionEvent!");
			}
		});
		jtoggleButton.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ev)
			{
				System.out.println("JToggleButton-ItemEvent!");
			}
		});
		jtoggleButton.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent ev)
			{
				System.out.println("JToggleButton-ChangeEvent!");
			}
		});

		JPanel jtoggleButtonPanel = new JPanel();
		jtoggleButtonPanel.add(jtoggleButton);
		mainPanel.add(jtoggleButtonPanel);

		/**************************** 3.JCheckBox *********************************/
		JCheckBox jcheckBox1 = new JCheckBox("JCheckBox1-Sample");
		JCheckBox jcheckBox2 = new JCheckBox("JCheckBox2-Sample");
		JPanel checkBoxPanel = new JPanel(new GridLayout(2, 1));

		checkBoxPanel.add(jcheckBox1);
		checkBoxPanel.add(jcheckBox2);
		mainPanel.add(checkBoxPanel);

		/**************************** 4.JRadioButton *********************************/
		ButtonGroup radioButtonGroup = new ButtonGroup();
		JRadioButton jradioButton1 = new JRadioButton("JRadioButton1-Sample");
		JRadioButton jradioButton2 = new JRadioButton("JRadioButton2-Sample");
		radioButtonGroup.add(jradioButton1);
		radioButtonGroup.add(jradioButton2);

		JPanel radioButtonPanel = new JPanel(new GridLayout(2, 1));
		radioButtonPanel.add(jradioButton1);
		radioButtonPanel.add(jradioButton2);
		mainPanel.add(radioButtonPanel);

		// Set panel properties
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		mainFrame.setContentPane(mainPanel);
		mainFrame.setSize(200, 200);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}
