package com.yeep.gwt.app.shudu.client;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * DTO for Board Object
 */
public class BoardDTO implements IsSerializable
{
	public NodeDTO[][] nodes = new NodeDTO[9][9];
	
	// Constructor
	
	public BoardDTO()
	{
		initializeNodes();
	}
	
	// Private Methods
	
	private void initializeNodes()
	{
		for (int rowIndex = 0; rowIndex < nodes.length; rowIndex++)
		{
			NodeDTO[] row = nodes[rowIndex];
			for (int columnIndex = 0; columnIndex < row.length; columnIndex++)
			{
				nodes[rowIndex][columnIndex] = new NodeDTO(rowIndex, columnIndex, 0);
			}
		}
	}
}
