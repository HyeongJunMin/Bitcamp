<%@page import="com.model.dto.UserDTO"%>
<%@page import="com.model.dao.UserDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int pages = 0;
	int currPage = 0;
%>
<%
	UserDAO dao = UserDAO.getInstance();

	List<UserDTO> lst = null;
	
	if( request.getAttribute("userlist") != null ){
		lst = (List<UserDTO>)request.getAttribute("userlist");	
	}
	
	String command = "muldel";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<a href="../">go to home</a>
<a href="./MVCModel1.jsp">Lecture2 home</a>
<a href="./userlist.jsp">고객 목록</a>

 <h1>MVC 2 고객 목록</h1>
 
<div>
	<form action="userConMain" method="post">
		<input type="hidden" name="command" value="<%=command %>">
		<table style="width: 700">
			<colgroup> <col width="100"><col width="300"><col width="300"> </colgroup>
			<tr>
				<td height="2" bgcolor="#000ff" colspan="3"></td>
			</tr>
			<tr bgcolor="yellow">
				<th>
					<input type="checkbox" name="alldel">
				</th>
				<th>ID</th>
				<th>NAME</th>
			</tr>
			<tr>
				<td height="2" bgcolor="#000ff" colspan="3"></td>
			</tr>
			<%
				if( request.getAttribute("searchResult") != null ){
					lst = (List<UserDTO>)request.getAttribute("searchResult");//검색결과 있으면
				}
				if( request.getParameter("page") == null){
					currPage = 1;
				}else{
					currPage = Integer.parseInt(request.getParameter("page") + "" );
				}
				int start = (currPage * 5) - 5;
				int end = ( (currPage*5)  ) > lst.size() ? lst.size() : ( (currPage*5) )  ;
				if( lst != null ){
					pages = (lst.size()/5) + 1;
					for(int i = start ; i < end ; i++ ){
			%>
					<tr bgcolor="#f6f6f6">
						<td align="center" bgcolor="yellow">
							<input type="checkbox" name="delck" value="<%=lst.get(i).getId() %>">
						</td>
						<td><%=lst.get(i).getId() %></td>
						<td>
							<a href="userConMain?command=userdetail&id=<%=lst.get(i).getId() %>"><%=lst.get(i).getName() %></a>
						</td>
					</tr>		
			<%
					}
				}else{
					out.println("<tr><td colspan=\"3\" align=\"center\">고객없음</td></tr>");
				}
			%>
			<tr>
				<td colspan="3">
					<%
						if( lst != null){
							pages = ( (lst.size()+1)/5);	
							for( int i = 1 ; i < pages + 1 ; i++ ){
								out.println("<a href=\"userConMain?command=list&page=" + i +"\">" + i + "</a>");
							}
						}
					%>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="고객정보 삭제" >
				</td>
				<td>
					<a href="./adduser.jsp">고객 정보 추가</a>
				</td>
			</tr>
			<tr>
				<td height="2" bgcolor="#000ff" colspan="3"></td>
			</tr>
			<tr>
				<td>
					<select name="serchOption">
					<option value="1">ID</option>
					<option value="2">NAME</option>
					<option value="3">ADDRESS</option>
					</select>
				</td>
				<td>
					<input type="text" placeholder="검색내용 입력" name="searchTxt">
				</td>
				<td>
					<input type="submit" value="검색" formmethod="get" onclick="fncSearch()">
				</td>
			</tr>
			<tr>
				<td height="2" bgcolor="#000ff" colspan="3"></td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
$(function(){
	$("input[name=alldel]").change(function(){
		if( $("input[name=alldel]").is(":checked") ){
			$("input[name=delck]").prop("checked", true);
		}else{
			$("input[name=delck]").prop("checked", false);
		}
	});
	

});
function fncSearch(){
	//location.href = 'userConMain?command=search';
	$("input[name=command]").val('search');
}
</script>
</body>
</html>