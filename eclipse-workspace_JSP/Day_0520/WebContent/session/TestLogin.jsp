<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>\
<%
String id="AAA";
String pw="123";
String name="최영원";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
if(id.equals(request.getParameter("id"))){
	if(pw.equals(request.getParameter("pw"))){
	session.setAttribute("loginUser", name);
	response.sendRedirect("Main.jsp");
	}
}else{%>
<script>
alert("id 또는 비밀번호가 틀립니다.");
</script>
<% 
response.sendRedirect("LoginForm.jsp");			
}
%>
</head>
<body>

</body>
</html>