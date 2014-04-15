package com.yeep.study.ejb3.helloWorld.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.yeep.study.ejb3.helloWorld.HelloWorld;

@Stateless(mappedName="HelloWorld/remote")
@Remote( { HelloWorld.class })
/**
 * Session Bean which implements Remote Interface
 */
public class HelloWorldBean implements HelloWorld
{

	@Override
	public String sayHello(String name)
	{
		return name + ", hello world, this is the first sample of EJB3 which using a Remote Interface";
	}

}
