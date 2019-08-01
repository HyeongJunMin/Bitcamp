<%@page import="java.util.Date"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDto user = (MemberDto)session.getAttribute("login");

	//시간(시스템타임) 취득
	String fname = new Date().getTime() + "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<div align="center">
	<br><br><h1>자료 업로드</h1><br><br>
	<form action="pdsupload.jsp" method="post" enctype="multipart/form-data">
		<table border="1">
			<col width="200"><col width="500">
			<tr>
				<th>ID</th>
				<td><%=user.getId() %><input type="hidden" name="id" value="<%=user.getId() %>"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" size="49"></td>
			</tr>
			<tr>
				<th>파일업로드</th>
				<td><input type="file" name="fileload" style="width:400px;"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="50" name="content"></textarea></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="업로드">
				</td>
			</tr>			
		</table>	
	</form>
</div>





<br><br>
<pre>
주의사항
1. 파일 명 중복 배제
 - 같은 파일명이 업로드 될 수 있기 때문에 파일명의 업로드 시간(시스템타임)을 붙여주는 등의 처리가 필요.
2. 파일 명 한글이름  ㄴㄴ
 - 디스크에 저장하는 파일만 해당
3. form 메소드는 post여야만 함(필수)
4. 멀티파트 방식 사용
 - form field : String이 넘어오는 방식
 - form multipart : String, byte 등 아무거나 다 (뭐가 넘어올지 모름)
 </pre>
 <br><br>
</body>
</html>