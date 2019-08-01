<%@page import="dto.MemberDto"%>
<%@page import="dto.CalendarDto"%>
<%@page import="dao.CalendarDao"%>
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
</head>
<body>


<%
	String currId = "guest";
	if( (MemberDto)session.getAttribute("login") != null ){
		currId = ( (MemberDto)session.getAttribute("login") ).getId();
	}


	int seq = Integer.parseInt(request.getParameter("seq")+"");

	CalendarDto dto = CalendarDao.getInstance().getOneSch(seq);
	
	if( dto != null ){
		out.println(dto.toString());
	}
%>

<div align="center">
<form action="caldetailAf.jsp" id="caldetailForm" method="get">
<br><br><h3>Calendar detail page</h3><br><br>
<input type="hidden" value="<%=currId %>" id="currId">
<input type="hidden" id="command" name="_command" value="none">
<table>
	<tr>
		<td>No</td>
		<td> <input type="text" value="<%=dto.getSeq() %>" readonly="readonly" name="_seq"> </td>
	</tr>
	<tr>
		<td>ID</td>
		<td> <input type="text" value="<%=dto.getId() %>" readonly="readonly" id="author" name="_author"> </td>
	</tr>
	<tr>
		<td>Title</td>
		<td> <input type="text" value="<%=dto.getTitle() %>" readonly="readonly" id="title" name="_title"> </td>
	</tr>
	<tr>
		<td colspan="2">Content</td>
	</tr>
	<tr>
		<td colspan="2"> <textarea rows="20" cols="70" readonly="readonly" id="content" name="_content"><%=dto.getContent() %></textarea>  </td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" id="btnReturnInCalDetail" value="돌아가기">
			<input type="button" id="btnModifyInCalDetail" value="수정" disabled="disabled">
			<input type="button" id="btnDeleteInCalDetail" value="삭제" disabled="disabled">
		</td>
	</tr>
</table>
</form>
</div>
<script type="text/javascript">
$(function(){
	var currId = $("#currId").val();
	var author = $("#author").val();
	var originTitle = $("#title").val();
	var originContent = $("#content").text();
	
	//돌아가기 버튼 클릭
	$("#btnReturnInCalDetail").click(function(){
		location.href = "calendar.jsp";
	});
	
	//수정 버튼 클릭
	$("#btnModifyInCalDetail").click(function(){
		//alert('mod');
		$("#command").val('mod');
		$("#caldetailForm").submit();
	});
	
	//삭제 버튼 클릭
	$("#btnDeleteInCalDetail").click(function(){
		//alert('del');
		$("#command").val('del');
		$("#caldetailForm").submit();
	});
	
	//세션 ID가 일정 작성자와 동일한 경우 readonly 해제
	if( currId === author){
		$("#btnDeleteInCalDetail").removeAttr("disabled");
		$("#title").removeAttr("readonly");
		$("#content").removeAttr("readonly");
		
		//제목 또는 내용 변경 시 수정버튼 활성화
		$("#title").keyup(function(){
			var currTitle = $("#title").text();
			if( currTitle === originTitle){
				$("#btnModifyInCalDetail").attr("disabled","");
			}else{
				$("#btnModifyInCalDetail").removeAttr("disabled","");
			}
		});		
		$("#content").keyup(function(){
			var currContent = $("#content").val();
			if( currContent === originContent){
				$("#btnModifyInCalDetail").attr("disabled","");
			}else{
				$("#btnModifyInCalDetail").removeAttr("disabled","");
			}
		});
		
		
	//세션 ID가 일정 작성자와 동일하지 않은 경우
	}else{
		$("#btnDeleteInCalDetail, #btnModifyInCalDetail").click(function(){
			alert('작성자만 사용할 수 있는 기능입니다.');
		});
	}

});
</script>

</body>
</html>