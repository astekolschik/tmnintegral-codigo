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

function displayComando(cId, isEdition){
	window.location.replace("/TMNIntegralWeb/displayComando.htm?cId=" + cId + "&edit=" + isEdition);
}

function nuevoComando(){
	window.location.replace("/TMNIntegralWeb/nuevoComando.htm");
}

function displayListComandos(){
	window.location.replace("/TMNIntegralWeb/listComandos.htm");
}

function deleteComando(idComando){
	window.location.replace("/TMNIntegralWeb/deleteComando.htm?cId=" + idComando);
}


function setEnableFields(isEnabled){
	$('input[type=text]').each(function () {
		this.disabled = !isEnabled ;
	  });
}

function paginateTable(tableId){
	$('#' + tableId).DataTable({
    	"language": {
    	    "sProcessing":     "Procesando...",
    	    "sLengthMenu":     "Mostrar _MENU_ registros",
    	    "sZeroRecords":    "No se encontraron resultados",
    	    "sEmptyTable":     "Ningún dato disponible en esta tabla",
    	    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
    	    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
    	    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
    	    "sInfoPostFix":    "",
    	    "sSearch":         "Buscar:",
    	    "sUrl":            "",
    	    "sInfoThousands":  ",",
    	    "sLoadingRecords": "Cargando...",
    	    "oPaginate": {
    	        "sFirst":    "Primero",
    	        "sLast":     "Último",
    	        "sNext":     "Siguiente",
    	        "sPrevious": "Anterior"
    	    },
    	    "oAria": {
    	        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
    	        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
    	    }
    	}
    });
}

function selectAllCheckbox(chk){
	var val = chk.checked;
	$('input[type=checkbox]').each(function () {
		this.checked = val;
	  });
}

function setTipoEquiposSelectValues(dts){
	var vals = [];
	$.each(dts, function(i,e){
	    $("#dt-select option[value='" + e + "']").prop("selected", true);
	});
}

function setdtValues(){
    $("#dtValues").val($("#dt-select").val());
}