package com.yeep.study.struts1.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.actions.DispatchAction;

import com.yeep.util.GlobalConstants;

/**
 * This abstract class is the parent class of all the ajax action.
 * It inherits from DispatchAction and provide the method to render the text/html/xml for ajax.
 *
 * @author Roger.Yee
 */
public abstract class StrutsAjaxBaseAction extends DispatchAction
{
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * Set result to response writter using "text/plain;charset=UTF-8"
     *
     * @param response
     * @param text
     */
    public void renderText(HttpServletResponse response, String text)
    {
        renderResult(response, text, GlobalConstants.TEXT_PLAIN_CHARSET_UTF8);
    }

    /**
     * Set result to response writter using "text/html;charset=UTF-8"
     *
     * @param response
     * @param text
     */
    public void renderHtml(HttpServletResponse response, String text)
    {
        renderResult(response, text, GlobalConstants.TEXT_HTML_CHARSET_UTF8);
    }

    /**
     * Set result to response writter using "text/xml;charset=UTF-8"
     *
     * @param response
     * @param text
     */
    public void renderXml(HttpServletResponse response, String text)
    {
        renderResult(response, text, GlobalConstants.TEXT_XML_CHARSET_UTF8);
    }

    /**
     * Set result to response writter using the specific type
     *
     * @param response
     * @param text
     * @param renderType
     */
    private void renderResult(HttpServletResponse response, String text, String renderType)
    {
        PrintWriter out = null;

        try
        {
            out = response.getWriter();
            response.setContentType(renderType);
            out.write(text);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (out != null)
            {
                out.flush();
                out.close();
                out = null;
            }
        }
    }


}
