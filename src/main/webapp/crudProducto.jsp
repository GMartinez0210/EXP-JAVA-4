
<%@ include file="views/partials/head.jsp"%>
<jsp:include page="components/nav.jsp" />

<div class="d-flex">
	<div class="card col-sm-4">
		<div class="card-body">
			<form action="CrudProducto" method="POST" enctype="multipart/form-data">

				<div class="form-group">
					<label>Codigo de producto :</label> <input type="text"
						name="txtCodigo" class="form-control" value="${p.id_prod }">
				</div>

				<div class="form-group">
					<label>Nombre producto :</label> <input type="text"
						name="txtNombre" class="form-control" value="${p.nombre }">
				</div>


				<div class="form-group">
					<label>Precio :</label> <input type="text" name="txtPrecio"
						class="form-control" value="${p.precio }">
				</div>

				<div class="form-group">
					<label>Stock :</label> <input type="text" name="txtStock"
						class="form-control" value="${p.stock }">
				</div>

				<div class="form-row">

					<div class="form-group col-md-6">
						<label for="inputState">Categoria :</label> <select
							id="inputState" class="form-select" name="cboCategoria">
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
									<option value="${c.getId() }" >${c.getNombre() }</option>
								</c:if>
								
							</c:forEach>


						</select>
					</div>
					<div class="mb-3">
						<label for="formFileSm" class="form-label">Imagen</label> <input
							class="form-control form-control-sm" id="formFileSm" type="file"
							name="txtImg">
					</div>

				</div>

				<button type="submit" class="btn btn-primary " name="btnAccion"
					value="reg">Registrar</button>
				<button type="submit" class="btn btn-primary" name="btnAccion"
					value="act">Actualizar</button>
				<button type="submit" class="btn btn-danger" name="btnAccion"
					value="eli">Eliminar</button>
				<button type="submit" class="btn btn-primary" name="btnAccion"
					value="lis">Listado</button>
			</form>
			<br> ${mensaje }
		</div>
	</div>


	<div class="col-sm-8">
		<table class="table" id="myTable">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Codigo</th>
					<th scope="col">Producto</th>
					<th scope="col">Precio</th>
					<th scope="col">Stock</th>
					<th scope="col">Categoría</th>
					<th scope="col">Imagen</th>
					<th scope="col"></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="p" items="${lstProducto }">
					<tr>

						<td scope="row">${p.getId_prod() }</td>
						<td scope="row">${p.getNombre() }</td>
						<td scope="row">${p.getPrecio() }</td>
						<td scope="row">${p.getStock() }</td>
						<td scope="row">${p.getCategoria() }</td>
						<td scope="row"><img src="listarImg?id=${p.getId_prod() }" width="100" height="100"></td>
						
						<td class=minicontenedor id="acciones">

							<form action="CrudProducto" method="post" enctype="multipart/form-data">
								<input name="codigo" value="${p.id_prod }" type="hidden">
								<button name="btnAccion" value="editar" type="submit"
									class="btn btn-link">
										<i class="bi bi-pencil-square" style="font-size: 30px;"></i>
								</button>
							</form>

						</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>

	</div>
</div>

<jsp:include page="components/footer.jsp" />
<%@ include file="views/partials/foot.jsp"%>