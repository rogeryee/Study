package com.yeep.study.struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * This is a test class of DispatchAction
 * 
 * @author Roger.Yee
 */
public class StrutsAjaxSampleAction extends StrutsAjaxBaseAction
{
	Logger logger = Logger.getLogger(this.getClass());

	public ActionForward searchPosition(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		String department = request.getParameter("department");

		if (department != null && !"".equals(department))
		{
			if ("Manager".equals(department))
			{
				this
						.renderHtml(
								response,
								"<select id='position'><option value='gm'>General Manager</option><option value='vgm'>Vice of General Manager</option></select>");
			}

			if ("Developer".equals(department))
			{
				this
						.renderHtml(
								response,
								"<select id='position'><option value='sse'>Systems Engineer</option><option value='soe'>Software Engineer</option></select>");
			}
		}

		return null;
	}
}
