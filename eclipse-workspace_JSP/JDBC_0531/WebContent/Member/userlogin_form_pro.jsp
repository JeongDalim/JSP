<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="jdbc_0531_member.*"%>
<%
	String userid = null;
	if (request.getParameter("userid") != null) {
		userid = request.getParameter("userid");
	}
	String passwd = null;
	if (request.getParameter("passwd") != null) {
		passwd = request.getParameter("passwd");
	}
	MemberManager mm = MemberManager.getInstance();
	MemberBean mb = mm.mb2(userid,passwd);
	request.setAttribute("mb", mb);
if(mb==null){
%>
<script>
alert("아이디 혹은 비밀번호가 맞지 않습니다. 다시 입력해 주십시오");
history.back();
</script>
<%}else{%>
<script>
alert("로그인 성공!");
location.href="userlogin_ok.jsp?userid="+'${mb.userid}';
</script>
<%}%>