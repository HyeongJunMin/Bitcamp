<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:if test="${empty login || login.id != bbs.id }">
	<script type="text/javascript">alert('수정 권한이 없습니다.'); history.back();</script>
</c:if>
<!-- 게시글 수정 -->
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
			<td>제목 : <input type="text" id="_titleInBbsMod" name="title" value="${bbs.title }"></td>
		</tr>
		<tr>
			<td>내용</td>
		</tr>
		<tr>
			<td>
				<textarea rows="15" cols="120" id="_contentInBbsMod" name="content">${bbs.content }</textarea>
			</td>
		</tr>
	</tbody>
</table>

<input type="button" value="돌아가기" id="btnBackInDetail" onclick="history.back();">
<c:if test="${not empty login }">
	<c:if test="${login.id == bbs.id }">
		<input type="button" value="저장하기" id="btnModInDetail">
		<input type="button" value="삭제하기" id="btnDelInMod">
	</c:if>	
</c:if>
<script>
$("#_contentInBbsMod").focus();
$(function(){
	//삭제 ajax
	$("#btnDelInMod").click(function(){
		//alert('삭제버튼');
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
	
	//수정 ajax
	$("#btnModInDetail").click(function(){
		//alert('수정버튼');
		//배열 초기화
		var viewData = {};
		//data[키] = 밸류
		viewData["seq"] = ${bbs.seq};
		viewData["id"] = ${bbs.id};
		viewData["title"] = $("#_titleInBbsMod").val();
		viewData["content"] = $("#_contentInBbsMod").val();
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			url:'bbsmodify.do',
			type:'post',
			data:JSON.stringify(viewData),
			success:function(resp){
				//alert(resp);
				if( resp === 1){
					alert('수정이 완료되었습니다.');
					//location.href="bbsmod.do?seq=" + viewData["seq"];					
				}else{
					alert('수정에 실패했습니다. 다시 시도해 주세요.');
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