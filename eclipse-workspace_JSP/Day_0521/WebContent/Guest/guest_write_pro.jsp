<%@ page import="day_0521_guest_vo.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="guest" class="day_0521_guest_vo.GuestBean">
<jsp:setProperty name="guest" property="*"></jsp:setProperty>
<%-- <jsp:setProperty name="guest" property="readcnt" value="1"></jsp:setProperty> --%>
</jsp:useBean> 
<%

String[] kinds =request.getParameterValues("kind");
String kind = kinds[0];
for(int i=1; i<kinds.length; i++){
	kind+=","+kinds[i];
	
}
guest.setKind(kind);
request.setAttribute("guest", guest);
RequestDispatcher rd = request.getRequestDispatcher("guest_edit.jsp");
rd.forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
자바 빈즈를 이용한 출력<p/>
공개여부: <%=guest.getOpen() %><p/>
이름 : <%=guest.getName() %><p/>
글종류: <%=guest.getKind() %><p/>
제목 : <%=guest.getSubject() %><p/>
내용 : <%=guest.getContent() %><p/>
</body>
</html>