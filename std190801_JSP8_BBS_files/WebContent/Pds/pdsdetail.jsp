<%@page import="dto.MemberDto"%>
<%@page import="pds.PdsDto"%>
<%@page import="pds.PdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap, jQuery CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>
</head>
<body>
<%
	//로그인 id 체크
	String currId = "guest";
	if( (MemberDto)session.getAttribute("login") != null ){
		currId = ( (MemberDto)session.getAttribute("login") ).getId();
	}

	int seq = Integer.parseInt(request.getParameter("seq"));
	PdsDto dto = PdsDao.getInstance().getOnePds(seq);
	
	//readcount++ 성공하면 현재 페이지에도 적용
	boolean addDone = PdsDao.getInstance().addCount(seq, true, false);
	if( addDone == true ){
		dto.setReadcount( dto.getReadcount() + 1 );
	}
%>

<div align="center">

<h3>Pds Detail</h3>
<form action="pdsdetailAf.jsp" method="post" enctype="multipart/form-data" id="pdsdetailFrm">
<input type="hidden" value="<%=currId %>" id="_currId">
<input type="hidden" id="_command" name="command" value="none">
<table border="1">
	<tr>
		<td>No</td>
		<td> <input type="text" value="<%=dto.getSeq() %>" readonly="readonly" name="seq" id="_seq">
			조회수 : <%=dto.getReadcount() %> 다운로드수 : <%=dto.getDowncount() %>
		</td>
	</tr>
	<tr>
		<td>ID</td>
		<td> <input type="text" value="<%=dto.getId() %>" readonly="readonly" id="_author" name="author"> </td>
	</tr>
	<tr>
		<td>Title</td>
		<td><input type="text" value="<%=dto.getTitle() %>" readonly="readonly" id="_title" name="title"></td>
	</tr>
	<tr>
		<td>File</td>
		<td>
			<a href=" ../filedown?filename=<%=dto.getFilename() %>&seq=<%= dto.getSeq()%> " id="originFile">
				<%=dto.getFilename() %>
			</a>			
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="파일 수정" id="btnFileInput">
			<input type="button" value="취소" id="btnInputCancel">
			<input type="file" size="10" id="fileInput" name="inputFile">
			<input type="button" value="저장" id="btnInputSave">
		</td>
	</tr>
	<tr>
		<td colspan="2">Content</td>
	</tr>
	<tr>
		<td colspan="2"> <textarea rows="10" cols="70" readonly="readonly" id="_content" name="content"><%=dto.getContent() %></textarea>  </td>
	</tr>
	<tr>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" id="btnReturnInCalDetail" value="돌아가기">
			<input type="button" id="btnModifyInCalDetail" value="수정" disabled="disabled">
			<input type="button" id="btnDeleteInCalDetail" value="삭제" disabled="disabled">
		</td>
	</tr>
</table>
</form>
</div>

<div id="testDiv">
<h3 id="test"></h3>
<h3 id="test2"></h3>
<h3 id="test3"></h3>
<input type="button" id="btnTest" value="test go">
</div>
<script type="text/javascript">

