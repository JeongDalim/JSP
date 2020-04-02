<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
고전적인 방식
<%
String num1 = request.getParameter("num1");
String num2 = request.getParameter("num2");
int sum = Integer.parseInt(num1)+Integer.parseInt(num2);
%>
<%= Integer.parseInt(num1)%>+<%=Integer.parseInt(num2) %>=<%=sum %><p/>

EL 방식
${param.num1 }+${param.num2 }=${param.num1+param.num2 }
</body>
</html>