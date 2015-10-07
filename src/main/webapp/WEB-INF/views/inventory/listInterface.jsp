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
						<section class="12u 24u(narrower)">
							<h3>Administración de Interfaces</h3>
							<table class="default">
								<thead>
									<tr>
										<td>#</td>
										<td>Id</td>
										<td>Administrator Status</td>
										<td>Alias</td>
										<td>Name</td>
										<td>Shelf</td>
										<td>Slot</td>
										<td>Port</td>
										<td>Sub Port</td>
										<td>Type</td>
										<td>Device</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${model.deviceList}" var="de">
										<tr>
											<td>
												<input type="checkbox" name="userCheck" value="${de.id}"/>
											</td>
											<td>${de.id}</td>
											<td>${de.adminStatus}</td>
											<td>${de.alias}</td>
											<td>${de.name}</td>
											<td>${de.shelf}</td>
											<td>${de.slot}</td>
											<td>${de.port}</td>
											<td>${de.subPort}</td>
											<td>${de.type}</td>
											<td>${de.device.ip}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</section>
					</div>
				</div>
			

			<!-- Footer -->
			<%@ include file="/WEB-INF/views/footer.jsp" %>
	</body>
</html>