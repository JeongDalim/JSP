<%@ page import="java.time.LocalDate" contentType="text/html; charset=UTF-8" %>
<%
LocalDate now = LocalDate.now();
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
int number=5;
%>
<html>
<head><title>방명록 작성</title>
</head>
 <body >
 <form name="frm" method="post">
작성자<%=name%><p>
제목<%=subject%></p><p>
내용<%=content%></p>
<%
request.setAttribute("name" ,name);
request.setAttribute("subject" ,subject);
request.setAttribute("content" ,content);
request.setAttribute("number" ,++number+"");
request.setAttribute("now" ,now+"");

RequestDispatcher rd = request.getRequestDispatcher("guest_list.jsp?name=name&subject=subject&content=content&number=number&now=now");
rd.forward(request, response);%>
<a href="guest_write_ok2.jsp"><input type="button" value="방명록으로 돌아가기"></a>
</form>
</body>
</html>
