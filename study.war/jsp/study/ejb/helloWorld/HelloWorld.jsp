<%@ page
	import="com.yeep.study.ejb3.helloWorld.*,javax.naming.*,com.yeep.study.ejb3.util.ContextLoader"%>
<%
	try
	{
		InitialContext ctx = ContextLoader.getInitialPropertiesContext();
		HelloWorld helloWorld = (HelloWorld) ctx.lookup("HelloWorld/remote");
		out.println(helloWorld.sayHello("Roger"));
	}
	catch (NamingException e)
	{
		e.printStackTrace();
		out.println(e.getMessage());
	}
%>