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

</head>
<body>
<a href="../index.jsp">Go to home</a>
<a href="./datepicker.jsp">Lecture 1 DatePicker</a>
<a href="./slider.jsp">Lecture 2 Slider</a>
<h1>jQuery UI Slider</h1>
<img alt="" src="./images/p1.jpg">
<img alt="" src="./images/p2.jpg">
<img alt="" src="./images/p3.jpg">
<div id="imgSlider" style="width:250px;"></div>
<div id="imgSlider2" style="width:500px;"></div>
<p id="imgSliderOpacity"></p>

<script type="text/javascript">
$(function() {	
	$("#imgSlider").slider({
		animate: true
		,range: "min"
		,value: 100
		,slide: function(event, ui){
			console.log("slide moved");
			$("#sliderId").css( {"opacity" : ui.value/100 } );
			$("#imgSliderOpacity").text( "투명도 : " + ui.value );
                        $("#imgSlider2").slider('value', ui.value );
		}		
	});
        $("#imgSlider2").slider({
                animate: true
                ,range: "min"
                ,value: 100
                ,slide: function(event, ui){
                       $("#imgSlider").slider('value', ui.value );
                }
        });
});
</script>
</div>
</body>
</html>