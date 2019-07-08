<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

//String job = request.getParameter("job");
//System.out.println("job:" + job);

String jobs[] = request.getParameterValues("job");

if(jobs != null && jobs.length > 0){
	for(int i = 0;i < jobs.length; i++){
		System.out.println(jobs[i]);
	}
}
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>