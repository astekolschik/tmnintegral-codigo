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
		<title>TMN Integral - Administración de Usuarios</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->

	</head>
	<body onload="setMenuValue('usuario');paginateTable('usersTable')">
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
							<h3>Administración de usuarios</h3>
							<table id="usersTable" class="default">
								<thead>
									<tr>
										<td>
											<input type="checkbox" name="userCheck" value="all" onclick="selectAllCheckbox(this);"/>
										</td>
										<td>Nombre de usuario</td>
										<td>Nombre</td>
										<td>Apellido</td>
										<td>Email</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${model.userList}" var="user">
										<tr>
											<td>
												<input type="checkbox" name="userCheck" value="${user.user_name}"/>
											</td>
											<td>${user.user_name}</td>
											<td>${user.name}</td>
											<td>${user.lastName}</td>
											<td>${user.email}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<input type="button" onclick="eliminarUsuarios();" value="Eliminar"/>
						</section>
					</div>
				</div>
			

			<!-- Footer -->
			<%@ include file="/WEB-INF/views/footer.jsp" %>
		</div>
	</body>
</html>