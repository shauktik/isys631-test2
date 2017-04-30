//global validation flag, check if true before submitting the form
dataError = true;

//main validate function
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
function FormValidation1() {
    if (dataError || $("input#email1").val().trim() == "" || $("textarea#comment1").val().trim() == "" || $("input#lname1").val().trim() == "" || $("input#fname1").val().trim() == "") {
        alert("Opps! Could not submit. Please check that the values are not empty or containing errors.");
        return false;
    }
    else
        alert("Thanks! Your request has been submitted. We'll contact you shortly.");
}

//Function with message box called on submit - responsive
function FormValidation2() {
    if (dataError || $("input#email2").val().trim() == "" || $("textarea#comment2").val().trim() == "" || $("input#lname2").val().trim() == "" || $("input#fname2").val().trim() == "") {
        alert("Oops! Could not submit. Please check that the values are not empty or containing errors.");
        return false;
    }
    else
        alert("Thanks! Your request has been submitted. We'll contact you shortly.");
}

//bind control specific events on page load 
$(document).ready(function () {
    //validate email, phone, first name, last name and comment
    $("input#email1").on("blur", function () {
        validate($(this), "email");
    });
    $("input#phone1").on("blur", function () {
        validate($(this), "phone");
    });
    $("input#fname1").on("blur", function () {
        validate($(this), "fname");
    });
    $("input#lname1").on("blur", function () {
        validate($(this), "lname");
    });
    $("textarea#comment1").on("blur", function () {
        validate($(this), "comment");
    });
    $("input#phone1").keyup(function () {
        $(this).val($(this).val().replace(/^(\d{3})(\d{3})(\d)+$/, "($1) $2-$3"));
    });
    
    //validate email, phone, first name, last name and comment - responsive
    $("input#email2").on("blur", function () {
        validate($(this), "email");
    });
    $("input#phone2").on("blur", function () {
        validate($(this), "phone");
    });
    $("input#fname2").on("blur", function () {
        validate($(this), "fname");
    });
    $("input#lname2").on("blur", function () {
        validate($(this), "lname");
    });
    $("textarea#comment2").on("blur", function () {
        validate($(this), "comment");
    });
    $("input#phone2").keyup(function () {
        $(this).val($(this).val().replace(/^(\d{3})(\d{3})(\d)+$/, "($1) $2-$3"));
    });
});