<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세</title>
</head>
<body>

<div class="mainContiner">
	<div class="bbsDetailWrap">
		<table>
			<tr>
				<td>작성자</td>
			</tr>		
			<tr>
				<td>
					<p>${BbsDto.id }</p>
				</td>
			</tr>
			<tr>
				<td>제목</td>
			</tr>
			<tr>
				<td><p>${BbsDto.title }<p></td>
			</tr>
			<tr>
				<td>내용</td>
			</tr>
			<tr>
				<td>
					<textarea rows="15" cols="70">${BbsDto.content }</textarea>
				</td>
			</tr>
		</table>
	</div>
	<div class="bbsDetailNavWrap">
		<input type="button" value="돌아가기" onclick="location.href='<%=request.getContextPath()%>/showbbsordersearch.do'">
		<c:if test="${not empty currUser }">
			<input type="button" value="답글 달기" id="btnReply" onclick="location.href='<%=request.getContextPath()%>/shownewreply.do?seq=${BbsDto.seq }'">
		</c:if>
		<c:if test="${currUser.id == BbsDto.id}">
			<input type="button" value="게시글 수정" id="btnUpdate" onclick="location.href='<%=request.getContextPath()%>/showbbsupdate.do?seq=${BbsDto.seq }'">	
		</c:if>		
	</div>
</div>




</body>
</html>