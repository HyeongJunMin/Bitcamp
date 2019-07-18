<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p id="demo"></p>
<input type="button" value="go" onclick="loadXMLDoc()">

<script type="text/javascript">
var xhttp = new XMLHttpRequest();

function loadXMLDoc(){
	xhttp.onreadystatechange = function(){	
		//실제 데이터를 보내는 곳, 준비상태를 계속 유지함
		if(this.readyState == 4 && this.status == 200){
			//document.getElementById("demo").innerHTML = this.responseText;
			//f1(this);
			//f2(this);
			f3(this);
		}		
	};
	
	xhttp.open("GET", "xmlExam1.xml", true);	//데이터 파일 설정
	xhttp.send();	//전송
}

function f1( xml ){
	//xml 내부 태그 이름을 알고 있는 경우
	var name;
	var txt, ntxt, xmlDoc;
	txt = ntxt = '';
	xmlDoc = xml.responseXML;
	name = xmlDoc.getElementsByName("title");
	
	for(i = 0 ; i < name.length ; i++){
		txt += name[i].childNodes[0].nodeValue + "<br/>";
	}
	
	document.getElementById("demo").innerHTML = txt;
}

function f2( xml ){
	//xml 내부 태그 이름을 알지 못하는 경우
	var arr, xmlDoc, txt;
	txt = "";
	xmlDoc = xml.responseXML;
	arr = xmlDoc.documentElement.childNodes;
	
	for(i = 0 ; i < arr.length ; i++){
		if(arr[i].nodeType == 1){
			txt += arr[i].nodeName + "<br/>";
		}
	}
	document.getElementById("demo").innerHTML = txt;
}

function f3( xml ){
	var arr, xmlDoc, txt;
	txt = "";
	xmlDoc = xml.responseXML;
	arr = xmlDoc.getElementsByTagName("movie")[0];
	//alert(arr.childNodes.length);
	var fChild = arr.firstChild;
	for(i = 0 ; i < arr.childNodes.length ; i++){
		if(fChild.nodeType == 1 ){//타입이 정상일 때
			txt += i + " " + fChild.nodeName + "<br/>";
		}
		fChild = fChild.nextSibling;
	}
	document.getElementById("demo").innerHTML = txt;
}
</script>
</body>
</html>