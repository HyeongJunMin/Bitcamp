<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
<link rel="stylesheet" type="text/css" href="css/style.css"/>

<style type="text/css">
#login_wrap {
	margin:10px;
}
#login_wrap th {
	font-weight:bold;
}
#main_wrap { 
	width:800px; 
	margin-left:auto; 
	margin-right:auto; padding:0px; 
}			
#content_wrap { 
	width: 100%; 
	height: 500px; 
	background-image:url("image/backa.jpg"); 
	background-repeat:no-repeat; 
	background-position:top center;  
}
			
.login_title_wrap {
	width:500px; 
	color:#FFFFFF; 
	text-align:center; 
	background-color:#3e5fba; 
	border:solid 1px #EFEFEF; 
	font-weight:bold; 
	height:60px;
}

/* table셋팅 */
.content_table { width:98%; border-bottom:1px solid #EFEFEF; border-right:1px solid #EFEFEF; border-collapse:collapse; margin-left:auto; margin-right:auto;  clear:both; }
.content_table td, .content_table th { text-align:center; border-top:1px solid #EFEFEF; border-left:1px solid #EFEFEF; padding:0.3em; }
.content_table th { background-color:#4D6BB3; color:#FFFFFF; line-height: 1.7em; font-weight:normal;}
.content_table td { padding-left:5px; text-align:left; line-height: 1.7em; }
.content_table td.contents { width:100%; height:400px; overflow:auto; }
.content_table th, .content_table td { vertical-align:middle; }

.content_table select { height:19px; border:#CCCCCC solid 1px; vertical-align:middle; line-height: 1.8em; padding-left:0px; }
.content_table select option { margin-right:10px; }

</style>

</head>
<body>

<div id="main_wrap">
	<div id="middle_wrap">
		<div id="content_wrap">
			
			<div style="width: 502px; height: 166px; margin-left: auto; margin-right: auto;
						position: relative; top: 100px;">
				<div class="login_title_wrap">
					<div style="margin-top: 12px;">
						<h2>My Home Page</h2>
					</div>
				</div>	
				
				<div id="login_wrap">
					<form action="loginAf.do" name="frmForm" id="_frmForm" method="post">
						<table class="content_table" style="width:75%;">
							<colgroup>
								<col style="width:30%;">
								<col style="width:70%;">
							</colgroup>
							<tbody>
								<tr>
									<th style="background: #eeeeee; color: #3e5fba">아이디</th>
									<td>&nbsp;
										<input type="text" id="_userid" name="id" data-msg="ID를" size="20px" title="아이디" style="border:1px solid #dddddd">
										<input type="checkbox" id="chk_save_id">
									</td>
								</tr>
								<tr>
									<th style="background: #eeeeee; color: #3e5fba">패스워드</th>
									<td>&nbsp;
										<input type="password" id="_pwd" name="pw" data-msg="PW를" size="20px" title="패스워드" style="border:1px solid #dddddd">
									</td>
								</tr>
								<tr>
									<td>
										<a href="#none" id="btnLogin" title="로그인">
											<img alt="" src="image/login_btn.jpg">
										</a>
										<!-- <input type="button" value="로그인" id="btnLogin"> -->
										<input type="button" value="회원가입" id="btnSignup">
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
				
			</div>		
		</div>	
	</div>
</div>

<script type="text/javascript">
$(function(){
	//로그인 버튼 클릭 이벤트
	$("#btnLogin").click(function(){
		//입력 ID값
		var inputId = $("#_userid").val();
		var inputPw = $("#_pwd").val();
		//모든 공백 체크 정규식, 공백포함되어있으면 true
		var regExp = /\s/g;
		var testResult = regExp.test( inputId );
		
		if( testResult === true || inputId.length < 1 ){
			alert('아이디에 공백을 입력할 수 없습니다.');
		}else{
			testResult = regExp.test( inputPw );
			if( testResult === true || inputPw.length < 1 ){
				alert('비밀번호에 공백을 입력할 수 없습니다.');	
			}else{
				$("#_frmForm").submit();		
			}
		}		
		//alert('입력값:' + inputId + ',  정규식:' + regExp + ',  결과 : ' + testResult);
	});
	
	//cookie를 찾는 부분
	var userId = $.cookie("userId");
	if(userId != null){
		//alert('cookie exist');
		$("#_userid").val(userId);
		$("#chk_save_id").attr("checked", "checked");
	}else{
		//alert("cookie doesn't exist");		
	}
	
	//쿠키 저장 체크박스 클릭 이벤트
	$("#chk_save_id").click(function(){
		if( $(this).is(":checked") ){
			if( $("#_userid").val().trim() === ""){
				$(this).prop("checked", false);
			}else{//쿠키이름, 저장데이터, 조건(유효기한7일, root경로-모든 경로에서 접근 가능 해당)
				$.cookie("userId", $("#_userid").val().trim(), {expires:7, path:'/'} );
			}
		}else{//체크를 해제하면 쿠키삭제(=기한을 0으로 설정)
			$.removeCookie("userId", {path:'/'} );
		}
	});
	
	//아이디 입력 이벤트 쿠키확인
	$("#_userid").keyup(function(){
		if( $("#chk_save_id").is(":checked") ){
			$.cookie("userId", $("#_userid").val().trim(), {expires:7, path:'/'} );
		}else{//체크를 해제하면 쿠키삭제(=기한을 0으로 설정)
			$.removeCookie("userId", {path:'/'} );			
		}
	});
	
	//회원가입 버튼 클릭 이벤트
	$("#btnSignup").click(function(){
		location.href="regi.do";
	});
});
</script>

</body>
</html>





