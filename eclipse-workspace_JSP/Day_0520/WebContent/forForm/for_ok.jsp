<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String number=request.getParameter("number");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
1부터 <%=number%>까지 자연수의 합 구하기<br>
<%
String result="";
int tot=0;
for(int i=1; i<=Integer.parseInt(number); i++){
	if(i<Integer.parseInt(number)){
	result=i+"+";
	}else{
	result=i+"";	
	}
	out.print(result);
	tot+=i;
}
out.print("="+tot);
%>
</body>
</html>