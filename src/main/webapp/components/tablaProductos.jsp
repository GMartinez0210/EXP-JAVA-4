<%@page import="beans.ListProd"%>
<%@ page import="beans.Usuario_DTO"%>
<%@ page import="dao.DAO_Factory"%>
<%@ page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
	<thead>
		<tr>
			<%
			String[] tableHeaders = { "Código", "Producto", "Precio", "Stock", "Categoria", "Imagen", "Acciones" };
			%>
			<%
			for (String tableHeader : tableHeaders) {
			%>
			<th scope="col"><%=tableHeader%></th>
			<%
			}
			%>
		</tr>
	</thead>
	<tbody>
		<%
		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		ArrayList<ListProd> lstProducto = fabrica.getProductoInterface().listado();
		request.setAttribute("lstProducto", lstProducto);
		%>
		<c:forEach var="p" items="${lstProducto }">
			<tr>
				<td scope="row">${p.getId_prod() }</td>
				<td scope="row">${p.getNombre() }</td>
				<td scope="row">${p.getPrecio() }</td>
				<td scope="row">${p.getStock() }</td>
				<td scope="row">${p.getCategoria() }</td>
				<td scope="row"><img src="listarImg?id=${p.getId_prod() }"
					width="100" height="100"></td>

				<td class="d-flex justify-content-center align-items-center gap-3">
					<a href="CrudProducto?accion=editar&&id=${p.getId_prod() }"> <i
						class="bi bi-pencil-square table-icon"></i>
				</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>