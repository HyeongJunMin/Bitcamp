/**
 * 
 */
$(function(){
	$("#btn27").click(function(){
		for(i = 1 ;  i < 101 ; i++){
			if(i == 100)	$("#q27").append(i);
			else	$("#q27").append(i + ", ");			
		}
	});
	
	var arr1 =['커피', '홍차', '우유', '주스', '소다' ];
	$("#btn28").click(function(){
		for(i = 0 ; i < arr1.length ; i++){
			$(".q28").append( '<li>' + arr1[i] + '</li>' );
		}
	});
	
	$("#q29_button").click(function(){
		var val = parseInt( $("#q29_val").val() );
		if( val > 70 ) {
			$("#q29_answer").text("합격");
		}else{
			$("#q29_answer").text("불합격");
		}
	});
	
	$("#q30_color").on("click", function(){
		$("#q30_box").css("width",
				$("#q30_select option:selected").val());
	});
	
	$("#q31_button").on("click", function(){
		var num1 = parseInt( $("#q31_val").val() );
		var num2 = parseInt( $("#q31_subject").val() );
		var oper = $("#q31_select option:selected").val();
		var result = 0 ;
		switch(oper){
			case 'addition': result = num1+num2; break;
			case 'subtraction': result = num1-num2; break;
			case 'multiplication': result = num1*num2; break;
			case 'division': result = num1/num2; break;
		}
		
		$("#q31_answer").text('결과 :' + result);
		
	});
});