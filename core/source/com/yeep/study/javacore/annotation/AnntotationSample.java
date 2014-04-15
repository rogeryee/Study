package com.yeep.study.javacore.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class AnntotationSample extends SuperClass
{
	public static void main(String [] args)
	{
		AnntotationSample sample = new AnntotationSample();
		sample.method5();
	}
	
	@Override
	public void method()
	{
	}

	// If use @Override tag, the method will be check from parent class
	// @Override
	// public void meTHod2(){}

	@Deprecated
	public void method3()
	{
	}

	@SuppressWarnings(value =
	{ "unchecked" })
	public void method4()
	{
		List list = new ArrayList();
		list.add("foo");
	}
	
	@MyAnnotation(value="Phoebe")
	public void method5()
	{
		// Use reflect to get annotation
		Annotation[] annotations = MyAnnotation.class.getAnnotations();
		for(Annotation annotation:annotations)
		{
			System.out.println(annotation.toString());
		}
	}
}

class SuperClass
{
	public void method()
	{
	}

	public void method2()
	{
	}
}
