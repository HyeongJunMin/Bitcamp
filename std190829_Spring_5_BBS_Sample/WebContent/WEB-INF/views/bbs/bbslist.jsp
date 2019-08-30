<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 검색 -->
<div class="box_border" style="margin-top: 5px; margin-bottom: 10px;">
	<form action="" name="frmForm1" id="_frmFormSearch" method="post">
		<table style="margin-left: auto; margin-right: auto; margin-top: 3px; margin-bottom: 3px;">
			<tr>
				<td>검색:</td>
				<td style="padding-left: 5px;">
					<select id="_s_category" name="s_category">
						<option value="" <c:out value="${param.s_category == ''?'selected':'' }"/> >선택</option>
						<option value="title" <c:out value="${param.s_category == 'title'?'selected':'' }"/> >제목</option>
						<option value="contents" <c:out value="${param.s_category == 'contents'?'selected':'' }"/> >내용</option>
						<option value="writer" <c:out value="${param.s_category == 'writer'?'selected':'' }"/> >작성자</option>
					</select>
				</td>
				<td style="padding-left: 5px;">
					<input type="text" id="_s_keyword" name="s_keyword" value="${param.s_keyword != ''?param.s_keyword:'' }">
				</td>
				<td style="padding-left: 5px;">
					<span class="button blue">
						<button type="button" id="_btnSearch">검색</button>
					</span>
				</td>
			</tr>
		</table>
		<input type="hidden" name="pageNumber" id="_pageNumber" value="${(empty pageNumber)?0:pageNumber }">
		<input type="hidden" name="recordCountPerPage" id="_recordCountPerPage" value="${(empty recordCountPerPage)?0:recordCountPerPage }">
	</form>
</div>

<!-- 글 목록 -->
<jsp:useBean id="ubbs" class="bit.com.a.util.BbsArrow"/><!-- arrow 객체 생성 -->
<table class="list_table" style="width: 85%;">
	<colgroup>
		<col style="width: 70px;">
		<col style="width: auto;">
		<col style="width: 100px;">
	</colgroup>
	<thead>
		<tr>
			<th>번호</th><th>제목</th><th>작성자</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty bbslist }">
			<tr>
				<td colspan="3">작성된 글이 없습니다.<br><br><br><a href="bbslist.do">돌아가기</a></td>
			</tr>
		</c:if>
		<c:forEach items="${bbslist }" var="bbs" varStatus="vs"><!-- vs가 카운트값을 가짐 -->
			<jsp:setProperty property="depth" name="ubbs" value="${bbs.depth }"/> <!-- setDepth를 호출하는 코드(BbsArrow.java) -->
			<tr class="_hover_tr">
				<td>${vs.count }</td>
				<td style="text-align: left;">
					<jsp:getProperty property="arrow" name="ubbs"/> <!-- getArrow 호출(BbsArrow.java) -->
					<c:if test="${bbs.del eq 1 }">
						이 글은 작성자에 의해 삭제되었습니다.
					</c:if>
					<c:if test="${bbs.del eq 0 }">
						<a href="bbsdetail.do?seq=${bbs.seq }">${bbs.title }</a>
					</c:if>
				</td>
				<td>${bbs.id }</td>
			</tr>			
		</c:forEach>
	</tbody>
</table>

<!-- 페이징 : paging.jsp 인용 -->
<div id="paging_wrap">
	<!-- include로 가져올 jsp에 parameter를 보내는 방법 -->
	<jsp:include page="/WEB-INF/views/bbs/paging.jsp" flush="false">
		<jsp:param name="totalRecordCount" value="${totalRecordCount }"/>
		<jsp:param name="pageNumber" value="${pageNumber }"/>
		<jsp:param name="pageCountPerScreen" value="${pageCountPerScreen }"/>
		<jsp:param name="recordCountPerPage" value="${recordCountPerPage }"/>
	</jsp:include>
</div>

<script type="text/javascript">
//페이징 링크 onclick에서 사용할 함수
function goPage( pageNumber ){
	//_pageNumber는 폼 안에 있는 히든태그 
	$("#_pageNumber").val( pageNumber );
	//폼 제출
	$("#_frmFormSearch").attr("action", "bbslist.do").submit();
}

//검색 버튼 클릭 이벤트
$("#_btnSearch").click(function(){
	//폼 제출
	$("#_frmFormSearch").attr("action", "bbslist.do").submit();
});
</script>

</body>
</html>