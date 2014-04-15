package com.yeep.study.struts2.interceptor.sample;

public class TestInterceptor
{
	public static void main(String[] args)
	{
		ExecuteFunctionInterface test = new ExecuteFunction();

		ExecuteFunctionInterface resultObject = (ExecuteFunctionInterface) new ProxyObject().getProxy(test);
		resultObject.execute();
		resultObject.stop();
	}

}
