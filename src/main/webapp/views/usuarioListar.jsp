<%@ page import="beans.Categoria_Tipo_DTO" %>
<%@ page import="dao.DAO_Factory" %>
<%@ page import="java.util.ArrayList" %>

<jsp:include page="./partials/head.jsp" />

<jsp:include page="../components/nav.jsp" />

<main class="container">
	<div class="row">
		<section class="col col-12 col-md-4">
			<% String tipo = (String) request.getParameter("tipo"); %>
			<% if(!tipo.equals("buscar")) { %>
				<jsp:include page="../components/formAgregarUsuario.jsp" />			
			<% } %>
			<% if(tipo.equals("buscar")) { %>
				<jsp:include page="../components/formMantenimientoUsuario.jsp" />			
			<% } %>
			
			<% boolean error = false;%>
			<% String mensaje = ""; %>
			<% 
			try {
				error = (boolean) request.getAttribute("error");
				mensaje = (String) request.getAttribute("mensaje");
			}
			catch (Exception e) {
				error = false;
				mensaje = "";
			}
			%>			
			
			<% if(!error && mensaje.length() != 0) { %>
				<div class="alert alert-success" role="alert">
				  <%= mensaje %>
				</div>
			<% } %>
			
			<% if(error && mensaje.length() != 0) { %>
				<div class="alert alert-danger" role="alert">
				  <%= mensaje %>
				</div>
			<% } %>
			
		</section>
		<section class="col col-12 col-md-8">
			<a href="Usuario?tipo=listar" class="btn btn-md btn-primary mb-5">Agregar Usuario</a>
			<jsp:include page="../components/tablaUsuario.jsp" />
		</section>
	</div>
</main>

<jsp:include page="../components/footer.jsp" />
<jsp:include page="./partials/foot.jsp" />

<script src="../js/usuarioListar.js" type="module"></script>