<%@page import="bit.com.a.util.DateUtil"%>
<%@page import="bit.com.a.model.PollDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	List<PollDto> plists = (List<PollDto>)request.getAttribute("plists");
%>
<!DOCTYPE html>
<html>
<!-- 관리자메뉴 -->
<c:if test="${login.auth eq '1' }">
	<table class="list_table" style="width: 95%;">
		<col width="50"><col width="50"><col width="50"><col width="100">
		<col width="100"><col width="50"><col width="50"><col width="100">
		<tr>
			<th>번호</th><th>아이디</th><th>주제</th><th>시작일</th>
			<th>종료일</th><th>선택지</th><th>투표수</th><th>등록일</th>
		</tr>
		<%
			for(int i = 0 ; i < plists.size() ; i++ ){
				PollDto poll = plists.get(i);
				%>
					<tr bgcolor="#aabbcc">
						<td><%=i+1 %></td>
						<td><%=poll.getId() %></td>
						<td><%=poll.getQuestion() %></td>
						<td><%=poll.getSdate() %></td>
						<td><%=poll.getEdate() %></td>
						<td><%=poll.getItemcount() %></td>
						<td><%=poll.getPolltotal() %></td>
						<td><%=poll.getRegdate() %></td>
					</tr>				
				<%
			}
		%>
	</table>
	<a href="pollmake.do">투표 만들기</a>
</c:if>

<!-- 유저 메뉴 -->
<c:if test="${login.auth eq '3' }">
	<table class="list_table" style="width: 95%;">
		<col width="50"><col width="50"><col width="50"><col width="100">
		<col width="100"><col width="50"><col width="50"><col width="100">
		<tr>
			<th>번호</th><th>아이디</th><th>주제</th><th>결과</th><th>시작일</th>
			<th>종료일</th><th>선택지</th><th>투표수</th><th>등록일</th>
		</tr>
		<%
			for(int i = 0 ; i < plists.size() ; i++ ){
				PollDto poll = plists.get(i);
				%>
					<tr bgcolor="#aabbcc">
						<td><%=i+1 %></td>
						<td><%=poll.getId() %></td>						
						<%
							//투표를 했거나, 투표 기한이 만료되었으면 투표불가
							boolean isS = poll.isVote();
							if( isS == true || DateUtil.isEnd(poll.getEdate()) == true ){
								//투표 했거나 기한이 만료되었음
								%>
									<td>[마감]<%=poll.getQuestion() %></td>
									<td>
										<a href="pollresult.do?pollid=<%=poll.getPollid() %>">결과</a>
									</td>
								<%
							}else{
								//투표 안했고 기한도 만료되지 않았음
								%>
									<td>
										<a href="polldetail.do?pollid=<%=poll.getPollid() %>"><%=poll.getQuestion() %></a>
									</td>
									<td><img alt="" src="<%=request.getContextPath()%>/image/pen.gif"></td>
								<%
							}
						%>
						<td><%=poll.getSdate() %></td>
						<td><%=poll.getEdate() %></td>
						<td><%=poll.getItemcount() %></td>
						<td><%=poll.getPolltotal() %></td>
						<td><%=poll.getRegdate() %></td>
					</tr>				
				<%
			}
		%>
	</table>	
</c:if>

</html>