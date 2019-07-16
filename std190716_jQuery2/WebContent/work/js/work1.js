$(function(){
	$("#btnConfirm").click(function(){
		var name = $("#inputName_id").val();
		var add = $("#inputPost1").val() + '-' + $("#inputPost2").val();
		var phn = $("#phone1").val() + '-' + 
				$("#phone2").val() + '-' +
				$("#phone3").val();
		var time = $("#postTime_id option:selected").val(); 
		var receipt = $("input[name='radioRec']:checked").val();
		//영수증 신청=1, 신청안함=2
		
		location.href="./work1Result.jsp?name=" + name +
						"&address=" + add +
						"&phone=" + phn +
						"&time=" + time +
						"&receipt=" + receipt;
	});
});

