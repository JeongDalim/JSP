<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
   int add(int a, int b){
   return a+b;
}
%>

<%
int a= Integer.parseInt(request.getParameter("a"));
int b= Integer.parseInt(request.getParameter("b"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><h3>함수호출</h3>
	<%=a %>+<%=b %>=<%=add(a,b) %>
	<%request.getContextPath();
	  request.getMethod();
	  request.getRequestURI();
	  request.getRequestURL();
	  request.getRemoteAddr();
	  %>
</body>
</html>