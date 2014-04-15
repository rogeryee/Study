package com.yeep.study.webservice.axis2.helloWorld;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;


public class HelloWorld
{
	private static final String NAME_SPACE = "http://helloWorld.axis2.webservice.study.yeep.com";
	
	public String hello1(String username)
	{
		return "Hi " + username + ", Welcome to HelloWorld! --> HelloWorld.hello1()";
	}

	public OMElement hello2(OMElement request)
	{
		String username = request.getText();
		String info = "Hi " + username + ", Welcome to HelloWorld! --> HelloWorld.hello2()";
		
		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace(NAME_SPACE, "hw");
		OMElement response = fac.createOMElement("hello2Response", omNs);
		response.setText(info);
		
		return response;
	}
}
