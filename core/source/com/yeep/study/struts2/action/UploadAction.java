package com.yeep.study.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UploadAction extends ActionSupport
{
	private final static String UPLOADDIR = "/upload";
	private List<File> file;
	private List<String> fileFileName;
	private List<String> fileContentType;

	public List<File> getFile()
	{
		return file;
	}

	public void setFile(List<File> file)
	{
		this.file = file;
	}

	public List<String> getFileFileName()
	{
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName)
	{
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType()
	{
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType)
	{
		this.fileContentType = fileContentType;
	}

	@Override
	public String execute() throws Exception
	{
		for (int i = 0; i < file.size(); i++)
		{
			uploadFile(i);
		}
		return "success";
	}

	private void uploadFile(int i) throws FileNotFoundException, IOException
	{
		try
		{
			InputStream in = new FileInputStream(file.get(i));
			String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);
			File uploadFile = new File(dir, this.getFileFileName().get(i));
			OutputStream out = new FileOutputStream(uploadFile);
			byte[] buffer = new byte[1024 * 1024];
			int length;
			while ((length = in.read(buffer)) > 0)
			{
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
		}
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
