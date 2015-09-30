<%@ include file="/WEB-INF/views/include.jsp" %>

<%-- Redirected because we can't set the welcome page to a virtual URL. --%>
<!-- c:redirect url="/hello.htm"/-->
<!--
	Arcana by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>TMN Integral - Configuración</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	
		<script type="text/javascript">
				$(document).ready(function() {
				    $('#comandosTable').DataTable({
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
				} );
		</script>
	</head>
	<body onload="setMenuValue('configuracion');">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Logo -->
						<h1><a href="index.htm" id="logo">TMN <em>Integral</em></a></h1>

					<!-- Nav -->
						<%@ include file="/WEB-INF/views/menu.jsp" %>

				</div>
				
				<div class="container">
						<section class="12u 24u(narrower)">
							<h3>Administración de Comandos</h3>
							<table id="comandosTable" class="default">
								<thead>
									<tr>
										<td>Id</td>
										<td>Comando</td>
										<td>Tipo de Comando</td>
										<td>Ver</td>
										<td>Modificar</td>
										<td>Eliminar</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${model.commandList}" var="c">
										<tr>
											<td>${c.id_command}</td>
											<td>${c.command}</td>
											<td>${c.command_type}</td>
											<td><input type="image" src="images/view.png" onclick="displayComando(${c.id_command}, false)" style="width: 20px;height: 20px;"></td>
											<td><input type="image" src="images/update.png" onclick="displayComando(${c.id_command}, true)" style="width: 20px;height: 20px;"></td>
											<td><input type="image" src="images/delete.png" onclick="deleteComando(${c.id_command})" style="width: 20px;height: 20px;"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="row 100%">
								<ul class="actions">
									<li><input type="button" class="button alt" value="Nuevo" onclick="nuevoComando();" /></li>
								</ul>
							</div>
						</section>
					</div>
				</div>
			

			<!-- Footer -->
			<%@ include file="/WEB-INF/views/footer.jsp" %>
		</div>
	</body>
</html>