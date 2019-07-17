/**
 * 
 */
$(function(){
	$("#btn01").click(function(){
		//change font color 
		$("#q01").css("color", "#ff0000");
		//change font color, background color
		$("#q01").css({
				"color" : "#00ff00",
				"background-color" : "#ffff00"
		});
	});
	
	$("#btn02").on("click", function(){
		//change html code
		$("#q02").html("<b>Change</b> HTML code");
	});
	
	$("#btn03").on("click", function(){
		$("#q03").addClass("cls1");
	});
	
	$("#btn04").on("click", function(){
		//add item to list
		$("#q03").append("<li>orange</li>");
	});	
	
	$("#btn05").on("click", function(){
		//remove item from list
		$("#q03 li").remove();
	});
	
	$("#btn06").on("click", function(){
		//add something to tags
		$("#q04").append("<a> until the end</a>");
		$("#q04").prepend("<a>say : </a>");
	});
	
	$("#btn07").on("click", function(){
		//add something to tags
		$("#q05 li").before('<li>tea</li>');
		$("#q05 li").after('<li>coke</li>');
	});
	
	$("#btn08").on("click", function(){
		//wrap tags
		$("#q06").wrap("<div class='cls2'><div>");
	});	
});