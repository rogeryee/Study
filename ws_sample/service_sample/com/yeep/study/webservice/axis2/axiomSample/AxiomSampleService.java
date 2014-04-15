package com.yeep.study.webservice.axis2.axiomSample;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

public class AxiomSampleService
{
	private static final String NAME_SPACE = "http://axiomSample.axis2.webservice.study.yeep.com";
	private static final String NAME_SPACE_PREFIX = "as";

	/**
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
	public OMElement sample1(OMElement request)
	{
		OMFactory omFactory = OMAbstractFactory.getOMFactory();
		OMNamespace ns = omFactory.createOMNamespace(NAME_SPACE, NAME_SPACE_PREFIX);

		// Create root
		OMElement root = omFactory.createOMElement("RootElement", ns);

		// create children
		OMElement firstChild = omFactory.createOMElement("ChildElement", ns);
		firstChild.setText("I am the first child element");
		firstChild.addAttribute("myAttr", "attrValue", ns);

		OMElement secondChild = omFactory.createOMElement("ChildElement", ns);
		secondChild.setText("I am the second child element");
		secondChild.addAttribute("myAttr", "attrValue", ns);

		// add children to root element
		root.addChild(firstChild);
		root.addChild(secondChild);
		root.declareNamespace(NAME_SPACE, NAME_SPACE_PREFIX);

		return root;
	}
	
	/**
	 * The output xml like the below:
	 * 
	 * <as:Person xmlns:as="http://axiomSample.axis2.webservice.study.yeep.com" 
	 *            type="com.yeep.study.webservice.axis2.Person">
	 * 	 <age>27</age>
	 * 	 <name>Roger</name>
	 * </as:Person>
	 * 
	 */
	public OMElement sample2(OMElement request)
	{
		OMFactory omFactory = OMAbstractFactory.getOMFactory();
		OMNamespace ns = omFactory.createOMNamespace(NAME_SPACE, NAME_SPACE_PREFIX);
		
		String name = request.getFirstElement().getText();
		
		// Create root
		OMElement root = omFactory.createOMElement("Person", ns);
		root.setNamespace(ns);
		
		// create children
		OMElement nameElement = omFactory.createOMElement("name", ns);
		nameElement.setText(name);
		root.addChild(nameElement);

		OMElement ageElement = omFactory.createOMElement("age", ns);
		ageElement.setText("25");
		root.addChild(ageElement);
		
		OMElement addressElement = omFactory.createOMElement("address", ns);
		addressElement.setText("Shanghai");
		root.addChild(addressElement);

		return root;
	}
}
