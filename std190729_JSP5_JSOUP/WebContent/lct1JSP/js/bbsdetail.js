/**
 * 
 */
$(function(){

	var titleChanged = false;
	var contentChanged = false;
	var originTitle = $("#_inputTitle").val();
	var originContent = $("#_inputContent").val();
	
	//제목 변경 확인
	$("#_inputTitle").keyup(function(){
		if( originTitle == $("#_inputTitle").val() ){
			titleChanged = false;
		}else{
			titleChanged = true;
		}	
		//변경되는 내용 확인
		//$("#chkTitle").text('titleChanged = ' + titleChanged);
		
		//제목 또는 내용 둘 중 하나라도 변경사항이 있으면 저장버튼 활성화
		$("#_btnSave").attr("disabled" , ( titleChanged || contentChanged ) ? false : true );
	});
	
	//내용 변경 확인
	$("#_inputContent").keyup(function(){
		//alert('keyup');
		if( originContent == $("#_inputContent").val() ){
			//초기 내용에서 변경사항이 없으면? contentChanged false
			contentChanged = false;
		}else{
			contentChanged = true;
		}
		//변경되는 내용 확인
		//$("#chkContent").text('contentChanged = ' + contentChanged);
		
		//제목 또는 내용 둘 중 하나라도 변경사항이 있으면 저장버튼 활성화
		$("#_btnSave").attr("disabled" , ( titleChanged || contentChanged ) ? false : true );
	});
	
	$("#btnHide").click(function(){
		//$("#_btnSave").css('visibility', 'hidden');
		$("#_btnSave").toggle();
		alert( 'ok' );
	});
	
	//현재 접속한 ID와 작성자가 같으면 저장버튼 활성화
	if( $("#currId").val().trim() === $("#writer").text().trim() ){
		$("#_btnSave").css('visibility', 'visible');	
	}else{
		$("#_btnSave").css('visibility', 'hidden');
	}
	
	//변경내용이 있으면 AJAX를 활용해서 DB에 저장
	$("#_btnSave").click(function(){
		var inputSeq = $("#originSeq").val();
		var inputTitle = $("#_inputTitle").val();
		var inputContent = $("#_inputContent").val();
		
		$.ajax({
			type: "POST"
			, cache: false
			, data: {seq : inputSeq , title: inputTitle , content: inputContent}
			, url: "./bbsdetailAf.jsp"
			, success: function( data ){
/*				alert('raw data : ' + data);
				var json = (data+'').trim();
				alert('json data : ' + json);
				
				var parsedJson = JSON.parse(json);
				alert('parsedJson : ' + parsedJson);
				
				$("#_inputTitle").val(parsedJson.content);*/
				$("#modifyDone").text('변경내용 저장 완료.');
			}, error: function( error ){
				return false;
			}
		});
	});
});