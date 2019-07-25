<%@page import="com.model.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%
	String id = "";
	String name = "";
	String addr = "";
	String addResult = "";
	if( request.getAttribute("addedUser") != null ){
		UserDTO dto = (UserDTO)request.getAttribute("addedUser");
		id = dto.getId();
		name = dto.getName();
		addr = dto.getAddress();
	}
	
	if( request.getAttribute("addResult") != null ){
		addResult = request.getAttribute("addResult") + "";
	}
%>
<form action="./userConMain" method="get">
	<input type="hidden" name="command" value="adduser">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="inputId" value="<%=id %>"></td>
		</tr>
		<tr>
			<td>NAME</td>
			<td><input type="text" name="inputName" value="<%=name %>"></td>
		</tr>
		<tr>
			<td>ADDR</td>
			<td><input type="text" name="inputAddr" value="<%=addr %>"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="추가">
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript">
$("input[name=inputId]").focus();
</script>
</body>
</html>