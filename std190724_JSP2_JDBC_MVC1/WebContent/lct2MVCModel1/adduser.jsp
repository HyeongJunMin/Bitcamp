<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<form action="./adduser.do" method="get">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="inputId"></td>
		</tr>
		<tr>
			<td>NAME</td>
			<td><input type="text" name="inputName" ></td>
		</tr>
		<tr>
			<td>ADDR</td>
			<td><input type="text" name="inputAddr"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="추가">
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript">
$("input[name=inputId]").focus();
</script>
</body>
</html>