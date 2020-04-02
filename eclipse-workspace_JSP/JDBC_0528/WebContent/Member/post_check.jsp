<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="dbconn.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
	String addr = null;
	if (request.getParameter("addr") != null) {
		addr = request.getParameter("addr");
	}
%>
<%
	try {
		Class.forName(myDriver);
	} catch (Exception e) {
		out.print(e);
		out.print("드라이버 연결 실패");
	}
	String sql = "select * from zipcode where dong =?";
	String sql2 = "select * from zipcode where dong like '%" + addr + "%'";
	try {
		myConn = DriverManager.getConnection(myUrl, myID, myPass);
		ps = myConn.prepareStatement(sql2);
		//ps.setString(1, addr);
		rs = ps.executeQuery();
		while (rs.next()) {
			out.print(rs.getString("zipcode") + " ");
			out.print(rs.getString("sido") + " ");
			out.print(rs.getString("gugun") + " ");
			out.print(rs.getString("dong") + " ");
			out.print(rs.getString("bunji") + "<br>");
		}
	} catch (Exception e) {
		out.print(e);
		out.print("커넥션 연결 실패");
	} finally {
		try {
			myConn.close();
		} catch (Exception e) {
			out.print(e);
		}
	}
%>
<HTML>
<HEAD>
<TITLE>우편번호 찾기</TITLE>

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

a {
	font-family: 돋움, Verdana;
	color: #000000;
	text-decoration: none
}

a:link {
	font-family: 돋움;
	font-size: 9pt;
	text-decoration: none
}

a:visited {
	font-family: 돋움;
	font-size: 9pt;
	text-decoration: none
}

a:hover {
	font-family: 돋움;
	text-decoration: underline
}
-->
</STYLE>
<script type="text/javascript">
	function check() {
		if (inquiry.addr.value == "") {
			alert("동 이름 입력");
			inquiry.addr.focus();
			return false;
		}
	}
</script>
</HEAD>

<BODY BGCOLOR="#FFFFFF" onLoad="document.inquiry.addr.focus();">
	<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
		<TR BGCOLOR=#7AAAD5>
			<td align=left><img src="./img/u_b02.gif"></td>
			<td align=center><FONT COLOR="#FFFFFF"><b>우편번호 찾기</FONT></td>
			<td align=right><img src="./img/u_b03.gif"></td>
		</tr>
	</table>

	<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
		<TR>
			<TD BGCOLOR=#948DCF>
				<TABLE CELLPADDING=0 CELLSPACING=1 BORDER=0 WIDTH=330>
					<TR>
						<TD>
							<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=3 WIDTH=100%
								BGCOLOR=#FFFFFF>
								<FORM NAME="inquiry" METHOD="post" ACTION="post_check.jsp"
									onSubmit="return check();">
									<TR>
										<TD ALIGN=CENTER><br> 동이름 입력 : <INPUT NAME="addr"
											TYPE="text" style="width: 120"> <INPUT TYPE="image"
											src="./img/u_bt08.gif" hspace=10></TD>
									</TR>
									<TR>
										<TD ALIGN=CENTER>※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.</TD>
									</TR>
									<TR>
										<TD>123-123 대전광역시 중구 도마동 123</TD>
									</TR>
									<TR>
										<TD>123-123 대전광역시 중구 도마동 123</TD>
									</TR>
									<TR>
										<TD>123-123 대전광역시 중구 도마동 123</TD>
									</TR>

								</FORM>
							</TABLE>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>

	<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
		<TR BGCOLOR=#7AAAD5>
			<td align=left><img src="./img/u_b04.gif"></td>
			<td align=right><img src="./img/u_b05.gif"></td>
		</tr>
		<tr>
			<td colspan=2 align=center><img src="./img/u_bt13.gif" border=0
				vspace=5></td>
		</tr>
	</table>
</BODY>
</HTML>
