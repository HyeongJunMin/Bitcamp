function f1(){
	var str = document.getElementById("h3tag").innerHTML;
	alert(str);
}

function f2(){
	var str = document.getElementById("h3tag2").value;
	alert(str);
}

function showDate(){
	document.getElementById("p1").innerHTML = Date();
	document.getElementById("t1").value = (Date()+"").substring(0, 24);
}

//setInterval("showDate()", 1000);
function getDateInfo(){
	var d = new Date();
	
	//setter	년, 월, 일, 시, 분, 초, ms
	//d = new Date(2019, 10 - 1, 12, 3, 27, 25, 100);
	document.getElementById("p2").innerHTML = d;
	document.getElementById("b2").value = d.getMonth()+1;
}
var timeleftSec = 1;
function ftimer(){
	var timeleft = document.getElementById("timer1").value;
	alert(timeleft+'분 카운트 시작');
	timeleftSec = timeleft*60;
	//timeleftSec = 5;
	
	document.getElementById("showlefttime").innerHTML = '완료까지 ' + timeleftSec + ' 초 남았습니다.';
	
	runTimer = setInterval(function(){
		timeleftSec -=1;
		document.getElementById("showlefttime").innerHTML = '완료까지 ' + timeleftSec + ' 초 남았습니다.';
		if(timeleftSec === 0){
			alert('종료!');
			clearInterval(runTimer);
		}
	}, 1000);
}

function countSeconds(timeleft){
	document.getElementById("showlefttime").innerHTML = '완료까지 ' + timeleft + ' 초 남았습니다.';
	timeleft -=1;
	
}