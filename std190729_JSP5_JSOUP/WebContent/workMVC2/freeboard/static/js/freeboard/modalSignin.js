/**
 * 로그인 관련 자바스크립트(jQuery)
 */

$(function(){
	//로그인 모달 창이 완전히 열렸을 때 입력창에 포커스(shown - show)
	$("#signinModal").on('shown.bs.modal', function(e){
		$("#txtIdInSignin").focus();
	});
	
	//로그인 모달 창 닫혔을 때 입력된 text 초기화(hidden - hide)
	$("#signinModal").on('hidden.bs.modal', function(e){
		$("#signupWarn").text( '' );
		$("#signinModal input").val( '' );
		e.stopImmediatePropagation();
	});	
	
    //로그인 모달 폼에서 Sign in 버튼 클릭 이벤트
    $("#btnSigninInSigninModal").click(function(){
    	if( $("#txtIdInSignin").val().length < 5 ){
    		alert('ID를 입력해 주세요!');
    		$("#txtIdInSignin").focus();
    	}else if( $("#txtPwInSignin").val().length < 5 ){
    		alert('PW를 입력해 주세요!');
    		$("#txtPwInSignin").focus();
    	}else{
    		$.ajax
    	}
    });
    
    //로그인 모달 폼에서 취소 버튼 클릭 이벤트
    $("#btnCancelInSigninModal").click(function(){
    	$("#txtPwInSignin").val('');
    	$("#txtIdInSignin").val('');
    });
	
});