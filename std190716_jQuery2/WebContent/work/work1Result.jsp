<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>신청내용</h1>
<%
	String name = request.getParameter("name");
	String add = request.getParameter("address");
	String phone = request.getParameter("phone");
	String time = request.getParameter("time");
	String receipt = request.getParameter("receipt");
	String rResult ="신청";
	if( "2".equals(receipt)){
		rResult = "신청안함";
	}
	
	out.println("name : " + name + "<br>" +
				"address : " + add + "<br>" +
				"phone: " + phone + "<br>" +
				"time : " + time + "<br>" +
				"receipt : " + rResult + "<br>"	);
	
	//name=1&address=2-3&phone=34-5-6&time=4&receipt=1
%>

</body>
</html>