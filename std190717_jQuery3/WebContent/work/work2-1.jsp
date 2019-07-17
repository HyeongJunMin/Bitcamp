<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
	<img src="./images/img01.jpg"/>
</div>
<div>
class 명 eee의 ul 요소의 목록의 수를 취득 해, id 명 q21 요소 li 태그의 수는 n 개로 표시하라
<ul class="eee"> <li>리스트①</li> <li>리스트②</li> <li>리스트③</li> <li>리스트④</li> <li>리스트⑤</li> <li>리스트⑥</li> </ul> <p id="q21"></p>
<input type="button" value="clk" id="btn1">
Q21 목록을 클릭하면 지금 클릭된 요소가 몇 번째인지를 id 명 q22 요소를 클릭 하면 n 번째로 표시되도록 한다
<input type="text" value="clk" id="txt1">
</div>
점수를 입력 받고 버튼을 클릭하면, "합격"은 70 점 이상, "불합격“은 75점 이하의 판정을 id 명 "q23"요소에 출력하라
<div id="q23"></div>
<input type="text" value="clk" id="txt2"><input type="button" value="clk" id="btn2">
<br>
class 명 .q24의 ul 요소 목록의 텍스트를 순서대로 class 명 p 요소의 q25에 ","를 추가하여 앞 부분에 출력하라.
<h4>주인공</h4> <ul class= "q24"> <li>홍길동</li> <li>일지매</li> <li>임꺽정</li> <li>정수동</li> </ul> <p class= "q25"> 주인공들의 모임 </p>
<input type="button" value="go" id="btn3"><br><br>

id 명 q26의 ul 요소의 목록의 맨 앞에 1부터 카운트 번호 및 문자열 ","를 추가하라.
<ul id= "q26"> <li>1, 커피</li> <li>2, 홍차</li> <li>3, 우유</li> <li>4, 쥬스</li> <li>5, 소다</li> </ul>
<p class="q26"></p>
<input type="button" value="go" id="btn4"><br><br>
<script type="text/javascript">
$(function(){
	$("img").css({"width":"500px", "height":"300px"});
	
	$("#btn1").click(function(){
		$("#q21").html($(".eee").children().length + '개');		
	});
	
	$(".eee li").click(function(){
		$("#txt1").val($(this).index()+1);
	});
	
	$("#btn2").click(function(){
		var num = parseInt( $("#txt2").val() );
		if(num >= 70){
			$("#q23").html("합격");	
		}else{
			$("#q23").html("불합격");
		}
	});
	
	$("#btn3").click(function(){
		var str  = "" ;
		
		$('.q24').children().each(function (index, item) {
			str += $(this).text() + ", ";
		});
		$(".q25").html(str + $(".q25").html());
	});
	
	$("#btn4").click(function(){
		var str  = "" ;
		
		$('#q26').children().each(function (index, item) {
			str += $(this).text() + ", ";
		});
		$(".q26").html(str + $(".q26").html());
	});
});
</script>
</body>
</html>