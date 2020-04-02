<%@ page contentType="text/html; charset=UTF-8" %>

   <head><title>게시판 수정</title>
    <link rel="stylesheet" type="text/css" href="/stylesheet.css">
<script>
function go(){
	if(f.name.value==""){
		alert("이름은 필수입력입니다.");
		f.name.focus();
		return;
	}
	if(f.subject.value==""){
		alert("제목은 필수입력입니다.");
		f.subject.focus();
		return;
	}
	if(f.contents.value==""){
		alert("내용은 필수입력입니다.");
		my.contents.focus();
		return;
	}
     if(f.pass.value==""){
	alert("비밀번호는 필수입력입니다.");
	f.pass.focus();
	return;
    }

	if(f.pass.value=='${bean.pass}'){
		if(confirm("정말 수정하시겠습니까?")){
			f.action="board_modify_pro.do";
			f.submit();
		}
	}else{
		alert("비밀번호가 맞지 않습니다.");
		return;
	}
}

</script>
</head>

 <body topmargin="0" leftmargin="0">
 <table border="0" width="800">
 <tr>
   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">

   <!-- 다음에 추가할 부분 "-->

   </td>
   <td width="80%" valign="top">&nbsp;<br>
     <img src="./img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>자 유 게 시 판</b></font>
     <font size="2"> - 수정하기</font><p>
     <img src="./img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="./img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     <form name ="f" method="post" >
      <input type="hidden" name="num" value="${bean.num }">
      <table border="0">
       <tr>
         <td width="5%" align="right"><img src="./img/bullet-02.gif"></td>
         <td width="15%"><font size="2 face="돋움"">글쓴이</font></td>
         <td width="80%">
         <input type="text" size="20" name="name" value="${bean.name }" readonly></td>
       </tr>
       <tr>
         <td align="right">&nbsp;</td>
         <td ><font size="2 face="돋움"">메일주소</font></td>
         <td>
          <input type="text" size="20" name="email" value="${bean.email }"></td>
       </tr>
       <tr>
         <td align="right"><img src="./img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제 목</font></td>
         <td><input type="text" size="60" name="subject" value="${bean.subject }"></td>
       </tr>
       <tr>
         <td align="right"><img src="./img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" name="contents" cols="60" >${bean.contents }</textarea></td>
       </tr>
       <tr>
         <td align="right"><img src="./img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">비밀번호</font></td>
          <td><input type="password" size="10" name="pass" >
		  <font size="2" face="돋움">*.수정과 삭제시 꼭 입력하셔야 합니다.</font></td>
        </tr>
        <tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td><a href="#" onClick="go()"><img src="./img/edit2.gif" border=0></a>&nbsp;
          <a href="board_list.do"><img src="./img/cancle.gif" border=0></a></td></tr>
      </table>
      </form>
    </td></tr>
  </table>
  </body>
  </html>
