<%@ taglib uri="/tags/struts-html.tld" prefix="html" %>

<html>
<head>
<title>DispatchAction Test</title>
<script language="javascript">

    function submitForm()
    {
        form1.submit();
    }

</script>
</head>

<body>

<%
    String msg = (String)request.getAttribute("msg");
    if(msg==null || "".equals(msg))
        msg = "&nbsp;";

    out.print("<center>"+msg+"</center><br><br>");
%>

<form name="form1" action="/yeep/dynaFormTest.do">

<input type="text" name="userName">
&nbsp;&nbsp;
<input type="text" name="password">
&nbsp;&nbsp;
<input type="button" value="DynaActionForm Test" onClick="submitForm()">
    
</form>

</body>
</html>
