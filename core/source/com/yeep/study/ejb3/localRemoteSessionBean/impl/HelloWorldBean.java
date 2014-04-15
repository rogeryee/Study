package com.yeep.study.ejb3.localRemoteSessionBean.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.yeep.study.ejb3.localRemoteSessionBean.HelloWorld;
import com.yeep.study.ejb3.localRemoteSessionBean.LocalHelloWorld;

@Stateless(mappedName = "HelloWorld/LocalAndRemote")
@Remote(HelloWorld.class)
@Local(LocalHelloWorld.class)
/**
 * Session Bean which implements both Remote and Local Interface.
 */
public class HelloWorldBean implements HelloWorld, LocalHelloWorld
{
	private int count;

	@Override
	public String sayHello(String name)
	{
		count++;
		return name + ", hello world, this is the first sample of EJB3 which using a Remote/Local Interface";
	}

	public int getCount()
	{
		return count;
	}
}
