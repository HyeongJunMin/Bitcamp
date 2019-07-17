<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css"> .aaa{color:#F00;} 
				.ccc { padding: 10px; border: #000 2px solid; background-color: red; }
				.q17_b{ text-decoration:underline; color:#00F; }
				.q18 { background:#FFF; width:100px; height:100px; }	
				.button { padding: 5px 10px; border:#666 solid 1px; background:#FFF; display:block; width:100px; text-align:center;
				</style>
</head>
<body>

id의 "q01"텍스트 색상을 빨간색으로 변경하라.
<p id="q01" onclick="$(this).css('color','red')">Hello JQuery Click!</p>
id 명 "q02"텍스트 색상을 파랑으로 배경색을 노란색으로 변경하라
<p id="q02" onclick="$(this).css({'color':'blue', 'background':'yellow'})"> Hello JQuery click!</p>
id명 "q03" 에 텍스트 “JQuery"를 추가하라
<p id="q03"></p><input type="button" value="click!" onclick="$('#q03').text('jQuery')"/> 
id명 q04의 “하이”의 내용을  a 태그를 포함한 “안녕하세요”로 대체하라
<p id="q04">하이</p><input type="button" value="click!" id="btnAltTagInfo" />
ul 요소에 class 명 "aaa"를 추가하라
<ul id="q05"> <li id="addCssAndClass">리스트1 click!</li> <li>리스트2</li> <li>리스트3</li> </ul> 
li 요소를 제거하라
<ul id="q06"> <li id="removeChild">리스트1 cilck!</li> <li>리스트2</li> <li>리스트3</li> </ul>
스크립트 변수 q9에 문자의 색상 값을 p #q9에 출력하라
<p id="q09"></p><input type="button" value="click!" id="btnGetColor" />
텍스트의 앞에 “나는 성공한다” 를 추가하라
<p id="q10">반드시 click!</p>
p 요소의 끝에 자신의 명을 추가하라
<p id="q10-1">나는 성공한다. 내 이름은 click! </p>
ul 요소의 li 태그 앞에 li 태그에 “홍차”를 추가하라
<ul id="q11"> <li>커피</li> </ul>
id 명 "q12"요소의 부모 요소 class 명 "ccc"를 추가하십시오
<div><p id="q12">최선을 다해서</p></div>
class 명 "q15"를 가진 요소의 a 태그의 href 속성을 제거하라
<p class="q15"><a href="#">aaa</a></p> <p><a href="#">bbb</a></p> <p class="q15"><a href="#">ccc</a></p> <p><a href="#">ddd</a></p> <p class="q15"><a href="#">eee</a></p>
<input type="button" value="click!" id="q15" />
class 명 "q16"를 가진 요소의 a 태그에 새로운 창으로 표시되도록 하는 속성을 추가하라.
<p class="q16"><a href="#">AAA</a></p> <p><a href="#">BBB</a></p> <p class="q16"><a href="#">CCC</a></p> <p><a href="#">DDD</a></p> <p class="q16"><a href="#">EEE</a></p>
<input type="button" value="click!" id="q16" />
class 명 "q17_a"요소를 class 명 "q27_b"로 변경하라.
<p class="q17_a">Ｑ２７ click!</p>
양식에 입력 값을 "입력해 주십시오“로 변경하십시오
<form> <input type="text" value="입력하지 마십시오" id="p17"> </form>
id 명 "q18"의 요소를 150px 300px 값으로 표시하라
<p id="q18">Ｑ18</p> 
p 요소를 클릭하면 바로 아래 ul의 자식 요소를 모두 비우도록 하라
<p class="button">버튼</p> <ul id="q19"> <li>리스트1</li> <li>리스트2</li> <li>리스트3</li> </ul>


<script type="text/javascript">
$(function(){
	$("#btnAltTagInfo").click(function(){
		$('#q04').html('<a href="#">안녕하세요</a>');
	});

	$("#addCssAndClass").click(function(){
		$("#q05").addClass("aaa");
	});
	
	$("#removeChild").click(function(){
		$("#q06 li").remove();
	});
	$("#btnGetColor").click(function(){
		$("#q09").html( $("#q09").css("color") );
	});
	
	$("#q10").click(function(){
		$("#q10").prepend( "나는 성공한다 " );
	});
	
	$("#q10-1").click(function(){
		$("#q10-1").append( "ㅎㅎㅎ " );
	});
	
	$("#q11").click(function(){
		$("#q11 li").prepend( "<li>홍차</li>" );
		$("#q11 li").after( "<li>녹차</li>" );
	});
	
	$("#q12").click(function(){
		$("#q12").parent('div').addClass("ccc");
	});
	
	$("#q15").click(function(){
		$(".q15").children().removeAttr( 'href' );
	});
	
	$("#q16").click(function(){
		$(".q16").children().attr("target","blank");
	});

	$(".q17_a").click(function(){
		$(".q17_a").attr("class","q17_b");
	});
	
	$("#p17").click(function(){
		$("#p17").val("입력해 주십시오.");
	});
	
	$("#q18").click(function(){
		$("#q18").addClass("q18");
	});
	
	$(".button").click(function(){
		$("#q19").children().remove();
	});
});
</script>
</body>
</html>