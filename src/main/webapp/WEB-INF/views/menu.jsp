<nav id="nav">
	<ul>
		<li id="menu-index"><a href="index.htm">Inicio</a></li>
		<c:if test="${empty user}">
			<li id="menu-login"><a href="login.htm">Ingresar</a></li>
			<li id="menu-register"><a href="register.htm">Registrarse</a></li>
			<li id="menu-contactenos"><a href="#footer">Contáctenos</a></li>
		</c:if>
		<c:if test="${not empty user}">
			<li id="menu-usuario">
				<a href="#">Usuario</a>
				<ul>
					<li><a href="updateUser.htm">Modificar usuario</a></li>
					<c:if test="${user.role_id == 1}">
						<li><a href="deleteUser.htm">Eliminar Usuarios</a></li>
					</c:if>
				</ul>
			</li>
			<li id="menu-inventory">
				<a href="#">Inventario</a>
				<ul>
					<li><a href="listTipoEquipos.htm">Tipos de Equipo</a></li>
					<!-- <li><a href="listDevice.htm">Equipos</a></li> -->
					<!-- <li><a href="altaDevice.htm">Alta de Equipos</a></li> -->
					<!-- <li><a href="listDevice.htm">Lista de Equipos</a></li> -->
					<!-- <li><a href="listInterface.htm">Lista de Interfaces</a></li> -->
					<!-- <li><a href="listRed.htm">Redes</a></li> -->
					<li><a href="altaRed.htm">Alta de Red</a></li>
					<li><a href="displayNetwork.htm">Topología de Red</a></li>
				</ul>
			</li>
			<li id="menu-configuracion">
				<a href="#">Configuración</a>
				<ul>
					<li><a href="listComandos.htm">Comandos</a></li>
					<li><a href="restoreConfiguration.htm">Restaurar</a></li>
				</ul>
			</li>
			<li id="menu-reportes">
				<a href="parametrosReporte.htm">Reportes</a>
			</li>
			<li><a href="logout.htm">Cerrar Sesión</a></li>
		</c:if>
	</ul>
</nav>