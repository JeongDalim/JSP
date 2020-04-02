<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,java.sql.*,Jdbc_0529_Guest_Bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
int num = Integer.parseInt(request.getParameter("num"));
%>
<%
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "JSLDB";
	String password = "6007";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	BoardBean bb = null;

	try {
		Class.forName(myDriver);
		//out.print("드라이버 성공");
	} catch (Exception e) {
		out.print(e);
		out.print("드라이버 실패");
	}
	try {
		conn = DriverManager.getConnection(url, user, password);
		String sql1= "update board set readcnt=readcnt+1 where num="+num;
		ps = conn.prepareStatement(sql1);
		rs = ps.executeQuery();
		//out.print("커넥션 성공");
		String sql2 = "select * from board where num="+num;
		ps = conn.prepareStatement(sql2);
		rs = ps.executeQuery();
		while (rs.next()) {
			bb = new BoardBean();
			bb.setNum(rs.getInt("num"));
			bb.setName(rs.getString("name"));
			bb.setPass(rs.getString("pass"));
			bb.setIndate(rs.getString("indate"));
			bb.setEmail(rs.getString("email"));
			bb.setSubject(rs.getString("subject"));
			bb.setContents(rs.getString("contents"));
			bb.setReadcnt(rs.getInt("readcnt"));
		}
	} catch (Exception e) {
		out.print(e);
		out.print("커넥션 실패");
	} finally {
		try {

		} catch (Exception e) {
		}
	}
	request.setAttribute("bb", bb);
%>
 <html>
 <head><meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
   <title>게시판 내용 보기</title>
   <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>

 </head>
 <body topmargin="0" leftmargin="0">
   <table border="0" width="800">
     <tr>
       <td width="20%"  height="500" bgcolor="#ecf1ef" valign="top">

		 <!--  다음에 추가할 부분 -->

	   </td>
       <td width="80%" valign="top">&nbsp;<br>
         <table border="0" width="90%" align="center">
           <tr>
             <td colspan="2"><img src="./img/bullet-01.gif"> 
              <font color="blue" size="3">자 유 게 시 판</font><font size="2"> - 글읽기</font></td>
           </tr>
         </table>
       <p>
       <table border="0" width="90%" align="center" cellspacing="0"  style="border-width:1px;border-color:#0066cc;border-style:outset;">
         <tr bgcolor="e3e9ff">
           <td class="title">
             <img src="./img/bullet-04.gif"> <font size="2" face="돋움">
                  ${bb.subject }</font>
           </td>
         </tr>
         <tr>
           <td class="content">
             <p align="right"><font size="2" face="돋움">
              <a class="list" href="mailto:ein1027@nate.com">${bb.name }</a> / <font size="2" face="돋움">${bb.indate } / ${bb.readcnt }번 읽음</font>
             <p>
            ${bb.contents }<p><!--contents의 내용을 <BR>태그로 처리-->
           </td>
         </tr>
       </table>
  
      <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 답변, 수정, 삭제, 목록보기 ****-->
      <p align="center">
      <font size="2">
       <!-- 새글쓰기 -->
       <a href="">
       <img src="./img/write.jpg" border="0"></a>&nbsp;&nbsp;
	   <!-- 답글쓰기 -->
       <a href="">
       <img src="./img/reply.gif" border="0"></a>&nbsp;&nbsp;
	   <!-- 수정하기 -->
       <a href="board_modify.jsp?num=${bb.num}"><img src="./img/edit.gif" border="0"></a>&nbsp;&nbsp;
         <!-- 삭제하기 -->
       <a href="board_delete.jsp?num=${bb.num }&pass=${bb.pass}"><img src="./img/del.gif" border="0"></a>&nbsp;&nbsp;
       <!-- 목록보기 -->
       <a href="board_list.jsp"><img src="./img/list-2.gif" border="0"></a>&nbsp;&nbsp;
      </font>
    </td>
  </tr>
  </table>
  </body>
  </html>