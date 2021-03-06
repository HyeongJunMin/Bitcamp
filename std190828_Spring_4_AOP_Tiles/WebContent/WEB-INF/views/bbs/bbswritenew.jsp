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

<h3>새 글 작성</h3>

<div class="mainContiner">
	<div class="bbsWriteWrap">
		<form action="">
		<table>
			<tr>
				<td>작성자</td>
			</tr>		
			<tr>
				<td>
					<p id="currId">${currUser.id }</p>
				</td>
			</tr>
			<tr>
				<td>제목</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="title" name="title">
				</td>
			</tr>
			<tr>
				<td>내용</td>
			</tr>
			<tr>
				<td>
					<textarea rows="15" cols="70" id="content" name="content">${BbsDto.content }</textarea>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div class="bbsWriteNavWrap">
		<input type="button" value="돌아가기" onclick="location.href='<%=request.getContextPath()%>/showbbs.do'">
		<input type="button" value="저장" id="btnSave">
	</div>
</div>

<script type="text/javascript">
$(function(){

	//저장버튼 클릭 시 ajax통신
	$("#btnSave").click(function(){
		//배열 초기화
		var viewData = {};
		//data[키] = 밸류
		viewData["id"] = $("#currId").text().trim();
		viewData["title"] = $("#title").val();
		viewData["content"] = $("#content").val();
		//alert(viewData["id"] + viewData["title"] + viewData["content"]);
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			url:'writenew.do',
			type:'post',
			data:JSON.stringify(viewData),
			success:function(resp){
				//alert(resp);
				if( resp === 1){
					alert('저장이 완료되었습니다.');
					location.href="showbbs.do";
				}else{
					alert('저장에 실패했습니다. 다시 시도해 주세요.');
				}
				
			},
			error:function(){
				alert('저장 중 에러가 발생했습니다. 다시 시도해 주세요.');
			}
		});
	});
});
</script>

</body>
</html>