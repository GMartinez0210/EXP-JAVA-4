<%@ page import="beans.Categoria_Tipo_DTO" %>
<%@ page import="interfaces.Categoria_Tipo_DAO" %>
<%@ page import="dao.DAO_Factory" %>

<style>
	.nav-brand-logo {
		font-size: 1.75rem;
		font-weight: 700;
	}
	.nav-link-text {
		font-size: 1.25rem;
		font-weight: 400;
		color: #000;
	}
	.nav-link-icon {
		font-size: 1rem;
		font-weight: 400;
		color: #000;
	}
</style>

<nav class="navbar navbar-expand-lg bg-white">
  <div class="container">
    <a class="navbar-brand nav-brand-logo" href="#">GEALLU Store</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
      <ul class="navbar-nav mx-auto">
        <li class="nav-item">
          <a class="nav-link nav-link-text active" aria-current="page" href="#">Home</a>
        </li>
        <% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
        <% Categoria_Tipo_DAO categoriaProductos = factory.getCategoriaProducto(); %>
        <% for(Categoria_Tipo_DTO categoriaProducto : categoriaProductos.listar()) {%>
        	<li class="nav-item">
	          <a class="nav-link nav-link-text" href="#<%= categoriaProducto.getNombre() %>">
	          	<%= categoriaProducto.getNombre() %>
	          </a>
	        </li>
        <% } %>
      </ul>
      <ul class="navbar-nav">
      	<li class="nav-item p-3">
      		<i class="bi bi-search nav-link-icon"></i>
      	</li>
      	<li class="nav-item p-3">
      		<i class="bi bi-heart nav-link-icon"></i>
      	</li>
      	<li class="nav-item p-3">
      		<i class="bi bi-cart nav-link-icon"></i>
      	</li>
      </ul>
    </div>
  </div>
</nav>