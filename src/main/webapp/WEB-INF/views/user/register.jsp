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
		<title>TMN Integral - Registro</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	
	</head>
	<body onload="setMenuValue('register');">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Logo -->
						<h1><a href="index.htm" id="logo">TMN <em>Integral</em></a></h1>

					<!-- Nav -->
						<%@ include file="/WEB-INF/views/menu.jsp" %>

				</div>
				
				<div class="container">
						<section class="6u 12u(narrower)">
							<h3>Información del Usuario</h3>
							<form action="/TMNIntegralWeb/register.htm" onsubmit="return createUserValidate()"
								method="post">
								<div class="row 100%">
									<div class="6u 12u(mobilep)">
										<input type="text" name="nombre" id="nombre" placeholder="Nombre" />
									</div>
									<div class="6u 12u(mobilep)">
										<input type="text" name="apellido" id="apellido" placeholder="Apellido" />
									</div>
									<div class="6u 12u(mobilep)">
										<input type="email" name="email" id="email" placeholder="E-mail" />
									</div>
									<div class="6u 12u(mobilep)">
										<input type="text" name="usuario" id="usuario" placeholder="Nombre de Usuario" />
									</div>
									<div class="6u 12u(mobilep)">
										<input type="password" name="password" id="password" placeholder="Contraseña" />
									</div>
									<div class="6u 12u(mobilep)">
										<input type="password" name="password2" id="password2" placeholder="Verifique su Contraseña" />
									</div>
								</div>
								<div class="row 50%">
									<div class="12u">
										<ul class="actions">
											<li><input type="submit" class="button alt" value="Registrarse" /></li>
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