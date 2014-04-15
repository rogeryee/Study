package com.yeep.study.webservice.axis2;

import java.io.StringReader;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class AxiomSampleClient
{
	private static final EndpointReference targetEPR = new EndpointReference(
			"http://localhost:18080/yeep/services/axiomSample");
	private static final String NAME_SPACE = "http://axiomSample.axis2.webservice.study.yeep.com";
	private static final String NAME_SPACE_PREFIX = "as";

	public static void main(String[] args)
	{
		try
		{
			// Test the callSample1() method of AxiomSample Service
			callSample1();

			callSample2();
		}
		catch (Exception axisFault)
		{
			axisFault.printStackTrace();
		}
	}

	/**
	 * Test for OMElement Transfer
	 * 
	 * The output xml like the below:
	 * 
	 * <as:RootElement xmlns:as="http://axiomSample.axis2.webservice.study.yeep.com">
	 *	 
	 *   <as:ChildElement as:myAttr="attrValue">
	 *    	I am the first child element
	 *   </as:ChildElement>
	 *   
	 *   <as:ChildElement as:myAttr="attrValue">
	 *   	  I am the second child element
	 *   </as:ChildElement>
	 *   
	 * </as:RootElement>
	 * 
	 */
	private static void callSample1() throws Exception
	{
		// Settup the request
		Options options = new Options();
		options.setTo(targetEPR);
		ServiceClient sender = new ServiceClient();
		sender.setOptions(options);

		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace(NAME_SPACE, NAME_SPACE_PREFIX);
		OMElement request = fac.createOMElement("sample1", omNs);
		request.setText("Roger");

		// Get the result
		OMElement response = sender.sendReceive(request);
		System.out.println(response);
		System.out.println();

		// Use getChildElements()
		System.out.println("----- Use getChildElements() -----");
		Iterator childrenIterator = response.getChildElements();
		while (childrenIterator.hasNext())
		{
			OMElement element = (OMElement) childrenIterator.next();
			System.out.println("Child Elment:" + element.getText());

			Iterator attrIterator = element.getAllAttributes();
			while (attrIterator.hasNext())
			{
				OMAttribute attribute = (OMAttribute) attrIterator.next();
				System.out.println(attribute.getQName() + ":"
						+ attribute.getAttributeValue());
			}
		}
		System.out.println();

		// Use getChildrenWithName()
		System.out.println("----- Use getChildrenWithName() -----");
		// use QName to specify the element
		childrenIterator = response.getChildrenWithName(new QName(NAME_SPACE,
				"ChildElement", NAME_SPACE_PREFIX));
		while (childrenIterator.hasNext())
		{
			OMElement element = (OMElement) childrenIterator.next();
			System.out.println("Child Elment:" + element.getText());

			OMAttribute attribute = (OMAttribute) element.getAttribute(new QName(
					NAME_SPACE, "myAttr", NAME_SPACE_PREFIX));
			System.out.println("Attribute:" + attribute.getAttributeValue());
		}
	}

	/**
	 * Test for Using StAXOMBuilder for Object
	 * 
	 * <as:Person xmlns:as="http://axiomSample.axis2.webservice.study.yeep.com" 
	 *            type="com.yeep.study.webservice.axis2.Person">
	 * 	 <age>27</age>
	 * 	 <name>Roger</name>
	 * </as:Person>
	 * @throws Exception
	 */
	private static void callSample2() throws Exception
	{
		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace(NAME_SPACE, NAME_SPACE_PREFIX);

		// use FileInputstream
		// BufferedReader reader = new BufferedReader(
		// new InputStreamReader(
		// new FileInputStream(
		// "D:\\Work\\yeep\\yeep_core\\source\\com\\yeep\\study\\webservice\\axis2\\axiomSampleIn.xml")));

		// use StringReader
		String xmlStr = "<as:RequestQuery xmlns:as=\"http://axiomSample.axis2.webservice.study.yeep.com\"><personName>Phoebe</personName></as:RequestQuery>";
		StringReader reader = new StringReader(xmlStr);

		XMLStreamReader parser = XMLInputFactory.newInstance()
				.createXMLStreamReader(reader);
		StAXOMBuilder builder = new StAXOMBuilder(fac, parser);

		OMElement request = builder.getDocumentElement();
		request.setLocalName("sample2");
		request.setNamespace(omNs);
		System.out.println("Requsest:" + request);

		// Get the result
		Options options = new Options();
		options.setTo(targetEPR);
		ServiceClient sender = new ServiceClient();
		sender.setOptions(options);

		OMElement response = sender.sendReceive(request);
		System.out.println(response);
	}
}
