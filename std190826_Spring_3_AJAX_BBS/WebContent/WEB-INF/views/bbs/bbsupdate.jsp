<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<c:if test="${currUser.id != BbsDto.id}">
	<script type="text/javascript">
		alert('수정 권한이 없습니다.');
		history.back();
	</script>
</c:if>
<h3>${BbsDto.id }님의 게시글 수정</h3>
<div class="mainContiner">
	<div class="bbsUpdateWrap">
		<form action="">
		<input type="hidden" value="${BbsDto.seq }" id="txtSeq" name="seq">
		<table>
			<tr>
				<td>작성자</td>
			</tr>		
			<tr>
				<td>
					<input type="text" id="txtId" name="id" value="${BbsDto.id }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>제목</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="txtTitle" name="title" value="${BbsDto.title }">
				</td>
 			</tr>
			<tr>
				<td>내용</td>
			</tr>
			<tr>
				<td>
					<textarea rows="15" cols="70" name="content" id="txtContent">${BbsDto.content }</textarea>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div class="bbsDetailNavWrap">
		<input type="button" value="돌아가기" onclick="location.href='<%=request.getContextPath()%>/showbbsordersearch.do'">		
		<input type="button" value="수정내용 저장" id="btnUpdate">	
		<input type="button" value="게시물 삭제" id="btnDelete">
	</div>
</div>

<script type="text/javascript">
$(function(){
	$("#btnUpdate").click(function(){
		
	});
	
	//삭제버튼 클릭 시 ajax통신
	$("#btnDelete").click(function(){
		//배열 초기화
		var viewData = {};
		//data[키] = 밸류
		viewData["seq"] = $("#txtSeq").val();
		viewData["id"] = $("#txtId").val();
		viewData["title"] = $("#txtTitle").val();
		viewData["content"] = $("#txtContent").text();
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			url:'deletepost.do',
			type:'post',
			data:JSON.stringify(viewData),
			success:function(resp){
				//alert(resp);
				if( resp === 1){
					alert('삭제가 완료되었습니다.');
					location.href="showbbsordersearch.do";
				}else{
					alert('삭제에 실패했습니다. 다시 시도해 주세요.');
				}
				
			},
			error:function(){
				alert('error');
			}
		});
	});
});
</script>

</body>
</html>
