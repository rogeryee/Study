package com.yeep.study.struts2.interceptor.sample;

import java.lang.reflect.Proxy;

public class ProxyObject
{
	private InterceptorHandler handler = new InterceptorHandler();

	public Object getProxy(Object object)
	{
		handler.setObject(object);
		return Proxy.newProxyInstance(ExecuteFunction.class.getClassLoader(), object.getClass().getInterfaces(), handler);
	}

}
