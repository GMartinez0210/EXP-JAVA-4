<%@page import="beans.Producto"%>
<%@ page import="beans.Categoria_Tipo_DTO"%>
<%@ page import="dao.DAO_Factory"%>
<%@ page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form class="p-3" action="CrudProducto?accion=act" method="post" enctype="multipart/form-data">
	<h2 class="mb-3">Mantenimiento Producto</h2>
	<% Producto p = (Producto) request.getAttribute("p"); %>
	<div class="mb-3">
		<label for="id" class="form-label">Codigo Producto</label> <input
			type="text" class="form-control" id="cod" name="txtCodigo"
			value="<%= p.getId_prod() %>" readonly="readonly">
	</div>

	<div class="mb-3">
		<label for="producto" class="form-label">Producto</label> <input
			type="text" class="form-control" id="producto" name="txtNombre"
			value="<%= p.getNombre() %>">
	</div>
	<div class="mb-3">
		<label for="precio" class="form-label">Precio</label> <input
			type="text" class="form-control" id="precio" name="txtPrecio"
			value="<%= p.getPrecio() %>">
	</div>
	<div class="mb-3">
		<label for="stock" class="form-label">Stock</label> <input type="text"
			class="form-control" id="stock" name="txtStock" value="<%= p.getStock() %>">
	</div>
	<div class="form-group col-md-6">
		<label for="inputState">Categoria :</label> <select id="inputState"
			class="form-select" name="cboCategoria">
			<option value="0" selected>Seleccione categoria...</option>
			<% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
    		<% ArrayList<Categoria_Tipo_DTO> tipos = factory.getCategoriaProducto().listar(); %>
    		<% for(Categoria_Tipo_DTO tipo :  tipos) { %>
    		<c:if test="<%= tipo.getId() == p.getId_categ() %>">
    			<option value="<%= tipo.getId() %>" selected="selected"> 
    			<%= tipo.getNombre() %> 
    		</option>
    		</c:if>
    		
    		<c:if test="<%= tipo.getId() != p.getId_categ() %>">
    			<option value="<%= tipo.getId() %>" > 
    			<%= tipo.getNombre() %> 
    		</option>
    		</c:if>
    	<% } %>
		</select>
	</div>
	<div class="mb-3">
		<label for="formFileSm" class="form-label">Imagen</label> <input
			class="form-control form-control-sm" id="formFileSm" type="file"
			name="txtImg">
	</div>
	<button type="submit" class="btn btn-lg btn-primary">Modificar</button>
	<a href="CrudProducto?accion=eli&&id=<%= p.getId_prod() %>"
		class="btn btn-lg btn-outline-danger">Eliminar</a>

</form>

