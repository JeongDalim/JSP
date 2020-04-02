<%@ page import="jdbc_0531_member.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="mb" class="jdbc_0531_member.MemberBean">
	<jsp:setProperty name="mb" property="*"></jsp:setProperty>
</jsp:useBean>
<%
	String[] fa = request.getParameterValues("favorite");
	String favorite = "";
	if (fa != null) {
		for (int i = 0; i < fa.length; i++) {
			favorite += fa[i];
			if (i != fa.length - 1)
				favorite += ",";
		}
	}
	MemberManager mm = MemberManager.getInstance();
	mb.setFavorite(favorite);
	int result = mm.modify(mb);

	if (result != 0) {
%>
<script>
	alert("수정완료");
	location.href = "userinfo_list.jsp";
</script>
<%
	} else {
%>
<script>
	alert("실패");
	history.back();
</script>
<%
	}
%>