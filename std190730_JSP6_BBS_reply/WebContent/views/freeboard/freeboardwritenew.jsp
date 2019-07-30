<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/static/js/freeboard/freeboardwritenew.js"></script>
<div id="writenewMain" align="center"  style="display:none;">
	<form action="http://localhost:8090/std190730_JSP6_BBS_reply/bbs" id="writenewForm" method="GET">
	<div id="writenewContent">
		<input type="hidden" name="command" value="writenewpost">
		<input type="hidden" name="id" value="<%=session.getAttribute("currId") %>">
		<table>
			<tr class="writenewTblLable">
				<td colspan="4"><h3>새 글 작성</h3></td>
			</tr>
			<tr class="writenewTblLable">
				<td colspan="4">작성자</td>
			</tr>
			<tr>
				<td colspan="4"><%=session.getAttribute("currId") %></td>
			</tr>
			<tr class="writenewTblLable">
				<td colspan="4">제목</td>
			</tr>
			<tr class="writenewTblLable">
				<td colspan="4"><input type="text" id="writenewTxtTitle" name="inputTitle"></td>
			</tr>
			<tr class="writenewTblLable">
				<td colspan="4">내용</td>
			</tr>
			<tr class="writenewTblLable">
				<td colspan="4"><textarea rows="15" cols="80" id="writenewTxtContent" name="inputContent"></textarea></td>
			</tr>
		</table>
	</div>
	<br>
	<div id="writenewBtns">
	<input type="button" class="btn" value="취소" id="writenewBtnCancel">
	<input type="button" class="btn btn-primary" value="저장" id="writenewBtnSave">
	</div>
	</form>
</div>
</html>