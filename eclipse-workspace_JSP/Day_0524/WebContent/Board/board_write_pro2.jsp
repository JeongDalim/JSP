<%@ page import="Day_0524_board.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:useBean id="board" class="Day_0524_board.boardBean">
<jsp:setProperty name="board" property="*"/>
</jsp:useBean>
</head>
<body>
<%=board.getName() %>
<%=board.getEmail() %>
<%=board.getSubject() %>
<%=board.getContents() %>
<%=board.getPass() %>
</body>
</html>