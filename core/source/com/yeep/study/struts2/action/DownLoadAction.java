package com.yeep.study.struts2.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DownLoadAction extends ActionSupport
{
	private final static String DOWNLOADFILEPATH = "/upload/";
	private String fileName;

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public InputStream getDownloadFile()
	{
		return ServletActionContext.getServletContext().getResourceAsStream(DOWNLOADFILEPATH + fileName);
	}

	public String getDownloadChineseFileName()
	{
		String downloadChineseFileName = fileName;

		try
		{
			downloadChineseFileName = new String(downloadChineseFileName.getBytes(), "ISO8859-1");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		return downloadChineseFileName;
	}

	public String execute()
	{
		return SUCCESS;
	}
}
