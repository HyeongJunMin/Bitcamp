function f1(){
	//alert('asd');
	var arrPtag = document.getElementsByTagName("p");
	
	for(i = 0 ; i < arrPtag.length; i++) {
		arrPtag[i].innerHTML = "Hello p tag";
	}
}
function f2(){
	alert('javascript function');
}


//jQuery 기본 사용법
//jQuery 사용 준비
$(document).ready(function() {
	//형식 : $(태그명 or class or id).핸들러함수명(매개변수);
	
	//모든 p태그의 내용을 수정하는 함수(setter)
	$("p").html("<b>Hi p tag!</b>"); //html태그 인식
	$("p").text("<b>p tag jQuery</b>");	//html태그 인식 불가
	
	//p태그의 값을 받아오는 함수(getter)
	//var strTemp1 = $("#demo").text();
	//alert(strTemp1);
	
	//클릭 이벤트 추가
	$("#btnId").click(function() {
		var strTemp2 = $("#txtId").val();
		alert(strTemp2);
		$("#txtId").val( $("#slc1").val() );
	});
	
	//클릭 이벤트 추가 2
	$("#txtId").on("click", function() {
		alert("on txtId click");
	});
	
	//클릭 이벤트 추가 3(외부 함수 호출)
	$("#eventMethod1").on("click", f2);
	

});
