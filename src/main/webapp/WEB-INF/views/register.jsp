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
	<body>
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Logo -->
						<h1><a href="index.html" id="logo">TMN <em>Integral</em></a></h1>

					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li><a href="index.html">Inicio</a></li>
								<li><a href="login.htm">Ingresar</a></li>
								<li class="current"><a href="register.htm">Registrarse</a></li>
								<li><a href="#footer">Contáctenos</a></li>
							</ul>
						</nav>

				</div>
				
				<div class="container">
						<section class="6u 12u(narrower)">
							<h3>Información del Usuario</h3>
							<form action="/tmnintegral/register.htm">
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
				<div id="footer" name="footer">
					<div class="container">
					<!-- Icons -->
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
							<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
							<li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
						</ul>

					<!-- Copyright -->
						<div class="copyright">
							<ul class="menu">
								<li>&copy; Untitled. All rights reserved</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>

				</div>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>