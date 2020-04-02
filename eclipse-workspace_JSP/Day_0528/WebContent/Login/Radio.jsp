<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function go() {
		if (rform.who[0].checked==true) {
			rform.action = "admin.jsp";
			rform.submit();
		}
		if (rform.who[1].checked==true) {
			rform.action = "user.jsp";
			rform.submit();
		}
	}
</script>
</head>
<body>
	<form name="rform" action="Radio_pro.jsp">
		아이디 : <input type="text" name="id">
		<p />
		암&nbsp;&nbsp;&nbsp;&nbsp;호 : <input type="password" name="pw">
		<p />
		<input type=radio name="who" value="admin">관리자
		<input type=radio name="who" value="user">사용자
		<p />
		<input type="button" value="로그인" onClick="go()">
	</form>
</body>
</html>