package com.yeep.study.struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 * A test action for DynaActionForm
 * 
 * @author Roger.Yee
 */
public class DynaFormTestAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		// create dynaForm
		DynaActionForm dynaform = (DynaActionForm) form;

		// use "get" method to get the value of property
		String msg = "The property get from dynaform:userName=["
				+ dynaform.get("userName") + "],password=[" + dynaform.get("password")
				+ "]";

		request.setAttribute("msg", msg);

		return mapping.findForward("test");
	}
}
