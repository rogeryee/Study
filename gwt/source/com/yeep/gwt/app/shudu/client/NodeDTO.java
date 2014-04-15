package com.yeep.gwt.app.shudu.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class NodeDTO implements IsSerializable
{
	private int value;
	private int rowIndex;
	private int columnIndex;
	private boolean fromMap = false;
	private boolean ultimate = false;
	
	// Constructor
	public NodeDTO()
	{
	}
	
	public NodeDTO(int rowIndex, int columnIndex, int value)
	{
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.value = value;
	}
	
	// Getter and Setter
	
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
}
