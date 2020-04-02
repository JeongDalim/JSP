<%@ page import="java.util.*,jdbc_0528.vo.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>업무</td>
			<td>상사번호</td>
			<td>입사일자</td>
			<td>급여</td>
			<td>커미션</td>
			<td>부서번호</td>
		</tr>
		<tr>
			<td>1111</td>
			<td>굴단</td>
			<td>흑마법사</td>
			<td>1234</td>
			<td>2017-09-09</td>
			<td>2000</td>
			<td>0</td>
			<td>10</td>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.eno }</td>
				<td>${emp.ename }</td>
				<td>${emp.job }</td>
				<td>${emp.manager }</td>
				<td>${emp.hiredate }</td>
				<td>${emp.salary }</td>
				<td>${emp.commission }</td>
				<td>${emp.dno }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>