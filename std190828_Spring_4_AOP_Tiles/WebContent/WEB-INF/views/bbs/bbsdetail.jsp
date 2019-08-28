<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
		<input type="button" value="돌아가기" onclick="location.href='<%=request.getContextPath()%>/showbbs.do'">
		<!-- 뎁스가 3보다 작고, 로그인 정보가 있어야 답글 작성 가능 -->
		<c:if test="${not empty currUser && BbsDto.depth < 3 }">
			<input type="button" value="답글 달기" id="btnReply" onclick="location.href='<%=request.getContextPath()%>/shownewreply.do?seq=${BbsDto.seq }'">
		</c:if>
		<c:if test="${currUser.id == BbsDto.id}">
			<input type="button" value="게시글 수정" id="btnUpdate" onclick="location.href='<%=request.getContextPath()%>/showbbsupdate.do?seq=${BbsDto.seq }'">	
		</c:if>		
	</div>
	
	<!-- 댓글 영역 -->
	<div class="bbsDetailCommentWrap">
		<div class="bbsDetailCommentInputWrap">
			<!-- 세션에 유저 정보가 있으면 댓글 입력창 활성화 -->
			<c:choose>				 
			    <c:when test="${not empty currUser}">
			    	<textarea rows="3" cols="50" id="txtCommentContent" placeholder="댓글을 입력해 주세요"></textarea>
			    	<input type="button" id="btnSaveComment" value="저장">
			    </c:when>
			    <c:otherwise>
					<textarea rows="3" cols="50" id="txtCommentContent" placeholder="로그인이 필요합니다." disabled="disabled"></textarea>
			    </c:otherwise>
			</c:choose>
		</div>		
		<div class="bbsDetailCommentListWrap">
			<table class="bbsDetailCommentListTbl">
				<tr>
					<td>작성자</td>
					<td>내용</td>
					<td>작성일</td>
					<td>추천</td>
				</tr>
				<!-- 댓글 리스트 길이가 1보다 작으면 등록된 댓글이 없습니다. -->
				<c:choose>				 
				    <c:when test="${empty commentList}">
				    	<tr><td colspan="4"><h3>등록된 댓글이 없습니다.</h3></td></tr>
				    </c:when>
				    <c:otherwise>
						<c:forEach items="${commentList }" var="cmm">
							<tr>
								<td>${cmm.id }</td>
								<td>${cmm.content }</td>
								<td>${fn:substring(cmm.wdate,0,10)  }</td>
								<td>${cmm.likecnt }</td>
							</tr>
						</c:forEach>
				    </c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
	$("#btnSaveComment").click(function(){
		//배열 초기화
		var viewData = {};
		//data[키] = 밸류
		viewData["parent"] = '${BbsDto.seq}';
		viewData["id"] = '${currUser.id }';
		viewData["content"] = $("#txtCommentContent").val();

		$.ajax({
			contentType:'application/json',
			dataType:'json',
			url:'writenewcomment.do',
			type:'post',
			data:JSON.stringify(viewData),
			success:function(resp){
				//alert(resp);
				if( resp === 1){
					alert('저장이 완료되었습니다.');
					location.href="showbbsdetail.do?seq=" + viewData["parent"];
				}else{
					alert('저장에 실패했습니다. 다시 시도해 주세요.');
				}
				
			},
			error:function(){
				alert('저장 중 에러가 발생했습니다. 다시 시도해 주세요.');
			}
		});
	});
});
</script>


</body>
</html>