<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*,Jdbc_0530_Board_Bean.*"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
<%
	BoardManager manager = BoardManager.getInstance();
	int result = manager.delete(num);
	if (result != 0) {
%>
<script>
	alert("삭제 성공");
	location.href = "board_list.jsp";
</script>
<%
	} else {
%>
<script>
	alert("삭제 실패! 관리자에게 문의하세요.");
</script>
<%
	}
%>