package com.yeep.study.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
/**
 * Use Register2Action-validation.xml to verifty the input value
 */
public class Register2Action extends ActionSupport
{
	private static String FORWARD = null;

	private String username;
	private String password;

	// Getters and Setters
	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	/**
	 * Default method to be executed
	 */
	public String execute() throws Exception
	{
		System.out.println("[Register2Action] execute()....");
		FORWARD = "success";
		return FORWARD;
	}
}
