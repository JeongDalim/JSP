<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jdbc_0531_member.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String userid = request.getParameter("userid");
	MemberManager mm = MemberManager.getInstance();
	int result = mm.delete(userid);
	if (result == 0) {
%>
<script>
	alert("삭제실패!");
	history.back();
</script>
<%
	} else {
%>
<script>
	alert("삭제성공!");
	location.href = "userinfo_list.jsp";
</script>
<%
	}
%>