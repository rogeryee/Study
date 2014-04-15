package com.yeep.study.struts2.interceptor.sample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InterceptorHandler implements InvocationHandler
{
	private Object object;

	private Interceptor inter = new Interceptor();

	public void setObject(Object object)
	{
		this.object = object;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		inter.beforeDoing();

		Object returnObject = method.invoke(object, args);
		inter.afterDoing();
		return returnObject;
	}
}
