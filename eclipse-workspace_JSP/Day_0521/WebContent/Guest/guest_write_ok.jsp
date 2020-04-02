<%@ page import="day_0521_guest_vo.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");
String name= request.getParameter("name");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

GuestBean gb = new GuestBean();

gb.setName(name);
gb.setSubject(subject);
gb.setContent(content);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
기존 출력<br>
이름 : <%=gb.getName() %><br>
제목 : <%=gb.getSubject() %><br>
내용 : <%=gb.getContent() %><br>
</body>
</html>