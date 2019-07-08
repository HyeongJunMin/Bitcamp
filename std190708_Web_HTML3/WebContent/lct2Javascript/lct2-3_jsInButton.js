function f1() {
	document.getElementById("d1").innerHTML = "Hello";
}
function f2(num) {
	document.getElementById("d1").innerHTML = num * 6;
}
function f3(){
	document.getElementById("d1").innerHTML = mul(3, 4);
}
function mul(x, y){
	return x * y;
}

function cal(){
	var n1 = document.getElementById("n1").value;
	document.getElementById("n1").value = n1;
}