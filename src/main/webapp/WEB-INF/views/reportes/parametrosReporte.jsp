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
		<title>TMN Integral - Reportes</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	
	</head>
	<body onload="setMenuValue('reportes')">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Logo -->
						<h1><a href="index.htm" id="logo">TMN <em>Integral</em></a></h1>

					<!-- Nav -->
						<%@ include file="/WEB-INF/views/menu.jsp" %>

				</div>
				
				<div class="container">
						<h3>Parámetros del reporte</h3>
						<section class="8u 16u(narrower)">
							<form action="/TMNIntegralWeb/generarReporte.htm" method="post" onsubmit="return validarFormReporte();">
								<div class="row 100%">
									<div class="row 100%" style="margin-left: 10px">
										<div class="row 100%">
											<div class="4u 8u(mobilep)">
												<label>Tipo de Reporte</label>
											</div>
											<div class="8u 16u(mobilep)">
												<select id="tipo-reporte" name="tipo-reporte">
													<option value="-1">Ninguno</option>
													<option value="1">Memoria disponible</option>
													<option value="2">Memoria utilizada</option>
													<option value="3">Tráfico entrante</option>
													<option value="4">Tráfico saliente</option>
													<option value="5">Utilización CPU</option>
												</select>
											</div>
										</div>
										<div class="row 100%">
											<div class="4u 8u(mobilep)">
												<label>Equipos</label>
											</div>
											<div class="8u 16u(mobilep)">
												<input type="hidden" name="lista-equipos-value">
												<select multiple id="nombre-equipo" name="nombre-equipo">
													<c:forEach items="${model.devices}" var="equipo">
														<option value="${equipo.id_device}">${equipo.ip}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="row 100%">
											<div class="4u 8u(mobilep)">
												<label>Fecha desde</label>
											</div>
											<div class="8u 16u(mobilep)">
												<input type="date" name="fecha-desde" id="fecha-desde"/>
											</div>
										</div>
										<div class="row 100%">
											<div class="4u 8u(mobilep)">
												<label>Fecha hasta</label>
											</div>
											<div class="8u 16u(mobilep)">
												<input type="date" name="fecha-hasta" id="fecha-hasta"/>
											</div>
										</div>
										
										<div class="row 100%">
											<div class="12u">
												<ul class="actions">
													<li>
														<input type="submit" class="button alt" value="Generar"/>
													</li>
												</ul>
											</div>
										</div>
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