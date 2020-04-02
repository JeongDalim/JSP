<%@ page import="Day_0524_board.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%-- <%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String email = request.getParameter("email");
String subject = request.getParameter("subject");
String contents = request.getParameter("contents");
String pass = request.getParameter("pass");
%> --%>
<jsp:useBean id="board" class="Day_0524_board.boardBean">
<jsp:setProperty name="board" property="*"></jsp:setProperty>
</jsp:useBean>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
작성자: <%=board.getName()%><br>
이메일: <%=board.getEmail()%><br>
제목: <%=board.getSubject()%><br>
내용: <%=board.getContents()%><br>
비번: <%=board.getPass()%><br>
</body>
</html>