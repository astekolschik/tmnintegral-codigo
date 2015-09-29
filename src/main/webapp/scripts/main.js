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
	
	var re = new RegExp("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20})");
	if (!re.test(pass1)){
		alert('La contraseña no cumple los criterios de seguridad: \n '
				+ '1. Debe tener al menos un caracter en mínuscula.'
				+ '2. Debe tener al menos un caracter en mayúscula.'
				+ '3. Debe tener al menos un número.'
				+ '4. Debe tener una longitud entre 8 y 20 caracteres.');
		return false;
	}
	
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

function displayTipoEquipo(teId, isEdition){
	window.location.replace("/TMNIntegralWeb/displayTipoEquipo.htm?teId=" + teId + "&edit=" + isEdition);
}

function nuevoTipoEquipo(){
	window.location.replace("/TMNIntegralWeb/nuevoTipoEquipo.htm");
}

function displayLisTipoEquipo(){
	window.location.replace("/TMNIntegralWeb/listTipoEquipos.htm");
}

function deleteTipoEquipo(idTipoEquipo){
	window.location.replace("/TMNIntegralWeb/deleteTipoEquipo.htm?teId=" + idTipoEquipo);
}

function setEnableFields(isEnabled){
	$('#idequipo').prop( "disabled", !isEnabled );
	$('#defaultComm').prop( "disabled", !isEnabled );
	$('#defaultSNMP').prop( "disabled", !isEnabled );
	$('#driver').prop( "disabled", !isEnabled );
	$('#technology').prop( "disabled", !isEnabled );
	$('#vendor').prop( "disabled", !isEnabled );
}