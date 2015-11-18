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
	<body onload="setMenuValue('inventory'); setEnableFields(${model.edit})">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Logo -->
						<h1><a href="index.htm" id="logo">TMN <em>Integral</em></a></h1>

					<!-- Nav -->
						<%@ include file="/WEB-INF/views/menu.jsp" %>

				</div>
				
				<div class="container">
						<section class="8u 16u(narrower)">
							<h3>Equipo</h3>
							<form action="/TMNIntegralWeb/updateEquipo.htm" method="post">
								<div class="row 100%">
									<c:if test="${model.deviceObj.device_id != 0}">
										<div class="4u 8u(mobilep)">
											<label>Id de Equipo</label>
										</div>
										<div class="8u 16u(mobilep)">
											<input type="text" id="idDevice" name="idDevice" value="${model.deviceObj.device_id}" placeholder="Id de Equipo" />
										</div>
									</c:if>
									<div class="4u 8u(mobilep)">
										<label>Community Read</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="communityRead" name="communityRead" value="${model.deviceObj.communityRead}" placeholder="Community Read" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Host</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="hostName" name="hostName" value="${model.deviceObj.hostName}" placeholder="Host" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Tipo Ios</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="iosType" name="iosType" value="${model.deviceObj.iosType}" placeholder="Tipo Ios" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Version Ios</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="iosVersion" name="iosVersion" value="${model.deviceObj.iosVersion}" placeholder="Version Ios" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>IP</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="ip" name="ip" value="${model.deviceObj.ip}" placeholder="IP" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Modelo</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="model" name="model" value="${model.deviceObj.model}" placeholder="Model" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Numero de Serie</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="serialNumber" name="serialNumber" value="${model.deviceObj.serialNumber}" placeholder="Numero de serie" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Release</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="softwareRelease" name="softwareRelease" value="${model.deviceObj.softwareRelease}" placeholder="Release" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Tipo de equipo</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="id_device_type" name="id_device_type" value="${model.deviceObj.id_device_type}" placeholder="Tipo de Equipo" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Red</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="id_network" name="id_network" value="${model.deviceObj.id_network}" placeholder="Red" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Configuracion</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="id_configuration" name="id_configuration" value="${model.deviceObj.id_configuration}" placeholder="Configuracion" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Informacion equipo</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="id_equipment_info" name="id_equipment_info" value="${model.deviceObj.id_equipment_info}" placeholder="Informacion Equipo" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Habilitado</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="enable" name="enable" value="${model.deviceObj.enable}" placeholder="Habilitado" />
									</div>
								</div>
								<div class="row 100%">
									<div class="12u">
										<ul class="actions">
											<li style="display: ${model.displayEdit}">
												<input type="submit" class="button alt" value="Guardar" />
											</li>
											<li><input type="button" class="button alt" value="Volver" onclick="displayLisDevice();" /></li>
										</ul>
									</div>
								</div>
							</form>
						</section>
					</div>
				</div>
			

			<!-- Footer -->
			<%@ include file="/WEB-INF/views/footer.jsp" %>
		</div>
	</body>
</html>