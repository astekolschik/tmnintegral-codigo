function setMenuValue(idMenu){
	$('#menu-' + idMenu).addClass('current');
	if(idMenu=='index')
		$('#menu-contactenos').show();
	else
		$('#menu-contactenos').hide();
}

function updateUserValidate(){
	$('#saveUser').val(true);
	return validatePassword();
}

function createUserValidate(){
	return validatePassword();
}

function validatePassword(){
	var pass1 = $('#password').val();
	var pass2 = $('#password2').val();
	if (pass1 != ''){
		if (pass1 == pass2)
			return true;
		else{
			alert('Las contraseñas deben coincidir');
			return false;
		}
	}
}

function eliminarUsuarios(){
	var delList = [];
	$("input:checkbox[name=userCheck]:checked").each(function(){
	    delList.push($(this).val());
	});
	if(delList.length == 0){
		alert('Debe seleccionar al menos un usuario.');
	}else{
		 window.location.replace("/TMNIntegralWeb/deleteUser.htm?deleteUserList=" + delList);
	}
}