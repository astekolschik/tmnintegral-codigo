function setMenuValue(idMenu){
	$('#menu-' + idMenu).addClass('current');
	if(idMenu=='index')
		$('#menu-contactenos').show();
	else
		$('#menu-contactenos').hide();
}