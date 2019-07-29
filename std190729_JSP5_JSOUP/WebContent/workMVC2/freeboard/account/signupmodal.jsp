<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
<script type="text/javascript" src="static/js/freeboard/modalSignup.js"></script>
	<!-- Sign up modal form -->
	<form action="/signup" id="formSignup">
	<div class="modal fade" id="signupModal" tabindex="-1" role="dialog"
		aria-labelledby="signupModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<!-- 모달 이름 -->
					<h5 class="modal-title" id="signupModalLabel">Sign up</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p id="signupWarn"> &nbsp;</p>
					<!-- 모달 내용 -->
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSignupIdIcon" class="fa fa-user"></i></span>
						<input type="text" id="inputIdInSignup" value='' placeholder="Write you ID" class="form-control" />
                    </div>
			
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSignupPwIcon1" class="fa fa-lock"></i></span> 
						<input type="password" id="inputPw1InSignup" value='' placeholder="Write your PW" class="form-control" />
					</div>
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSignupPwIcon2" class="fa fa-lock"></i></span> 
						<input type="password" id="inputPw2InSignup" value='' placeholder="PW again" class="form-control" />
					</div>
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSignupNameIcon" class="fa fa-male"></i></span> 
						<input type="text" id="inputNameInSignup" value='' placeholder="Write your Name" class="form-control" />
					</div>
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSignupEmailIcon" class="fa fa-envelope"></i></span> 
						<input type="text" id="inputEmailInSignup" value='' placeholder="Write your e-mail" class="form-control" />
					</div>
				</div>
				<div class="modal-footer">
					<!-- data-dismiss="modal"를 통해 모달을 닫을수 있다. -->
					<button type="button" id="btnCancelInSignupModal" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" id="btnSignupInSignupModal" class="btn btn-primary">Sign up</button>
				</div>
			</div>
		</div>
	</div>
	</form>

</body>
</html>