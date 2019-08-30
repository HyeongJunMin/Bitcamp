<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<!-- 게시글 상세정보 -->
<table class="content_table" style="width: 85%;">
	<colgroup>
		<col style="width: 70px;">
		<col style="width: auto;">
		<col style="width: 100px;">
	</colgroup>

	<tbody>
		<tr>
			<td>작성자 : ${bbs.id }</td>
		</tr>
		<tr>
			<td>제목 : ${bbs.title }</td>
		</tr>
		<tr>
			<td>내용</td>
		</tr>
		<tr>
			<td>
				<textarea rows="15" cols="120" readonly>${bbs.content }</textarea>
			</td>
		</tr>
	</tbody>
</table>

<input type="button" value="돌아가기" id="btnBackInDetail" onclick="history.back();">
<c:if test="${not empty login }">
	<c:if test="${login.id == bbs.id }">
		<input type="button" value="수정하기" id="btnModInDetail" onclick="location.href='bbsmod.do?seq=${bbs.seq}'">
		<input type="button" value="삭제하기" id="btnDelInDetail">
	</c:if>	
</c:if>

<script>
$(function(){
	
	//삭제 ajax
	$("#btnDelInDetail").click(function(){
		alert('삭제버튼');
		//배열 초기화
		var viewData = {};
		//data[키] = 밸류
		viewData["seq"] = ${bbs.seq};
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			url:'bbsdeletepost.do',
			type:'post',
			data:JSON.stringify(viewData),
			success:function(resp){
				//alert(resp);
				if( resp === 1){
					alert('삭제가 완료되었습니다.');
					location.href="bbslist.do";
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

</html>