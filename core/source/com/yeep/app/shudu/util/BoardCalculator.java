package com.yeep.app.shudu.util;

import java.util.ArrayList;

import com.yeep.app.shudu.Constants;
import com.yeep.app.shudu.model.Board;
import com.yeep.app.shudu.model.Node;

/**
 * The Calculate class for Board
 */
public class BoardCalculator
{
	private Board board;
	private int currentRowIndex; // the row index of the current processing node
	private int currentColumnIndex; // the column index of the current processing node

	/**
	 * Calculate the Board
	 * 
	 * @param board
	 * @return
	 */
	public Board calculate(Board board)
	{
		long startTime = System.currentTimeMillis();
		this.board = board;

		// Loop for every node of the board
		for (int rowIndex = 0; rowIndex < this.board.nodes.length; rowIndex++)
		{
			Node[] row = this.board.nodes[rowIndex];

			for (int colIndex = 0; colIndex < row.length; colIndex++)
			{
				Node node = row[colIndex];

				if (!node.isUltimate())
				{
					node.setTempPotentialValues(new ArrayList<Integer>(node
							.getPotentialValues()));
					processNode(node);
				}
				node.setUltimate(true);
				node.setPotentialValues(new ArrayList<Integer>());
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Spend time = " + (endTime - startTime) + " ms ");

		return board;
	}

	/**
	 * Process the node, and loop for the nodes next to it.
	 * 
	 * @param currentNode
	 */
	private void processNode(Node currentNode)
	{
		this.currentRowIndex = currentNode.getRowIndex();
		this.currentColumnIndex = currentNode.getColumnIndex();

		// find the acceptable value of potential values for the node
		boolean findCorrectValue = false;
		while (currentNode.getTempPotentialValues() != null
				&& !currentNode.getTempPotentialValues().isEmpty())
		{
			currentNode.setValue(currentNode.getTempPotentialValues().get(0));
			currentNode.getTempPotentialValues().remove(0);

			// if the value is found then break this loop, and to process next node
			if (currentNode.validate())
			{
				findCorrectValue = true;
				break;
			}
		}

		// if the value is not exist, then return to process the previous node
		if (!findCorrectValue)
		{
			// reset the value for current node
			currentNode.setValue(Constants.INVALID_VALUE);

			Node previousNode = getPreviousNode();
			if (previousNode == null)
				return;

			if (currentNode != previousNode)
				currentNode.setTempPotentialValues(new ArrayList<Integer>(currentNode
						.getPotentialValues()));
			processNode(previousNode);
		}

		// Process the next node
		Node nextNode = getNextNode();
		if (nextNode == null)
			return;

		nextNode.setTempPotentialValues(new ArrayList<Integer>(nextNode
				.getPotentialValues()));
		processNode(nextNode);
	}

	/**
	 * Get the next non-ultimate node to be processed
	 * <p>
	 * if row or column is out of index then return null
	 * 
	 * @return
	 */
	private Node getNextNode()
	{
		Node node = null;

		do
		{
			if (this.currentColumnIndex == Constants.MAX_VALUE - 1)
			{
				this.currentRowIndex++;
				this.currentColumnIndex = 0;
			}
			else
				this.currentColumnIndex++;

			if (this.currentRowIndex > 8 || this.currentColumnIndex > 8)
				return null;

			node = this.board.nodes[this.currentRowIndex][currentColumnIndex];
		}
		while (node != null && node.isUltimate());

		return node;
	}

	/**
	 * Get the previous non-ultimate node to be processed
	 * <p>
	 * if row or column is out of index then return null
	 * 
	 * @return
	 */
	private Node getPreviousNode()
	{
		Node node = null;

		do
		{
			if (this.currentColumnIndex == 0)
			{
				this.currentRowIndex--;
				this.currentColumnIndex = 8;
			}
			else
				this.currentColumnIndex--;

			if (this.currentRowIndex < 0 || this.currentColumnIndex < 0)
				return null;

			node = this.board.nodes[this.currentRowIndex][currentColumnIndex];
		}
		while (node != null && node.isUltimate());

		return node;
	}
}
