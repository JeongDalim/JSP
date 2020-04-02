<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
쿠키 이름과 쿠키 값 확인 <br>
<%
Cookie[] cookies = request.getCookies();
for(Cookie cook : cookies){
	out.print(cook.getName()+" : "+cook.getValue()+"<br>"); // 쿠키이름을 가져옴,쿠키값을 가져옴
}
%>
</body>
</html>