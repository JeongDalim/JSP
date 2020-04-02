<%@ page import=" Day_0527.javaBean.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mb" class="Day_0527.javaBean.MemberBean">
<jsp:setProperty name="mb" property="*"/>    
</jsp:useBean>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:<%=mb.getName() %>
아이디:<%=mb.getUserid() %>
</body>
</html>