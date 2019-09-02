<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<form action="pdsmodAf.do" id="_frmForm" name="frmForm" method="post"
	enctype="multipart/form-data">

	<table class="list_table">
		<tr>
			<th>아이디</th>
			<td style="text-align: left;">
				<input type="text" name="id" readonly="readonly" value="${pds.id }" size="50">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td style="text-align: left;">
				<input type="text" name="title" size="50" value="${pds.title }">
			</td>
		</tr>
		<tr>
			<th>파일</th>
			<td style="text-align: left;">				
				<input type="hidden" name="filename" value="${pds.filename }">
				<div id="modwrapBf">
					${pds.filename }
					<input type="button" id="btnModFile" value="자료 수정">	
				</div>				
				<div id="modwrapAf">
					<input type="file" id="btnUploadFile" name="fileload" style="width: 200px;" value="업로드">
					<input type="button" id="btnCancelModFile" value="수정 취소">
				</div>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td style="text-align: left;">
				<textarea rows="10" cols="50" name="content">${pds.content }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="height:50px; text-align: center;">
				<span class="button blue">
					<button type="button" id="_btnBackToList" onclick="location.href='pdsdetail.do?seq=${pds.seq }';">돌아가기</button>
					<button type="button" id="_btnSave">저장</button>
				</span>
			</td>
		</tr>
	</table>

</form>

<script type="text/javascript">
$(function(){
	$("#modwrapAf").hide();
	
	//자료 수정 버튼 클릭 시 수정할 수 있는 메뉴로 전환
	$("#btnModFile").click(function(){
		$("#modwrapBf").hide();
		$("#modwrapAf").show();		
	});
	
	//수정 취소 버튼 클릭 시 원상태로 복귀
	$("#btnCancelModFile").click(function(){
		$("#modwrapAf").hide();	
		$("#modwrapBf").show();
	});
	
	$("#_btnSave").click(function(){		
		$("#_frmForm").submit();
	});
});
</script>

</html>