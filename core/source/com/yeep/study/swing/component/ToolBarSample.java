package com.yeep.study.swing.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class ToolBarSample
{
	public static void main(String[] args)
	{
		ToolBarSample sample = new ToolBarSample();
		sample.init();
	}

	/**
	 * initialize the sample
	 */
	public void init()
	{
		pane = new JTextPane();
		pane.setPreferredSize(new Dimension(250, 250));
		toolBar = new JToolBar("Formatting");
		toolBar.setMaximumSize(toolBar.getSize());
		toolBar.addSeparator();
		toolBar.add(new JLabel("Font"));

		toolBar.addSeparator();
		JComboBox combo = new JComboBox(fonts);
		combo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					pane.getStyledDocument().insertString(
							0,
							"Font [" + ((JComboBox) e.getSource()).getSelectedItem()
									+ "] chosen!\n", null);
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		toolBar.add(combo);

		JFrame frame = new JFrame("ToolsBar Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		frame.getContentPane().add(pane, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);

	}

	public JTextPane pane;
	public JMenuBar menuBar;
	public JToolBar toolBar;
	String fonts[] =
	{ "Serif", "SansSerif", "Monospaced", "Dialog", "DialogInput" };
}
