<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="./templates/header.jsp"></jsp:include>
<script type="text/javascript" src="./static/js/signupview.js"></script>
</head>
<body>
<form action="/6_CoffeeOrderSystemMVC2/coffee" id="formSignup" method="get">
	<input type="hidden" name="command" value="signupdata">
	<div class="modal-body" style="width: 50%; margin:auto;">
		<p id="signupWarn"></p>
		<!-- 모달 내용 -->
		<div class="input-group">
			<span class="input-group-addon"><i id="mainSignupIdIcon"
				class="fa fa-user"></i></span> <input type="text" id="inputIdInSignup"
				value='' placeholder="Write you ID" class="form-control" name="txtId" />
		</div>

		<div class="input-group">
			<span class="input-group-addon"><i id="mainSignupPwIcon1"
				class="fa fa-lock"></i></span> <input type="password" id="inputPw1InSignup"
				value='' placeholder="Write your PW" class="form-control" name="txtPw"/>
		</div>
		<div class="input-group">
			<span class="input-group-addon"><i id="mainSignupPwIcon2"
				class="fa fa-lock"></i></span> <input type="password" id="inputPw2InSignup"
				value='' placeholder="PW again" class="form-control" />
		</div>
		<div class="input-group">
			<span class="input-group-addon"><i id="mainSignupNameIcon"
				class="fa fa-male"></i></span> <input type="text" id="inputNameInSignup"
				value='' placeholder="Write your Name" class="form-control" name="txtName"/>
		</div>
		<div class="input-group">
			<span class="input-group-addon"><i id="mainSignupEmailIcon"
				class="fa fa-envelope"></i></span> <input type="text"
				id="inputEmailInSignup" value='' placeholder="Write your e-mail"
				class="form-control"  name="txtEmail"/>
		</div>
	</div>
	<div class="modal-footer" style="width: 50%; margin:auto;">
		<!-- data-dismiss="modal"를 통해 모달을 닫을수 있다. -->
		<button type="button" id="btnCancelInSignupModal"
			class="btn btn-secondary" data-dismiss="modal">Close</button>
		<button type="button" id="btnSignupInSignupModal"
			class="btn btn-primary">Sign up</button>
	</div>
</form>

</body>
</html>