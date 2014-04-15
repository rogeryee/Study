package com.yeep.app.shudu.service;

import com.yeep.app.shudu.model.Board;

/**
 * Interface for Demo Shudu
 */
public interface ShuduService
{
	/**
	 * Get Board for specific level
	 * 
	 * @param level
	 * @return
	 */
	public Board getBoard(int level);

	/**
	 * Calculate the board
	 * 
	 * @param board
	 * @return
	 */
	public Board calculate(Board board);
}
