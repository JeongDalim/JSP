<%@ page contentType="text/html; charset=UTF-8" %>
<%
if(request.getParameter("err")!=null){
	String err = request.getParameter("err");
	if(err.equals("1")){
%>
<script>
alert("삭제실패했습니다. 비밀번호를 확인해주세요");
location.href="board_list.do";
</script>
<%
	}
}
%>
<html>
<head><title>방명록 삭제</title>
 <link rel="stylesheet" type="text/css" href="/stylesheet.css">
 <script>
 function check(){
	 if(form.pass.value==""){
		 alert("비밀번호를 입력해주세요.")
		 form.pass.focus();
		 return;
	 }
	 form.submit();
 }
 </script>
 </head>
 <body>
 <form method="post" name="form" action="BoardServlet">
   <table border="0" cellpadding="0" cellspacing="0" width="300" align="center">
     <tr>
       <td height="50">
       <img src="Board/img/bullet-05.gif"><b><font size="3" color="red">잠깐 !!</font></b></td></tr>
     <tr>
       <td valign="middle" height="30">
       <font size="2" face="돋움">게시물은 작성하신 분만 삭제할 수 있습니다.<br>
       글작성시 입력한 비밀번호를 입력해 주세요...</font></td></tr>
     <tr>
       <td valign="middle" height="40">
       <font size="2" face="돋움">
       비밀번호 <input type="password" name="pass" size="8"></font>
       <input type="hidden" name="cmd" value="board_delete_pro">
       <input type="hidden" name="num" value="${num }">
       <input type="hidden" name="page" value="${nowpage }">
       
       <a href="javascript:check()"><input type="button" value="삭제"></a>
       <a href="javascript:history.back()"><input type="button" value="닫기"></a></td></tr>
   </table>
   </form>
 </body>
 </html>
