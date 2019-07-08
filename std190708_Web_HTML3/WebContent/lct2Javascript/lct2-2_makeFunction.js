function f1(){
	alert("function1");
}

var pi = 3.141582;
var name = "홍길동";
var number=123, updown=true, person = "일지매", num=234+5;

function f2(){
	alert("person" + person + " num:" + num);
}

function f3(){
	num = "야호!";
	alert("person" + person + " num:" + num);
}
//배열
var cars = new Array(3);
cars[0] = "현대";
cars[1] = "기아";
cars[2] = "대우";
function arrF1(){
	for(v in cars){
		console.log(cars);	
	}
}

function json1(){
	var obj = { f:"길동", l:"홍", a:24, f:function(){alert("obj function");}};
	console.log(obj.f);
	console.log(obj.l);
	console.log(obj.a);
	
	obj.f();
}


