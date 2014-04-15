package com.yeep.gwt.app.shudu.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry Point for Shudu
 */
public class Shudu implements EntryPoint, ClickListener
{
	private final ShuduServiceGWTAsync shuduRPC;
	private BoardDTO boardDTO = new BoardDTO();

	private Panel mainPanel;
	private FlexTable table;
	private Button calculateBtn;
	private Button mapBtn;

	// Constructor
	public Shudu()
	{
		this.shuduRPC = createRPC();
	}

	// Load Module
	public void onModuleLoad()
	{
		this.mainPanel = new VerticalPanel();

		this.table = new FlexTable();
		this.mainPanel.add(this.table);
		this.mainPanel.add(buildButtonPanel());

		buildTable(this.table, this.boardDTO);

		RootPanel.get().add(this.mainPanel);
	}

	/**
	 * Build the table panel from the board
	 * 
	 * @param boardDTO
	 * @return
	 */
	private void buildTable(FlexTable table, BoardDTO boardDTO)
	{
		if (table == null)
			table = new FlexTable();
		table.setBorderWidth(1);

		for (int rowIndex = 0; rowIndex < boardDTO.nodes.length; rowIndex++)
		{
			NodeDTO[] row = boardDTO.nodes[rowIndex];
			for (int colIndex = 0; colIndex < row.length; colIndex++)
			{
				NodeDTO nodeDTO = row[colIndex];
				if (nodeDTO.getValue() == 0)
				{
					TextBox tb = new TextBox();
					tb.setSize("20", "20");
					table.setWidget(rowIndex, colIndex, tb);
				}
				else
				{
					Label label = new Label(String.valueOf(nodeDTO.getValue()));
					table.setWidget(rowIndex, colIndex, label);

					String styleName = nodeDTO.isFromMap() ? "value-fixed"
							: "value-userinput";
					table.getFlexCellFormatter().addStyleName(rowIndex, colIndex,
							styleName);
				}

				// Set style of node
				table.getFlexCellFormatter().setAlignment(rowIndex, colIndex,
						HasHorizontalAlignment.ALIGN_CENTER,
						HasVerticalAlignment.ALIGN_MIDDLE);
				table.getFlexCellFormatter().setWidth(rowIndex, colIndex, "50");
				table.getFlexCellFormatter().setHeight(rowIndex, colIndex, "50");
			}
		}
	}

	/**
	 * Build the button panel
	 * 
	 * @return
	 */
	public Panel buildButtonPanel()
	{
		HorizontalPanel buttonPanel = new HorizontalPanel();

		// Calculate button
		this.calculateBtn = new Button("Calculate");
		this.calculateBtn.addClickListener(this);
		buttonPanel.add(this.calculateBtn);

		// Get Map button
		this.mapBtn = new Button("New Map");
		this.mapBtn.addClickListener(this);
		buttonPanel.add(this.mapBtn);

		for (int i = 0; i < 9; i++)
		{
			final int label = i + 1;

			RadioButton rb = new RadioButton("selectNumber", String.valueOf(label));
			rb.addClickListener(new ClickListener()
			{
				public void onClick(Widget sender)
				{
					boolean checked = ((RadioButton) sender).isChecked();
					if (checked)
						selectValue(label, true);
					else
						selectValue(label, false);
				}
			});

			buttonPanel.add(rb);
		}

		RadioButton rb = new RadioButton("selectNumber", String.valueOf("X"));
		rb.addClickListener(new ClickListener()
		{
			public void onClick(Widget sender)
			{
				boolean checked = ((RadioButton) sender).isChecked();
				if (checked)
					selectValue(-1, true);
				else
					selectValue(-1, false);
			}
		});
		buttonPanel.add(rb);

		return buttonPanel;
	}

	/**
	 * Select or un-Select the grids which equals the specific value
	 */
	private void selectValue(int selectValue, boolean isSelected)
	{
		if (this.table == null)
			return;

		for (int rowIndex = 0; rowIndex < boardDTO.nodes.length; rowIndex++)
		{
			NodeDTO[] row = this.boardDTO.nodes[rowIndex];
			for (int colIndex = 0; colIndex < row.length; colIndex++)
			{
				if (row[colIndex].getValue() == selectValue && isSelected)
				{
					table.getFlexCellFormatter().addStyleName(rowIndex, colIndex,
							"value-selected");
				}
				else
					table.getFlexCellFormatter().removeStyleName(rowIndex, colIndex,
							"value-selected");
			}
		}
	}

	/**
	 * Clean the content of table
	 */
	private void cleanTable()
	{
		if (this.table != null)
		{
			while (this.table.getRowCount() > 0)
			{
				this.table.removeRow(this.table.getRowCount() - 1);
			}
		}
	}

	/**
	 * @see com.google.gwt.user.client.ui.ClickListener#onClick(Widget)
	 */
	public void onClick(Widget sender)
	{
		if (sender == null)
			return;

		if (sender == this.calculateBtn)
		{
			calculateBoard();
		}
		else if (sender == this.mapBtn)
		{
			getMap();
		}
	}

	/**
	 * Calculate the board
	 */
	private void calculateBoard()
	{
		AsyncCallback callback = new AsyncCallback()
		{
			public void onFailure(Throwable caught)
			{
				Window.alert("Error!");
			}

			public void onSuccess(Object result)
			{
				boardDTO = (BoardDTO) result;
				cleanTable();
				buildTable(table, boardDTO);
			}
		};

		setBoardFromTable();
		this.shuduRPC.calculate(this.boardDTO, callback);
	}

	/**
	 * Get the map
	 */
	private void getMap()
	{
		AsyncCallback callback = new AsyncCallback()
		{
			public void onFailure(Throwable caught)
			{
				Window.alert("Error!");
			}

			public void onSuccess(Object result)
			{
				boardDTO = (BoardDTO) result;
				cleanTable();
				buildTable(table, boardDTO);
			}
		};

		this.shuduRPC.getBoard(callback);
	}

	/**
	 * Set values to dto from table
	 */
	private void setBoardFromTable()
	{
		if (this.table == null || this.boardDTO == null)
			return;

		for (int rowIndex = 0; rowIndex < this.boardDTO.nodes.length; rowIndex++)
		{
			NodeDTO[] row = this.boardDTO.nodes[rowIndex];
			for (int colIndex = 0; colIndex < row.length; colIndex++)
			{
				Widget widget = this.table.getWidget(rowIndex, colIndex);

				if (widget instanceof TextBox)
				{
					TextBox tb = (TextBox) widget;
					if (tb.getText() != null && !"".equals(tb.getText()))
						this.boardDTO.nodes[rowIndex][colIndex].setValue(Integer
								.parseInt(tb.getText()));
				}
			}
		}
	}

	/**
	 * Create RPC call for ShuduService
	 * 
	 * @return
	 */
	private ShuduServiceGWTAsync createRPC()
	{
		ShuduServiceGWTAsync ret = (ShuduServiceGWTAsync) GWT
				.create(ShuduServiceGWT.class);
		((ServiceDefTarget) ret).setServiceEntryPoint(GWT.getModuleBaseURL()
				+ ShuduServiceGWT.URL);
		return ret;
	}
}
