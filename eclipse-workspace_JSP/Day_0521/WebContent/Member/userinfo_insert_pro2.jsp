<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String userid = request.getParameter("userid");
String passwd = request.getParameter("passwd");
String star =passwd.substring(0,1);
for(int i=1; i<passwd.length(); i++){
	star+="*";
}
String zip = request.getParameter("zip");
String addr1 = request.getParameter("addr1");
String addr2 = request.getParameter("addr2");
String addr = addr1+"-"+addr2;
String tel = request.getParameter("tel");
String email= request.getParameter("email");
String [] fas = request.getParameterValues("fa");
String fa = fas[0];
for(int i=1; i<fas.length; i++){
	fa+=","+fas[i];
}
String job = request.getParameter("job");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>입력결과출력</h2><p/>
<strong>성명:<%=name%></strong> <p/>
<strong>아이디:<%=userid%></strong> <p/>
<strong>비번:<%=star%></strong><p/>
<strong>우편번호:<%=zip%></strong><p/>
<strong>주소:<%=addr%></strong> <p/>
<strong>전화번호:<%=tel%> </strong><p/>
<strong>이메일:<%=email%></strong> <p/>
<strong>관심분야 :<%=fa%></strong> <p/>
<strong>직업:<%=job%> </strong><p/>

<form action="userinfo_edit.jsp">

<input type="hidden"  name = "name" value=<%=name%>>
<input type="hidden"  name = "userid" value=<%=userid%>>
<input type="hidden"  name = "passwd" value=<%=passwd%>>
<input type="hidden"  name = "zip" value=<%=zip%>>
<input type="hidden"  name = "addr1" value=<%=addr1%>>
<input type="hidden"  name = "addr2" value=<%=addr2%>>
<input type="hidden"  name = "tel" value=<%=tel%>>
<input type="hidden"  name = "email" value=<%=email%>>
<input type="hidden"  name = "fa" value=<%=fa%>>
<input type="hidden"  name = "job" value=<%=job%>>

<input type="submit" value="수정">

</form>
<p/>
</body>
</html>