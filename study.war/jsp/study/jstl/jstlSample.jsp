<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/tags/c" prefix="c"%>

<%@ page import="com.yeep.study.hibernate.model.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
<title>A Simple JSTL Sample</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>

<c:out value="This is the first JSTL page!" />
<br>
Your Browser:
<c:out value="${header['User-Agent']}" />
<br>

<c:set var="username" value="Roger.Yee & Phoebe Cao" scope="session"/>
<c:out value="${username}" escapeXml="true"/> 
<br>


<jsp:useBean id="user" class="com.yeep.study.hibernate.model.User"/>
<c:set target="${user}" property="name" value="KKMei" />
<c:out value="${user.name}" default="bean->name"/>
<br>

<%--
<c:set target="${test.Test}" property="name" value="KKMei" var="xx" scope="page" />
<c:set target="${test.Test}" property="age" value="13" var="xx" scope="page" />

<c:out value="${xx[Test.name]}" default="bean->name"/>,
<c:out value="${xx[Test.age]}" default="bean->age"/>
<br>
--%>

<c:forEach var="i" begin="1" end="10">
<c:out value="${i}"/>,
</c:forEach>
<br>

<c:set var="k" value="3"/>
<c:if test="${k==3}">
k====3
</c:if>
<br>

<c:set var="str" value="jStl" />
<jsp:useBean id="str" type="java.lang.String" />

<c-rt:if test='<%="JSTL".equals(str)%>'>
    rt if test equals <%="JSTL".equals(str)%>
</c-rt:if>
<br>

<c-rt:if test='<%="JSTL".equalsIgnoreCase(str)%>'>
    rt if test equalsIgnoreCase <%="JSTL".equalsIgnoreCase(str)%>
</c-rt:if>

<br>

<c:choose>
<c:when test="${k==1}">
c:when k==1
</c:when>
<c:when test="${k==2}">
c:when k==2
</c:when>
<c:otherwise>
otherwise====0
</c:otherwise>
</c:choose> 
<br>

<%
    Map map = new HashMap();
    map.put("A", "AAAAAAAAAAAA");
    map.put("B", "BBBBBBBBBBBB");
    map.put("C", "CCCCCCCCCCCC");
    
    request.setAttribute("map", map);
    List users = new ArrayList();

    for (int i = 0; i < 5; i++)
    {
        User oneUser = new User();
        oneUser.setName("f"+String.valueOf(i));
        users.add(oneUser);
    }
    
    request.setAttribute("users", users);
    
%>

<c:forEach var="xmap" items="${map}" >
Element <c:out value="${xmap.value}"/>,
</c:forEach>
<br>

<c:forEach var="xlist" items="${users}" varStatus="status">
<c:out value="${xlist.name}" /><br>
<c:choose>
<c:when test="${status.count % 2==0}">
the even row of the list
</c:when>
</c:choose>
</c:forEach>
<br>

<c:set var="urlName" value="WWW.SINA.COM.CN" scope="page" />
<c:url value="http://localhost:18080/yeep/jsp/index.jsp" var="myvar">
<c:param name="urlName" value="${urlName}" />
</c:url>
<a href='<c:out value="${myvar}"/>'>link</a>
<br>

<fmt:formatNumber value="455558414.63" type="currency" pattern=".000"/>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" timeStyle="long" dateStyle="long"/><br>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh:mm:ss" timeStyle="full"/>
<br>
<fmt:timeZone value="GMT+1:00">
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
</fmt:timeZone>
<br>

</body>
</html>
