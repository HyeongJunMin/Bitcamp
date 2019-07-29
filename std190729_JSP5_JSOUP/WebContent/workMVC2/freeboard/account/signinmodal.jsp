<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
<script type="text/javascript" src="static/js/freeboard/modalSignin.js"></script>
<!-- Modal form -->
	<!-- class를 통해 모달을 선언하고 투명에서 밝아지는 효과(fade)를 준다. -->
	<!-- 여기서 가장 중요한거는 id 입니다. 위에 타겟과 동일해야 합니다. #은 아이디 .은 클래스 -->
	
	<!-- Sign in modal form -->
	<div class="modal fade" id="signinModal" tabindex="-1" role="dialog"
		aria-labelledby="signinModalLabel" aria-hidden="true">
		<!-- class를 주목하시면  여기 클레스에 modal-lg, modal-sm을 입력하시면 스몰 모달, 라지 모달로 선언이 가능 합니다. -->
		<!-- 위에 설명 예 : <div class="modal-dialog modal-sm" role="document"> -->
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<!-- 모달 이름 -->
					<h5 class="modal-title" id="signinModalLabel">Sign in</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- 모달 내용 -->
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSigninIdIcon" class="fa fa-user"></i></span>
						<input type="text" id="txtIdInSignin" value='' placeholder="Write you ID" class="form-control" />
                    </div>
			
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSigninPwIcon" class="fa fa-lock"></i></span> 
						<input type="password" id="txtPwInSignin" value='' placeholder="Write your PW" class="form-control" />
					</div>
				</div>
				<div class="modal-footer">
					<!-- data-dismiss="modal"를 통해 모달을 닫을수 있다. -->
					<button type="button" id="btnCancelInSigninModal" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" id="btnSigninInSigninModal" class="btn btn-primary">Sign in</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>