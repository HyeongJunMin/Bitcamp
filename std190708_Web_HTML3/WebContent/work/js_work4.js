var amount = document.getElementById("charge").value;
function f1(){
	//체크가 되어있는지 boolean
	var chk = document.getElementById("light").checked;
	
	amount = document.getElementById("charge").value.replace("," , "");
	if( chk === true){
		amount = Number(amount) + 20000 + "";
	}else{
		amount = Number(amount) - 20000 + "";
	}
	document.getElementById("charge").value = numberWithCommas(amount);
}
function f2(){
	var chk = document.getElementById("net").checked;
	amount = document.getElementById("charge").value.replace(",","");
	if( chk === true){
		amount = Number(amount) + 4000 +"";
	}else{
		amount = Number(amount) - 4000 +"";
	}
	document.getElementById("charge").value = numberWithCommas(amount);
}
function f3(){
	var chk = document.getElementById("ball").checked;
	amount = document.getElementById("charge").value.replace(",","");
	if( chk === true){
		amount = Number(amount) + 5000 +"";
	}else{
		amount = Number(amount) - 5000 +"";
	}
	document.getElementById("charge").value = numberWithCommas(amount);
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}