package com.yeep.gwt.app.shudu.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.yeep.app.shudu.Constants;
import com.yeep.app.shudu.model.Board;
import com.yeep.app.shudu.model.Node;
import com.yeep.app.shudu.service.ShuduService;
import com.yeep.gwt.app.shudu.client.BoardDTO;
import com.yeep.gwt.app.shudu.client.NodeDTO;
import com.yeep.gwt.app.shudu.client.ShuduServiceGWT;

public class ShuduServiceGWTImpl extends RemoteServiceServlet implements
		ShuduServiceGWT
{
	private ShuduService shuduService;
 
	// Constructor 

	public ShuduServiceGWTImpl(ShuduService shuduService)
	{
		this.shuduService = shuduService;
	}

	// Public Methods

	/**
	 * @see com.study.gwt.shudu.client.ShuduServiceGWT#getBoard()
	 */
	public BoardDTO getBoard()
	{
		Board model = this.shuduService.getBoard(Constants.LEVEL_ONE);
		return fromModel(model);
	}

	/**
	 * @see com.study.gwt.shudu.client.ShuduServiceGWT#calculate()
	 */
	public BoardDTO calculate(BoardDTO boardDTO)
	{
		Board model = this.shuduService.calculate(fromDTO(boardDTO));
		return fromModel(model);
	}

	/**
	 * Mapping Board DTO from Board Object
	 * 
	 * @param model
	 * @return
	 */
	private BoardDTO fromModel(Board board)
	{
		if (board == null)
			return null;

		BoardDTO boardDTO = new BoardDTO();
		for (int rowIndex = 0; rowIndex < board.nodes.length; rowIndex++)
		{
			Node[] row = board.nodes[rowIndex];
			for (int colIndex = 0; colIndex < row.length; colIndex++)
			{
				Node node = row[colIndex];
				boardDTO.nodes[rowIndex][colIndex] = fromModel(node);
			}
		}
		return boardDTO;
	}

	/**
	 * Mapping Node DTO from Node Object
	 * 
	 * @param node
	 * @return
	 */
	private NodeDTO fromModel(Node node)
	{
		if (node == null)
			return null;

		NodeDTO nodeDTO = new NodeDTO(node.getRowIndex(), node.getColumnIndex(),
				node.getValue());
		nodeDTO.setFromMap(node.isFromMap());
		nodeDTO.setUltimate(node.isUltimate());

		return nodeDTO;
	}

	/**
	 * Mapping Board Object from Board DTO
	 * 
	 * @param boardDTO
	 * @return
	 */
	private Board fromDTO(BoardDTO boardDTO)
	{
		if (boardDTO == null)
			return null;

		Node[][] nodes = new Node[9][9];
		for (int rowIndex = 0; rowIndex < boardDTO.nodes.length; rowIndex++)
		{
			NodeDTO[] row = boardDTO.nodes[rowIndex];
			for (int colIndex = 0; colIndex < row.length; colIndex++)
			{
				NodeDTO nodeDTO = row[colIndex];
				nodes[rowIndex][colIndex] = fromDTO(nodeDTO);
			}
		}
		Board board = new Board(nodes);

		return board;
	}

	/**
	 * Mapping Node Object from Node DTO
	 * 
	 * @param node
	 * @return
	 */
	private Node fromDTO(NodeDTO nodeDTO)
	{
		if (nodeDTO == null)
			return null;

		Node node = new Node(nodeDTO.getRowIndex(), nodeDTO.getColumnIndex(),
				nodeDTO.getValue(), nodeDTO.isFromMap());

		return node;
	}
}