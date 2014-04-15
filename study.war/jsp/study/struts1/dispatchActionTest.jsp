<%@ taglib uri="/tags/struts-html.tld" prefix="html" %>

<html>
<head>
<title>DispatchAction Test</title>
<script language="javascript">

    function method1()
    {
        studyForm.action = "/yeep/dispatchActionTest.do?method=method1";
        studyForm.submit();
    }

    function method2()
    {
        studyForm.action = "/yeep/dispatchActionTest.do?method=method2";
        studyForm.submit();
    }

    function methodnull()
    {
        studyForm.action = "/yeep/dispatchActionTest.do";
        studyForm.submit();
    }

</script>
</head>

<body>

<%
	String actionName = (String)request.getAttribute("actionName");

  out.print("<center>"+"We call the " + actionName + " method."+"</center><br><br>");
%>

<html:form action="dispatchActionTest.do">

<input type="button" value="Use Method1" onClick="method1()">
&nbsp;&nbsp;
<input type="button" value="Use Method2" onClick="method2()">
&nbsp;&nbsp;
<input type="button" value="Use no Method" onClick="methodnull()">
    
</html:form>

</body>
</html>
