<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int totalRecordCount = 0;	//전체 글 수 ex)23개면 3개페이지
	int pageNumber = 0;			//현재 페이지.
	int pageCountPerScreen = 0;	//스크린 당 페이지(네비게이션) 수
	int recordCountPerPage = 0;	//페이지 당 글 개수
	
	//bbslist와 함께 움직이기 때문에 받을 수 있는 파라미터들
	String st1 = request.getParameter("totalRecordCount");
	totalRecordCount = (st1 == null)?0:Integer.parseInt(st1);
	
	String st2 = request.getParameter("pageNumber");
	totalRecordCount = (st2 == null)?0:Integer.parseInt(st1);
	
	String st3 = request.getParameter("pageCountPerScreen");
	totalRecordCount = (st3 == null)?0:Integer.parseInt(st1);
	
	String st4 = request.getParameter("recordCountPerPage");
	totalRecordCount = (st4 == null)?0:Integer.parseInt(st1);
	
	//총 페이지 수
	int totalPageCount = totalRecordCount / recordCountPerPage;
	
	if( (totalRecordCount % recordCountPerPage) != 0){
		totalPageCount++;
	}
	
	//시작 페이지
	int screenStartPageIndex = ( (pageNumber + 1) / pageCountPerScreen ) * pageCountPerScreen;
	
	//마지막 페이지 숫자
	int screenEndPageIndex = ( ( (pageNumber + 1) / pageCountPerScreen ) * pageCountPerScreen);

	// 끝 페이지는 다시 계산한다
	// 왜? 몇 까지 갈지 모르니까
	if (screenEndPageIndex > totalPageCount) {
		screenEndPageIndex = totalPageCount;
	}

	if ((pageNumber + 1) % pageCountPerScreen == 0) {
		screenStartPageIndex = ((pageNumber + 1) / pageCountPerScreen * pageCountPerScreen)
				- pageCountPerScreen;

		screenEndPageIndex = pageNumber + 1;
	}
%>

<div style="float: left; width: 96%; text-align: center;">
	<a href="#none" title="첫페이지" onclick="goPage('0')"> <img alt=""
		src="image/arrow_first.gif" style="width: 9px; height: 9px;">
	</a>
	<%
      for (int i = screenStartPageIndex; i < screenEndPageIndex; i++) {
      if(i == pageNumber){
   %>
	<span style="font-size: 9px; color: #000000; font-weight: bold">
		<%=i+1 %>
	</span>
	<%
      } else {
         %>
	<a href="#none" title="<%=i+1%>페이지" onclick="goPage(<%=i+1%>)"
		style="font-size: 7.5pt; color: #000000; font-weight: normal;"> [<%=i+1 %>]
	</a>
	<%
      }
   }
   %>
	<!-- > -->
	<%
   if(screenEndPageIndex < totalPageCount){ // [11][12][13]
      %>
	<a href="#none" title="다음페이지" onclick="goPage(<%=screenEndPageIndex%>)">
		<img alt="" src="image/arrow_next.gif" style="width: 9px; height: 9px">
	</a>
	<% 
   }
   int end_page = 0;
   if(totalPageCount > 0) {
      end_page = totalPageCount -1 ; 
   }
   %>
</div>