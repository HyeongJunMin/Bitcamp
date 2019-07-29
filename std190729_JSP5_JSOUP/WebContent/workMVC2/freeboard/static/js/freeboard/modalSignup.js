/**
 * 모달 폼 회원가입 관련 jQuery 
 */
$(function(){
	//회원가입 모달 창이 완전히 열렸을 때 입력창에 포커스(shown - show)
	$("#signupModal").on('shown.bs.modal', function(e){
		$("#inputIdInSignup").focus();
	});
	
	//회원가입 모달 창 닫혔을 때 입력된 text 초기화(hidden - hide)
	$("#signupModal").on('hidden.bs.modal', function(e){
		$("#signupWarn").text( '　' );
		$("#signupModal input").val( '' );
		e.stopImmediatePropagation();
	});
	
	//정규식 활용 id 체크(영소문자+숫자 5자 이상)
	$("#inputIdInSignup").keyup(function(){
		var inputTxt = $("#inputIdInSignup").val()+'';

		var chkOnlyEngNum = /^[a-zA-Z0-9_-]{5,15}$/;

		if( chkOnlyEngNum.test( inputTxt ) ){
			$("#signupWarn").text( '　' );
			$("#btnSignupInSignupModal").prop("disabled",false);
		}else{			
			$("#signupWarn").text( 'ID형식 : 5~15자 사이의 영문 소문자, 영문 대문자, 숫자의 조합' );
			$("#btnSignupInSignupModal").prop("disabled",true);
		}
		/*
		var inputId = $("#inputIdInSignup").val();
		if( inputId.length > 5 ){
			//ajax 활용 id 중복체크
			$.ajax({
				type: "get"
				, url: "./static/ajax/iddupchk.jsp"
				, data: { id:inputId }
				, success: function( obj ){
					
					var result = obj.trim();

					if( result == 'true' ){
						//사용가능한 ID이면? 버튼 활성화
						$("#btnSignupInSignupModal").prop("disabled",false);
						return false;
					}else{
						//중복된 ID이면? 비활성화
						$("#signupWarn").text('이미 사용중인 ID입니다. [' + inputId + ']' );
						$("#btnSignupInSignupModal").prop("disabled",true);
					}
				}, error: function(){
					alert('fail');
				}
			});
		}
		*/
	});

	//PW 길이 체크
	$("#inputPw1InSignup").keyup(function(){
		if( $("#inputPw1InSignup").val().length < 5 ){
			$("#signupWarn").text( '비밀번호 형식 : 5자 이상' );
			$("#btnSignupInSignupModal").prop("disabled",true);
		}else{
			$("#signupWarn").text( '　' );
			$("#btnSignupInSignupModal").prop("disabled",false);
		}
	});

	//PW 확인 체크
	$("#inputPw2InSignup").keyup(function(){
		var pw1 = $("#inputPw1InSignup").val();
		var pw2 = $("#inputPw2InSignup").val();
		if( pw1 == pw2 ){
			$("#signupWarn").text( '　' );
			$("#btnSignupInSignupModal").prop("disabled",false);
		}else{
			$("#signupWarn").text( '두 비밀번호 불일치' );
			$("#btnSignupInSignupModal").prop("disabled",true);
		}
	});
	
	//E-mail 체크
	$("#inputEmailInSignup").keyup(function(){
		var inputTxt = $("#inputEmailInSignup").val();
		var chkEmail = /^[a-zA-Z0-9]+@([a-zA-Z0-9]{1,10})\.([a-zA-Z]{1,10})+$/;
		if( chkEmail.test(inputTxt) ){
			$("#signupWarn").text( '　' );
			$("#btnSignupInSignupModal").prop("disabled",false);
		}else{
			$("#signupWarn").text( '이메일 형식 : ccc@cccc.ccc ' );
			$("#btnSignupInSignupModal").prop("disabled",true);
		}
	});
	
	//회원가입 버튼 클릭
	$("#btnSignupInSignupModal").click(function(){
		if( $("#inputIdInSignup").val().length < 1 ){
			$("#signupWarn").text( '아이디를 입력해 주세요' );
			$("#inputIdInSignup").focus();
		}else if( $("#inputPw1InSignup").val().length < 1 ){
			$("#signupWarn").text( '비밀번호를 입력해 주세요' );
			$("#inputPw1InSignup").focus();
		}else if( $("#inputPw2InSignup").val().length < 1 ){
			$("#signupWarn").text( '비밀번호 확인란을 입력해 주세요' );
			$("#inputPw2InSignup").focus();
		}else if( $("#inputNameInSignup").val().length < 1 ){
			$("#signupWarn").text( '성함을 입력해 주세요' );
			$("#inputNameInSignup").focus();
		}else if( $("#inputEmailInSignup").val().length < 1 ){
			$("#signupWarn").text( '이메일을 입력해 주세요' );
			$("#inputEmailInSignup").focus();
		}else{
			//빈칸 검사, 중복체크 완료되면 회원가입 ㄱㄱ

			$("#formSignup").submit();
			//http://localhost:8090/6_CoffeeOrderSystemMVC2/views/11111?
		}
	});
	
	//취소 버튼 클릭하면 로그인페이지로 이동
	$("#btnCancelInSignupModal").click(function(){
		location.href='/6_CoffeeOrderSystemMVC2/coffee';
		return false;
	});
});