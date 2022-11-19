<%@ page import="beans.Usuario_DTO" %>
<%@ page import="beans.Categoria_Tipo_DTO" %>
<%@ page import="dao.DAO_Factory" %>
<%@ page import="java.util.ArrayList" %>

<form class="p-3" action="Usuario?tipo=modificar" method="post">
  <h2 class="mb-3">Mantenimiento Usuario</h2>
  <% Usuario_DTO usuario = (Usuario_DTO) request.getAttribute("usuario"); %>
  <div class="mb-3">
    <label for="id" class="form-label">ID</label>
    <input type="number" class="form-control" id="id" name="id" value="<%= usuario.getId() %>" readonly="readonly">
  </div>
  <div class="mb-3">
    <label for="idTipo" class="form-label">Tipo</label>
    <select class="form-control" id="idTipo" name="idTipo">
        <% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
    	<% ArrayList<Categoria_Tipo_DTO> tipos = factory.getTipoUsuario().listar(); %>
    	<% for(Categoria_Tipo_DTO tipo :  tipos) { %>
    		<option value="<%= tipo.getId() %>"> 
    			<%= tipo.getNombre() %> 
    		</option>
    	<% } %>
    </select>
  </div>
  <div class="mb-3">
    <label for="email" class="form-label">Email</label>
    <input type="email" class="form-control" id="email" name="email" value="<%= usuario.getEmail() %>">
  </div>
  <div class="mb-3">
    <label for="clave" class="form-label">Clave</label>
    <input type="password" class="form-control" id="clave" name="clave" value="<%= usuario.getClave() %>">
  </div>
  <div class="mb-3">
    <label for="dni" class="form-label">Dni</label>
    <input type="text" class="form-control" id="dni" name="dni" value="<%= usuario.getDni() %>">
  </div>
  <div class="mb-3">
    <label for="nombre" class="form-label">Nombre</label>
    <input type="text" class="form-control" id="nombre" name="nombre" value="<%= usuario.getNombre() %>">
  </div>
  <div class="mb-3">
    <label for="apellidos" class="form-label">Apellidos</label>
    <input type="text" class="form-control" id="apellidos" name="apellidos" value="<%= usuario.getApellidos() %>">
  </div>
  <button type="submit" class="btn btn-lg btn-primary">Modificar</button>
  <a href="Usuario?tipo=eliminar&&id=<%= usuario.getId() %>" class="btn btn-lg btn-outline-danger">Eliminar</a>
</form>