<%@ page import="java.net.URLDecoder" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
관리자로 로그인 성공<br>
<%=URLDecoder.decode(request.getParameter("userName"),"utf-8") %>
(<%=request.getParameter("id") %>)님 환영합니다.
</body>
</body>
</html>