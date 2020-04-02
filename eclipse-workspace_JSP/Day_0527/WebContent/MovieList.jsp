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
	<%
		String[] movies = { "어벤져스 1", "어벤져스 2:에이지 오브 울트론", "어벤져스 3:인피니티 워", "어벤져스 4:엔드 게임" };
		pageContext.setAttribute("movies", movies);
	%>
	<table border="1">
		<tr>
			<td align="center"><strong>index</strong></td>
			<td align="center"><strong>count</strong></td>
			<td align="center"><strong>title</strong></td>
		</tr>
		<c:forEach var="movie" items="${movies}" varStatus="status">
			<tr>
				<td align="center"><strong>${status.index}</strong></td>
				<td align="center"><strong>${status.count}</strong></td>
				<td align="center"><strong>${movie}</strong></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>