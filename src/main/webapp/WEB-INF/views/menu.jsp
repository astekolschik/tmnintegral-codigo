<nav id="nav">
	<ul>
		<li id="menu-index"><a href="index.htm">Inicio</a></li>
		<c:if test="${empty user}">
			<li id="menu-login"><a href="login.htm">Ingresar</a></li>
			<li id="menu-register"><a href="register.htm">Registrarse</a></li>
		</c:if>
		<c:if test="${not empty user}">
			<li id="menu-update"><a href="updateUser.htm">Modificar usuario</a></li>
			<li id="menu-update"><a href="logout.htm">Cerrar Sesión</a></li>
		</c:if>
		<li id="menu-contactenos"><a href="#footer">Contáctenos</a></li>
	</ul>
</nav>