<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원등록</title>
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
	color: #000000;
	BACKGROUND-POSITION: left top;
	BACKGROUND-REPEAT: no-repeat;
}

-->
.formbox {
	BACKGROUND-COLOR: #F0F0F0;
	FONT-FAMILY: "Verdana", "Arial", "Helvetica", "돋움";
	FONT-SIZE: 9pt
}
-
-->
</STYLE>
<script type="text/javascript">
function id_check(){
	if(fname.userid.value==""){
		alert("ID는 빈칸없이 입력하세요."); 
		fname.userid.focus();
		return;
	}else if(fname.userid.value.length < 5 || fname.userid.value.length > 15){
		alert("5~16자 이내의 영문이나 숫자만 가능합니다. 다시입력해 주십시오.");
		fname.userid.focus();
		return;	
	}else if(a_or_d(fname.userid.value)){
		alert("5~16자 이내의 영문이나 숫자만 가능합니다. 다시입력해 주십시오.");
		fname.userid.focus();
		return;	
	}else{
		window.open("id_check.jsp?userid="+fname.userid.value);
	}
}
function insert_check(){
	if(fname.name.value==""){
		alert("성명는 빈칸없이 입력하세요."); 
		fname.name.focus();
		return;
	}
	if(fname.userid.value==""){
		alert("ID는 빈칸없이 입력하세요."); 
		fname.userid.focus();
		return;
	}
	if(fname.passwd.value==""){
		alert("비밀번호는 빈칸없이 입력하세요.");
		fname.passwd.focus();
		return;
	}else if(fname.passwd.value.length < 5 || fname.passwd.value.length > 11){
		alert("5~12자 이내의 영문이나 숫자만 가능합니다. 다시입력해 주십시오.");
		form.passwd.focus();
		return;
	}else if(fname.passwd.value != fname.repasswd.value){
		alert("비밀번호가 다릅니다. 다시입력해 주십시오.");
		fname.passwd.focus();
		return;
	}
	if(fname.tel.value==""){
		alert("전화번호는 빈칸없이 입력하세요.");
		fname.tel.focus();
		return;
	} 
	var sw=0;
	for(i=0; i<fname.fa.length; i++){
		if(fname.fa[i].checked){
			sw=1;
			}
		}
	if(sw==0){
		alert("관심분야를 1개 이상 선택하세요.");
		return;
		}
	if(fname.job.selectedIndex==0){
		alert("직업을 선택하세요");
		return;
		}
 
    if(!tel_check(fname.tel.value)){
    	alert("전화번호 형식 맞지 않습니다. 다시 입력해 주십시오.");
    	fname.tel.focus();
    	return;
    	}
    
    if(fname.addr1.value==""){
    	fname.addr1.value="";
    }
    var sw = 1;
    if(fname.email.value==""){
		fname.email.value="";
		sw=0;
	}
    if(sw==1){
    	if(!email_check(fname.email.value)){
    	alert("이메일 형식 맞지 않습니다. 다시 입력해 주십시오.");
    	fname.email.focus();
    	return;
    	}
    } 
    alert("등록성공!");
    fname.action="userinfo_list.jsp";
    fname.submit();
}
    
function insert_reset(){
	fname.reset();
	}
function a_or_d(str){
	var lower_str =str.toLowerCase(); //소문자로 변환
	for(i=0; i<lower_str.length; i++){
	var ch=lower_str.charAt(i);
	if(((ch<'a')||(ch>'z'))&&((ch<'0')||(ch>'9'))){ //영문자 및 숫자 이외에는 다 거르기
		return true;
		}
	}
	return false;
}

function tel_check(str){
	str= str.split("-").join('');
	var phone = /^(010[0-9]{8})$/; //전화번호 정규식
	return phone.test(str);
}

function email_check(str){
	var email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; //이메일 정규식
	return email.test(str);
}

function post_check(){
	window.open("post_check.jsp");
}

</script>
</head>

