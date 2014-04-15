package com.yeep.app.shudu.model;

import com.yeep.app.shudu.Constants;

/**
 * Bar Object contains an array of Nodes
 */
public class Bar
{
	public Node[] nodes = new Node[Constants.MAX_VALUE];
	
	/**
	 * Validate the Bar by the specific node. If the value of the node is
	 * conflicted with others, then return false. Otherwise return true. If the
	 * node is null or the value of the node equals to 0, return true.
	 */
	public boolean validateNode(Node node)
	{
		if (node == null)
			return true;
		
		int valueToCheck = node.getValue();
		
		if (valueToCheck == Constants.INVALID_VALUE)
			return true;
		
		for(Node nodeToCheck:nodes)
		{
			// If valueToCheck == nodeToCheck's value, 
			// it means these two nodes are conflicted.
			if (node!=nodeToCheck && node.getValue() == nodeToCheck.getValue())
				return false;
		}
	
		return true;
	}
}
