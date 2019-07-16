$(function(){
	$("#img1").mouseover(function() {
		$("#img1").attr("src", "./images/b_pic2.jpg")	
	});
	$("#img1").mouseout(function() {
		$("#img1").attr("src", "./images/b_pic1.jpg")	
	});
	
	$("img[name=pics]").click(function() {
		var str = $(this).attr("alt");
		alert(str);
	});
});