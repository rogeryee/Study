package com.yeep.gwt.util;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GWTController extends RemoteServiceServlet implements Controller, ServletContextAware
{
	// Instance fields
	private RemoteService remoteService;
	private Class remoteServiceClass;
	private ServletContext servletContext;

	// Public methods

	/**
	 * Process the request and return a ModelAndView object which the DispatcherServlet
	 * will render. A <code>null</code> return value is not an error: It indicates that
	 * this object completed request processing itself, thus there is no ModelAndView
	 * to render.
	 *
	 * @param request  current HTTP request
	 * @param response current HTTP response
	 * @return a ModelAndView to render, or <code>null</code> if handled directly
	 * @throws Exception in case of errors
	 */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super.doPost(request, response);
		return null; // response handled by GWT RPC over XmlHttpRequest - so there is no Model or View to return
	}

	/**
	 * Process the RPC request encoded into the payload string and return a string
	 * that encodes either the method return or an exception thrown by it.
	 */
	public String processCall(String payload) throws SerializationException
	{
		try
		{
			RPCRequest rpcRequest = RPC.decodeRequest(payload, this.remoteServiceClass);

			// delegate work to the spring injected service
			return RPC.invokeAndEncodeResponse(this.remoteService, rpcRequest.getMethod(), rpcRequest.getParameters());
		}
		catch (IncompatibleRemoteServiceException e)
		{
			return RPC.encodeResponseForFailure(null, e);
		}
	}

	/**
	 * @param remoteService the GWT RemoteService implementation that will be delegated to by
	 *                      the GWTController
	 */
	public void setRemoteService(RemoteService remoteService)
	{
		this.remoteService = remoteService;
		this.remoteServiceClass = this.remoteService.getClass();
	}

	protected void doUnexpectedFailure(Throwable e)
	{
		e.printStackTrace();
		super.doUnexpectedFailure(e);
	}

	/** {@inheritDoc} */
	public void setServletContext(ServletContext servletContext)
	{
		this.servletContext = servletContext;
	}

	public ServletContext getServletContext()
	{
		return this.servletContext;
	}
}
