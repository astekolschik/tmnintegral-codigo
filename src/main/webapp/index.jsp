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
		<title>TMN Integral - Inicio</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	
	</head>
	<body onload="setMenuValue('index');">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Logo -->
						<h1><a href="index.htm" id="logo">TMN <em>Integral</em></a></h1>

					<!-- Nav -->
						<%@ include file="/WEB-INF/views/menu.jsp" %>

				</div>
			<c:if test="${empty user}">
				<!-- Banner -->
				<section id="banner">
					<header>
						<h2>TMN Integral: <em>Solución para la gestión de redes</em></h2>
						<a href="#" class="button">Conozca más...</a>
					</header>
				</section>

			<!-- Footer -->
				<div id="footer" name="footer">
					<div class="container">
						<div class="row">
							<section class="6u 12u(narrower) 24u$(mobilep)">
								<h3>Algunos links útiles</h3>
								<ul class="links">
									<li><a href="#">CISCO</a></li>
									<li><a href="#">IEEE</a></li>
								</ul>
							</section>
							<section class="6u 12u(narrower)">
								<h3>Contáctenos</h3>
								<form action="/tmnintegral/contacto.htm">
									<div class="row 50%">
										<div class="6u 12u(mobilep)">
											<input type="text" name="name" id="name" placeholder="Nombre" />
										</div>
										<div class="6u 12u(mobilep)">
											<input type="email" name="email" id="email" placeholder="E-mail" />
										</div>
									</div>
									<div class="row 50%">
										<div class="12u">
											<input type="text" name="motivo" id="motivo" placeholder="Motivo de Contacto" />
										</div>
									</div>
									<div class="row 50%">
										<div class="12u">
											<textarea name="message" id="message" placeholder="Mensaje" rows="5"></textarea>
										</div>
									</div>
									<div class="row 50%">
										<div class="12u">
											<ul class="actions">
												<li><input type="submit" class="button alt" value="Enviar" /></li>
											</ul>
										</div>
									</div>
								</form>
							</section>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty user}">
			<div>
				<section class="12u 24u(narrower)" style="margin-left: 70px">
					<h3>Bienvenido/a de vuelta, <c:out value="${user.name}"></c:out></h3>
					<br/>
					<div class="row">
						Últimos movimientos: <br/>
						<table style="border: 0px">
							<c:forEach items="${model.logs}" var="log">
								<tr>
									<td>${log.log_desc}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</section>
			</div>
			</c:if>
			<%@ include file="/WEB-INF/views/footer.jsp" %>
		</div>
	</body>
</html>