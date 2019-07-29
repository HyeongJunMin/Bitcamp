<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>
<script type="text/javascript" src="./js/bbswrite.js"></script>
<meta charset="UTF-8">
<title>new post 190729</title>
</head>
<body>


	<div>
		<div>
		<h1>새 글 쓰기</h1>
		</div>
		
		<div>
		<form action="./bbswriteAf.jsp" method="GET" id="frmWrite">
			<table>
				<tr>
					<td>작성자 ID : </td>
					<td><%=( (MemberDto)session.getAttribute("login") ).getId() %></td>
				</tr>
				<tr>
					<td>제목 : </td>
					<td>
						<input type="text" size="25" id="_inputTitle" name="inputTitle">
					</td>
				</tr>
				<tr>
					<td colspan="2">내용</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="15" cols="40" id="_inputContent" name="inputContent"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="저장" id="_btnSave" name="btnSave">
					</td>
					<td></td>
				</tr>
			</table>
		
		</form>		
		</div>
		
	</div>

</body>
</html>