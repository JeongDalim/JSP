<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int age = Integer.parseInt(request.getParameter("age"));
if(age<19){
%>
<script type="text/javascript">
	alert("19세 미만은 입장불가.");
	history.go(-1);
<%}else{
request.setAttribute("name", "성윤성");
RequestDispatcher rd = request.getRequestDispatcher("forwardResult.jsp");
rd.forward(request, response);
}%>
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

</body>
</html>