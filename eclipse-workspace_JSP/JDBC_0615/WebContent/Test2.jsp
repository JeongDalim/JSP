<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${session}
<form method="post" action="test2.do">
<input type="button" value="버튼" onClick="javascript:submit()">
<input type="hidden" name="h" value="forever">
</form>

</body>
</html>