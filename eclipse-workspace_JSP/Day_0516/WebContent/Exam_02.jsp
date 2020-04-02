<%@ page import="Day_0516.test.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Exam_01 ex1 = new Exam_01();
int sum=ex1.test();
%>
1에서 10까지의 합은 <%=sum %> 입니다.
</body>
</html>