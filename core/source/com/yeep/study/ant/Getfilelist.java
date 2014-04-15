package com.yeep.study.ant;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class Getfilelist extends Task
{
	private String filename;
	private String property;

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getProperty()
	{
		return property;
	}

	public void setProperty(String property)
	{
		this.property = property;
	}

	@Override
	public void execute() throws BuildException
	{
		String ret = "";
		BufferedReader br;
		try
		{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(getFilename()),Charset.forName("GBK")));
			String row;
			while ((row = br.readLine()) != null)
			{
				if (row == null || "".equals(row.trim()))
					continue;

				int index = row.indexOf("=");
				ret = ret + "," + row.substring(0, index);
			}

			if (ret.length() > 0)
				ret = ret.substring(1, ret.length());
			getProject().setNewProperty(getProperty(), ret);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
