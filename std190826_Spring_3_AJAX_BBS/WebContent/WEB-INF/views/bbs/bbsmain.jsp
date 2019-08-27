<%@page import="bit.com.a.bbs.model.BbsDto"%>
<%@page import="java.util.List"%>
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
게시판 메인

<div class="mainContainer">
	<div class="bbsContent">
		<div class="bbsListWrap">
			<table class="tblBbs">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회</th>
					<th>ref</th>
					<th>step</th>
					<th>depth</th>					
				</tr>
				<c:forEach items="${bbsList }" var="bbs">
					<tr class="tblBbsTr">
						<td>${bbs.seq }</td>
						<td>${bbs.title} </td>
						<td>${bbs.id} </td>
						<td>${bbs.wdate} </td>
						<td>${bbs.readcount} </td>
						<td>${bbs.ref }</td>
						<td>${bbs.step }</td>
						<td>${bbs.depth }</td>	
					</tr>				
				</c:forEach>
			</table>
		</div>		
	</div>
</div>

<!-- 세션에 아이디가 있으면 버튼 활성화 -->
<c:if test="${not empty currUser.id}">
	<input type="button" value="로그아웃" id="btnLogout" onclick="location.href='logout.do';"/>
	<input type="button" value="새 글 작성" id="btnWriteNew" onclick="location.href='showwritenew.do'; "/>	
</c:if>
<!-- 세션에 아이디가 없으면 버튼 활성화 -->
<c:if test="${empty currUser.id}">
	<input type="button" value="로그인" id="btnLogin" onclick="location.href='showlogin.do';"/>	
</c:if>

<script type="text/javascript">

$(function(){	
	//테이블 행 클릭 시 seq에 맞는 디테일 페이지로 이동
	$(".tblBbsTr").click(function(){
		var seq = $(this).children().eq(0).text().trim();
		location.href="showbbsdetail.do?seq=" + seq;
	});
});

</script>

</body>
</html>