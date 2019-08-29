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
						<h2>회원가입</h2>
					</div>
				</div>	
				
				<div id="login_wrap">
					<form action="" method="post" id="_signupForm" name="signupForm">
						<table class="content_table" style="width:75%;">
							<colgroup>
								<col style="width:30%;">
								<col style="width:70%;">
							</colgroup>
							<tbody>
								<tr>
									<th style="background: #eeeeee; color: #3e5fba">아이디 체크</th>
									<td>&nbsp;
										<input type="text" id="_id" name="sid" data-msg="ID를" size="30" title="아이디" style="border:1px solid #dddddd">
										<a href="#none" id="_btnGetId" title="ID체크">
											<img alt="" src="image/idcheck.png">
										</a>
										<div id="_rgetid"></div>
									</td>
								</tr>
								<tr>
									<th style="background: #eeeeee; color: #3e5fba">아이디</th>
									<td>&nbsp;
										<input type="text" id="_userid" name="id" data-msg="ID를" size="30" title="아이디" style="border:1px solid #dddddd" readonly>
									</td>
								</tr>
								<tr>
									<th style="background: #eeeeee; color: #3e5fba">패스워드</th>
									<td>&nbsp;
										<input type="password" id="_pw" name="pw" data-msg="PW를" size="30" title="패스워드" style="border:1px solid #dddddd">
									</td>
								</tr>
								<tr>
									<th style="background: #eeeeee; color: #3e5fba">이름</th>
									<td>&nbsp;
										<input type="text" id="_name" name="name" data-msg="이름을" size="30" title="이름" style="border:1px solid #dddddd">
									</td>
								</tr>
								<tr>
									<th style="background: #eeeeee; color: #3e5fba">이메일</th>
									<td>&nbsp;
										<input type="text" id="_email" name="email" data-msg="이메일을" size="30" title="이메일" style="border:1px solid #dddddd">
									</td>
								</tr>
								<tr>
									<td colspan="2" style="height: 50px; text-align: center;">
										<a href="#none" id="_btnRegi" title="회원가입">
											<img alt="" src="image/regi.jpg">
										</a>
										<a href="#none" id="_btnLogin" title="로그인">
											<img alt="" src="image/login_btn.jpg">
										</a>
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
	
	//회원가입 버튼 클릭 이벤트
	$("#_btnRegi").click(function(){
		//빈 칸 체크
		$("#signupForm").attr("action", "regiAf.do").submit();
	});
	
	//아이디 중복체크 버튼 이벤트
	$("#_btnGetId").click(function(){
		$.ajax({
			url: "getId.do",
			type: "post",
			data: { id:$("#_id").val() },
			success: function(msg){
				if( msg === 'OK'){
					$("#_rgetid").html("사용 가능한 아이디입니다.");
					$("#_rgetid").css("background-color", "#0000ff");
					$("#_userid").val( $("#_id").val() );
				}else{
					$("#_rgetid").html("사용할 수 없는 아이디입니다.");
					$("#_rgetid").css("background-color", "#ff0000");
					$("#_id").val("");
					$("#_userid").val("");
				}
			},
			error: function(){
				
			}
		});
	});
});
</script>

</body>
</html>





