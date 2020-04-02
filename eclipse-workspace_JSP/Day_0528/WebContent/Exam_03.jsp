<%@ page import="java.util.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String str = "aaa,bbb,ccc.ddd,eee.ddd,rrr.ggg";
	StringTokenizer st = new StringTokenizer(str, ",.");
	while (st.hasMoreTokens()) {
		out.print(st.nextToken() + "<br>");
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