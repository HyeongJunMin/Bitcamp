/**
 * 
 */
$(function(){
	//글쓰기 화면에서 취소 버튼을 클릭하면 글쓰기 구역 hide
	$("#writenewBtnCancel").click(function(){
		var result = confirm("새 글 작성을 취소하시겠습니까?");
		if( result ){
			$("#writenewTxtTitle").val( '' );
			$("#writenewTxtContent").val( '' );
			
			//$("#writenewMain").hide();
			//$("#bbsTableArea").show();			
		}		
	});
	
	$("#writenewBtnSave").click(function(){
		var result = confirm("저장 ㄱ?");
		if( result ){
			$("#writenewForm").submit();
		}
	});
});