<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,java.sql.*,Jdbc_0530_Board_Bean.*"%>
<%
	String name = request.getParameter("name");
	String email = "";
	if (request.getParameter("email") != null) {
		email = request.getParameter("email");
	}
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	String pass = request.getParameter("pass");
	int readcnt = 0;

	BoardManager manager = BoardManager.getInstance();
	int result = manager.write(name, email, subject, contents, pass, readcnt);
	if (result != 0) {
%>
<script type="text/javascript">
	alert("등록되었습니다.");
	location.href = "board_list.jsp";
</script>
<%
	} else {
%>
<script type="text/javascript">
	alert("등록에 실패하였습니다.\n 다음에 다시 등록해 주세요.");
	history.back();
</script>
<%
	}
%>