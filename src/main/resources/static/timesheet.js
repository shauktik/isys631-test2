//global validation flag, check if true before submitting the form
dataError = false;

//Fetching week start and end dates on the basis of odd-even logic. Weeks will always be fetched in pairs, example - 1,2/3,4..etc
//Timesheet weeks will be 2 weeks before schedule weeks
//Week - 1
function getcurrdt1() {
    var curr = new Date;
    today = moment(curr).format('MM-DD-YYYY');
    var wkno = moment(today).week();
    if (wkno % 2 == 0) {
        var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay() - 21));
        var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay() + 6));
        firstday1 = moment(firstday).format('MM/DD');
        lastday1 = moment(lastday).format('MM/DD');
        var finaldate = new String(firstday1 + "-" + lastday1);
    }
    else {
        var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay() - 14));
        var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay() + 6));
        firstday1 = moment(firstday).format('MM/DD');
        lastday1 = moment(lastday).format('MM/DD');
        var finaldate = new String(firstday1 + "-" + lastday1);
    }
    return finaldate;
}

//Week - 2
function getcurrdt2() {
    var curr = new Date;
    today = moment(curr).format('MM-DD-YYYY');
    var wkno = moment(today).week();
    if (wkno % 2 == 0) {
        var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay() - 14));
        var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay() + 6));
        firstday1 = moment(firstday).format('MM/DD');
        lastday1 = moment(lastday).format('MM/DD');
        var finaldate = new String(firstday1 + "-" + lastday1);
    }
    else {
        var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay() - 7));
        var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay() + 6));
        firstday1 = moment(firstday).format('MM/DD');
        lastday1 = moment(lastday).format('MM/DD');
        var finaldate = new String(firstday1 + "-" + lastday1);
    }
    return finaldate;
}

//Addition of all the hours from week1 and week2 into respective total fields
function findTotal() {
    var arr = document.getElementsByName('tw1');
    var tot = 0;
    for (var i = 0; i < arr.length; i++) {
        if (parseFloat(arr[i].value))
            tot += parseFloat(arr[i].value);
    }
    document.getElementById('totalw1').value = tot.toFixed(2);
    document.getElementById('totalw1r').value = tot.toFixed(2);
    var arr1 = document.getElementsByName('tw2');
    var tot1 = 0;
    for (var i = 0; i < arr1.length; i++) {
        if (parseFloat(arr1[i].value))
            tot1 += parseFloat(arr1[i].value);
    }
    document.getElementById('totalw2').value = tot1.toFixed(2);
    document.getElementById('totalw2r').value = tot1.toFixed(2);
}
document.getElementById("currwkdt1").innerHTML = getcurrdt1();
document.getElementById("currwkdt2").innerHTML = getcurrdt2();
document.getElementById("currwkdt1r").innerHTML = getcurrdt1();
document.getElementById("currwkdt2r").innerHTML = getcurrdt2();

//Validate that timesheet is entered as numbers or decimals
function validateTimesheet(input) {
    var re = /[^0-9\.]/;
    return re.test(input);
}

//Validate all timesheet input boxes at once on submit
function submitTime() {
		  var flag = false;
		  $('.shorty').filter(function() {
		    if (validateTimesheet($(this).val()) || parseFloat($(this).val()) > 24) {
		       dataError = true;
		      //no need to iterate further
		      return false;
		    }
		  });

    if (!dataError)
        alert("Thanks! Your time sheet has been submitted.");
    else
        alert("Uh Oh. Please check your time values for errors.");
}

//bind control specific events on page load 
$(document).ready(function () {
	//restricting length of input field
    $('.shorty').attr("maxlength", "5");
    
    //validate input Number in timesheet and highlight error cells as red
    $('.shorty').blur(function () {
        if (validateTimesheet($(this).val()) || parseFloat($(this).val()) > 24) {
            $(this).css("border-color", "red");
        }
        else {
            $(this).css("border-color", "#CCCCCC");
            if ($(this).val() != "")
                $(this).val(parseFloat($(this).val()).toFixed(2));
        }
    });

});