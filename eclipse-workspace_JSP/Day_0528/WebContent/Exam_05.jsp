<%@ page import="java.util.*" import="java.time.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	/* LocalDateTime now = LocalDateTime.now(); */
	Date now2 = new Date();
	/* LocalTime now3 = LocalTime.now(); */

	/* out.print(now + "<br>");
	out.print(now2 + "<br>");
	out.print(now3 + "<br>"); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="now" value="<%=now2 %>"></c:set>
\${now}:${now}<p/>
<fmt:formatDate value="${now }"/><p/>
date : <fmt:formatDate value="${now }" type="date"/><p/>
time : <fmt:formatDate value="${now }" type="time"/><p/>
both : <fmt:formatDate value="${now }" type="both"/><p/>
===============================================<p/>
default : <fmt:formatDate value="${now }" type="both" dateStyle="default" timeStyle="default"/><p/>
short : <fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"/><p/>
medium : <fmt:formatDate value="${now }" type="both" dateStyle="medium" timeStyle="medium"/><p/>
long : <fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="long"/><p/>
full : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
</body>
</html>