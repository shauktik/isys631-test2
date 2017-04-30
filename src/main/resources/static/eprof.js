//global validation flag, check if true before submitting the form
dataError = true;

//main validate method
function validateControl(type, elem) {
    var result = true;
    //regex for email
    var re = /\S+@\S+\.\S+/;
    if (type == "phone")
        re = /([0-9]{10})|(\([0-9]{3}\)\s+[0-9]{3}\-[0-9]{4})/;
    if (type == "phone" || type == "email") {
        if (type == "phone" && elem.val() == "")	
            return true;
        else
            return re.test(elem.val());
    }
    else if (elem.val().trim() == "")
        result = false;
    return result;
}

//validation function for highlighting cells as red on error
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

//Function with message box called on submit
function saveVal() {
if (dataError || $("input#addressline1").val().trim() == "" || $("input#state").val().trim() == "" || $("input#addressline2").val().trim() == "" || $("input#zip").val().trim() == "" || $("input#phone").val().trim() == "") {
        alert("Oops! Could not submit. Please check that the values are not empty or containing errors.");
        return false;
    }
    else {
        alert("Alright! Your changes have been saved.");
    }
}

//bind control specific events on page load 
$(document).ready(function () {
	//validate addressline1
    $("input#addressline1").on("blur", function () {
        validate($(this), "addressline1");
    });
	//validate addressline2
    $("input#addressline2").on("blur", function () {
        validate($(this), "addressline2");
    });
	//validate state
    $("input#state").on("blur", function () {
        validate($(this), "state");
    });
	//validate zip
    $("input#zip").on("blur", function () {
        validate($(this), "zip");
    });
    //validate phone number
    $("input#phone").on("blur", function () {
        validate($(this), "phone");
    });
    //format phone number
    $("input#phone").keyup(function () {
        $(this).val($(this).val().replace(/^(\d{3})(\d{3})(\d)+$/, "($1) $2-$3"));
    });
});