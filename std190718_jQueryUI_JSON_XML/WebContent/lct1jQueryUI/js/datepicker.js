/**
 * 
 */
$(function() {
	
	var dow = ['일','월','화','수','목','금','토'];
	
	$("#date").datepicker( {
		dateFormat: "yy/mm/dd"
		,dayNamesMin: ['일','월','화','수','목','금','토']
		,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,onSelect: function( d ){
			var arr = d.split('/');
			$("#year").val( arr[0].trim() );
			$("#month").val( arr[1].trim() );
			$("#dateNum").val( arr[2].trim() );
			
			var week = new Date( $("#date").datepicker( {dateFormat: "yy/mm/dd"} ).val() );
			$("#dayOfWeek").val( dow[week.getDay()] );
		}
	} );
	
});

