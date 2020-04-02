<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.naming.*,javax.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Context ic = new InitialContext();
		Context env = (Context) ic.lookup("java:/comp/env");
		DataSource ds = (DataSource) env.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		out.print("DB 연결");
	%>
</body>
</html>