<%@ page import="Day_0527.javaBean.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="board" class="Day_0527.javaBean.BoardBean">
	<jsp:setProperty name="board" property="*" />
</jsp:useBean>
<%
	request.setAttribute("board", board);
	RequestDispatcher rd = request.getRequestDispatcher("board_modify.jsp");
	rd.forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>