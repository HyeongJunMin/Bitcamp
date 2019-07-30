/**
 * 
 */
function echoTest(){
	alert('echo');
}

$(function(){
	//contextPath
	var contextPath = $("#contextPath").val();
	
	//현재 ID가 guest이면 환영화면, member이면 멤버화면 show
	if( $("#currId").val() === 'guest' ){
		$.ajax({
			url: contextPath + "/views/account/accountViewGuest.jsp"
			, success: function(result){
				$("#mainAccountTemplate").html( result );
			}
		});
	}else{
		$.ajax({
			url: contextPath + "/views/account/accountViewMember.jsp"
			, success: function(result){
				$("#mainAccountTemplate").html( result );
			}
		});
	}
		
	
    $("#btnPop").click(function(){
        $('layerpop.modal').modal();
    })
    
    //상단 메뉴 바 이벤트
    var headerBarMenuState = true;
    $("#mainHeaderBarMenu a").mouseenter(function(){
    	$(this).animate({ opacity: "0.8" }, 200);
    });
    
    $("#mainHeaderBarMenu a").mouseleave(function(){
    	$(this).animate({ opacity: "1.0" }, 200);    	
    });
    
    $("#includeMainAccountView").click(function(){
    	alert('dddd');
    });
    
    //새 글 쓰기 버튼 클릭 이벤트
    $("#btnWriteNew").click(function(){
    	if( $("#currId").val() === 'guest' ){
    		alert('새 글 작성을 위해 로그인이 필요합니다.');
    		$("#btnMainSignin").focus();
    	}else{
    		$("#writenewMain").show();
    		$("#bbsTableArea").hide();
    	}    	
    });
});
