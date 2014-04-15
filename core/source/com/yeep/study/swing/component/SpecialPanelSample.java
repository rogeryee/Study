package com.yeep.study.swing.component;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class SpecialPanelSample
{
	public static void main(String[] args)
	{
		SpecialPanelSample sample = new SpecialPanelSample();
		sample.init();
	}

	/**
	 * initialize the sample
	 */
	public void init()
	{
		/****************** 1.JSplitPanel ********************/
		JFrame frame1 = new JFrame();
		frame1.setSize(450, 200);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String sometext = "This is a simple text string that is long enough "
				+ "to wrap over a few lines in the simple demo we're about to build.  We'll "
				+ "put two text areas side by side in a split pane.";
		JTextArea jt1 = new JTextArea(sometext);
		JTextArea jt2 = new JTextArea(sometext);

		// Make sure our text boxes do line wrapping and have reasonable minimum
		// sizes.
		jt1.setLineWrap(true);
		jt2.setLineWrap(true);

		jt1.setMinimumSize(new Dimension(150, 150));
		jt2.setMinimumSize(new Dimension(150, 150));

		jt1.setPreferredSize(new Dimension(250, 200));
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jt1, jt2);
		frame1.getContentPane().add(sp, BorderLayout.CENTER);
		frame1.setVisible(true);

		/****************** 2.JScrollPanel ********************/
		JFrame frame2 = new JFrame();
		frame2.setSize(300, 200);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String categories[] =
		{ "Household", "Office", "Extended Family", "Company (US)",
				"Company (World)", "Team", "Will", "Birthday Card List", "High School",
				"Country", "Continent", "Planet" };
		JList list = new JList(categories);
		JScrollPane scrollpane = new JScrollPane(list);

		frame2.getContentPane().add(scrollpane, BorderLayout.CENTER);
		frame2.setVisible(true);
		
		/****************** 3.JTabbedPane ********************/
		JFrame frame3 = new JFrame();
		frame3.setSize(200, 200);
		
		JTabbedPane jtp = new JTabbedPane( );
    jtp.addTab("Tab1", new JLabel("This is Tab One"));
    jtp.addTab("Tab2", new JButton("This is Tab Two"));
    jtp.addTab("Tab3", new JCheckBox("This is Tab Three"));
    frame3.getContentPane().add(jtp);

    frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame3.setVisible(true);

	}
}
