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
		<title>TMN Integral - Alarmas</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	
	</head>
	<body onload="setMenuValue('reportes');paginateTable('alarmas-table')">
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
							<h3>Listado de alarmas enviadas</h3>
							<table id="alarmas-table" class="default">
								<thead>
									<tr>
										<td>Elemento</td>
										<td>Tipo de Alarma</td>
										<td>Última actualización</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${model.alarmas}" var="a">
										<tr>
											<td>${a.elementName}</td>
											<td>${a.valor}</td>
											<td>${a.lastUpdateDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</section>
					</div>
				</div>
			

			<!-- Footer -->
			<%@ include file="/WEB-INF/views/footer.jsp" %>
		</div>
	</body>
</html>