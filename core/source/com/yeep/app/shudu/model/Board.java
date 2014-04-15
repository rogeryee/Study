package com.yeep.app.shudu.model;

import com.yeep.app.shudu.Constants;

/**
 * Board Object contains an array of Nodes and three arrays for row, column and
 * grid
 */
public class Board
{
	public Node[][] nodes = new Node[Constants.MAX_VALUE][Constants.MAX_VALUE];

	private Bar[] rows = new Bar[Constants.MAX_VALUE];
	private Bar[] columns = new Bar[Constants.MAX_VALUE];
	private Bar[] grids = new Bar[Constants.MAX_VALUE];

	// Constructor

	public Board(int[][] data)
	{
		for (int rowIndex = 0; rowIndex < data.length; rowIndex++)
		{
			int[] row = data[rowIndex];
			for (int colIndex = 0; colIndex < row.length; colIndex++)
			{
				Node node = new Node(rowIndex, colIndex, row[colIndex],
						row[colIndex] != Constants.INVALID_VALUE);
				this.addNode(node);
			}
		}
		this.initBars();
	}

	public Board(Node[][] data)
	{
		for (int rowIndex = 0; rowIndex < data.length; rowIndex++)
		{
			Node[] row = data[rowIndex];
			for (int colIndex = 0; colIndex < row.length; colIndex++)
			{
				this.addNode(row[colIndex]);
			}
		}
		this.initBars();
	}

	// Private Methods

	/**
	 * Initialize the Bars (Grid, Row and Column)
	 * 
	 * @param board
	 */
	private void initBars()
	{
		for (int i = 0; i < Constants.MAX_VALUE; i++)
		{
			rows[i] = new Bar();
			columns[i] = new Bar();
			grids[i] = new Bar();
		}

		for (int rowIndex = 0; rowIndex < this.nodes.length; rowIndex++)
		{
			Node[] row = this.nodes[rowIndex];
			for (int colIndex = 0; colIndex < row.length; colIndex++)
			{
				Node node = row[colIndex];

				// Make Rows
				this.rows[rowIndex].nodes[colIndex] = node;
				node.setRow(this.rows[rowIndex]);

				// Make Columns
				this.columns[colIndex].nodes[rowIndex] = node;
				node.setColumn(this.columns[colIndex]);

				// Make Grid
				// the index of Grid Array
				int gridIndex = colIndex / 3 + (rowIndex / 3) * 3;

				// the index of nodes array of one grid object
				int gridNodeIndex = colIndex % 3 + (rowIndex % 3) * 3;
				this.grids[gridIndex].nodes[gridNodeIndex] = node;
				node.setGrid(this.grids[gridIndex]);
			}
		}
	}

	/**
	 * Add the Node to Board
	 */
	private void addNode(Node node)
	{
		if (node == null)
			return;
		this.nodes[node.getRowIndex()][node.getColumnIndex()] = node;
	}
}
