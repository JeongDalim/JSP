<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="upload.do" enctype="multipart/form-data">
		<table border="1">
			<colgroup>
			</colgroup>
			<tr>
				<td>작성자:</td><td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>제목:</td><td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>첨부파일:</td><td><input type="file" name="upfile"></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="2"><input type="submit" value="전송">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>