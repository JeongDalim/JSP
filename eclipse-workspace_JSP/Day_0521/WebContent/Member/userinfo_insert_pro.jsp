<%@ page import="day_0521_member_vo.MemberBean" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String[] favorites = request.getParameterValues("fa");
String favorite = favorites[0];
for(int i=1; i<favorites.length; i++){
	favorite+=","+favorites[i];	
}
String zipcode = request.getParameter("zip");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="member" class="day_0521_member_vo.MemberBean">

<jsp:setProperty name="member" property="*"></jsp:setProperty>

</jsp:useBean>
<body>
<%
member.setZipcode(zipcode);
member.setFavorite(favorite);
%>
이름:<%=member.getName() %><p/>
아이디:<%=member.getUserid() %><p/>
비번:<%=member.getPasswd() %><p/>
주소:<%=member.getZipcode() %>-<%=member.getAddr1()%>-<%=member.getAddr2()%><p/>
전화:<%=member.getTel() %><p/>
이메일:<%=member.getEmail() %><p/>
직업:<%=member.getJob() %><p/>
자기소개:<%=member.getIntro() %><p/>
관심분야:<%=member.getFavorite() %><p/>
</body>
</html>