<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="./templates/header.jsp"></jsp:include>
</head>
<body>
<h3>UserList Main</h3>

<div class="listMain">
	<form action="" id="formUserList">
		<table>
		<colgroup> <col width="100"><col width="300"><col width="300"> </colgroup>
			<tr>
				<th>
					<input type="checkbox" name="alldel">
				</th>
				<th>ID</th> <th>NAME</th>				
			</tr>
			<tr>	<td height="2" bgcolor="#000ff" colspan="3"></td>	</tr>
			<!-- 유저 리스트 출력 부 -->
			<c:set var="userList" value="${list }"/>
			<c:if test="${userList eq null }">
				<tr><td colspan="3"><c:out value="유저 정보 없음"/></td></tr>
			</c:if>
			<c:if test="${userList ne null}">
				<c:forEach var="str" items="${userList }">
					<tr><td colspan="3"><c:out value="${str }"/></td></tr>
				</c:forEach>
			</c:if>
		</table>
	</form>
</div>

</body>
</html>