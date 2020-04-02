<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>공지사항 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
body, td, tr, table {
	font-size: 9pt;
	font-family: tahoma;
	color: #666666;
	line-height: 160%;
}

A:link {
	font-family: tahoma;
	font-size: 9pt;
	color: #666666;
	text-decoration: none;
}

A:visited {
	font-family: tahoma;
	font-size: 9pt;
	color: #666666;
	text-decoration: none;
}

A:active {
	font-family: tahoma;
	font-size: 9pt;
	color: #666666;
	text-decoration: none;
}

A:hover {
	font-family: tahoma;
	font-size: 9pt;
	color: #009900;
	text-decoration: underline;
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
						<td height=40 align="center" style="font-size: 15px;"><b>공지사항
						</b></a> </b></td>
					</tr>
				</table> <br>
				<table width="80%" border="0" cellspacing="0" cellpadding="0">

					<tr>
						<td height="20">* 총 등록수 : <font color=red>${list.size() }</font>
							건
						</td>
					</tr>
					<tr>
						<td><table width="100%" border="0" cellpadding="6"
								cellspacing="1" bgcolor="DDDDDD">
								<tr bgcolor="EcECEC">
									<td width="15%" align="center" bgcolor="EcECEC"><strong>번호</strong></td>
									<td align="center" bgcolor="EcECEC"><strong>제목</strong></td>
									<td width="20%" align="center"><strong>접수일</strong></td>
									<td width="10%" align="center"><strong>조회수</strong></td>
								</tr>
								<c:if test="${!empty list}">
									<c:set var="bunho" value="${list.size() }"></c:set>
									<c:forEach var="vo" items="${list }">
										<tr>
											<td align="center" bgcolor="#FFFFFF">${bunho }</td>
											<td bgcolor="#FFFFFF"><a
												href="NoticeServlet?cmd=notice_view&idx=${vo.idx }" class="unnamed1">${vo.subject }</a></td>
											<td align="center" bgcolor="#FFFFFF">${vo.regdate }</td>
											<td align="center" bgcolor="#FFFFFF">${vo.readcnt }</td>
										</tr>
										<c:set var="bunho" value="${bunho-1 }"></c:set>
									</c:forEach>
								</c:if>
								<tr>
									<td height="35" colspan="10" align="center" bgcolor="#FFFFFF">[1][2][3]</td>
								</tr>
								<form action="notice.jsp" method="post" name="b_search">
									<tr>
										<td colspan="10" align="center" bgcolor="#FFFFFF"><table
												width="610" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width=80% height="30" colspan="2" align="right"><select
														name="search" class="textfield">
															<option>제목</option>
													</select> <input name="key" type="text" class="textfield" size="30"
														value=""></td>
													<td width=20% align="right"><a href=""><b>[검색]</b></a>
														&nbsp;<a href="NoticeServlet?cmd=notice_write"><b>[글쓰기]</b></a></td>
												</tr>
											</table></td>
									</tr>
									<!-- 리스트가 없을때 -->
							</table> <c:if test="${empty list}">
								<tr>
									<td height="20">* 총 등록수 : <font color=red>${list.size() }</font>
										건
									</td>
								</tr>
								<tr>
									<td><table width="100%" border="0" cellpadding="6"
											cellspacing="1" bgcolor="DDDDDD">
											<tr bgcolor="EcECEC">
												<td width="15%" align="center" bgcolor="EcECEC"><strong>번호</strong></td>
												<td align="center" bgcolor="EcECEC"><strong>제목</strong></td>
												<td width="20%" align="center"><strong>접수일</strong></td>
												<td width="10%" align="center"><strong>조회수</strong></td>
											</tr>
											<tr>
												<td align="center" bgcolor="#FFFFFF" colspan="4">등록된
													공지사항이 없습니다.</td>
											</tr>
											<tr>
												<td height="35" colspan="10" align="center"
													bgcolor="#FFFFFF">[1]</td>
											</tr>

										</table>
							</c:if>
</body>
</html>
