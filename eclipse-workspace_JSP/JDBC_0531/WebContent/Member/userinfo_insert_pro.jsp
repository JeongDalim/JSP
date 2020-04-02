<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jdbc_0531_member.*,jdbc_0531_util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="mb" class="jdbc_0531_member.MemberBean">
	<jsp:setProperty name="mb" property="*"></jsp:setProperty>
</jsp:useBean>
<%
	String[] fa = request.getParameterValues("fa");
	String favorite = "";
	if (fa != null) {
		for (int i = 0; i < fa.length; i++) {
			favorite += fa[i];
			if (i != fa.length - 1)
				favorite += ",";
		}
	}
	mb.setFavorite(favorite);
	MemberManager mm = MemberManager.getInstance();
	int result = mm.write(mb);
	if (result != 0) {
%>
<script>
	alert("등록성공!");
	location.href = "userinfo_list.jsp";
</script>
<%
	} else {
%>
<script>
	alert("등록실패!");
	history.back();
</script>
<%
	}
%>