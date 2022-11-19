<%@ page import="beans.Categoria_Tipo_DTO" %>
<%@ page import="dao.DAO_Factory" %>
<%@ page import="java.util.ArrayList" %>

<form class="p-3" action="Usuario?tipo=agregar" method="post">
  <h2 class="mb-3">Mantenimiento Usuario</h2>
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
    <input type="email" class="form-control" id="email" name="email">
  </div>
  <div class="mb-3">
    <label for="clave" class="form-label">Clave</label>
    <input type="password" class="form-control" id="clave" name="clave">
  </div>
  <div class="mb-3">
    <label for="dni" class="form-label">Dni</label>
    <input type="text" class="form-control" id="dni" name="dni">
  </div>
  <div class="mb-3">
    <label for="nombre" class="form-label">Nombre</label>
    <input type="text" class="form-control" id="nombre" name="nombre">
  </div>
  <div class="mb-3">
    <label for="apellidos" class="form-label">Apellidos</label>
    <input type="text" class="form-control" id="apellidos" name="apellidos">
  </div>
  <button type="submit" class="btn btn-lg btn-primary">Aceptar</button>
</form>