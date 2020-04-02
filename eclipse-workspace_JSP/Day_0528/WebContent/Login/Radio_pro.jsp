<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.who == 1}">
		<c:redirect url="admin.jsp?name=${param.id}&${param.who}"></c:redirect>
	</c:if>
	<c:if test="${param.who == 2}">
		<c:redirect url="user.jsp?name=${param.id }"></c:redirect>
	</c:if>
</body>
</html>