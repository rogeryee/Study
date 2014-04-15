package com.yeep.study.swing.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DialogSample
{
	public static void main(String[] args)
	{
		DialogSample sample = new DialogSample();
		sample.init();
	}

	/**
	 * initialize the sample
	 */
	public void init()
	{
		JFrame mainFrame = new JFrame();

		/****************** 1.JDialog without using JOptionPane ********************/
		this.showSimpleDialog(mainFrame);
		
		/****************** 2.JDialog using JOptionPane ********************/
		this.showSimpleDialogWithJOptionPane(mainFrame);
	}

	/**
	 * JDialog without using JOptionPane
	 * @param frame
	 */
	public void showSimpleDialog(JFrame frame)
	{
		final JDialog dialog = new JDialog(frame, "Click OK", true);
		dialog.setSize(200, 150);

		JLabel label = new JLabel("Click OK after you read this", JLabel.CENTER);
		dialog.getContentPane().setLayout(new BorderLayout());
		dialog.getContentPane().add(label, BorderLayout.CENTER);
		JButton btn = new JButton("OK");
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		JPanel p = new JPanel(); // Flow layout will center button.
		p.add(btn);
		dialog.getContentPane().add(p, BorderLayout.SOUTH);
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
	}

	/**
	 * JDialog without using JOptionPane
	 * @param frame
	 */
	public void showSimpleDialogWithJOptionPane(JFrame frame)
	{
		// Constructor : public JOptionPane(Object message, int messageType, int optionType, Icon icon, Object[] options, Object initialValue) 
		JOptionPane.showMessageDialog(frame, "Click OK after you read this",
				"Click OK", JOptionPane.INFORMATION_MESSAGE);
		
		// Input dialog (JList)
		JOptionPane.showInputDialog(frame, "Please choose a name", "Example 1",
			  JOptionPane.QUESTION_MESSAGE, null, new Object[] {
			    "Amanda", "Colin", "Don", "Fred", "Gordon", "Janet", "Jay", "Joe",
			    "Judie", "Kerstin", "Lotus", "Maciek", "Mark", "Mike", "Mulhern",
			    "Oliver", "Peter", "Quaxo", "Rita", "Sandro", "Tim", "Will"}, "Joe");
		
		//Input dialog (JTextField)
		JOptionPane.showInputDialog(null, "Please enter your name", "Example 2",
			  JOptionPane.QUESTION_MESSAGE, null, null, "Shannon");
		
		//Confirm dialog
		JOptionPane.showConfirmDialog(null, "Are you sure?", "Example 4",
			  JOptionPane.YES_NO_CANCEL_OPTION);
	}
}
