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
	<body onload="setMenuValue('inventory');">
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
							<h3>Tipo de equipo</h3>
							<form action="/TMNIntegralWeb/updateTipoEquipo.htm" method="post">
								<div class="row 100%">
									<div class="4u 8u(mobilep)">
										<label>Id de equipo</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="idequipo" value="${model.tipoEquipoObj.id}" placeholder="Id equipo" disabled="${model.edit}"/>
									</div>
									<div class="4u 8u(mobilep)">
										<label>Comando Default</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="defaultComm" value="${model.tipoEquipoObj.default_comm_read}" placeholder="Comando Default" disabled="${model.edit}"/>
									</div>
									<div class="4u 8u(mobilep)">
										<label>SNMP Default</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="defaultSNMP" value="${model.tipoEquipoObj.default_snmp_version}" placeholder="SNMP Default" disabled="${model.edit}"/>
									</div>
									<div class="4u 8u(mobilep)">
										<label>Driver</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="driver" value="${model.tipoEquipoObj.driver}" placeholder="Driver" disabled="${model.edit}"/>
									</div>
									<div class="4u 8u(mobilep)">
										<label>Tecnologia</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="technology" value="${model.tipoEquipoObj.technology}" placeholder="Tecnologia" disabled="${model.edit}"/>
									</div>
									<div class="4u 8u(mobilep)">
										<label>Marca</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="vendor" value="${model.tipoEquipoObj.vendor}" placeholder="Vendor" disabled="${model.edit}"/>
									</div>
								</div>
								<div class="row 100%">
									<div class="12u">
										<ul class="actions" style="display: ${model.displayEdit}">
											<li><input type="submit" class="button alt" value="Modificar" /></li>
										</ul>
										<ul class="actions">
											<li><input type="button" class="button alt" value="Volver" /></li>
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