<%@ taglib prefix="struts" uri="/struts-tags"%>
<body>
	<h3 align="left">Value in Session and Request</h3>
	request.materialName: <struts:property value="#request.materialName" /><br/>
	session.materialName: <struts:property value="#session.materialName" /><br/>

	<h3 align="left">Show data by condition (less than 50 RMB)</h3>
	<ul>
		<struts:iterator value="materials.{?#this.mainbid <50}">
			<li><struts:property value="materialName" /> Price is <struts:property value="mainbid" /> RMB!</li>
		</struts:iterator>
	</ul>
	<p>Storage of Product1 <struts:property value="materials.{?#this.materialName=='Product1'}.{mount}[0]" /></p>
	<h3 align="left">Map data</h3>
	<struts:set name="frank" value="#{'material':'Product2', 'mount':'500'}" />
	<p>Rest product of frank: <struts:property value="#frank['material']" /></p>
	<p>Storgae: <struts:property value="#frank['mount']" /></p>
</body>
