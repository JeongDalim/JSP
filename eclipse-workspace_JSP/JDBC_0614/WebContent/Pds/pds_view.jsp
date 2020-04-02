<%@ page contentType="text/html; charset=UTF-8" %>

<html>
   <head>
      <title> 게시판 내용 보기 </title>
 <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>
 </head>
   <!--DB에서 검색한 자료를 화면에 출력  -->
 <body topmargin="0" leftmargin="0">
 <table border="0" width="800">
   <tr>
     <td width="20%"  height="500" bgcolor="#ecf1ef" valign="top">

<!--  로그인 폼 추가 -->

     </td>
     <td width="80%" valign="top">
       &nbsp;<br>
     <table border="0" width="90%" align="center">
       <tr>
         <td colspan="2"><img src="./img/bullet-01.gif"> 
           <font color="blue" size="3">참 좋은 자료실</font><font size="2"> - 자료읽기</font></td>
       </tr>
     </table>
     <p>

     <table border="0" width="90%" align="center" cellspacing="0" style="border-width:1px;border-color:#0066cc;border-style:outset;">
       <tr bgcolor="e3e9ff">
         <td class="title">
           <img src="./img/bullet-04.gif">   
           <font size="2" face="돋움">${bean.subject }
           </font></td></tr>
  <tr>  
    <td class="content">
    <p align="right"><font size="2" face="돋움">  
			${bean.name } / ${bean.indate } / ${bean.readcnt }번 읽음
    <p>${bean.contents }<p>
    <img src="./img/disk.gif" align="middle" width="22" height="20" border="0">&nbsp;<a href="filedown.do?filename=${bean.filename }">${bean.filename }</a>
	
	</font></td></tr>
  </table>
  <p align="center">
  <font size="2">
  <a href="modify.do"><img src="./img/edit-1.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="delete.do"><img src="./img/del.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="list.do"><img src="./img/list-2.gif" border="0"></a></font></td></tr>  
</table>  
</body>  
</html>


</body>
</html>