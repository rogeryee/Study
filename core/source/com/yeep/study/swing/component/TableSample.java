package com.yeep.study.swing.component;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class TableSample
{
	public static void main(String[] args)
	{
		TableSample sample = new TableSample();
		sample.init();
	}

	/**
	 * initialize the sample
	 */
	public void init()
	{
		simpleTableSample();
		tableSampleWithColumnModel();
	}

	/**
	 * Simple Table Sample
	 */
	private void simpleTableSample()
	{
		String title[] = new String[]
		{ "ID?", "NAME", "GENDER" };
		Object[][] data = new String[][]
		{
		{ "001", "Roger", "male" },
		{ "002", "Phoebe", "female" },
		{ "003", "Adams", "male" } };

		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTable table = new JTable(data, title);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setColumnSelectionAllowed(true);

		JScrollPane scrollPanel = new JScrollPane(table);
		frame.getContentPane().add(scrollPanel, BorderLayout.CENTER);

		frame.setVisible(true);
	}

	private void tableSampleWithColumnModel()
	{
		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultTableModel dtm = new DefaultTableModel(new String[][]
		{
		{ "7", "2", "7" },
		{ "4", "5", "6" } }, new String[]
		{ "Names", "In", "Order" });
		SortingColumnModel scm = new SortingColumnModel();

		JTable table = new JTable(dtm, scm);
		table.createDefaultColumnsFromModel();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setColumnSelectionAllowed(true);

		JScrollPane scrollPanel = new JScrollPane(table);
		frame.getContentPane().add(scrollPanel, BorderLayout.CENTER);

		frame.setVisible(true);
	}
}

class SortingColumnModel extends DefaultTableColumnModel
{
	public void addColumn(TableColumn tc)
	{
		super.addColumn(tc);
		int newIndex = sortedIndexOf(tc);
		if (newIndex != tc.getModelIndex())
		{
			moveColumn(tc.getModelIndex(), newIndex);
		}
	}

	protected int sortedIndexOf(TableColumn tc)
	{
		// Just do a linear search for now.
		int stop = getColumnCount();
		String name = tc.getHeaderValue().toString();

		for (int i = 0; i < stop; i++)
		{
			if (name.compareTo(getColumn(i).getHeaderValue().toString()) <= 0)
			{
				return i;
			}
		}
		return stop;
	}
}
