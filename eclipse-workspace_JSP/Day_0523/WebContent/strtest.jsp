<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pattern_check() {
		if (pform.pattern.value == "") {
			alert("빈칸입니다.");
			pform.pattern.focus();
			return;
		}
		if (pform.pattern.value.length % 2 != 0) {
			alert("패턴의 글자 수는 짝수만 가능합니다.");
			pform.pattern.focus();
			return;
		}
		alert("등록성공!");
		pform.action="strtest_pro.jsp";
		pform.submit();
	}
</script>
</head>
<body>
	<br>
	<form name="pform">
		<table border="1" align="center">
			<tr>
				<td>패턴입력<input type="text" name="pattern"></td>
			</tr>

			<tr>
				<td align="center"><input type="button" value="등록"
					onClick="pattern_check()"></td>
			</tr>
		</table>
	</form>
</body>
</html>