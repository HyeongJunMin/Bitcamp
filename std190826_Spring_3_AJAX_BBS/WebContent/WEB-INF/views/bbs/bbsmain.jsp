<%@page import="bit.com.a.bbs.model.BbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("crcn", "\r\n"); %>
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
				<c:if test="${fn:length(bbsList) < 1 }">
					<tr>
						<td colspan="8"><a href="showbbsordersearch.do">검색 결과가 없습니다.</a></td>
					</tr>
				</c:if>
				<c:forEach items="${bbsList }" var="bbs">
					<tr class="tblBbsTr">
						<td>${bbs.seq }</td>
						<td>
							<c:forEach var="i" begin="1" end="${bbs.depth }">
								<c:out value="&nbsp;" escapeXml="false"/>
							</c:forEach>
							${bbs.title}							
						</td>
						<td>${bbs.id} </td>
						<td>${fn:substring(bbs.wdate,0,10) } </td>
						<td>${bbs.readcount} </td>
						<td>${bbs.ref }</td>
						<td>${bbs.step }</td>
						<td>${bbs.depth }</td>
					</tr>				
				</c:forEach>
			</table>
			<ul class="pagingNav">
				<c:choose>				 
				    <c:when test="${bbsOrderDto.cond eq '4'}">
				    	<c:forEach var="i" begin="${bbsOrderDto.firstNavIndex }" end="${bbsOrderDto.lastNavIndex }" step="1">
							<li class="pagingNavItem"><c:out value="${i}"/></li>
						</c:forEach>
				    </c:when>				 			 
				    <c:otherwise>
						<c:forEach var="i" begin="${bbsOrderDto.firstNavIndex }" end="${bbsOrderDto.lastNavIndex }" step="1">
							<li class="pagingNavItemWithSearchCond"><c:out value="${i}"/></li>
						</c:forEach>
				    </c:otherwise>				 
				</c:choose>
			</ul>
		</div>		
		<div class="bbsListSearchConditions">
			<select id="cond">
				<option value="0" <c:out value="${bbsOrderDto.cond == '0'?'selected':'' }"/>>제목</option>
				<option value="1" <c:out value="${bbsOrderDto.cond == '1'?'selected':'' }"/>>내용</option>
				<option value="2" <c:out value="${bbsOrderDto.cond == '2'?'selected':'' }"/>>아이디</option>
			</select>
			<input type="text" id="keyword" value="${bbsOrderDto.keyword != ''?bbsOrderDto.keyword:'' }">
			<input type="button" id="btnSearch" value="검색">
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
	
	//검색 조건이 없을 때 페이징 네비게이션
	$(".pagingNavItem").click(function(){
		location.href='showbbsordersearch.do?pageNum=' + $(this).text();
	});
	
	//검색 조건이 있을 때 페이징 네비게이션
	$(".pagingNavItemWithSearchCond").click(function(){
		var cond = $("#cond option:selected").val();
		var keyword = $("#keyword").val();
		location.href='showbbsordersearch.do?pageNum=' + $(this).text() + '&cond=' + cond + '&keyword=' + keyword; 
	});
	
	//검색버튼 클릭 시 조건에 맞는 검색페이지로 이동
	$("#btnSearch").click(function(){
		var cond = $("#cond option:selected").val();
		var keyword = $("#keyword").val();
		location.href='showbbsordersearch.do?pageNum=1&cond=' + cond + '&keyword=' + keyword; 
	});
});

</script>

</body>
</html>