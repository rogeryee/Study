<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="struts" uri="/struts-tags"%>
<html>
<head>
<title>Register</title>
</head>
<body>
<struts:form action="register">
	<table width="60%" height="76" border="0">
		<struts:textfield name="username" label="UserName" />
		<struts:password name="password" label="Password" />
		<struts:submit value="Submit-Validate()" align="center" />
	</table>
</struts:form>

<struts:form action="register!Register.action">
	<table width="60%" height="76" border="0">
		<struts:textfield name="username" label="UserName" />
		<struts:password name="password" label="Password" />
		<struts:submit value="Submit-ValidateXXX()" align="center" />
	</table>
</struts:form>

<struts:form action="register2">
	<table width="60%" height="76" border="0">
		<struts:textfield name="username" label="UserName" />
		<struts:password name="password" label="Password" />
		<struts:submit value="Submit-ValidateXml" align="center" />
	</table>
</struts:form>
</body>
</html>
