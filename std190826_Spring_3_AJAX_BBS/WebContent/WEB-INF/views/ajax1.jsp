<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<p>메소드 타입 중요</p>
<form method="get">
아이디: <input type="text" id="txtIdChk">
<br>
<input type="button" id="_check" onclick="idcheck()" value="idCheck">
</form>

<br>
<p>json으로 보내서 Map으로 받기</p>
<p>순수 json이 아닌 json형태의 문자열로 보낸 것</p>
<form method="post">
이름: <input type="text" id="txtNameFrm2"><br/>
전화: <input type="text" id="txtPhoneFrm2"><br/>
이메일: <input type="text" id="txtEmailFrm2"><br/>
생년월일: <input type="text" id="txtBirthFrm2"><br/>
<input type="button" id="account" value="account"><br/>
</form>


<br>
<p>순수 json으로 보내기(Map-Map)</p>
이름: <input type="text" id="txtNameFrm3"><br/>
전화: <input type="text" id="txtPhoneFrm3"><br/>
이메일: <input type="text" id="txtEmailFrm3"><br/>
생년월일: <input type="text" id="txtBirthFrm3"><br/>
<input type="button" id="account3" value="account"><br/>

<script type="text/javascript">
function idcheck(){
	$.ajax({
		url:"idcheck.do",
		type:"get",
		data:"id=" + $("#txtIdChk").val().trim(),
		success:function(data){
			alert('success' + data);
		}, error:function(r, s, err){
			alert('error');
		}
	});	
}


$(function(){
	//json형태의 문자열 보내기
	$("#account").click(function(){
		
		var mydata = { name:$("#txtNameFrm2").val(),
				phone:$("#txtPhoneFrm2").val(),
				email:$("#txtEmailFrm2").val(),
				birth:$("#txtBirthFrm2").val()};
		
		$.ajax({
			url:"account.do",
			type:"post",
			data:mydata,
			dataType:'json',
			async:true,
			success:function(data){
				alert('success' + data.msg);
				alert('success' + data.data);
			}, error:function(r, s, err){
				alert('error');
			}
		});	
	});
	
	$("#account3").click(function(){
		//배열 초기화
		var viewData = {};
		//data[키] = 밸류
		viewData["name"] = $("#txtNameFrm3").val();
		viewData["phone"] = $("#txtPhoneFrm3").val();
		viewData["email"] = $("#txtEmailFrm3").val();
		
		//-를 없애는 정규식 적용
		var birth = $("#txtBirthFrm3").val();
		viewData["birth"] = birth.replace(/-/g, "");
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			url:'updateUser.do',
			type:'post',
			data:JSON.stringify(viewData),
			success:function(resp){
				alert('success' + resp.msg + " , " + resp.data);
			},
			error:function(){
				alert('error');
			}
		});
	});
});

</script>

</body>
</html>