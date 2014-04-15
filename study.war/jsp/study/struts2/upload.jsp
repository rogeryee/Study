<%@taglib prefix="struts" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload File</title>
</head>
<body>

<struts:form action="upload" method="post" enctype="multipart/form-data">
	<tr>
		<td>Upload:<struts:file name="file"></struts:file></td>
	</tr>
	<tr>
		<td align="left"><struts:submit name="submit" value="Submit"></struts:submit></td>
	</tr>
</struts:form>

</body>
</html>
