//global validation flag, check if true before submitting the form
dataError = false;
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
        var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay()));
        var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay() + 6));
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
    if (wkno % 2 == 0) {
        var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay() - 14));
        var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay() + 6));
        firstday1 = moment(firstday).format('MM/DD');
        lastday1 = moment(lastday).format('MM/DD');
        var finaldate = new String(firstday1 + "-" + lastday1);
    }
    else {
        var firstday = new Date(curr.setDate(curr.getDate() - curr.getDay() + 7));
        var lastday = new Date(curr.setDate(curr.getDate() - curr.getDay() + 6));
        firstday1 = moment(firstday).format('MM/DD');
        lastday1 = moment(lastday).format('MM/DD');
        var finaldate = new String(firstday1 + "-" + lastday1);
    }
    return finaldate;
}
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

/*New changes*/
function validateTimesheet(input) {
    var re = /[^0-9\.]/;
    return re.test(input);
}
function submitTime() {
    if (!dataError)
        alert("Your time sheet has been submitted.");
    else
        alert("Please check your time values for errors.");
}

$(document).ready(function () {
    //restricting length of input field
    $("input[type='text']").attr("maxlength", "5");
   // $("input[type='text']").attr("type", "number");
    //validate input Number in timesheet
    $('input').blur(function () {
        if (validateTimesheet($(this).val()) || parseFloat($(this).val()) > 24) {
            $(this).css("border-color", "red");
            dataError = true;
        }
        else {
            $(this).css("border-color", "#CCCCCC");
            $(this).val(parseFloat($(this).val()).toFixed(2));
            dataError = false;
        }
    });

});
//End new changes