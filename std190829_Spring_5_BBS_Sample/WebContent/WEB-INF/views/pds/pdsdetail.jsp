<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<table class="list_table">
		<tr>
			<th>작성자</th>
			<td style="text-align: left;">${pds.id }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td style="text-align: left;">${pds.title }</td>
		</tr>
		<tr>
			<th>파일다운로드</th>
			<td style="text-align: left;">${pds.origin_filename } <input type="button" name="btnDownload" value="다운로드" onclick="filedowns('${pds.filename}', '${pds.seq }');"></td>
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
					<button type="button" id="_btnBackToList" onclick="location.href='pdslist.do';">돌아가기</button>
					<c:if test="${pds.id == login.id }">
						<button type="button" id="_btnPdsMod" onclick="location.href='pdsmod.do?seq=${pds.seq }';">글 수정</button>
					</c:if>
				</span>
				
			</td>
		</tr>		
	</table>

<!-- 다운로드 버튼 클릭 시 -->
<form name="file_Down" action="fileDownload.do" method="post">
	<input type="hidden" name="filename">
	<input type="hidden" name="seq">
</form>

<script type="text/javascript">
//파일 다운로드 버튼 클릭 이벤트
function filedowns(filename, seq){
	var doc = document.file_Down;
	doc.filename.value = filename;
	doc.seq.value = seq;
	doc.submit();
}

</script>

</html>