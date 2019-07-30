/**
 * 
 */
$(function(){
	//t3 k3 -> t4 k4 ...
	
	//공백 체크
	var chk1 = /^S*$/;
	$("#regex1").text(chk1 + '');
	$("#txt1").keyup(function(){
		var txt1 = $("#txt1").val();
		$("#result1").val(chk1 + ' result : ' + chk1.test(txt1) + ' txt:' + txt1);
	});
	
	//핸드폰번호 체크
	var chk2 = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
	$("#regex2").text(chk2 + '');
	$("#txt2").keyup(function(){
		var txt = $(this).val();
		$("#result2").val('result : ' + chk2.test(txt) + ' txt:' + txt);
	});
	
	//숫자만 입력 가능
	var chk3 = /^[0-9]*$/;
	$("#regex3").text(chk3 + '');
	$("#txt3").keyup(function(){
		var txt = $(this).val();
		$("#result3").val('result : ' + chk3.test(txt) + ' txt:' + txt);
	});
	
	//한글만 입력 가능
	var chk4 = /^[가-힣ㄱ-ㅣa-zA-Z]*$/;
	$("#regex4").text(chk4 + '');
	$("#txt4").keyup(function(){
		var txt = $(this).val();
		$("#result4").val('result : ' + chk4.test(txt) + ' txt:' + txt);
	});
	
	//이메일만 입력 가능
	var chk5 = /^[a-zA-Z0-9]+@([a-zA-Z0-9]{1,10})\.([a-zA-Z]{1,10})+$/;
	$("#regex5").text(chk5 + '');
	$("#txt5").keyup(function(){
		var txt = $(this).val();
		$("#result5").val('result : ' + chk5.test(txt) + ' txt:' + txt);
	});
	
	//8자리 이하 특수문자만 입력 가능
	var chk6 = /^[!@#$%^*()\-_=+\\\|\[\]{};:\'",.<>\/?]{1,8})+$/;
	$("#regex6").text(chk6 + '');
	$("#txt6").keyup(function(){
		var txt = $(this).val();
		$("#result6").val('result : ' + chk6.test(txt) + ' txt:' + txt);
	});
});