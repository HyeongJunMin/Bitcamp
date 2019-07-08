var si = document.getElementById('')

function btnSigninClick() {
	var strId = document.getElementById("txtId").value;
	var strPw = document.getElementById("txtPw").value;
	var str = "ID : " + strId + "\nPW : " + strPw;
	alert(str);	
}
function btnSignupClick() {
	
	alert("회원가입");
}


//레이어팝업

function LayerPopupView(sDivName, nTop, nLeft, nHeight, nWidth) {
	/*
	레이어 팝업을 띄웁니다.
	팝업의 크기는 내용물의 크기에 영향을 받습니다.
	그렇기 때문에 내용물에 따라 정확하지 않은 크기가 적용될수 있습니다.
	    
	매개변수 
	sDivName : 레이어 팝업으로 쓸 div id
	nTop : 팝업의 세로 위치
	nLeft : 팝업의 가로 위치
	nHeight : 팝업의 세로 크기
	nWidth : 팝업의 가로 크기
	 */
	//사용할 레이어을 불러온다.
	var oPopup = document.getElementById(sDivName);
	//레이어을 표시하고
	oPopup.style.display = "block";

	//위치 및 크기 설정
	oPopup.style.top = nTop + "px";
	oPopup.style.left = nLeft + "px";
	oPopup.style.height = nHeight + "px";
	oPopup.style.width = nWidth + "px";
//	oPopup.style.top = "10px";
//	oPopup.style.left = "1px";
//	oPopup.style.height = "200px";
//	oPopup.style.width = "100px";
}

function LayerPopupClose(sDivName) {
	/*
	어 팝업을 닫습니다.	    
	매개변수 
	sDivName : 레이어 팝업으로 쓸 div id
	 */
	var oPopup = document.getElementById(sDivName);
	oPopup.style.display = "none";
}

function pageMove(){
	alert("누르긴했어");
	location.replace("./JSPTest/JSPLoopTest.jsp");
}