<%@ page import="java.util.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		if (iform.name.value == "") {
			alert("이름을 입력해 주십시오");
			iform.name.focus();
			return;
		}
		if (iform.money.value == "") {
			alert("출장비를 입력해 주십시오");
			iform.money.focus();
			return;
		}
		if (number(iform.money.value)) {
			alert("출장비는 숫자로만 입력해 주십시오");
			iform.money.focus();
			return;
		}
		if (iform.name.value == "Quit") {
			alert("결과창으로 이동합니다.");
			iform.action = "input_pro.jsp";
			iform.submit();
		} else {
			alert("등록성공!");
			iform.action = "input_pro.jsp";
			iform.submit();
		}
	}
	function number(num) {
		for (i = 0; i < num.length; i++) {
			if (num.charAt(i) < '0' || num.charAt(i) > '9') {
				return true; //문자
			} else {
				return false; //숫자
			}
		}
	}
</script>
</head>
<body>
	<form name="iform">
		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center"><strong>출장비지급신청서</strong></td>
			</tr>
			<tr>
				<td><strong>이름</strong></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><strong>출장비</strong></td>
				<td><input type="text" name="money"></td>
			</tr>
		</table>
		<p />
		<center>
			<input type="button" value="등록" onClick="check()"> <input
				type="reset" value="취소">
		</center>
	</form>
</body>
</html>