<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="struts" uri="/struts-tags"%>
<html>
<head>
	<title>Login</title>
</head>
<body>

	<struts:form action="Login">
		<table width="60%" height="76" border="0">
				<struts:textfield name="username" label="User Name"/>
				<struts:password name="password" label="Password" />
				<struts:submit value="Login" align="center"/>				
		</table>
	</struts:form>
	
</body>
</html> 
