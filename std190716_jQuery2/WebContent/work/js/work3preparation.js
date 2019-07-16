$(function(){
	var cntRe = 1;
	var visible = 0;
	$("#btnReply").click(function() {
		if(visible === 1) return;
		visible = 1;
		var reply = "<div id='divReply'> " +
		"<br>답글 : <input type='text' id='txtReply'> " +
	" <br><input type='button' value='답글입력완료' id='btnReplyComplete'>"
		+ "</div>";
		$("#origin").append(reply);
		
		$("#btnReplyComplete").click(function(){
			alert($("#txtReply").val());
			$("body").append( "<p>답글" + cntRe + ": " + $("#txtReply").val() + "</p>" );
			cntRe += 1;
			$("#divReply").remove();
			visible = 0;
		});
	});
	
	$("#btnRemove").click(function(){
		$("body").remove("a");
	});
});