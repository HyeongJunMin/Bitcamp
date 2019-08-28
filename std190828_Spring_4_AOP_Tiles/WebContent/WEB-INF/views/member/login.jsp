<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<c:if test="${empty currUser }">
<h1>로그인</h1>
<form action="dologin.do">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" id="inputId" name="id" placeholder="아이디입력">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="text" id="inputPw" name="pw" placeholder="비밀번호입력">
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" id="goSignup" value="회원가입" onclick="location.href='showsignup.do';">
			</td>
			<td>
				<input type="submit" id="doLogin" value="로그인">			
			</td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${not empty currUser }">
<a>${currUser.id }님 안녕하세요.</a>
<input type="button" id="btnLogout" value="로그아웃" onclick="logout();"/>
</c:if>

<script type="text/javascript">
function logout(){
	location.href='${pageContext.request.contextPath}/logout.do';
}
</script>

</html>