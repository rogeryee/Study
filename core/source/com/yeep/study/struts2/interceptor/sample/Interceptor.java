package com.yeep.study.struts2.interceptor.sample;

public class Interceptor
{
	public void beforeDoing()
	{
		System.out.println("before doing Something...");
	}

	public void afterDoing()
	{
		System.out.println("after doing Something...");
	}

}
