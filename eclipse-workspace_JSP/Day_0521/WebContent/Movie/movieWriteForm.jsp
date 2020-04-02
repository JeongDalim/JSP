<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="movieWrite.jsp">
<h2>정보등록</h2><p/>
<strong>제 &nbsp; &nbsp; &nbsp; &nbsp;목 </strong> <input type="text" name="title"><p/>
<strong>가 &nbsp; &nbsp; &nbsp; &nbsp;격 </strong> <input type ="number" name="price"><p/>
<strong>감 &nbsp; &nbsp; &nbsp; &nbsp;독  </strong> <input type ="text" name="director"><p/>
<strong>출연배우</strong> <input type ="text" name="actor"><p/>
<strong>시놉시스 </strong> <input type ="text" name="synopsis"><p/>
<strong>장 &nbsp; &nbsp; &nbsp; &nbsp;르</strong> <select name="genre">
<option value="로맨스">로맨스
<option value="스릴러">스릴러
<option value="미스터리">미스터리
<option value="액션">액션
<option value="코미디">코미디
<option value="애니메이션">애니메이션
</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="확인">
<input type="reset" value="취소">
</form>
</body>
</html>