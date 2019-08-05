<%@page import="movieJsoup.MovieManager"%>
<%@page import="movieJsoup.MovieVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap, jQuery CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
</head>
<body>

<%
	List<MovieVO> lst = MovieManager.getCGVData();

	for(MovieVO vo : lst){
		out.println(vo.toString());
	}
	
	String jsonlike = "[";
	
	for(MovieVO vo : lst){
		jsonlike += "{ name:'" + vo.getTitle() + "', y:" + vo.getLike() +" } ,";
	}
	
	jsonlike = jsonlike.substring(0, jsonlike.lastIndexOf(","));
	jsonlike += "]";
	out.println(jsonlike);
	
	//자바스크립트로 사용하기 위해 json 문자열을 객체로 만들어줌
	request.setAttribute("jsonlike", jsonlike);
%>

	<div id="container"
		style="min-width: 310px; height: 400px; max-width: 600px; margin: 0px auto; overflow: hidden;"
		data-highcharts-chart="0">
		<div id="highcharts-5r7bhgf-0" dir="ltr" class="highcharts-container "
			style="position: relative; overflow: hidden; width: 600px; height: 400px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
		</div>
	</div>


<script type="text/javascript">
	Highcharts.chart('container', {
	  chart: {
	    plotBackgroundColor: null,
	    plotBorderWidth: null,
	    plotShadow: false,
	    type: 'pie'
	  },
	  title: {
	    text: '영화가 좋아요'
	  },
	  tooltip: {
	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	  },
	  plotOptions: {
	    pie: {
	      allowPointSelect: true,
	      cursor: 'pointer',
	      dataLabels: {
	        enabled: true,
	        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	        style: {
	          color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	        }
	      }
	    }
	  },
	  series: [{
	    name: 'Brands',
	    colorByPoint: true,
	    data: <%=request.getAttribute("jsonlike") %>
	  }]
	});
</script>

</body>
</html>