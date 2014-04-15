<%@taglib prefix="struts" uri="/struts-tags"%>
<body>
		Upload file:
		<table>
		<struts:iterator value="fileFileName" status="fn">
			<tr>
				<td>
					<struts:property />		
				</td>
				<td>
					<a href="<struts:url value='download.action'>  				
                 	 <struts:param name='fileName' value='fileFileName[#fn.getIndex()]'/>  
                   </struts:url>">download</a>
				</td>
		</tr>
		</struts:iterator>		
		</table>		
</body>

