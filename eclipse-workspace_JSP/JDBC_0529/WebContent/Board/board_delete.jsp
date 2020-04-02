<%@ page contentType="text/html; charset=UTF-8" %>
<%
int num = Integer.parseInt(request.getParameter("num"));
String pass = request.getParameter("pass");
%>
<html>
<head><title>방명록 삭제</title>
 <link rel="stylesheet" type="text/css" href="/stylesheet.css">
 <script type="text/javascript">
 function check(){
	 if(bform.pass.value==""){
		 alert("비밀번호를 입력해 주십시오.");
		 bform.pass.value.focus();
	 }
	 if(bform.pass.value=="<%=pass%>") {
		 alert("삭제성공");
		 bform.action="board_delete_pro.jsp?num="+"<%=num%>";
		 bform.submit();
/* 		 if(confirm("삭제하시겠습니까?")){
			 alert("d");
		 }else{
			 alert("리스트로 돌아갑니다.");
			 location href="board_list.jsp";
		 } */
	 }else{
		 alert("비밀번호가 틀립니다. 다시 입력해 주십시오.");
		 bform.pass.value.focus();
	 }
 }
 </script>
 </head>
 <body>
 <form name="bform" method="post">
   <table border="0" cellpadding="0" cellspacing="0" width="300" align="center">
     <tr>
       <td height="50">
       <img src="./img/bullet-05.gif"><b><font size="3" color="red">잠깐 !!</font></b></td></tr>
     <tr>
       <td valign="middle" height="30">
       <font size="2" face="돋움">게시물은 작성하신 분만 삭제할 수 있습니다.<br>
       글작성시 입력한 비밀번호를 입력해 주세요...</font></td></tr>
     <tr>
       <td valign="middle" height="40">
       <font size="2" face="돋움">
       비밀번호 <input type="password" name="pass" size="8"></font>
       <a href="#" onClick="check()"><input type="submit" value="삭제"></a>
       <input type="button" value="닫기"></td></tr>
   </table>
   </form>
 </body>
 </html>
