<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userid = null;
	if (request.getParameter("userid") != null) {
		userid = request.getParameter("userid");
	}

	session.setAttribute("userid", userid);
	session.setMaxInactiveInterval(60 * 30);
%>
<script type="text/javascript">
	function delete_check() {
		if (confirm("정말 삭제하시겠습니까?")) {
		location.href = "delete.jsp?userid=${userid}";
			
		}
	}
</script>
<HTML>

<TITLE>본 사이트에 오신 것을 환영합니다..</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<STYLE TYPE="text/css">
<!--
body {
	font-family: 돋움, Verdana;
	font-size: 9pt
}

td {
	font-family: 돋움, Verdana;
	font-size: 9pt;
	text-decoration: none;
	color: #000000
}
-->
</STYLE>
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
	<TR BGCOLOR=#7AAAD5>
		<td align=left><img src=./img/h_b02.gif></td>
		<td align=center><FONT COLOR="#FFFFFF"><b>로그인 성공</b></FONT></td>
		<td align=right><img src=./img/f_b03.gif></td>
	</tr>
</table>
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
	<TR BGCOLOR=#948DCF>
		<TD>
			<TABLE CELLPADDING=4 CELLSPACING=1 BORDER=0 WIDTH=330>
				<TR BGCOLOR="#FFFFFF">
					<TD ALIGN="center">${userid}님 환영합니다.<br>
					<br>
					</TD>
				</TR>
			</TABLE>
		</TD>
	</TR>
</TABLE>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
	<TR BGCOLOR=#7AAAD5>
		<td align=left><img src=./img/h_b04.gif></td>
		<td align=right><img src=./img/h_b05.gif></td>
	</tr>
</table>

<br>
<br>
<table cellpadding=0 cellspacing=0 border=0 width=330>
	<tr>
		<td align="center"><a href="userinfo_modify.jsp?userid=${userid}">[자기정보수정]</a>
			<a href="logout_pro.jsp">[로그아웃]</a> <a href="#" onClick="delete_check()">[회원삭제]</a>
		</td>
	</tr>
</table>

</BODY>
</HTML>