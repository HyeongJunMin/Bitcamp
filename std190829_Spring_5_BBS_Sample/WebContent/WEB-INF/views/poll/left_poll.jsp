<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="menu_table">
	<ul style="width: 100%;">
		<li class="title">투표</li>
		<li class="subtitle">투표</li>
		<!-- 사용자메뉴 -->
		<c:if test="${login.auth eq '3' }">
			<li class="menu_item">
				<a href="polllist.do" title="투표목록">투표목록</a>
			</li>
			<li class="menu_item">
				<a href="makepoll.do" title="투표만들기">투표만들기</a>
			</li>
		</c:if>
	</ul>
</div>