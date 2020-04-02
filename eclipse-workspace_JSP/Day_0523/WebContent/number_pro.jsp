<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String number = request.getParameter("num");
	String number2="";
	char[] c = number.toCharArray();
	for (int i = c.length - 1; i >= 0; i--) {
		number2+=c[i];
	}
	int number3 = Integer.parseInt(number)+Integer.parseInt(number2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	data=
	<%=number%>+<%=number2%><p/>
	<%=number3 %>
</body>
</html>