//bind control specific events on page load 
$(document).ready(function () {
//Display Navbar with all options only when the user is logged in
var uname = sessionStorage.getItem("userName");
	if(uname!==""){
		document.getElementById("navbar3").style.visibility='visible';
		document.getElementById("buttonCheck1").style.visibility='visible';	
		document.getElementById("aboutUsLogoLink").href="/userProfilePage";
	}
	else{
		document.getElementById("aboutUsLogoLink").href="/index";
	}
});