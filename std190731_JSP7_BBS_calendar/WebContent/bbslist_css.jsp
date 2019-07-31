<%@page import="vo.PagingVO"%>
<%@page import="dto.MemberDto"%>
<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@page import="dao.iBbsDao"%>

<%!
// 댓글용 함수
public String arrow(int depth){
	String rs = "<img src='./image/arrow.png' width='20px' height='20px'/>";
	String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";	// 여백
	
	String ts = "";	
	for(int i = 0;i < depth; i++){
		ts += nbsp;
	}	
	return depth==0?"":ts + rs;
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbslist</title>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<style type="text/css">
table.type02 {
    border-collapse: separate;
    border-spacing: 0;
    text-align: left;
    line-height: 1.0;
    border-top: 1px solid #ccc;
    border-left: 1px solid #ccc;
  	margin : 20px 10px;
}
table.type02 th {
    /* width: 150px; */
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    border-top: 1px solid #fff;
    border-left: 1px solid #fff;
    background: #eee;
    text-align: center;
}
table.type02 td {
    /* width: 350px; */
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
</style>

<!-- 메뉴  -->
<link type="text/css" rel="stylesheet" href="./css/ui.css">
</head>
<body>

<%
// 검색항목, 검색어
String searchWord = request.getParameter("searchWord");
String choice = request.getParameter("choice");

System.out.println("검색항목:" + choice);
System.out.println("검색어:" + searchWord);

if(choice == null || choice.equals("")){
	choice = "sel";
}

// 검색어를 지정하지 않고 choice가 넘어 왔을때
if(choice.equals("sel")){
	searchWord = "";
}
if(searchWord == null){
	searchWord = "";
	choice = "sel";
}
%>

<%
Object ologin = session.getAttribute("login");
MemberDto mem = null;
if(ologin == null){
	%>
	<script type="text/javascript">
	alert("로그인 해 주십시오");
	location.href = "login.jsp";
	</script>
	<%
}
mem = (MemberDto)ologin;
%>

<%
iBbsDao dao = BbsDao.getInstance();

//List<BbsDto> list = dao.getBbsList();
List<BbsDto> list = dao.getBbsList(choice, searchWord);
PagingVO pagingVO = new PagingVO( list.size() ,10);

//페이지번호가 있는 경우 list 갱신
if( request.getParameter("pageNum") != null ){
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	list = BbsDao.getInstance().getPagingList(pagingVO, pageNum);
}else{
	//int pageNum = 1;
	//list = BbsDao.getInstance().getPagingList(pagingVO, pageNum);
}
%>

<h4 align="right" style="background-color: #f0f0f0">환영합니다 <%=mem.getId() %>님 반갑습니다</h4>

<!-- 
<h1>게시판</h1>
 -->

<ul>
	<li><a href="./bbslist_css.jsp">게시판</a></li>
	<li><a href="./calendar.jsp">일정관리</a></li>
	<li><a href="./pdslist.jsp">자료실</a></li>
</ul>
 
<hr>

<div align="center">

<table class="type02">
<col width="70"><col width="600"><col width="150">

<tr>
	<th>번호</th><th>제목</th><th>작성자</th>
</tr>

<%
if(list == null || list.size() == 0){
	%>
	<tr>
		<td colspan="3">작성된 글이 없습니다</td>
	</tr>
	<%
}else{
	for(int i = 0;i < list.size(); i++){
		BbsDto bbs = list.get(i);
	%>
	<tr>
		<th><%=i + 1 %></th>
		 	
		<%
			if(bbs.getDel() == 0){
		%>	
				<td class="seqclick" seq=<%=bbs.getSeq() %>>
					<%=arrow( bbs.getDepth() ) %>			
					<%=bbs.getTitle() %>
				</td>		 
		 <%
			}else{
		 %>
		 		<td class=""><font color="#ff0000">이 글은 작성자에 의해서 삭제되었습니다</font></td> 
		 <%
			}
		 %>
		 <%-- 
		<td>
			<%
			if(bbs.getDel() == 0){
				%>
				<%=arrow( bbs.getDepth() ) %>			
				<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>">
					<%=bbs.getTitle() %>
				</a>	
				<%
			}else{
				%>		
				이 글은 작성자에 의해서 삭제되었습니다
				<%
			}
			%>
		</td>
		 --%>
		<td align="center"><%=bbs.getId() %></td>
	</tr>
	<%
	}
}
%>
</table>
<table>
	<tr align="center">
		<td colspan="3">
			<%
				for(int i = 1 ; i < pagingVO.getTotalPage() + 2 ; i++ ){
					out.println("<a href='bbslist_css.jsp?pageNum=" + i +"'>[" + i + "]</a>");
				}
			%>
		</td>
	</tr>
</table>
<br>
<a href="bbswrite.jsp">글쓰기</a>
</div>

<div align="center">

<select id="choice">
<option value="sel">선택</option>
<option value="title">제목</option>
<option value="writer">작성자</option>
<option value="content">내용</option>
</select>

<input type="text" id="search" value="">
<button onclick="searchBbs()">검색</button>
</div>

<hr>

<script type="text/javascript">
function searchBbs() {
	var choice = document.getElementById("choice").value;
	var word = $("#search").val();
//	alert(choice);
//	alert(word);
	
	if(word == ""){
		document.getElementById("choice").value = 'sel';		
	}
	
	location.href = "bbslist_css.jsp?searchWord=" + word + "&choice=" + choice;
}

$(function () {
		
	$(".seqclick").mousedown(function() {
	//	alert("mousedown");
		location.href = "bbsdetail.jsp?seq=" + $(this).attr("seq");
	});
	
	$(".seqclick").mouseover(function() {		
		$(this).css("background", "#e0e0e0");
	});
	$(".seqclick").mouseout(function() {
		$(this).css("background", "#ffffff");
	});
	
});


</script>

</body>
</html>









