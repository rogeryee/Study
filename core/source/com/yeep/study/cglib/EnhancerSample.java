package com.yeep.study.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class EnhancerSample
{
	public static void main(String[] args)
	{
		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(TestClass.class);
		enhancer.setCallback(new MethodInterceptorImpl());

		TestClass test = (TestClass) enhancer.create();

		test.method1();
	}

	private static class MethodInterceptorImpl implements MethodInterceptor
	{
		public Object intercept(Object obj, Method method, Object[] args,
				MethodProxy proxy) throws Throwable
		{
			proxy.invokeSuper(obj, args);
			System.out.println("MethodInterceptor.After Invoke");
			return null;
		}
	}

}

class TestClass
{
	public void method1()
	{
		System.out.println("TestClass.method1");
	}
}
