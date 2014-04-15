package com.yeep.study.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Login Action 
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport
{
	private String username;
	private String password;

	/** Getters and Setters **/
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

	public String login() throws Exception
	{
		username = getUsername();
		password = getPassword();

		try
		{
			if (username != null && !username.equals("") && password != null && !password.equals(""))
			{
				ActionContext.getContext().getSession().put("user", getUsername());
				return forwardSuccess();
			}
			else
			{
				return forwardInput();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return forwardInput();
	}

	private String forwardSuccess()
	{
		return SUCCESS;
	}

	private String forwardInput()
	{
		return INPUT;
	}

	/**
	 * Validate fields inputed by user
	 */
	public void validate()
	{
		if (getUsername() == null || getUsername().trim().equals(""))
		{
			addFieldError("username", getText("user.required"));
		}
		if (getPassword() == null || getPassword().trim().equals(""))
		{
			addFieldError("password", getText("pass.required"));
		}
	}

}
