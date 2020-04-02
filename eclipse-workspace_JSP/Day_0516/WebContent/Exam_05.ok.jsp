<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="frm" method="post" action="Exam_05.jsp">
<h2><strong>설문 조사</strong></h2>
이름 : <input type="text" name="name"><p>
성별 : <input type="radio" name="gender" value="남자">남자<input type="radio" name="gender" value="남자">여자</p><p>
좋아하는 계절: <input type="checkbox" name="season" value="1">봄
           <input type="checkbox" name="season" value="2">여름
           <input type="checkbox" name="season" value="3">가을
           <input type="checkbox" name="season" value="4">겨울</p><p>
<input type="submit" value="등록">   
<input type="reset" value="취소"></p>         
</form>
</body>
</html>