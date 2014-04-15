<%@ page
	import="com.yeep.study.ejb3.localRemoteSessionBean.*,javax.naming.*,com.yeep.study.ejb3.util.ContextLoader"%>
<%
	try
	{
		InitialContext ctx = ContextLoader.getInitialPropertiesContext();
		HelloWorld helloWorld = (HelloWorld) ctx.lookup("HelloWorld/LocalAndRemote");
		out.println(helloWorld.sayHello("Roger"));
	}
	catch (NamingException e)
	{
		e.printStackTrace();
		out.println(e.getMessage());
	}
%>