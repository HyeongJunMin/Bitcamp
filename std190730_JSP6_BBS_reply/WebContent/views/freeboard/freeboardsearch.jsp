<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/static/js/freeboard/freeboardsearch.js"></script>
<div id="mainContentSearchPost">
		<select id="mainContenSearchSelect" name="option">
			<option value="1">제목</option>
			<option value="2">내용</option>
			<option value="3">작성자</option>
		</select>
		<input type="text" placeholder="검색어 입력" id="mainContentSearchTxt" size="15" name="condition">
		<input type="button" value="검색" id="mainContentSearchBtn">
</div>
</html>
237-390-000