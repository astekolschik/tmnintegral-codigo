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
	<body onload="setMenuValue('inventory');paginateTable('interfaceTable')">
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
							<table id="interfaceTable" class="default">
								<thead>
									<tr>
										<td>Id</td>
										<td>Status</td>
										<td>Alias</td>
										<td>Nombre</td>
										<td>Shelf</td>
										<td>Slot</td>
										<td>Puerto</td>
										<td>Sub Puerto</td>
										<td>Tipo</td>
										<td>If Index</td>
										<td>IP If index</td>
										<td>MAC</td>
										<td>IP próximo salto</td>
										<td>MAC próximo salto</td>
										<td>Ver</td>
										<td>Modificar</td>
										<td>Eliminar</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${model.interfaceList}" var="te">
										<tr>
											<td>${te.id}</td>
											<td>${te.adminStatus}</td>
											<td>${te.alias}</td>
											<td>${te.name}</td>
											<td>${te.shelf}</td>
											<td>${te.slot}</td>
											<td>${te.port}</td>
											<td>${te.subPort}</td>
											<td>${te.type}</td>
											<td>${te.ifIndex}</td>
											<td>${te.ipAdEntIfIndex}</td>
											<td>${te.mac}</td>
											<td>${te.ip_next_hop}</td>
											<td>${te.mac_next_hop}</td>
											<td><input type="image" src="images/view.png" onclick="displayInterfaz(${te.id}, false)" style="width: 20px;height: 20px;"></td>
											<td><input type="image" src="images/update.png" onclick="displayInterfaz(${te.id}, true)" style="width: 20px;height: 20px;"></td>
											<td><input type="image" src="images/delete.png" onclick="deleteInterfaz(${te.id})" style="width: 20px;height: 20px;"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="row 100%">
								<ul class="actions">
									<li><input type="button" class="button alt" value="Nueva" onclick="nuevaInterfaz();" /></li>
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