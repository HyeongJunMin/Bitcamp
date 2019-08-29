<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${not empty currUser }">
${currUser.id }님 안녕하세요
<table border="1" bgcolor="Gray">
	<col width="200">
		<tr>
		  <td>
		  	<a href="bbslist.do">글목록</a>
		  </td>
		</tr>
		<tr>
		  <td>
		  	<a href="bbswrite.do">글쓰기</a>
		  </td>
		</tr>
</table>
</c:if>
<c:if test="${empty login }">
<form action="loginAf.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" size="20"></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="text" name="pw" size="20"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="log-in"></td>
		</tr>
	</table>
	<a href="regi.do">회원가입</a>
</form>
</c:if>