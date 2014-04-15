package com.yeep.gwt.app.shudu.client;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Proxy Interface for ShuduService in GWT side
 */
public interface ShuduServiceGWT extends RemoteService
{
  public static final String URL = "shuduRPC.rpc";

  /**
   * Get Board from Service 
   * @return
   */
  public BoardDTO getBoard();

  /**
   * Calculate the Board
   * @return
   */
  public BoardDTO calculate(BoardDTO boardDTO);
}
