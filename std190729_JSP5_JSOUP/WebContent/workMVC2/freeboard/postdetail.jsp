<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap, jQuery CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"></link>

<!-- Custom js, css -->
<script type="text/javascript" src="/resources/js/freeboard/freeboardmain.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/freeboard/freeboardmain.css"></link>
</head>
<body id="mainBody">

<%
	request.getParameter("");
%>

	<!-- Main Header Bar Menu -->
	<div id="mainHeaderBar">
		<div id="mainHeaderBarMenu">
			<a href=""><span>menu 1</span></a>
			<a href=""><span>menu 2</span></a>
			<a href=""><span>menu 3</span></a>
			<a href=""><span>menu 4</span></a>
			<a href=""><span>menu 5</span></a>
			<a href=""><span>menu 6</span></a>
			<a href=""><span>menu 7</span></a>
		</div>
	</div>
	<!-- Main Header -->
	<div id="mainHeader">
		<h1>Free Board</h1>
	</div>

	<!-- Main Body -->
	<div id="mainContainer">
		<!-- Contents View -->
		<div id="mainContentsView">
			<div id="mainContentsList">
				<div id="postdetailContent">
					<div id="postContentHeader">
						<br><br><h3 class="h3">제목</h3><hr>
					</div>
					<div id="postContentBody">
						
					</div>					
					<div id="postContentFooter">
					
					</div>
				</div>				
			</div>
		</div>

		<!-- Side view in container -->
		<div id="mainSideView">
			<!-- Sign in and Sign up  -->
			<div id="mainAccountView">
				<!-- Button for open modal view Attribute : data-target, data-toggle-->
				<button id="btnMainSignin" type="button" class="btn btn-primary"
					data-toggle="modal" data-target="#signinModal">Sign in</button>
				<!-- <input id="btnMainSignin" type="button" value="Sign in" onclick="echoTest()"> -->
				<br><br> 
				<a onclick="echoTest()" href="">Find ID/PW</a>	&nbsp;&nbsp;&nbsp;&nbsp; 
				<a href="" data-toggle="modal" data-target="#signupModal">Sign up here!</a>
			</div>
			<!-- Show category  -->
			<div id="mainCategoryView">mainCategory</div>
		</div>
	</div>

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
						<input type="text" id="userid" value='' placeholder="Write you ID" class="form-control" />
                    </div>
			
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSigninPwIcon" class="fa fa-lock"></i></span> 
						<input type="password" id="password" value='' placeholder="Write your PW" class="form-control" />
					</div>
				</div>
				<div class="modal-footer">
					<!-- data-dismiss="modal"를 통해 모달을 닫을수 있다. -->
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Sign in</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Sign up modal form -->
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
					<!-- 모달 내용 -->
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSignupIdIcon" class="fa fa-user"></i></span>
						<input type="text" id="inputId" value='' placeholder="Write you ID" class="form-control" />
                    </div>
			
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSignupPwIcon1" class="fa fa-lock"></i></span> 
						<input type="password" id="inputPw1" value='' placeholder="Write your PW" class="form-control" />
					</div>
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSignupPwIcon2" class="fa fa-lock"></i></span> 
						<input type="password" id="inputPw2" value='' placeholder="PW again" class="form-control" />
					</div>
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSignupNameIcon" class="fa fa-male"></i></span> 
						<input type="text" id="inputName" value='' placeholder="Write your Name" class="form-control" />
					</div>
					<div class="input-group">
						<span class="input-group-addon"><i id="mainSignupEmailIcon" class="fa fa-envelope"></i></span> 
						<input type="text" id="inputEmail" value='' placeholder="Write your e-mail" class="form-control" />
					</div>
				</div>
				<div class="modal-footer">
					<!-- data-dismiss="modal"를 통해 모달을 닫을수 있다. -->
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Sign up</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>