/**
 * 
 */
$(function(){
	$(".seqclick").click(function(){
		var seq = $(this).attr('seq');
		$("#frmBbs").submit();
	});
});