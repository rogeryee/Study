package com.yeep.app.shudu.service;

import com.yeep.app.shudu.model.Board;
import com.yeep.app.shudu.util.BoardCalculator;
import com.yeep.app.shudu.util.BoardFactory;

/**
 * Implementation Class for ShuduService Interface
 */
public class ShuduServiceImpl implements ShuduService
{
	/**
	 * @see com.study.demo.shudu.service.ShuduService#getBoard()
	 */
	public Board getBoard(int level)
	{
		return BoardFactory.createBoard(level);
	}

	public Board calculate(Board board)
	{
		BoardCalculator calculator = new BoardCalculator();
		return calculator.calculate(board);
	}
}