<body bgcolor="#FFFFFF" LEFTMARGIN=0 TOPMARGIN=0>

	<!-- 탑 메뉴 영역 삽입-->


	<table border="0" width="800">
		<tr>
			<td width="20%" bgcolor="#ecf1ef" valign="top"
				style="padding-left: 0;">
				<!--로그인 영역 삽입-->

			</td>
			<td width="80%" valign="top">&nbsp;<img src="./img/title1.gif"><br>
				<form name=fname method=post>
					<table border=0 cellpadding=0 cellspacing=0 border=0 width=730
						valign=top>
						<tr>
							<td align=center><br>
								<table cellpadding=0 cellspacing=0 border=0 width=650
									align=center>
									<tr>
										<td bgcolor="#7AAAD5">
											<table cellpadding=0 cellspacing=0 border=0 width=100%>
												<tr bgcolor=#7AAAD5>
													<td align=left BORDER="0" HSPACE="0" VSPACE="0"><img
														src="./img/u_b02.gif"></td>
													<td align=center bgcolor="#7AAAD5"><FONT
														COLOR="#FFFFFF"><b>사용자등록&nbsp;</b><font color=black>(</font><font
															color=red>&nbsp;*&nbsp;</font><font color=black>표시항목은
																반드시 입력하십시요.)</font></FONT></td>
													<td align=right BORDER="0" HSPACE="0" VSPACE="0"><img
														src="./img/u_b03.gif"></td>
												</tr>
											</table>
											<table cellpadding=3 cellspacing=1 border=0 width=100%>
												<tr>
													<td width=110 bgcolor=#EFF4F8>&nbsp;회원 성명<font
														color=red>&nbsp;*</font></td>
													<TD BGCOLOR=WHITE><input type=text name=name size=16
														maxlength=20 value="">성명은 빈칸없이 입력하세요.</td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;회원 ID<font color=red>&nbsp;*</font></td>
													<TD BGCOLOR=WHITE>
														<table cellspacing=0 cellpadding=0>
															<tr>
																<td align=absmiddle><input type=text name=userid
																	size=12 maxlength=16 value="" style="width: 120">
																</td>
																<td><a href="#" onClick="id_check()"><img
																		src="./img/u_bt01.gif" hspace=2 border=0 name=img1
																		align=absmiddle></a> 5~16자 이내의 영문이나 숫자만 가능합니다.</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호<font color=red>&nbsp;*</font></td>
													<TD BGCOLOR=WHITE><input type=password name=passwd
														size=8 maxlength=12 style="width: 80"> 6~12자 이내의
														영문이나 숫자만 가능합니다.</td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호확인<font color=red>&nbsp;*</font></td>
													<TD BGCOLOR=WHITE><input type=password name=repasswd
														size=8 maxlength=12 value="" style="width: 80">비밀번호
														확인을 위해서 비밀번호를 한번 더 입력해주세요.</td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;주소구분<font color=red>&nbsp;</font></td>
													<TD BGCOLOR=WHITE><input type=radio name=addr_gubun
														value="1" checked>직장(학교) <input type=radio
														name=addr_gubun value="2">자택</td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;우편번호<font color=red>&nbsp;</font></td>
													<TD BGCOLOR=WHITE>
														<table cellspacing=0 cellpadding=0>
															<tr>
																<td><input type=text name=zip size=6 maxlength=6 readonly>
																</td>
																<td><a href="#" onClick="post_check()"><img src="./img/u_bt07.gif" hspace=2 border=0
																	name=img2 align=absmiddle></a></td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;주소<font color=red>&nbsp;</font></td>
													<TD BGCOLOR=WHITE><input type=text name=addr1 size=50
														maxlength=100 value="" readonly></td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;나머지 주소<font color=red>&nbsp;</font></td>
													<TD BGCOLOR=WHITE><input type=text name=addr2 size=50
														maxlength=100 value=""></td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;전화번호<font color=red>&nbsp;*</font></td>
													<TD BGCOLOR=WHITE><input type=text name=tel size=13
														maxlength=13 value=""></td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;E-mail <font color=red>&nbsp;</font>
													</td>
													<td bgcolor=WHITE valign=middle><input type=text
														name=email size=30 maxlength=30 value=""></td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;관심분야 <font color=red>&nbsp;</font>
													</td>
													<td bgcolor=WHITE valign=middle><input type="checkbox"
														name="fa" value="건강" checked>건강
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
														type="checkbox" name="fa" value="문화예술">문화예술
														&nbsp;&nbsp; <input type="checkbox" name="fa" value="경제">경제
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="checkbox"
														name="fa" value="연예오락">연예오락 &nbsp; <input
														type="checkbox" name="fa" value="뉴스">뉴스 <br>
													<input type="checkbox" name="fa" value="여행레져">여행레져
														&nbsp;&nbsp; <input type="checkbox" name="fa" value="생활">생활
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
														type="checkbox" name="fa" value="스포츠">스포츠
														&nbsp;&nbsp; <input type="checkbox" name="fa" value="교육">교육
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
														type="checkbox" name="fa" value="컴퓨터">컴퓨터
														&nbsp;&nbsp; <input type="checkbox" name="fa" value="학문">학문
														&nbsp;&nbsp;</td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;직업<font color=red>&nbsp;</font></td>
													<TD BGCOLOR=WHITE><select name=job class="formbox">
															<option value="0">선택하세요 ---
															<option value="회사원">회사원
															<option value="연구전문직">연구전문직
															<option value="교수학생">교수학생
															<option value="일반자영업">일반자영업
															<option value="공무원">공무원
															<option value="의료인">의료인
															<option value="법조인">법조인
															<option value="종교,언론,에술인">종교.언론/예술인
															<option value="농,축,수산,광업인">농/축/수산/광업인
															<option value="주부">주부
															<option value="무직">무직
															<option value="기타">기타
													</select></td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;자기소개<font color=red>&nbsp;</font></td>
													<TD BGCOLOR=WHITE><textarea cols=65 rows=5
															name="intro"></textarea></td>
												</tr>
											</table>
											<table cellpadding=0 cellspacing=0 border=0 width=100%>
												<tr bgcolor=#7AAAD5>
													<td valign=bottom><img src="./img/u_b04.gif"
														align=left hspace=0 vspace=0 border=0></td>
													<td align=center></td>
													<td valign=bottom><img src="./img/u_b05.gif"
														align=right hspace=0 vspace=0 border=0></td>
												</tr>
												<tr bgcolor=#ffffff>
													<td colspan=3 align=center><a href="#"
														onClick="insert_check()"><img src="./img/u_bt06.gif"
															vspace=3 border=0 name=img3></a> <a href="#"
														onClick="insert_reset()"><img src="./img/u_bt05.gif"
															border=0 hspace=10 vspace=3 name=img4></a></td>
												</tr>
											</table>
										</td>
									</tr>
									</td>
									</tr>
								</table>
								</form></td>
						</tr>
					</table>

					<!-- copyright 영역 삽입-->
</body>
</html>
