<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String userid = request.getParameter("userid");
String passwd = request.getParameter("passwd");
String zip = request.getParameter("zip");
String addr = request.getParameter("addr1")+request.getParameter("addr2");
String tel = request.getParameter("tel");
String email= request.getParameter("email");
String [] fas = request.getParameterValues("fa");
String fa = fas[0];
for(int i=1; i<fas.length; i++){
	fa+=","+fas[i];
}
String job = request.getParameter("job");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>수정결과출력</h2><p/>
<strong>성명:<%=name%></strong> <p/>
<strong>아이디:<%=userid%></strong> <p/>
<strong>비번:<%=passwd%></strong><p/>
<strong>우편번호:<%=zip%></strong><p/>
<strong>주소:<%=addr%></strong> <p/>
<strong>전화번호:<%=tel%> </strong><p/>
<strong>이메일:<%=email%></strong> <p/>
<strong>관심분야 :<%=fa%></strong> <p/>
<strong>직업:<%=job%> </strong><p/>
<a href="userinfo_list.jsp"><input type="button" value="회원목록으로"></a>
<p/>
</body>
</html>