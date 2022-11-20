<%@ page import="beans.Categoria_Tipo_DTO" %>
<%@ page import="dao.DAO_Factory" %>
<%@ page import="java.util.ArrayList" %>

<jsp:include page="./partials/head.jsp" />

<jsp:include page="../components/nav.jsp" />

<main class="container">
	<div class="row">
		<section class="col col-12 col-md-4">
			<% String accion = (String) request.getParameter("accion"); %>
			<% if(!accion.equals("editar")) { %>
				<jsp:include page="../components/formAgregarProducto.jsp" />			
			<% } %>
			<% if(accion.equals("editar")) { %>
				<jsp:include page="../components/formMantenimientoProducto.jsp" />			
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
				  ${mensaje }
				</div>
			<% } %>
			
			<% if(error && mensaje.length() != 0) { %>
				<div class="alert alert-danger" role="alert">
				  ${mensaje }
				</div>
			<% } %>
			
		</section>
		<section class="col col-12 col-md-8">
			<a href="CrudProducto?accion=lis" class="btn btn-md btn-primary mb-5">Agregar Producto</a>
			<jsp:include page="../components/tablaProductos.jsp" />
		</section>
	</div>
</main>


<jsp:include page="../components/footer.jsp" />
<jsp:include page="./partials/foot.jsp" />

