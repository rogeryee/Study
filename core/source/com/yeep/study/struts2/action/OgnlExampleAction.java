package com.yeep.study.struts2.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OgnlExampleAction extends ActionSupport
{
	private HttpServletRequest request;
	private HttpSession session;
	private List<Material> materials;

	public String execute() throws Exception
	{
		request = ServletActionContext.getRequest();
		session = request.getSession();

		request.setAttribute("materialName", "Product1");
		session.setAttribute("materialName", "Product2");

		materials = new ArrayList<Material>();
		materials.add(new Material("Product2", 100, 2000));
		materials.add(new Material("Product3", 20, 2900));
		materials.add(new Material("Product1", 56, 800));
		return SUCCESS;
	}

	//setter，getter
	public HttpServletRequest getRequest()
	{
		return request;
	}

	public void setRequest(HttpServletRequest request)
	{
		this.request = request;
	}
}

class Material
{
	private String materialName;
	private int mainbid;
	private int mount;

	// Constructor
	public Material(String materialName, int mainbid, int mount)
	{
		super();
		this.materialName = materialName;
		this.mainbid = mainbid;
		this.mount = mount;
	}

	// Getters and Setters
	public String getMaterialName()
	{
		return materialName;
	}

	public void setMaterialName(String materialName)
	{
		this.materialName = materialName;
	}
}
