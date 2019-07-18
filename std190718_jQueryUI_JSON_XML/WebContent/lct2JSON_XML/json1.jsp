<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<a href="/json1.jsp">json1</a>
<a href="/json2.jsp">json1</a>
<p id="demo"></p>
<h1>Json method1</h1>
<p id="showJson"></p>
<h1>Json method2</h1>
<p id="showJson2"></p>

<script type="text/javascript">
//parsing 할 데이터 선언 및 초기화
var text = '{"name":"gd", "age":24, "add":"seoul"}';

//문자열을 json형태로 parsing
var obj = JSON.parse(text);

var str = JSON.stringify(obj);
$(function(){
	$("#demo").text(obj.name + " " + obj.age + " " + obj.add);
});
</script>
<script type="text/javascript">
var xmlHttp = new XMLHttpRequest();

xmlHttp.onreadystatechange = function(){
	if(xmlHttp.readyState === 4 && xmlHttp.status === 200){
		//json 데이터를 갖고있는 변수
		f1( xmlHttp.responseText );
	}
};

xmlHttp.open("GET", "jsonExam1.json", true);
xmlHttp.send();

function f1( resp ){
	//responseText를 통해 문자열을 가져왔음
	var arr = JSON.parse(resp);//받은 문자열을 JSON형태로 변환
	var txt = '';
	
	//key 또는 key:value쌍 취득 가능
	for(i = 0 ; i < arr.length ; i++ ){
		for(key in arr[i]){
			txt += key + ":" + arr[i][key] + "  <br/>";
		}		
	}	
	document.getElementById("showJson").innerHTML = txt;
	
	txt = '';
	for(i = 0 ; i < arr.length ; i++ ){
		txt += arr[i].name + " " +
				arr[i].age+ " " +
				arr[i].add + " " +
				arr[i].phone + " " + "<br/>";
	}
	document.getElementById("showJson2").innerHTML = txt;
}
</script>
</body>
</html>