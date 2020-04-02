<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Enumeration str= request.getParameterNames(); 
while(str.hasMoreElements()){
	String name = (String)str.nextElement();
	String value =request.getParameter(name);
	out.println(name+":"+value+"<br>");
}
%>

</body>
</html>