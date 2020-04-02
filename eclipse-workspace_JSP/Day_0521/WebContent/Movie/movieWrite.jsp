<%@ page import=" day_0521_movie_vo.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="movie" class="day_0521_movie_vo.MovieBean">
<jsp:setProperty name="movie" property="*"></jsp:setProperty>
</jsp:useBean>
<body>
<h2>입력 완료된  정보</h2><p/>
<strong>제 &nbsp; &nbsp; &nbsp; &nbsp;목 :</strong>&nbsp;&nbsp;<%=movie.getTitle() %><p/>
<strong>가 &nbsp; &nbsp; &nbsp; &nbsp;격 :</strong>&nbsp;&nbsp;<%=movie.getPrice() %><p/>
<strong>감 &nbsp; &nbsp; &nbsp; &nbsp;독 :</strong>&nbsp;&nbsp;<%=movie.getDirector() %><p/>
<strong>출연배우:</strong>&nbsp;&nbsp;<%=movie.getActor() %><p/>
<strong>시놉시스:</strong>&nbsp;&nbsp;<%=movie.getSynopsis() %><p/>
<strong>장 &nbsp; &nbsp; &nbsp; &nbsp;르:</strong>&nbsp;&nbsp;<%=movie.getGenre() %><p/>
</body>
</html>