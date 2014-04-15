package com.yeep.study.swing.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LabelIconSample
{
	public static void main(String[] args)
	{
		LabelIconSample sample = new LabelIconSample();
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
		JPanel mainPanel = new JPanel(new GridLayout(3, 1));

		/**************************** 1.Label Sample *********************************/
		JLabel labelSample = new JLabel("Label Sample");

		JPanel labelPanel = new JPanel();
		labelPanel.add(labelSample);
		mainPanel.add(labelPanel);

		/**************************** 2.Label for Image *********************************/
		ClassLoader loader = this.getClass().getClassLoader();
		URL path = loader.getResource("com/yeep/study/swing/component/resources/close-btn.jpg");
		// URL path = this.getClass().getResource("resources/sun.gif");
		
		ImageIcon icon = new ImageIcon(path);
		JLabel labelImage = new JLabel(icon);

		JPanel labelImagePanel = new JPanel();
		labelImagePanel.add(labelImage);
		mainPanel.add(labelImagePanel);

		/**************************** 3.Icon *********************************/
		JLabel iconSample = new JLabel("Round!", new MyIcon(20, 20),
				SwingConstants.CENTER);

		JPanel iconSamplePanel = new JPanel();
		iconSamplePanel.add(iconSample);
		mainPanel.add(iconSamplePanel);

		// Set panel properties
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		mainFrame.setContentPane(mainPanel);
		mainFrame.setSize(200, 200);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	/**
	 * Customize Icon
	 */
	class MyIcon implements Icon
	{
		private int width, height;

		public MyIcon(int w, int h)
		{
			width = w;
			height = h;
		}

		public void paintIcon(Component c, Graphics g, int x, int y)
		{
			g.drawOval(x, y, width - 1, height - 1);
		}

		public int getIconWidth()
		{
			return width;
		}

		public int getIconHeight()
		{
			return height;
		}
	}
}
