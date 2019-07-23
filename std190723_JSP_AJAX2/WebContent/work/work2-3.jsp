<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<a href="../index.jsp">Go To Home</a><br/>
<a href="./work2-1.jsp">work2-1</a><br/>
<a href="./work2-2.jsp">work2-2</a><br/>
<a href="./work2-3.jsp">work2-3</a><br/>
<h3>Insert.jsp</h3>

<form action="./work2Dest.jsp" id="frm1" method="get">
ID <input type="text" name="inputId"><br>
PW <input type="password" name="inputPw"><br>
취미<br>
<input type="checkbox" name="hobby" value="sleep">잠자기
<input type="checkbox" name="hobby" value="sing">노래하기
<input type="checkbox" name="hobby" value="game">게임하기
<br><br>연령대<br>
<input type="radio" name="ages" value="10">10대
<input type="radio" name="ages" value="20" checked>20대
<input type="radio" name="ages" value="30">30대
<input type="radio" name="ages" value="40">40대
<input type="radio" name="ages" value="50">50대
<input type="radio" name="ages" value="60">60대이상
<br><br>기타하고싶은말<br>
<textarea rows="5" cols="50" name="gg"></textarea>
<input type="submit" value="go">
<input type="submit" value="go" formmethod="post" formaction="./workPost">
</form>

</body>
</html>