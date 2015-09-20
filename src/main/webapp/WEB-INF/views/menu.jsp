<nav id="nav">
	<ul>
		<li id="menu-index"><a href="index.htm">Inicio</a></li>
		<c:if test="${empty user}">
			<li id="menu-login"><a href="login.htm">Ingresar</a></li>
			<li id="menu-register"><a href="register.htm">Registrarse</a></li>
		</c:if>
		<c:if test="${not empty user}">
			<li id="menu-usuario">
				<a href="#">Usuario</a>
				<ul>
					<li><a href="updateUser.htm">Modificar usuario</a></li>
					<c:if test="${user.role_id == 1}">
						<li><a href="deleteUser.htm">Eliminar Usuarios</a></li>
					</c:if>
					<li><a href="logout.htm">Cerrar Sesión</a></li>
				</ul>
			</li>
			<li id="menu-inventory">
				<a href="#">Inventario</a>
				<ul>
					<li><a href="listTipoEquipos.htm">Tipos de Equipo</a></li>
				</ul>
			</li>
		</c:if>
		<li id="menu-contactenos"><a href="#footer">Contáctenos</a></li>
	</ul>
</nav>