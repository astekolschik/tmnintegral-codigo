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
							<h3>Interfaz</h3>
							<form action="/TMNIntegralWeb/updateInterface.htm" method="post">
								<div class="row 100%">
									<c:if test="${model.interfaceObj.id != 0}">
										<div class="4u 8u(mobilep)">
											<label>Id de Interfaz</label>
										</div>
										<div class="8u 16u(mobilep)">
											<input type="text" id="idInterfaz" name="idInterfaz" value="${model.interfaceObj.id}" placeholder="Id Interfaz" />
										</div>
									</c:if>
									<div class="4u 8u(mobilep)">
										<label>Status</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="status" name="status" value="${model.interfaceObj.adminStatus}" placeholder="Status" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Alias</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="alias" name="alias" value="${model.interfaceObj.alias}" placeholder="Alias" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Nombre</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="name" name="name" value="${model.interfaceObj.name}" placeholder="Nombre" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Shelf</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="shelf" name="shelf" value="${model.interfaceObj.shelf}" placeholder="Shelf" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Slot</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="slot" name="slot" value="${model.interfaceObj.slot}" placeholder="Slot" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Puerto</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="port" name="port" value="${model.interfaceObj.port}" placeholder="Port" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Sub Puerto</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="subport" name="subport" value="${model.interfaceObj.subPort}" placeholder="Sub Puerto" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Tipo</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="type" name="type" value="${model.interfaceObj.type}" placeholder="Tipo" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Equipo</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="device" name="device" value="${model.interfaceObj.id_device}" placeholder="Equipo" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>IF Index</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="ifIndex" name="ifIndex" value="${model.interfaceObj.ifIndex}" placeholder="If Index" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>IP If Index</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="ipAdEntIfIndex" name="ipAdEntIfIndex" value="${model.interfaceObj.ipAdEntIfIndex}" placeholder="IP If Index" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>MAC</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="mac" name="mac" value="${model.interfaceObj.mac}" placeholder="MAC" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>IP próximo salto</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="ip_next_hop" name="ip_next_hop" value="${model.interfaceObj.ip_next_hop}" placeholder="IP Próximo salto" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>MAC próximo salto</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="mac_next_hop" name="mac_next_hop" value="${model.interfaceObj.mac_next_hop}" placeholder="MAC Próximo salto" />
									</div>
								</div>
								<div class="row 100%">
									<div class="12u">
										<ul class="actions">
											<li style="display: ${model.displayEdit}">
												<input type="submit" class="button alt" value="Guardar" />
											</li>
											<li><input type="button" class="button alt" value="Volver" onclick="displayLisInterfaces();" /></li>
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