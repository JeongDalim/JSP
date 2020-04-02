<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "pag map");
	request.setAttribute("name", "request map");
	session.setAttribute("name", "session map");
	application.setAttribute("name", "application map");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name:${name}<p/>
page 속성 : ${pageScope.name}<p/>
request 속성 : ${requestScope.name }<p/>
session 속성 : ${sessionScope.name }<p/>
application 속성 : ${applicationScope.name }
</body>
</html>