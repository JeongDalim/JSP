<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("loginUser")==null){
	response.sendRedirect("LoginForm.jsp");
}else{
%>
<%=session.getAttribute("loginUser") %>님 환영합니다.
<form action="logout.jsp">
<input type="submit" value="로그아웃">
</form>
<%}%>
</body>
</html>