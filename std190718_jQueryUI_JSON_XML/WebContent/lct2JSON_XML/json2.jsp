<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/json1.jsp">json1</a>
<a href="/json2.jsp">json1</a>
<h3>Write JSON file, parse JSON file</h3>
<h6>Show title, author, price of 4 books by table</h6>

<div id="jsonTbl"></div>

<script type="text/javascript">
//xml객체 생성
var xmlHttp = new XMLHttpRequest();

xmlHttp.onreadystatechange = function(){
	if(xmlHttp.readyState === 4 && xmlHttp.status === 200){
		mkTbl( xmlHttp.responseText );
	}
};

xmlHttp.open("GET", "books.json", true);
xmlHttp.send();

function mkTbl( resp ){
	//responseText를 통해 문자열을 가져왔음
	var arr = JSON.parse(resp);//받은 문자열을 JSON형태로 변환
	var txt = '';
	
	var tbl = document.createElement("table");
	var tr = document.createElement("tr");
	var tdNo = document.createElement("td");
	var tdTitle = document.createElement("td");
	var tdAuthor = document.createElement("td");
	var tdPrice = document.createElement("td");
	
	tdNo.innerHTML = "No";
	tdTitle.innerHTML = "Title";
	tdAuthor.innerHTML = "Author";
	tdPrice.innerHTML = "Price";
	tr.appendChild(tdNo);
	tr.appendChild(tdTitle);
	tr.appendChild(tdAuthor);
	tr.appendChild(tdPrice);
	tbl.appendChild(tr);
	tr = document.createElement("tr");
	
	//key 또는 key:value쌍 취득 가능
	txt = '';
	for(i = 0 ; i < arr.length ; i++ ){
		tdNo = document.createElement("td");
		tdTitle = document.createElement("td");
		tdAuthor = document.createElement("td");
		tdPrice = document.createElement("td");

		tdNo.innerHTML = (i+1);
		tdTitle.innerHTML = arr[i].title;
		tdAuthor.innerHTML = arr[i].author;
		tdPrice.innerHTML = arr[i].price;
		
		tr.appendChild(tdNo);
		tr.appendChild(tdTitle);
		tr.appendChild(tdAuthor);
		tr.appendChild(tdPrice);
		
		tbl.appendChild(tr);
		
		tr = document.createElement("tr");				
	}
	jsonTbl.appendChild(tbl);
}
</script>
</body>
</html>