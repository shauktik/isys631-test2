//Validation for Dropshift message box
function fncheck() {
    if (document.getElementById("dropShiftMessage").value.trim() == "") {
        alert("Oops! This textbox should not be empty. Please enter the week, day, and shift you want to drop.");
        return false;
    }
    else
    	{
        alert("Thanks for letting us know! Your manager wil be in touch shortly.");
    	return false;
    	}
}

//Fetching week start and end dates on the basis of odd-even logic. Weeks will always be fetched in pairs, example - 1,2/3,4..etc
function getcurrdt() {
	var curr = new Date;
	today = moment(curr).format('MM-DD-YYYY');
	var wkno = moment(today).week();
	if (wkno % 2 == 0){
		var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay()-7));
		var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay()+13));
		firstday1 = moment(firstday).format('MM/DD');
		lastday1 = moment(lastday).format('MM/DD');
		var finaldate = new String(firstday1 + "-" + lastday1);
	}
	else{
		var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay()));
		var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay()+13));
		firstday1 = moment(firstday).format('MM/DD');
		lastday1 = moment(lastday).format('MM/DD');
		var finaldate = new String(firstday1 + "-" + lastday1);
	}
	return finaldate;	
}

//Fetching week number for schedule (Odd)
function getwk() {
	var curr = new Date;
	today = moment(curr).format('MM-DD-YYYY');
	var wkno = moment(today).week();
	if (wkno % 2 == 0){
		weekno = wkno - 1;
	}
	else{
		weekno = wkno;
	}
	return weekno;
}
//Fetching week number for schedule (Even)
function getwk1() {
	var curr = new Date;
	today = moment(curr).format('MM-DD-YYYY');
	var wkno = moment(today).week();
	if (wkno % 2 == 0){
		weekno = wkno;
	}
	else{
		weekno = wkno + 1;
	}
	return weekno;
}

document.getElementById("currwkdt").innerHTML = getcurrdt();
document.getElementById("currwkdtr").innerHTML = getcurrdt();
document.getElementById("currwk").innerHTML = getwk();
document.getElementById("currwk1").innerHTML = getwk1();
document.getElementById("currwkr").innerHTML = getwk();
document.getElementById("currwk1r").innerHTML = getwk1();

