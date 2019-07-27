/**
 * 
 */
/**
 * freeboard index page
 * /WEB-INF/views/freeboard/freeboardmain.jsp
 */
function echoTest(){
	alert('echo');
}

$(function(){
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
});
