package com.yeep.study.swing.component;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class ListSample
{
	public static void main(String[] args)
	{
		ListSample sample = new ListSample();
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
		JPanel mainPanel = new JPanel(new GridLayout(1, 4));

		/**************************** 1.JList *********************************/
		String labelList[] =
		{ "Element1", "Element2", "Element3", "Element4", "Element5" };
		JList jlist = new JList(labelList);
		JScrollPane jscrollPane = new JScrollPane(jlist);
		jscrollPane.setSize(30, 10);

		JPanel jlistPanel = new JPanel();
		jlistPanel.add(jscrollPane);
		mainPanel.add(jlistPanel);

		/**************************** 2.JComboBox (Array) *********************************/
		String[] fruits =
		{ "Apple", "Banana", "Orange", "Pear", "Mango", "Others" };
		JComboBox jcomboBox1 = new JComboBox(fruits);

		jcomboBox1.setBorder(BorderFactory.createTitledBorder("Your Favorites:"));
		JPanel jcomboBox1Panel = new JPanel();
		jcomboBox1Panel.add(jcomboBox1);
		mainPanel.add(jcomboBox1Panel);

		/**************************** 3.JComboBox (Model) *********************************/
		ComboBoxDataModel data = new ComboBoxDataModel();
		JComboBox jcomboBox2 = new JComboBox(data);

		jcomboBox2.setBorder(BorderFactory.createTitledBorder("Your Favorites:"));
		JPanel jcomboBox2Panel = new JPanel();
		jcomboBox2Panel.add(jcomboBox2);
		mainPanel.add(jcomboBox2Panel);
		
		data.addData("Roger");

		/**************************** 3.Spinner *********************************/
		String weekdays[] = new String[]
		{ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
				"Saturday" };
		JSpinner jspinner = new JSpinner(new SpinnerListModel(weekdays));
		JPanel jspinnerPanel = new JPanel();
		jspinnerPanel.add(jspinner);
		mainPanel.add(jspinnerPanel);

		// Set panel properties
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		mainFrame.setContentPane(mainPanel);
		mainFrame.setSize(200, 200);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}

class ComboBoxDataModel extends DefaultComboBoxModel
{
	public ComboBoxDataModel()
	{
		this.addElement("Apple");
		this.addElement("Banana");
		this.addElement("Orange");
		this.addElement("Pear");
		this.addElement("Mango");
		this.addElement("Others");
	}
	
	public void addData(String name)
	{
		this.addElement(name);
	}
}
