<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/work3-1.js"></script>
<style type="text/css">
#q30_box { width: 200px; height: 100px; background: #999; } 
</style>
</head>
<body>
id 명 q27요소에 1 ~ 100까지의 숫자를 문자열 ","를 뒤에 추가하여 출력하라
<div id="q27"></div><input type="button" id="btn27" value="go">
<br>
“커피”, “홍차”, “우유”, “주스”, “소다” 값이 포함 된 배열명 menu에 할당 된 수만큼
class 명 q28의 ul 요소 목록 요소로 추가하라<input type="button" id="btn28" value="go">
<ul class= "q28"></ul>
<br>
id 명 q29_val에 값을 입력하고 id 명 q29_button을 클릭하면 그 값을 변수 val에 대입하고 변수 val가 70 이상이면 "합격", 70 이하면 '실패 “를 id 명 q29_answer에 출력하는 처리를 반환하는 사용자 정의 함수 funcValReturn를 작성하라
<input id= "q29_val" type="text" /> <input id= "q29_button" type="button" value=" 결과는 " />
<p id="q29_answer"></p>
<br>
id 명 q30_select에서 뽑은 수치를 id 명 q30_box요소의 폭을 변경하는 사용자 정의 함수 
funcCssChenge()를 만들고 id 명 q30_color요소를 클릭하면 2 초 후에 실행되도록 하라
<select id= "q30_select"> 
<option value= "100" >100</option> 
<option value= "200" >200</option> 
<option value= "300" >300</option> 
<option value= "400" >400</option> 
<option value= "500" >500</option> 
</select> 
<input type= "button" id="q30_color" value=" 박스폭 변경 "> 
<div id="q30_box"></div>
<br><br>
두 수를 입력 한 값을 select에서 선택한 계산 방법에 id 명 q31_button를 클릭 한 후 
덧셈, 뺄셈, 곱셈, 나눗셈 각각의 처리 함수를 작성 조건에 맞는 계산 결과를 
id 명 q31_answer에 출력하라
<div id= "q31_box"> 
<label>첫번째수</label> <input id= "q31_val" type="text" size="3" width="50" /> 
<label>두번째수</label> <input id= "q31_subject" type="text" size="3" width="50" /> 
<select id= "q31_select"> 
<option value= "addition" > 더하기 </option> 
<option value= "subtraction" > 빼기 </option> 
<option value= "multiplication" > 곱하기 </option> 
<option value= "division" > 나누기 </option> </select> 
<input id= "q31_button" type="button" value=" 계산 " /> 
<p id= "q31_answer"></p> </div>

</body>
</html>