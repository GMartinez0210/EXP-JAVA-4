<%@ page import="beans.Usuario_DTO" %>
<%@ page import="dao.DAO_Factory" %>
<%@ page import="java.util.ArrayList" %>

<table class="table">
  <thead>
    <tr>
  		<% String[] tableHeaders = {"ID", "Tipo", "Email", "DNI", "Nombre", "Apellidos", "Acciones"}; %>
    	<% for(String tableHeader : tableHeaders) { %>
      		<th scope="col"> 
      			<%= tableHeader %> 
      		</th>			    		
    	<% } %>
    </tr>
  </thead>
  <tbody>
    <% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
    <% ArrayList<Usuario_DTO> usuarios = factory.getUsuario().listar();%>
    <% for(Usuario_DTO usuario : usuarios) { %>
		<tr>
    		<td scope="row"> <%= usuario.getId() %> </td>
    		<td> <%= usuario.getTipo() %> </td>
    		<td> <%= usuario.getEmail() %> </td>
    		<td> <%= usuario.getDni() %> </td>
    		<td> <%= usuario.getNombre() %> </td>
    		<td> <%= usuario.getApellidos() %> </td>
    		<td class="d-flex justify-content-center align-items-center gap-3">
    			<a href="Usuario?tipo=buscar&&id=<%= usuario.getId() %>">
    				<i class="bi bi-pencil-square table-icon"></i>
    			</a>
    		</td>
		</tr>
    <% } %>
  </tbody>
</table>