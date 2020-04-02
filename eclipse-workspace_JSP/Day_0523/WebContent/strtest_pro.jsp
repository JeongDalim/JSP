<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pattern = request.getParameter("pattern");
	char[] patterns = pattern.toCharArray();  //문자열을 쪼개서 char배열에 넣음
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="strtest.jsp">
		data :<%=pattern%><p />
		결과 :
		<%
		int max = 0;
		for (int i = 0; i < patterns.length; i = i + 2) {
			if (patterns[i] > '0' && patterns[i] < '9') {
				max = patterns[i] - '0'; //char 정수화
				for (int j = 0; j < max; j++) {
					out.print(patterns[i + 1]);
				}
			}
		}
	%>
		<p />
		<input type="submit" value="계속">
	</form>
</body>
</html>