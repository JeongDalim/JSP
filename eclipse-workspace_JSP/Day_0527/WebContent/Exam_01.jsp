<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	\${5+2}:${5+2 } <p/>
	
	\${5/2}:${5/2 } <p/>
	
	\${5 mod 2 }:${5 mod 2 }<p/>
	
	\${5>2}:${5>2 } <p/>
	
	\${5<2}:${5<2 } <p/>

	\${5==2}:${5==2 } <p/>
	
<%
String input=null;	
%>

\${empty input}:${empty input}
	
</body>
</html>