<%@ taglib uri="/tags/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/tags/struts-html.tld" prefix="html"%>

<html>
<head>
<title>DynaValidateForm Test</title>
</head>
<body>

<html:form action="/yeep/dynaValidateFormTest.do">

  UserName:<html:text property = "userName"/> <html:errors property="userName"/><br>
  Password:<html:text property = "password"/> <html:errors property="password"/><br>

   <html:submit/><html:reset/><html:cancel/>


</html:form>

</body>
</html>


