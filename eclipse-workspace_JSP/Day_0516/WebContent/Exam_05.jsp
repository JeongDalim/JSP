<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String name=request.getParameter("name");
String gender=request.getParameter("gender");
String[] season=request.getParameterValues("season");
String seasonresult="";
for(int i=0; i<season.length; i++){
	seasonresult+=season[i];
}
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><strong>설문조사 결과</strong></h2>
이름: <%=name %><p>
성별: <%=gender %></p><p>
당신이 좋아하는 계절은 
<%
	if(seasonresult.contains("1")){
		out.print("<b>봄</b>");
	}
	if(seasonresult.contains("2")){
		out.print("<b>여름</b>");
	}
	if(seasonresult.contains("3")){
		out.print("<b>가을</b>");
	}
	if(seasonresult.contains("4")){
		out.print("<b>겨울</b>");
	}
%>입니다.</p><p>
<a href="javascript:history.go(-1)">다시 입력하기</a></p>
</body>
</html>