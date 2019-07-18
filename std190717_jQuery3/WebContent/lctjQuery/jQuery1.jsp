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
<a href="../index.jsp">Go to home</a>
<a href="./jQuery1.jsp">1-1</a>
<a href="./jQuery2.jsp">1-2</a>

<ul class="bevList">
	<li class="bevCls">커피</li>
	<li class="bevCls">홍차</li>
	<li class="bevCls">우유</li>
	<li class="bevCls">쥬스</li>
	<li class="bevCls">녹차</li>
</ul>
<h4 id="countItems">0개의 요소가 있습니다.</h4>
선택한 항목 : <input type="text" id="txtSelect"><br>
추가 항목 : <input type="text" id="txtAdd"><input type="button" id="btnAdd" value="추가"><br>
삭제 항목 : <input type="text" id="txtDel"><input type="button" id="btnDel" value="삭제"><br>

<script type="text/javascript">
$(function () {
	addEvent();
	countUlLength();
	var index = 0;
	$("#btnAdd").click(function(){
		//입력값이 있으면 해당 텍스트 추가, 없으면 실행 취소
		if( $("#txtAdd").val().length > 0 ){
			var addItem = '<li class="bevCls">' + $("#txtAdd").val() + '</li>';	
		}else{
			alert('입력 필요');
			return;
		}		
		
		//선택된 항목이 있으면 선택된 항목 밑에 추가, 없으면 맨 아래 추가
		if( index > 0 ){
			$(".bevCls:eq(" + index +")").after(addItem);	
		}else{
			$(".bevList").append(addItem);
		}
		
		index = 0;
		
		//클릭 이벤트 추가
		addEvent();
		countUlLength();
	});
	
	$("#btnDel").click(function(){
		var ulLength = $(".bevList").children().length;
		var targetDelTxt = "";
		var deleteTxt = $("#txtDel").val();
		
		for(i=0 ; i < ulLength ; i++){
			targetDelTxt = $(".bevCls:eq(" + i +")").text();
			if( targetDelTxt === deleteTxt ){
				$(".bevCls:eq(" + i +")").remove();
			}	
		}
		countUlLength();
	});
	
	function addEvent(){
		$(".bevCls").click(function(){
			$("#txtSelect").val($(this).text());
			index = $(".bevCls").index(this);
		});
	}
	function countUlLength(){
		//길이 지정
		var ulLength = $(".bevList").children().length;
		$("#countItems").text(ulLength + "개의 요소가 있습니다.");
		//$("#countItems").html(ulLength + "개의 요소가 있습니다.");		
	};
});
</script>

</body>
</html>