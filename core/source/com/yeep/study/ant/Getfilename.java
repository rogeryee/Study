package com.yeep.study.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class Getfilename extends Task
{
	private String fileFullName;
	private String filename;
	private String ext;

	public String getExt()
	{
		return ext;
	}

	public void setExt(String ext)
	{
		this.ext = ext;
	}

	public String getFileFullName()
	{
		return fileFullName;
	}

	public void setFileFullName(String fileFullName)
	{
		this.fileFullName = fileFullName;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	@Override
	public void execute() throws BuildException
	{
		String fullname = getFileFullName();

		if (fullname == null || fullname.trim().equals(""))
			return;

		int beginIndex = fullname.lastIndexOf("\\");
		int endIndex = fullname.lastIndexOf(".");

		getProject().setNewProperty(getFilename(), fullname.substring(beginIndex + 1, endIndex));
		getProject().setNewProperty(getExt(), fullname.substring(endIndex+1));
	}
}
