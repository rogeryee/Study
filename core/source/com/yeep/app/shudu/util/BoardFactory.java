package com.yeep.app.shudu.util;

import com.yeep.app.shudu.Constants;
import com.yeep.app.shudu.model.Board;

/**
 * Factory for creating Board
 */
public class BoardFactory
{
	/**
	 * Create a Board according to the specific map
	 * 
	 * @param level
	 *          the specific difficult level
	 * @return
	 */
	public static Board createBoard(int level)
	{
		return new Board(getBoardData(level));
	}

	/**
	 * Get data of board according to the specific level
	 * 
	 * @param level
	 * @return
	 */
	private static int[][] getBoardData(int level)
	{
		switch (level)
		{
			case Constants.LEVEL_ONE:
				return new int[][]
				{
				{ 0, 1, 0, 0, 0, 0, 0, 7, 0 },
				{ 0, 6, 0, 0, 0, 0, 0, 9, 0 },
				{ 0, 0, 8, 2, 0, 9, 4, 0, 0 },
				{ 4, 9, 0, 0, 0, 0, 0, 6, 8 },
				{ 0, 0, 0, 4, 0, 5, 0, 0, 0 },
				{ 0, 0, 3, 0, 0, 0, 7, 0, 0 },
				{ 0, 0, 9, 7, 0, 6, 5, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 7, 4, 0, 0, 0, 0, 0, 1, 2 } };
			default:
				return new int[][]
				{
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		}
	}
}
