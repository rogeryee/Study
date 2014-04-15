package com.yeep.study.webservice.axis2;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class HelloWorldClient
{
	private static final EndpointReference targetEPR = new EndpointReference(
			"http://localhost:18080/yeep/services/helloWorld");
	private static final String NAME_SPACE = "http://helloWorld.axis2.webservice.study.yeep.com";

	public static void main(String[] args)
	{
		try
		{
			// Test the hello2() method of helloWorld Service
			callHello2();
		}
		catch (Exception axisFault)
		{
			axisFault.printStackTrace();
		}
	}

	private static void callHello2() throws Exception
	{
		// Settup the request
		Options options = new Options();
		options.setTo(targetEPR);
		ServiceClient sender = new ServiceClient();
		sender.setOptions(options);

		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace(NAME_SPACE, "hw");
		OMElement request = fac.createOMElement("hello2", omNs);
		request.setText("Roger");

		// Get the result
		OMElement response = sender.sendReceive(request);
		System.out.println(response);
		System.out.println(response.getText());
	}
}
