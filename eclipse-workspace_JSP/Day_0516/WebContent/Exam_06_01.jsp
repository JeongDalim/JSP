<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("urf-8");
String id="pinksung";
String pw="1234";
%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(id.equals(request.getParameter("id"))){
	if(pw.equals(request.getParameter("pw"))){
	response.sendRedirect("Exam_06_02.jsp");
	}
}else{
	response.sendRedirect("Exam_06_03.jsp");
}
%>
</body>
</html>