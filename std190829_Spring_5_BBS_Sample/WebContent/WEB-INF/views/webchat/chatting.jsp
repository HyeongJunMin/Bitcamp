<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

채팅닉네임:<input type="text" id="nickname">
<input type="button" id="enterBtn" value="입장" onclick="connect()">

<input type="button" id="exitBtn" value="나가기">
<br><br>

<h1>대화영역</h1>
<div id="chatArea">
	<div id="chatMessageArea">
		
	</div>
</div>
<input type="text" id="message">
<input type="button" id="sendBtn" value="전송" onclick="send()">

<script type="text/javascript">
//웹 소켓 변수
var wsocket;

//입장 버튼 클릭 시 
function connect(){
	if( wsocket != undefined && wsocket.readyState != WebSocket.CLOSED){
		//이미 소켓이 생성된 경우
		alert('이미 입장하셨습니다.');
		return;
	}
	
	// Web Socket 생성
	wsocket = new WebSocket("ws://localhost:8090/std190829_Spring_5_BBS_Sample/echo.do");
	//alert('wsocket : ' + wsocket);
	
	//웹소켓 오픈이됐을 때, onOpen을 호출하라
	wsocket.onopen = onOpen;
	wsocket.onmessage = onMessage;
	wsocket.close = onClose;
}

function disconnect(){
	wsocket.close();
}

function onOpen(){
	appendMessage("연결되었습니다.");
}

//서버로부터 메시지를 받았을 때 자동 호출되는 함수
function onMessage(evt){
	var data = evt.data;
	if( data.substring(0,4) === 'msg:' ){
		//메세지를 받았을 때, msg:를 제외한 모든 내용을 append
		appendMessage( data.substring(4) );
	}
}

function onClose(){
	appendMessage('연결이 끊겼습니다.');
}

function send(){
	//클라이언트 메시지를 서버에 전송하는 부분
	var nickname = $("#nickname").val();
	var msg = $("#message").val();
	
	wsocket.send("msg:" + nickname + ":" + msg);
	$("#message").val('');
}

function appendMessage(msg){
	//클라이언트로부터 받은 메시지를 추가하고 개행처리
	$("#chatMessageArea").append(msg + "<br>");
	
	//높이를 구해서 아래로 미는 처리를 수행하는 부분
	var chatAreaHeight = $("#chatArea").height();
	var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
	
	$("#chatArea").scrollTop(maxScroll);
}

</script>

</html>