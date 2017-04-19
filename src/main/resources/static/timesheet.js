function getcurrdt1() {
	var curr = new Date;
	today = moment(curr).format('MM-DD-YYYY');
	var wkno = moment(today).week();
	if (wkno % 2 == 0){
		var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay()-21));
		var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay()+6));
		firstday1 = moment(firstday).format('MM/DD');
		lastday1 = moment(lastday).format('MM/DD');
		var finaldate = new String(firstday1 + "-" + lastday1);
	}
	else{
		var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay()));
		var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay()+6));
		firstday1 = moment(firstday).format('MM/DD');
		lastday1 = moment(lastday).format('MM/DD');
		var finaldate = new String(firstday1 + "-" + lastday1);
	}
	return finaldate;	
}
function getcurrdt2() {
	var curr = new Date;
	today = moment(curr).format('MM-DD-YYYY');
	var wkno = moment(today).week();
	if (wkno % 2 == 0){
		var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay()-14));
		var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay()+6));
		firstday1 = moment(firstday).format('MM/DD');
		lastday1 = moment(lastday).format('MM/DD');
		var finaldate = new String(firstday1 + "-" + lastday1);
	}
	else{
		var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay()+7));
		var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay()+6));
		firstday1 = moment(firstday).format('MM/DD');
		lastday1 = moment(lastday).format('MM/DD');
		var finaldate = new String(firstday1 + "-" + lastday1);
	}
	return finaldate;	
}
function findTotal(){
    var arr = document.getElementsByName('tw1');	
    var tot=0;
    for(var i=0;i<arr.length;i++){
        if(parseFloat(arr[i].value))
            tot += parseFloat(arr[i].value);
    }
    document.getElementById('totalw1').value = tot;
	document.getElementById('totalw1r').value = tot;
    var arr1 = document.getElementsByName('tw2');	
    var tot1=0;
    for(var i=0;i<arr1.length;i++){
        if(parseFloat(arr1[i].value))
            tot1 += parseFloat(arr1[i].value);
    }
    document.getElementById('totalw2').value = tot1;
	document.getElementById('totalw2r').value = tot1;
}
document.getElementById("currwkdt1").innerHTML = getcurrdt1();
document.getElementById("currwkdt2").innerHTML = getcurrdt2();
document.getElementById("currwkdt1r").innerHTML = getcurrdt1();
document.getElementById("currwkdt2r").innerHTML = getcurrdt2();