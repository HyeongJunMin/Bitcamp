/**
 * 로그인 관련 자바스크립트(jQuery)
 */

$(function(){
	//contextPath
	var contextPath = $("#contextPath").val();	
	var controllerPath = "http://localhost:8090/std190730_JSP6_BBS_reply/";
	
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
    	if( $("#txtIdInSignin").val().length < 1 ){
    		alert('ID를 입력해 주세요!');
    		$("#txtIdInSignin").focus();
    	}else if( $("#txtPwInSignin").val().length < 1 ){
    		alert('PW를 입력해 주세요!');
    		$("#txtPwInSignin").focus();
    	}else{
    		var id = $("#txtIdInSignin").val();
    		var pw = $("#txtPwInSignin").val();
    		
    		$.ajax({
    			type:"GET"
    			, url: controllerPath + "member?command=signinchk"
    			//, url: contextPath + "/views/static/ajax/signinCheck.jsp"
    			//, url:"/std190730_JSP6_BBS_reply/views/static/ajax/signinCheck.jsp"
    			, datatype: "json"
    			, data: {"inputId": id , "inputPw" : pw }
    			, success: function( data ){
    				//alert('succeed : ' + data);
    				//json 파싱
    				//var recv = JSON.parse( data.trim() );
    				
    				//로그인 성공 시 로그인부분 div 전환
    				if( data ){
    					alert('환영합니다!');
    					location.href="http://localhost:8090/std190730_JSP6_BBS_reply/bbs?command=showbbslist";
    				}
    				//로그인 실패
    				else{
    					alert('계정 정보가 올바르지 않습니다.');
    				}
    				
    			}, error: function( error ){
    				//alert('error : ' + error);
    			}
    		});
    	}
    });
    
    //로그인 모달 폼에서 취소 버튼 클릭 이벤트
    $("#btnCancelInSigninModal").click(function(){
    	$("#txtPwInSignin").val('');
    	$("#txtIdInSignin").val('');
    });
	
});