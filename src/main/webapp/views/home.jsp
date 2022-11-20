<%@ page import="beans.Categoria_Tipo_DTO" %>
<%@ page import="interfaces.Categoria_Tipo_DAO" %>
<%@ page import="dao.DAO_Factory" %>


<jsp:include page="./partials/head.jsp" />
<jsp:include page="../components/nav.jsp" />

<main class="container">
	<section>
		<% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
        <% Categoria_Tipo_DAO categoriaProductos = factory.getCategoriaProducto(); %>
        <% for(Categoria_Tipo_DTO categoriaProducto : categoriaProductos.listar()) {%>
			<h2 class="section-title mt-5"> <%= categoriaProducto.getNombre() %> </h2>
			<jsp:include page="../components/slider.jsp">
				<jsp:param value="<%= categoriaProducto.getId() %>" name="idCategoria"/>
			</jsp:include>
        <% } %>
	</section>
</main>

<jsp:include page="../components/footer.jsp" />
<jsp:include page="./partials/foot.jsp" />

