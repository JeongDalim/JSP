<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
   int tot=0;
   int add(int a, int b){
   return a+b;
   }
%>
<% 
 int sum =0;
for(int i=1; i<=10; i++){
	out.print(i+"<br>");
	sum+=i;
}
%>
<h3>1에서 10까지의 합은 <%=sum%>입니다.</h3>
<h3>add(10,20) : <%=add(10,20) %></h3>
<h3> sum / tot : <%=sum++ %>/<%=tot++ %><h3>
</body>
</html>