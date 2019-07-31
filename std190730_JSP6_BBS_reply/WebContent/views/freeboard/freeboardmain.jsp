<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Freeboard Main</title>
<jsp:include page="/views/templates/freeboardheader.jsp"></jsp:include>

<!-- Custom js, css -->
<script type="text/javascript" src="${pageContext.request.contextPath}/views/static/js/freeboard/freeboardmain.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/static/css/freeboard/freeboardmain.css"></link>
</head>
<body id="mainBody">
<%
	String currId = "guest";
	if( session.getAttribute("currId") != null){
		currId = session.getAttribute("currId")+"";
	}
%>
<!-- Context Path -->
<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>">
<input type="hidden" id="currId" value="<%=currId %>">
	<!-- Main Header Bar Menu -->
	<div id="mainHeaderBar">
		<div id="mainHeaderBarMenu">
			<a href=""><span>menu 1</span></a>
			<a href=""><span>menu 2</span></a>
			<a href=""><span>menu 3</span></a>
			<a href=""><span>menu 4</span></a>
			<a href=""><span>menu 5</span></a>
			<a href=""><span>menu 6</span></a>
			<a href=""><span>menu 7</span></a>
		</div>
	</div>
	<!-- Main Header -->
	<div id="mainHeader">
		<h1>Free Board</h1>
	</div>

	<!-- Main Body -->
	<div id="mainContainer">
		<!-- Contents View -->
		<div id="mainContentsView">
			<div id="mainContentsList">
				<!-- 새 글 쓰기 파트 -->
				<div id="bbsWriteNewArea">
				<jsp:include page="/views/freeboard/freeboardwritenew.jsp"></jsp:include>
				</div>
				
				<!-- 글 상세보기 파트 -->
				<div id="bbsPostDetailArea" >
				<jsp:include page="/views/freeboard/freeboardpostdetail.jsp"></jsp:include>
				</div>
				
				<!-- 글 목록 파트 -->
				<div id="bbsTableArea">
				<table id="tblMainContentList" class="table table-hover">
				    <colgroup>
        				<col width="60px"/>
        				<col width="320px"/>
        				<col width="100px"/>
        				<col width="180px"/>
        				<col width="70px"/>
				    </colgroup>
					<tr>
						<th>No</th>	
						<th>Title</th>	
						<th>Writer</th>	
						<th>Date</th>	
						<th>Hit</th>
					</tr>
					<jsp:include page="/views/freeboard/freeboardtablecontent.jsp"></jsp:include>
				</table>
				<div id="mainContentFooter">
					<!-- 검색기능 -->
					<div id="mainContentSearchPostArea">
						<jsp:include page="/views/freeboard/freeboardsearch.jsp"></jsp:include>
					</div>
					<a id="btnWriteNew" class="btn pull-right" style="border: solid 1px; margin-right: 5px;">Write</a>
					</div>
				</div>				
			</div>			
		</div>

		<!-- Side view in container -->
		<div id="mainSideView">
			<div id="mainAccountTemplate">
			
			</div>

			<!-- Show category  -->
			<div id="mainCategoryView">mainCategory</div>
		</div>
	</div>
	
	<!-- 로그인 모달 폼 -->
	<jsp:include page="/views/account/signinmodal.jsp"></jsp:include>
	
	<!-- 회원가입 모달 폼 -->
	<jsp:include page="/views/account/signupmodal.jsp"></jsp:include>
</body>
</html>