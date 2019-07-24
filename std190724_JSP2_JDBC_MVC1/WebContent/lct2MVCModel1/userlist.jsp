<%@page import="com.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserDAO dao = UserDAO.getInstance();
	List<UserDTO> lst = dao.getUserList();
	/* 	
	lst.add(new UserDTO("!", "2", "3"));
	lst.add(new UserDTO("1", "2", "3"));
	lst.add(new UserDTO("2", "2", "3"));
	lst.add(new UserDTO("3", "2", "3"));
	lst.add(new UserDTO("4", "2", "3"));
	*/
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

 <h1>MVC 1 고객 목록</h1>
 
<div>
	<form action="muldel.jsp" method="post">
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
				if(lst.size() > 0){
					for(UserDTO d : lst){
			%>
					<tr bgcolor="#f6f6f6">
						<td align="center" bgcolor="yellow">
							<input type="checkbox" name="delck" value="<%=d.getId() %>">
						</td>
						<td><%=d.getId() %></td>
						<td>
							<a href="userdetail.jsp?id=<%=d.getId() %>"><%=d.getName() %></a>
						</td>
					</tr>		
			<%
					}
				}else{
					out.println("<tr><td colspan=\"3\" align=\"center\">고객없음</td></tr>");
				}
			%>
			<tr>
				<td>
					<input type="submit" value="고객정보 삭제">
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
					<input type="submit" value="검색" formaction="./searchuser.jsp" formmethod="get">
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
</script>
</body>
</html>