function enviarComentario(){
	
	var nombre = ($('#name')).value;
	var email = ($('#email')).value;
	var motivo = ($('#motivo')).value;
	var texto = ($('#message')).value;
	//Ajax request to send the comment
	var xmlhttp;
	if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}else{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				alert('Gracias!\nSu mail se envío conrrectamente. Responderemos a la brevedad.');
			}
	}
	
	xmlhttp.open("GET","/tmnintegral/contacto.htm?nombre=" + nombre + "&email=" + email + "&motivo=" + motivo + "&mensaje=" + texto,true);
	xmlhttp.send();
}