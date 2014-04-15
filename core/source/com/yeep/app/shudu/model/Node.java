package com.yeep.app.shudu.model;

import java.util.ArrayList;
import java.util.List;

import com.yeep.app.shudu.Constants;

/**
 * Node Object
 */
public class Node
{
	private int value;
	private int rowIndex;
	private int columnIndex;
	private boolean fromMap = true;
	private boolean ultimate = false;

	private List<Integer> potentialValues = new ArrayList<Integer>();
	private List<Integer> tempPotentialValues = new ArrayList<Integer>();

	private Bar row; // which row the node belongs to
	private Bar column; // which column the node belongs to
	private Bar grid; // which grid the node belongs to

	// Constructor

	/**
	 * Create a node
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @param value
	 */
	public Node(int rowIndex, int columnIndex, int value, boolean fromMap)
	{
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.value = value;
		this.fromMap = fromMap;

		if (this.value != Constants.INVALID_VALUE)
			this.ultimate = true;

		initPotentialValues();
	}

	// Public Methods

	/**
	 * Validate the value of this node for each bar(row, column and grid). If it
	 * can pass all the bars, then return true, otherwise return false.
	 */
	public boolean validate()
	{
		return this.row.validateNode(this) && this.column.validateNode(this)
				&& this.grid.validateNode(this);
	}

	// Private Methods

	/**
	 * initialize the potential values from 1 to 9
	 */
	private void initPotentialValues()
	{
		if (this.value != Constants.INVALID_VALUE)
			return;

		int tvalue = 1;
		while (this.potentialValues.size() < Constants.MAX_VALUE)
		{
			this.potentialValues.add(tvalue++);
		}
	}

	// Getters and Setters
	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public int getRowIndex()
	{
		return rowIndex;
	}

	public void setRowIndex(int rowIndex)
	{
		this.rowIndex = rowIndex;
	}

	public int getColumnIndex()
	{
		return columnIndex;
	}

	public void setColumnIndex(int columnIndex)
	{
		this.columnIndex = columnIndex;
	}

	public boolean isFromMap()
	{
		return fromMap;
	}

	public void setFromMap(boolean fromMap)
	{
		this.fromMap = fromMap;
	}

	public boolean isUltimate()
	{
		return ultimate;
	}

	public void setUltimate(boolean ultimate)
	{
		this.ultimate = ultimate;
	}

	public List<Integer> getPotentialValues()
	{
		return potentialValues;
	}

	public void setPotentialValues(List<Integer> potentialValues)
	{
		this.potentialValues = potentialValues;
	}

	public Bar getRow()
	{
		return row;
	}

	public void setRow(Bar row)
	{
		this.row = row;
	}

	public Bar getColumn()
	{
		return column;
	}

	public void setColumn(Bar column)
	{
		this.column = column;
	}

	public Bar getGrid()
	{
		return grid;
	}

	public void setGrid(Bar grid)
	{
		this.grid = grid;
	}

	public List<Integer> getTempPotentialValues()
	{
		return tempPotentialValues;
	}

	public void setTempPotentialValues(List<Integer> tempPotentialValues)
	{
		this.tempPotentialValues = tempPotentialValues;
	}

}
