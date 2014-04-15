package com.yeep.study.struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * This is a test class of DispatchAction
 * 
 * @author Roger.Yee
 */
public class DispatchActionTestAction extends DispatchAction
{
	Logger logger = Logger.getLogger(this.getClass());

	public ActionForward method1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		request.setAttribute("actionName", "method1");
		logger.info("logger info in method1");
		return mapping.findForward("test");
	}

	public ActionForward method2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		request.setAttribute("actionName", "method2");
		logger.info("logger info in method2");
		return mapping.findForward("test");
	}

	/**
	 * Use the method If we do not specify the name of the method parameter
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		request.setAttribute("actionName", "unspecified");
		logger.info("logger info in unspecified");
		return mapping.findForward("test");
	}

}
