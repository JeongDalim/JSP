<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
쿠키 생성 테스트
<%

Cookie info = new Cookie("jslhrd","testcookie");
info.setMaxAge(60); // 1분
response.addCookie(info);

%>
</body>
</html>