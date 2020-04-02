<%@ page import="Jdbc_0530_Board_Bean.*,java.sql.*"
	contentType="text/html; charset=UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
%>

<%
	BoardManager mananger = BoardManager.getInstance();
	int result = mananger.modify(num, subject, contents);
	if (result != 0) {
%>
<script>
	alert("수정 성공");
	location.href = "borad_list.jsp";
</script>

<%
	} else {
%>
<script>
	alert("수정실패! 관리자에게 문의하세요");
	history.back();
</script>
<%
	}
%>