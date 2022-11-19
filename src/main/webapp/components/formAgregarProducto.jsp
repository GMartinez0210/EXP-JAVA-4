<%@ page import="beans.Categoria_Tipo_DTO"%>
<%@ page import="dao.DAO_Factory"%>
<%@ page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="p-3" action="CrudProducto?accion=reg" method="post" enctype="multipart/form-data">
	<h2 class="mb-3">Mantenimiento Producto</h2>

	<div class="mb-3">
		<label for="Producto" class="form-label">Producto</label> <input
			type="text" class="form-control" id="producto" name="txtNombre">
	</div>
	<div class="mb-3">
		<label for="precio" class="form-label">Precio</label> <input
			type="text" class="form-control" id="precio" name="txtPrecio">
	</div>
	<div class="mb-3">
		<label for="Stock" class="form-label">Stock</label> <input type="text"
			class="form-control" id="stock" name="txtStock">
	</div>

	<div class="form-group col-md-6">
		<label for="inputState">Categoria :</label> <select id="inputState"
			class="form-select" name="cboCategoria">
			<option value="0" selected>Seleccione categoria...</option>
			<%
			DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
			ArrayList<Categoria_Tipo_DTO> lstCategoria = fabrica.getCategoriaProducto().listar();
			request.setAttribute("lstCategoria", lstCategoria);
			%>
			<c:forEach items="${lstCategoria }" var="c">
				<c:if test="${c.getId() == p.getId_categ() }">
					<option value="${c.getId() }" selected="selected">${c.getNombre() }</option>
				</c:if>
				<c:if test="${c.getId() != p.getId_categ() }">
					<option value="${c.getId() }">${c.getNombre() }</option>
				</c:if>
			</c:forEach>
		</select>
	</div>
	<div class="mb-3">
		<label for="formFileSm" class="form-label">Imagen</label> <input
			class="form-control form-control-sm" id="formFileSm" type="file"
			name="txtImg">
	</div>
	<button type="submit" class="btn btn-lg btn-primary" name="btnAccion"
		value="reg">Aceptar</button>
</form>