package com.yeep.study.struts2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class MethodFilterInterceptorExample extends MethodFilterInterceptor
{
	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception
	{
		System.out.println("[MethodFilterInterceptorExample]start invoking...");
		String result = arg0.invoke();
		System.out.println("[MethodFilterInterceptorExample]end invoking...");
		return result;
	}

}
