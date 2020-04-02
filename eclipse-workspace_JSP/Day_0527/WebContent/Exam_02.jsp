<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
int cnt=0;
%>    
<c:set var="cnt" value="0"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=cnt %>
${cnt} 
<c:set var="cnt" value="${cnt+1}"/>
${cnt}  
</body>
</html>