<%@page import="bit.com.a.model.PollSubDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<!-- 파이차트를 그리기 위한 하이차트 모듈 -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<%
	List<PollSubDto> list = (List<PollSubDto>)request.getAttribute("pollsublist");
	String jsonData = "[";
	
	for( PollSubDto d : list ){
		jsonData += "{ 'name' :'" + d.getAnswer() + "', 'y' :" + d.getAcount() + "},";
	}
	
	jsonData = jsonData.substring(0, jsonData.lastIndexOf(","));
	jsonData += "]";
	System.out.println(jsonData);
	request.setAttribute("jsonData", jsonData);
%>

<table class="list_table" style="95%">
	<colgroup>
	<col width="200px" /><col width="500px" />
	</colgroup>
	<tr>
		<th>투표번호</th>
		<td style="text-align:left">
			<input type="text" name="pollid" value="${poll.pollid }" size="50" readonly="readonly"/>
		</td>	
	</tr>
	<tr>
		<th>아이디</th>
		<td style="text-align:left">
			<input type="text" name="id" value="${login.id }" size="50" readonly="readonly"/>
		</td>
	</tr>
	<tr>
		<th>투표기한</th>
		<td style="text-align:left">
			${poll.sdate }~${poll.edate }
		</td>
	</tr>
	<tr>
		<th>투표내용</th>
		<td style="text-align:left">
		<textarea name="question" cols="50" rows="10" readonly="readonly" >${poll.question }</textarea>
		</td>
	</tr>
	<tr>
		<th>투표 문항수</th>
		<td style="text-align:left">
			${poll.itemcount }개
		</td>
	</tr>
	<tr>
		<th>투표 상세 문항</th>
		<td style="text-align:left">
			<c:forEach var="psub" items="${pollsublist }" varStatus="vs">
				<table class="list_table" style="width:95%">
				<col width="50" /><col width="500" />
				<tr>
					<th>${vs.count }번</th>
					<td style="text-align:left">
						<input type="text" size="60" readonly="readonly" 
						name="answer" value="${psub.answer }"/>
					</td>
				</tr>
				</table>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<th>투표결과(전체 투표자 : ${poll.polltotal }명)</th>
		<td style="text-align:left">
			<div id="container"></div>
			
			<jsp:useBean id="vbean" class="bit.com.a.model.VoteBean" />
			<c:forEach var="psub" items="${pollsublist }" varStatus="vs">
				<jsp:setProperty property="acount" name="vbean" value="${psub.acount }"/>
				<jsp:setProperty property="total"  name="vbean" value="${poll.polltotal }"/>
				
				<table class="list_table" style="width:95%">
					<col width="50" /><col width="500" />
					<tr>
						<th>${vs.count }번</th>
						<td style="text-align:left">
							<jsp:getProperty property="makeBar" name="vbean"/>
						</td>
					</tr>
				</table>
			</c:forEach>
		</td>
	</tr>
</table>

<a href="polllist.do">투표목록</a>

<script type="text/javascript">

Highcharts.chart('container', {
	  chart: {
	    plotBackgroundColor: null,
	    plotBorderWidth: null,
	    plotShadow: false,
	    type: 'pie'
	  },
	  title: {
	    text: '투표 통계 결과'
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
	        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	      }
	    }
	  },
	  series: [{
	    name: '투표',
	    colorByPoint: true,
	    data: <%=request.getAttribute("jsonData") %>
	  }]
});

</script>

</html>