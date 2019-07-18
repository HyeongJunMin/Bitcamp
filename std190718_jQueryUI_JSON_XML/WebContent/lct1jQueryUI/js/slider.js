/**
 * 
 */
$(function() {
	
	$("#imgSlider").slider({
		animate: true
		,range: "min"
		,value: 100
		,slide: function(event, ui){
			console.log("slide moved");
			$("img").css( {"opacity" : ui.value/100 } );
			$("#imgSliderOpacity").text( ui.value );
		}		
	});
	
});