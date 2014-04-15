package com.yeep.gwt.app.shudu.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by IntelliJ IDEA. User: Yiro Date: Sep 2, 2008 Time: 3:25:18 PM To change this template use File | Settings |
 * File Templates.
 */
public interface ShuduServiceGWTAsync
{
	/**
	 * Get Board from Service
	 * 
	 * @return
	 */
	void getBoard(AsyncCallback async);

	/**
	 * Calculate the Board
	 * 
	 * @return
	 */
	void calculate(BoardDTO boardDTO, AsyncCallback async);
}
