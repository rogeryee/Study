package com.yeep.study.ejb3.localSessionBean.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.yeep.study.ejb3.localSessionBean.HelloWorld;

@Stateless(mappedName="HelloWorld/local")
@Remote( { HelloWorld.class })
/**
 * Session Bean which implements Local Interface
 */
public class HelloWorldBean implements HelloWorld
{

	@Override
	public String sayHello(String name)
	{
		return name + ", hello world, this is the first sample of EJB3 which using a Local Interface";
	}

}
