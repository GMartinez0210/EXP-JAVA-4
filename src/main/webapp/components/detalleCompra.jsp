<%@ page import="dao.DAO_Factory" %>

<% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
<% int idUsuario = Integer.parseInt((String) request.getParameter("idUsu")); %>
<% double[] total_Subtotal_Descuento = factory.getCarrito().total_Subtotal_Descuento(idUsuario); %>

<div class="container">
	<div class="detalle-pedido">
		<div class="titulo-detalle">
			<h1 class="titulo">Detalle de pedido</h1>
		</div>
		<div class="total-det">
			<p>Sub-Total: <span class="precio-s"> $<%= total_Subtotal_Descuento[1]  %> </span> </p> 
			<p>Descuento: <span class="precio-d"> $<%= total_Subtotal_Descuento[2]  %> </span> </p> 
			<p>Total: <span class="precio-t"> $<%= total_Subtotal_Descuento[0]  %> </span> </p>
		</div>
		<div class="boton-det">
			<button type="submit" class="btn btn-primary botones procesar">
				Procesar compra
			</button>
			<button type="reset" class="btn btn-primary botones cancelar" >
				Cancelar compra
			</button>
		</div>
	</div>
</div>