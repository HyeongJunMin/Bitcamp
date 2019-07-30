/**
 * 
 */
$(function(){
	//contextPath
	var contextPath = $("#contextPath").val();
	
	//돌아가기 버튼 클릭시 view 변경
	$("#postdetailBtnCancel").click(function() {
		$("#bbsPostDetailArea").hide();
		$("#bbsTableArea").show();
	});
	

});

//테이블 행을 클릭하면 해당 행의 seq의 값에 따라 상세보기 제공
function viewPostDetail( seq ){
	//view 변경
	$("#bbsPostDetailArea").show();
	$("#bbsTableArea").hide();
	$.ajax({
		   type : "GET",
		   url : "http://localhost:8090/std190730_JSP6_BBS_reply/bbs?command=showonepost",
		   data : {"seqNum":seq},
		   datatype : "json",
		   success : function(data){
			   //alert('success : ' + data.trim() + " , type : " + data.trim().type);
			   
			   var str = data.trim().replace(/\r/gi, '\\r').replace(/\n/gi, '\\n');

			   $("#postdetailTxtContent").text(data.trim());
			   //var jsonData = JSON.parse( data );
			   var jsonData = JSON.parse( str );

			   //alert('success : ' + jsonData);
			   $("#postdetailTxtTitle").val(jsonData.title);
			   $("#postdetailTxtContent").text(jsonData.content);
			   $("#postdetailId").html(jsonData.id);
		   },
		   error : function(error){
			   alert('error : ' + error);
		   }
	});
}