<%@page import="com.dto.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/static/js/freeboard/freeboardpostdetail.js"></script>
<div id="postdetailMain" align="center">
	<form action="http://localhost:8090/std190730_JSP6_BBS_reply/bbs" id="writenewForm" method="GET">
	<%
		BbsDTO dto = new BbsDTO();
		if( request.getAttribute("currBbsDTO") != null ){
			dto = (BbsDTO)request.getAttribute("currBbsDTO");
		}
	%>
	<div id="postdetailContent">
		<input type="hidden" name="command" value="postdetail">
		<input type="hidden" name="id" value="<%=session.getAttribute("currId") %>">
		<table>
			<tr class="postdetailTblLable">
				<td colspan="4">작성자</td>
			</tr>
			<tr>
				<td colspan="4"><a id="postdetailId"></a></td>
			</tr>
			<tr class="postdetailTblLable">
				<td colspan="4">제목</td>
			</tr>
			<tr class="postdetailTblLable">
				<td colspan="4"><input readonly="readonly" type="text" id="postdetailTxtTitle" name="inputTitle" value="<%=dto.getTitle() %>"></td>
			</tr>
			<tr class="postdetailTblLable">
				<td colspan="4">내용</td>
			</tr>
			<tr class="postdetailTblLable">
				<td colspan="4"><textarea readonly="readonly" rows="15" cols="80" id="postdetailTxtContent" name="inputContent"></textarea></td>
			</tr>
		</table>
	</div>
	<br>
	<div id="writenewBtns">
	<input type="button" class="btn" value="돌아가기" id="postdetailBtnCancel">
	<input type="button" class="btn btn-primary" value="답글작성" id="postdetailBtnReply">
	<input type="button" class="btn btn-primary" value="수정" id="postdetailBtnSave" style="display:none;">
	</div>
	</form>
</div>
</html>