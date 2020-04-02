<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>공지사항 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
body, td, th {
	font-size: 12px;
	color: #606060;
}

body {
	margin-left: 0px;
	margin-top: 0px;
}
-->
</style>
<script>
	function modify_check() {
		alert("test");
		if (my.subject.value == "") {
			alert("제목을 입력해 주십시오.");
			my.subject.focus();
			return;
		}
		if (my.contents.value == "") {
			alert("내용을 입력해 주십시오.");
			my.contents.focus();
			return;
		}
		my.submit();
	}
</script>
</head>
<body>
	<form name="my" method="post" action="NoticeServlet">
		<input type="hidden" name="idx" value="${vo.idx }"> <input
			type="hidden" name="cmd" value="notice_modify_pro">

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><jsp:include page="../include/top_menu.jsp" flush="true" /></td>
			</tr>
			<tr>
				<td align="center" height="100%" valign=middle><br>
					<table width="30%" border="1" cellspacing="0" cellpadding="3"
						bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
						<tr>
							<td height=40 align="center" style="font-size: 15px;"><b>공지사항
									수정</b></a> </b></td>
						</tr>
					</table> <br>
					<table width="60%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="6"
									cellspacing="1" bgcolor="DDDDDD">
									<tr>
										<td width="20%" align="center" bgcolor="EcECEC"><strong>제목</strong></td>
										<td bgcolor="ffffff"><input name="subject" type="text"
											value="${vo.contents }"
											style="width: 450; height: 18; padding: 2; border: 1 solid slategray"
											size="120"></td>
									</tr>
									<tr bgcolor="EcECEC">
										<td align="center" bgcolor="EcECEC"><strong>내용</strong></td>
										<td bgcolor="ffffff"><textarea name="contents" cols="10"
												rows="10"
												style="width: 490; height: 200; padding: 2; border: 1 solid slategray"
												tabindex="2">${vo.contents }</textarea></td>
									</tr>
								</table></td>
						</tr>
					</table> <br>
					<table width="60%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td align=center><a href="#" onClick="modify_check()"><b>[수정]</b></a>&nbsp;
								<a href="#" onClick="javascript:reset()"><b>[취소]</b></a></td>
						</tr>
					</table>
					</form>
</body>
</html>
