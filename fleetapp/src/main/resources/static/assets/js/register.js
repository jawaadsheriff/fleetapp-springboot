/**
 *
 */

$('document').ready(function(){
	var password = document.getElementById('passwordId');
	var confirmPassword = document.getElementById('confirmPasswordId');
	
	function validatePassword(){
		if(confirmPassword.value != password.value){
			confirmPassword.setCustomValidity("Passwords dont match");
		}else{
			confirmPassword.setCustomValidity("");
		}
	}
	
	password.onchange = validatePassword;
	confirmPassword.onkeyup = validatePassword;
});