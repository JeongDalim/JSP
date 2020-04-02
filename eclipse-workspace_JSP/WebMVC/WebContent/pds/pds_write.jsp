<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>협력업체 관리 - 관리자페이지</title>
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
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td><jsp:include page="../include/top_menu.jsp" flush="true" /></td>
		</tr>
		<tr>
			<td align="center" height="100%" valign=middle><br>
				<table width="30%" border="1" cellspacing="0" cellpadding="3"
					bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
					<tr>
						<td height=40 align="center" style="font-size: 15px;"><b>다운로드자료</b></a>
							</b></td>
					</tr>
				</table> <br>
				<form name="my" method="post" action="PdsServlet?cmd=pds_write_pro"
					enctype="multipart/form-data">
					<table width="60%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="6"
									cellspacing="1" bgcolor="DDDDDD">
									<tr>
										<td width="20%" align="center" bgcolor="EcECEC"><strong>이름</strong></td>
										<td bgcolor="ffffff"><input name="name" type="text"
											style="width: 350; height: 18; padding: 2; border: 1 solid slategray"
											size="120"></td>
									</tr>
									<tr>
										<td width="20%" align="center" bgcolor="EcECEC"><strong>제목</strong></td>
										<td bgcolor="ffffff"><input name="subject" type="text"
											style="width: 350; height: 18; padding: 2; border: 1 solid slategray"
											size="120"></td>
									</tr>
									<tr bgcolor="EcECEC">
										<td align="center" bgcolor="EcECEC"><strong>내용</strong></td>
										<td bgcolor="ffffff"><textarea name="contents" cols="62"
												rows="10" class="textfield"></textarea></td>
									</tr>
									<tr bgcolor="EcECEC">
										<td align="center" bgcolor="EcECEC"><strong>첨부파일</strong></td>
										<td bgcolor="ffffff"><input type="file" name="filename"></td>
									</tr>
									<tr>
										<td width="20%" align="center" bgcolor="EcECEC"><strong>비밀번호</strong></td>
										<td bgcolor="ffffff"><input name="pass" type="password"
											style="width: 350; height: 18; padding: 2; border: 1 solid slategray"
											size="120"></td>
									</tr>
									<tr>
										<td width="20%" align="center" bgcolor="EcECEC"><strong>비밀번호
												확인</strong></td>
										<td bgcolor="ffffff"><input name="repass" type="password"
											style="width: 350; height: 18; padding: 2; border: 1 solid slategray"
											size="120"></td>
									</tr>
								</table></td>
						</tr>
					</table>
				</form> <br>
				<table width="60%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align=center><a href="#" onClick="javascript:my.submit()"><b>[등록]</b></a>&nbsp;
							<a href="#" onClick="javascript:my.reset()"><b>[취소]</b></a></td>
					</tr>
				</table>
</body>
</html>
