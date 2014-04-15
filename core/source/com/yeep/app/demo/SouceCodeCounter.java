package com.yeep.app.demo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import com.yeep.basis.swing.widget.table.TableWidget;
import com.yeep.basis.swing.widget.table.TableWidgetModel;
@SuppressWarnings("serial")
public class SouceCodeCounter extends JFrame
{
	private JButton fileButton;
	private JButton runButton;
	private JFileChooser fileChooser;
	private TableWidget<Result> resultTable;
	private String path;
	private Result totalResult;

	public SouceCodeCounter()
	{
		super();
		loadUI();
	}

	private void loadUI()
	{
		initWidgets();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		BorderLayout layout = new BorderLayout();
		mainPanel.setLayout(layout);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(this.fileButton);
		buttonPanel.add(this.runButton);

		mainPanel.add(buttonPanel, BorderLayout.NORTH);
		mainPanel.add(new JScrollPane(this.resultTable), BorderLayout.CENTER);

		getContentPane().add(mainPanel);

		setSize(500, 200);
		setVisible(true);
	}

	private void initWidgets()
	{
		// "Choose" button
		this.fileButton = new JButton("Choose folder");
		this.fileButton.setSize(50, 20);

		// File Chooser
		this.fileChooser = new JFileChooser();
		this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				SouceCodeCounter scc = SouceCodeCounter.this;
				if (scc.fileChooser != null
						&& scc.fileChooser.showOpenDialog(scc) == JFileChooser.APPROVE_OPTION)
				{
					scc.path = scc.fileChooser.getSelectedFile().getPath();
				}
			}
		});

		// "Run" button
		this.runButton = new JButton("Run");
		this.runButton.setSize(50, 20);
		this.runButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (SouceCodeCounter.this.path != null)
				{
					File f = new File(SouceCodeCounter.this.path);
					CodeCounter counter = new CodeCounter(f);
					displayResult(counter.start());
				}
			}
		});

		this.resultTable = new TableWidget<Result>();
	}

	private void displayResult(List<Result> results)
	{
		long size = results == null ? 0 : results.size();
		String totalName = "Total Result(" + size + " files)";
		this.totalResult = new Result(totalName);
		for (Result result : results)
		{
			this.totalResult.addCodeLine(result.getNumberOfCodeLines());
			this.totalResult.addCommentLine(result.getNumberOfCommentLines());
			this.totalResult.addEmptyLine(result.getNumberOfEmptyLines());
		}
		results.add(0, this.totalResult);

		renderDetailResult(results);
	}

	private void renderDetailResult(List<Result> results)
	{
		TableWidgetModel<Result> listModel = new TableWidgetModel<Result>(
				results, new String[] { "Name", "Code line", "Comment Line",
						"BLank Line" }, new String[] { "name",
						"numberOfCodeLines", "numberOfCommentLines",
						"numberOfEmptyLines" });
		this.resultTable.setListModel(listModel);
	}

	public static void main(String[] args)
	{
		try
		{
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					new SouceCodeCounter();
				}
			});
		}
		catch (Exception e)
		{
		}

	}
}

class CodeCounter
{
	private File file;
	private List<Result> results = new ArrayList<Result>();

	public CodeCounter(File file)
	{
		this.file = file;
	}

	public List<Result> start()
	{
		return process(this.file);
	}

	private List<Result> process(File f)
	{
		File[] childs = f.listFiles();

		for (int i = 0; i < childs.length; i++)
		{
			if (!childs[i].isDirectory())
			{
				if (childs[i].getName().matches(".*\\.java$"))
				{
					results.add(processOneFile(childs[i]));
				}
			}
			else
			{
				process(childs[i]);

			}
		}

		return results;
	}

	@SuppressWarnings("finally")
	private Result processOneFile(File file)
	{
		BufferedReader br = null;
		String line = "";
		boolean isComment = false;
		Result result = new Result(file.getName());

		try
		{
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null)
			{
				line = line.trim();
				if (line.matches("^[\\s&&[^\\n]]*$"))
				{
					result.addEmptyLine(1);
				}
				else if (line.startsWith("/*") && !line.endsWith("*/"))
				{
					result.addCommentLine(1);
					isComment = true;
				}
				else if (isComment)
				{
					result.addCommentLine(1);
					if (line.endsWith("*/"))
					{
						isComment = false;
					}
				}
				else if (line.startsWith("//"))
				{
					result.addCommentLine(1);
				}
				else
				{
					result.addCodeLine(1);
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();
					br = null;
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			return result;
		}
	}
}

class Result
{
	private String name;
	private long numberOfCodeLines = 0;
	private long numberOfCommentLines = 0;
	private long numberOfEmptyLines = 0;

	// Constructor
	public Result(String name)
	{
		this.name = name;
	}

	// Getters and Setters
	public long getNumberOfCodeLines()
	{
		return numberOfCodeLines;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public long getNumberOfCommentLines()
	{
		return numberOfCommentLines;
	}

	public long getNumberOfEmptyLines()
	{
		return numberOfEmptyLines;
	}

	// Methods
	public void addCodeLine(long increasement)
	{
		this.numberOfCodeLines += increasement;
	}

	public void addEmptyLine(long increasement)
	{
		this.numberOfEmptyLines += increasement;
	}

	public void addCommentLine(long increasement)
	{
		this.numberOfCommentLines += increasement;
	}
}
