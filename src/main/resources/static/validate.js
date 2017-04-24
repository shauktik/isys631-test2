//global validation flag, check if true before submitting the form
dataError = true;
function validateControl(type, elem) {
    var result = true;
    var re = /\S+@\S+\.\S+/;
    if (type == "phone")
        re = /([0-9]{10})|(\([0-9]{3}\)\s+[0-9]{3}\-[0-9]{4})/;
    if (type == "phone" || type == "email")
        return re.test(elem.val());
    else if (elem.val().trim() == "")
        result = false;
    return result;
}

function formatSSN(elem) {
    if (elem.val() != "" && elem.val() != "undefined") {
        var val = elem.val().replace(/\D/g, '');
        var newVal = '';
        if (val.length > 4) {
            elem.val(val);
        }
        if ((val.length > 3) && (val.length < 6)) {
            newVal += val.substr(0, 3) + '-';
            val = val.substr(3);
        }
        if (val.length > 5) {
            newVal += val.substr(0, 3) + '-';
            newVal += val.substr(3, 2) + '-';
            val = val.substr(5);
        }
        newVal += val;
        elem.val(newVal.substring(0, 11));
    }
}

//main validate method
function validate(elem, type) {
    var input = elem.val();
    if (validateControl(type, elem)) {
        elem.css("border-color", "#CCCCCC");
        dataError = false;
    } else {
        elem.css("border-color", "red");
        dataError = true;
    }
}

//saveBtn validation
function saveVal() {
    if (dataError == false) {
        alert("Your changes have been saved.");
    }
    else {
        alert("No changes have been made. Please make sure all fields are correctly entered.");
    }
}

function reset() {
    var okToRefresh = confirm("Do you really want to refresh the page?");
    if (okToRefresh) {
        setTimeout(this.reload(true), 1500);
    }
}
function FormValidation() {
    if (dataError) {
        alert("Cannot submit. Value cannot be empty or fields contain errors");
    }
    else
        alert("Submitted"); 
}

$(document).ready(function () {
    //bind control specific events on page load 
    //validate email
    $("input#email").on("blur", function () {
        validate($(this), "email");
    });
    //validate phone number
    $("input#phone").on("blur", function () {
        validate($(this), "phone");
    });
    $("input#fname").on("blur", function () {
        validate($(this), "fname");
    });
    $("input#lname").on("blur", function () {
        validate($(this), "lname");
    });
    $("#comment").on("blur", function () {
        validate($(this), "comment");
    });
    //format phone number
    $("input#phone").keyup(function () {
        $(this).val($(this).val().replace(/^(\d{3})(\d{3})(\d)+$/, "($1) $2-$3"));
    });
    //format ssn
    formatSSN($("#ssn"));
});