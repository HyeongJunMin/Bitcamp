/**
 * 
 */
$(function(){
	$("#mainContentSearchBtn").click(function(){
		//option 1:제목, 2:내용, 3:제목+내용, 4:작성자
		var option = $("#mainContenSearchSelect").val();
		var condition = $("#mainContentSearchTxt").val();
		var params = 'command=searchpost';
		
		params += '&option=' + option;
		params += '&condition=' + condition;
				
		location.href = 'http://localhost:8090/std190730_JSP6_BBS_reply/bbs?' + params;
		/*
		$.ajax({
			   type : "GET",
			   url : "http://localhost:8090/std190730_JSP6_BBS_reply/bbs?command=searchpost",
			   data : {"option":option, "condition": searchTxt},
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
		*/
	});
});