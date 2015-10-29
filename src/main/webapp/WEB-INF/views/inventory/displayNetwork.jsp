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
						<section class="31u 24u(narrower)">
							<h3>Topología de la red</h3>
							<div class="4u 8u(mobilep)">
								<label>Seleccione la red que desea visualizar:</label>
							</div>
							<br/><br/>
							<div class="row 100%">
								<div class="row" style="width: 30%; margin-left: 10px">
									<select multiple id="net-select" style="width: 200px" onchange="mostrarTopologiaConImagenes();">
										<option value="-1">Ninguna</option>
										<option value="1">Red 1</option>
										<option value="2">Red 2</option>
										<option value="3">Red 3</option>
										<option value="4">Red 4</option>
									</select>
								</div>
								<div class="row" style="width: 70%" id="net-container"></div>
							</div>
						</section>
					</div>
				</div>

			<!-- Footer -->
			<%@ include file="/WEB-INF/views/footer.jsp" %>
		</div>
	</body>
</html>