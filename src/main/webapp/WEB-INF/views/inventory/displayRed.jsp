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
							<h3>Red</h3>
							<form action="/TMNIntegralWeb/updateRed.htm" method="post">
								<div class="row 100%">
									<c:if test="${model.redObj.id_network != 0}">
										<div class="4u 8u(mobilep)">
											<label>Id de Red</label>
										</div>
										<div class="8u 16u(mobilep)">
											<input type="text" id="idred" name="idred" value="${model.redObj.id_network}" placeholder="Id Red" />
										</div>
									</c:if>
									<div class="4u 8u(mobilep)">
										<label>Nombre</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="network" name="network" value="${model.redObj.network}" placeholder="Nombre" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Habilitada</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="enabled" name="enabled" value="${model.redObj.enabled}" placeholder="Habilitada" />
									</div>
									<div class="4u 8u(mobilep)">
										<label>Descripción</label>
									</div>
									<div class="8u 16u(mobilep)">
										<input type="text" id="description" name="description" value="${model.redObj.description}" placeholder="Descripcion" />
									</div>
								</div>
								<div class="row 100%">
									<div class="12u">
										<ul class="actions">
											<li style="display: ${model.displayEdit}">
												<input type="submit" class="button alt" value="Guardar" />
											</li>
											<li><input type="button" class="button alt" value="Volver" onclick="displayLisRed();" /></li>
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