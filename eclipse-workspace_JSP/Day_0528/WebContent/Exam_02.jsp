<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String str = "aaa,bbb,ccc";
	String[] strs = str.split(",");
	for (int i = 0; i < strs.length; i++) {
		out.print(strs[i] + "<br>");
	}
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