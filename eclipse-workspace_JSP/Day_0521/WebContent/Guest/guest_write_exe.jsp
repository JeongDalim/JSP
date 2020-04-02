<%@ page import="day_0521_guest_vo.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String open = request.getParameter("open");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String[] kinds = request.getParameterValues("kind");
	String kind = kinds[0];
	for (int i = 1; i < kinds.length; i++) {
		kind += "," + kinds[i];	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function send(){
	fname.submit();
}
</script>
</head>
<body>
	<form name="fname" method="post" action="guest_edit.jsp">
		기존 출력 <br> 
		공개여부 :<%=open%><br> 
		이름 :<%=name%><br>
		글종류:<%=kind%><br> 
		제목 : <%=subject%><br> 
		내용:<%=content%><br>
		<input type="hidden" name=open value=<%=open%>>
		<input type="hidden" name=name value=<%=name%>>
		<input type="hidden" name=kind value=<%=kind%>>
		<input type="hidden" name=subject value=<%=subject%>>
		<input type="hidden" name=content value=<%=content%>>
		 <a href="#" onClick="send()">수정하기</a> 
	</form>
</body>
</html>