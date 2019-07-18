<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="./js/datepicker.js"></script>
</head>
<body>
<a href="../index.jsp">Go to home</a>
<a href="./datepicker.jsp">Lecture 1 DatePicker</a>
<a href="./slider.jsp">Lecture 2 Slider</a>
<h2>jQueryUI 달력</h2>
<h3>date picker</h3>
<p>선택일:<input type="text" id="date"></p>
<p>textbox를 클릭하면, 달력이 표시됩니다.</p>
연도:<input type="text" id="year" size="5"><br>
월:<input type="text" id="month"><br>
일:<input type="text" id="dateNum"><br>
요일:<input type="text" id="dayOfWeek"><br>

</body>
</html>