$(function(){
	//문서 초기화
	var currId = $("#_currId").val();
	var author = $("#_author").val();
	
	var titleChanged = false;
	var contentChanged = false;
	var fileChanged = false;
	
	$("#fileInput").hide();
	$("#btnInputCancel").hide();
	$("#btnInputSave").hide();
	
	var originTitle = $("#_title").val();
	var originContent = $("#_content").text();
	
	function changed(a, b, c){
		if( a || b || c ){
			$("#btnModifyInCalDetail").removeAttr("disabled");
			//alert('a:' + a + '  b:' + b + '  c:' + c);
		}else{
			$("#btnModifyInCalDetail").attr("disabled", "disabled");
		}	
	}
	
	//테스트
	$("#btnTest").click(function(){
		var t1 = $("#originFile").text().trim();
		//var t2 = $("#fileInput").val();
		var t2 = $("#fileInput").val().substring( ($("#fileInput").val().lastIndexOf('\\')+1) ).trim();
		$("#test").html( t1 );
		$("#test2").html( t2 );
		$("#test3").html( ( ( (t1 == t2) ) ? true : false ) + '..' );
		
		alert(t2.substring( (t2.lastIndexOf('\\')+1) ));
		alert('result ' + ( ( (t1 == t2) ) ? true : false ) );
	});
	
	
	
	//파일업로드 시작
	$("#btnFileInput").click(function(){
		$("#btnFileInput").hide();
		$("#fileInput").show();
		$("#btnInputCancel").show();
		//$("#btnInputSave").show();
	});
	
	//파일업로드 취소
	$("#btnInputCancel").click(function(){
		$("#btnFileInput").show();
		$("#fileInput").hide();
		$("#btnInputCancel").hide();
		$("#btnInputSave").hide();
		$("#fileInput").val('');
		fileChanged = false;
		changed(titleChanged, contentChanged, fileChanged);
	});
	
	//파일을 선택했을 때 이벤트
	$("#fileInput").change(function(e){
		var t1 = $("#originFile").text().trim();
		var t2 = $("#fileInput").val().substring( ($("#fileInput").val().lastIndexOf('\\')+1) ).trim();
		if( t1 === t2 ){
			//두 파일이 같으면 업로드를 취소
			alert('동일한 파일로 수정할 수 없습니다.');
			$("#fileInput").val('');
			fileChanged = false;
			changed(titleChanged, contentChanged, fileChanged);
		}else{
			//$("#btnModifyInCalDetail").removeAttr("disabled");
			fileChanged = true;
			changed(titleChanged, contentChanged, fileChanged);
		}
	});
	
	//title 변경여부 확인
	$("#_title").keyup(function(){
		var inputTitle = $("#_title").val();
		if( inputTitle.trim() === originTitle.trim() ){
			titleChanged = false;
			changed(titleChanged, contentChanged, fileChanged);
		}else{
			titleChanged = true;
			changed(titleChanged, contentChanged, fileChanged);
		}
	});
	
	//content 변경여부 확인
	$("#_content").keyup(function(){
		//alert('content ch');
		var inputContent = $(this).val();
		
		if(inputContent === originContent.trim() ){
			//alert( inputContent.length );
			contentChanged = false;
			changed(titleChanged, contentChanged, fileChanged);
		}else{
			//alert('2');
			contentChanged = true;
			changed(titleChanged, contentChanged, fileChanged);
		}
	});
	
	//업로드한 파일 적용
	$("#btnInputSave").click(function(){
		var inputData = $("#fileInput").val();
		if( inputData === null || inputData.length < 1){
			alert('파일을 선택해 주세요.' + inputData);
		}else{
			var t1 = $("#originFile").text().trim();
			var t2 = $("#fileInput").val().substring( ($("#fileInput").val().lastIndexOf('\\')+1) ).trim();
			if( t1 === t2 ){
				alert('동일한 파일로 수정할 수 없습니다.');
			}else{
				alert('ok go!');	
				$("#pdsdetailFrm").submit();	
			}			
		}
	});
	
	//세션 ID가 일정 작성자와 동일한 경우 readonly 해제	
	if( currId === author){
		$("#btnDeleteInCalDetail").removeAttr("disabled");
		$("#_title").removeAttr("readonly");
		$("#_content").removeAttr("readonly");		
	}
	
	//수정 버튼 클릭 시 Af로 이동
	$("#btnModifyInCalDetail").click(function(){
		$("#pdsdetailFrm").submit();
	});
	
	//게시글 삭제
	$("#btnDeleteInCalDetail").click(function(){
		var currId = $("#_currId").val();
		if( currId === 'guest'){
			alert('삭제 권한이 없습니다.');
		}else{
			var result = confirm('정말 삭제하시겠습니까?');
			if( result == true ){
				var seq = $("#_seq").val();
				location.href='pdsdetailAf.jsp?del=true&seq=' + seq;
			}
		}
	});
	
	//pds리스트로 돌아가기
	$("#btnReturnInCalDetail").click(function(){
		location.href='pdslist.jsp';
	})
});
</script>
</body>
</html>