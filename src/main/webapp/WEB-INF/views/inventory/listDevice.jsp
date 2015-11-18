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
		<title>TMN Integral - Inventory</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	
	</head>
	<body onload="setMenuValue('inventory');paginateTable('deviceTable')">
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
							<h3>Administración de Equipos</h3>
							<table id="deviceTable" class="default">
								<thead>
									<tr>
										<td>Id</td>
										<td>Community Reas</td>
										<td>Host Name</td>
										<td>Ios type</td>
										<td>Ios Version</td>
										<td>IP</td>
										<td>Modelo</td>
										<td>Número de Serie</td>
										<td>Software Release</td>
										<td>Tipo de Equipo</td>
										<td>Red</td>
										<td>Configuración</td>
										<td>Información del Equipo</td>
										<td>Enable</td>
										<td>Última Actualización</td>
										<td>Ver</td>
										<td>Modificar</td>
										<td>Eliminar</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${model.deviceList}" var="de">
										<tr>
											<td>${de.device_id}</td>
											<td>${de.communityRead}</td>
											<td>${de.hostName}</td>
											<td>${de.iosType}</td>
											<td>${de.iosVersion}</td>
											<td>${de.ip}</td>
											<td>${de.model}</td>
											<td>${de.serialNumber}</td>
											<td>${de.softwareRelease}</td>
											<td>${de.id_device_type}</td>
											<td>${de.id_network}</td>
											<td>${de.id_configuration}</td>
											<td>${de.id_equipment_info}</td>
											<td>${de.enable}</td>
											<td>${de.last_update_date}</td>
											<td><input type="image" src="images/view.png" onclick="displayDevice(${de.device_id}, false)" style="width: 20px;height: 20px;"></td>
											<td><input type="image" src="images/update.png" onclick="displayDevice(${de.device_id}, true)" style="width: 20px;height: 20px;"></td>
											<td><input type="image" src="images/delete.png" onclick="deleteDevice(${de.device_id})" style="width: 20px;height: 20px;"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="row 100%">
								<ul class="actions">
									<li><input type="button" class="button alt" value="Nueva" onclick="nuevoEquipo();" /></li>
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