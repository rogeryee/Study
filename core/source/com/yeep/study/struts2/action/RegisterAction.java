package com.yeep.study.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
/**
 * Use validate() and validateXXX() to verify the input value.
 */
public class RegisterAction extends ActionSupport
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
		System.out.println("[RegisterAction] execute()....");
		FORWARD = "success";
		return FORWARD;
	}

	@Override
	public void validate()
	{
		System.out.println("[RegisterAction] validate()....");
		if (getUsername() == null || getUsername().trim().equals(""))
		{
			addFieldError("username", getText("register.username.required"));
		}

		if (getPassword() == null || getPassword().trim().equals(""))
		{
			addFieldError("password", getText("register.password.required"));
		}
	}

	public String Register() throws Exception
	{
		System.out.println("[RegisterAction] Register()....");
		FORWARD = "success";
		return FORWARD;
	}

	public void validateRegister()
	{
		System.out.println("[RegisterAction] validateRegister()....");
		if (getUsername() == null || getUsername().trim().equals(""))
		{
			addFieldError("username", getText("register.username.required"));
		}

		if (getPassword() == null || getPassword().trim().equals(""))
		{
			addFieldError("password", getText("register.password.required"));
		}
	}
}
