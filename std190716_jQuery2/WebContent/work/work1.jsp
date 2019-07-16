<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post info</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/work1.js"></script>
</head>
<body>
<a href="./work1.jsp">work1</a>
<a href="./work2.jsp">work2</a>
<a href="./work3preparation.jsp">work3preparation</a>
<h1>송부정보의 입력</h1>
<form id="postForm">
<table>
<colgroup><col width="100px"><col></colgroup>
<tr>
	<td>이름 : </td>
	<td><input type="text" name="inputName" id="inputName_id"></td>
</tr>
<tr>
	<td>우편번호 : </td>
	<td><input type="text" id="inputPost1">-<input type="text" id="inputPost2">
		<input type="button" id="btnConvert" value="주소변환"></td>
</tr>
<tr>
	<td>주소 : </td>
	<td><textarea rows="5" cols="60" name="address" id="address_id"></textarea></td>
</tr>
<tr>
	<td>전화번호 : </td>
	<td><input type="text" name="inputPhone1" id="phone1">-<input type="text" name="inputPhone2" id="phone2">-
		<input type="text" name="inputPhone3" id="phone3">
</tr>
<tr>
	<td>배달시간 : </td>
	<td><select multiple name="postTime" id="postTime_id" style="height: 95px">
			<option value="1">10:00 ~ 12:00</option>
			<option value="2">12:00 ~ 15:00</option>
			<option value="3">15:00 ~ 17:00</option>
			<option value="4">17:00 ~ 20:00</option>
			<option value="0">지정하지 않음</option>
		</select>
	</td>
</tr> 
<tr>
	<td>영수증요청:</td>
	<td><input type="checkbox" name="chkReceipt" id="chkReceipt_id"></td>	
</tr>
<tr>
	<td colspan="2">메일 매거진을 수신	
		<input type="radio" name="radioRec" value="1" checked="checked">신청  
		<input type="radio" name="radioRec" value="2">신청하지 않음								 
</tr>	
</table>
</form>
<input type="button" id="btnConfirm" value="확인화면으로 진행">


</body>
</html>