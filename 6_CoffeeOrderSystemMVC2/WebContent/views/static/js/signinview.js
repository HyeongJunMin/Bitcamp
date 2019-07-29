/**
 * 
 */
$(function(){
	var count = 0;
	//Signin 버튼 submit 이벤트
	$("#btnSigninInSigninView").click(function(){
		var inputId = $("#_inputIdInSigninView").val();
		var inputPw = $("#_inputPwInSigninView").val();
		

		if( inputId.length < 1 ){//ID입력 없을 때
			alert('plz input ID');
			$("#_inputIdInSigninView").focus();
			return false;
		}else if( inputPw.length < 1 ){//PW 입력 없을 때
			alert('plz input PW');
			$("#_inputPwInSigninView").focus();
			return false;
		}else{
			//ajax통신을 통해 계정정보 검사
			$.ajax({
				type: "get"
				, url: "./static/ajax/idchk.jsp"
				, data: { id:inputId, pw:inputPw }
				, success: function( obj ){
					
					var result = obj.trim();

					if( result == 'true' ){
						//검사가 완료되면 command설정 후 contoller로 이동.
						$("#commandInSigninView").val('signinIdChk');
						$("#SigninForm").submit();
						return false;
					}else{
						count++;
						$("#txtResult").text('계정정보를 확인해 주세요. ' + count);
					}
				}, error: function(){
					alert('fail');
				}
			});
		}
	});
	
	$("#btnSignupInSigninView").click(function(){
		$("#commandInSigninView").val('signup');
		$("#SigninForm").submit();
		return false;
	});
	
	
});