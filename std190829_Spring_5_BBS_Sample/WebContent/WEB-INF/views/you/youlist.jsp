<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<div class="box_border" style="margin-top: 5px; margin-bottom: 10px;">
	<form action="" name="frmForm1" id="_frmForm1" method="post">
		<table style="margin-left: auto; margin-right: auto; margin-top: 3px; margin-bottom: 3px;">
			<tr>
				<td>검색</td>
				<td style="padding-left: 5px;">
					<input type="text" id="_s_keyword" name="s_keyword">
				</td>
				<td style="padding-left: 5px;">
					<span class="button blue">
						<button type="button" id="_btnSearch">검색</button>
					</span>
				</td>
			</tr>
		</table>
	</form>
</div>

<div id="_youtube_">
	<iframe id="_youtube" width="640" height="360" src="http://www.youtube.com/embed/" frameborder="0" allowfullscreen>
	</iframe>
</div>

<table class="list_table" style="width: 85%;">
	<colgroup>
		<col style="width: 70px;"><col style="width: auto;"><col style="width: 100px;"><col style="width: 30px;">
	</colgroup>
	<thead>
		<tr>
			<th>순서</th><th>제목</th><th>유튜브고유번호</th><th>저장</th>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
		<c:if test="${empty yulist }">
			<tr><td colspan="4">작성된 목록이 없습니다.</td></tr>
		</c:if>
		<c:forEach items="${yulist }" var="bbs" varStatus="vs">
			<tr class="_hover_tr">
				<td>${vs.count }</td>
				<td style="text-align: left;" id="_v${bbs.vname }ed2" onclick="getyoutube2('${bbs.vname}')">
					<div class="c_vname" vname="${bbs.vname }">${bbs.title }</div>
				</td>
				<td>${bbs.vname }</td>
				<td onclick="getyoutube('${login.id }', '${bbs.vname }')">
					<img alt="저장" src="<%=request.getContextPath() %>/image/save.png" class="ck_seq"
					 vname="${bbs.vname }" id="_v${bbs.vname }ed" loginId="${login.id }"
					 title="${bbs.title }" keyword='${empty s_keyword?"":s_keyword}'>
				</td>
			</tr>
		</c:forEach>
	
</table>

<script type="text/javascript">
$(document).ready(function(){
	$("#_youtube_").hide();
	
	//테이블 마우스오버 이벤트
	$("._hover_tr").mouseover(function(){
		$(this).children().css("background-color","#f0f5ff");
	}).mouseout(function(){
		$(this).children().css("background-color","#ffffff");
	});
	
	$("#_frmForm1").serialize();
	
	$("#_btnSearch").click(function(){
		$("#_frmForm1").attr( {"target":"_self", "action":"yutube.do"} ).submit();
	});
	
	$(".c_vname").click(function(){
		$("#_youtube_").show();
		$("#_youtube").attr("src","http://www.youtube.com/embed/" + $(this).attr("vname"));
	});
	
	$(".ck_seq").click(function(){
		var id = $(this).attr('loginId');
		var vname = $(this).attr('vname');
		var title = $(this).attr('title');
		var category = $(this).attr('keyword');
		
		$.ajax({
			type: 'post',
			url: "<%=request.getContextPath()%>/youtubesave.do",
			async: true,
			data: "id=" + id + "&vname" + vname + "&title" + title + "&category" + category,
			success: function(msg){
				alert("succeed")
			},
			error:function(error){
				alert("error" + error);
			}
		});
	});
});

function getyoutube2(vname){
	$("#_v" + vname + "ed2").css("background-color", "#ff0000");
}
</script>

</html>