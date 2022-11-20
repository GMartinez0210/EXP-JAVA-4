<%@page import="beans.CarritoDTO"%>
<%@page import="java.util.ArrayList"%>


<section class="cart-items">
	<%
		ArrayList<CarritoDTO> lista = (ArrayList<CarritoDTO>) request.getAttribute("data");
	if (lista != null) {
		for (CarritoDTO xCart : lista) {
			double descuento = xCart.getPrecioProd() + 100; %>
			
			<div class='cart-item-container p-3 my-4'>
				<div class='cart-item-imgcontainer'>
					<img class='cart-item-img' src='listarImg?id=<%= xCart.getIdProd() %>' alt=''>
				</div>
				<div class='cart-item-detail'>
					<div>
						<h3 class='cart-item-detail-brand'> <%= xCart.getMarcaProd() %> </h3>
						<p class='cart-item-detail-description'> <%= xCart.getNomProd() %> </p>
					</div>
					<div class='cart-item-price'>
						<p>Cantidad:</p>
						<div class='cart-item-detail-price'>
							<a href="#" class="btn btn-sm btn-secondary">
								<i class="bi bi-dash"></i>
							</a>
							<p><%= xCart.getCantProd() %></p>
							<a href="#" class="btn btn-sm btn-secondary">
								<i class="bi bi-plus"></i>
							</a>
						</div>
					</div>
					<div class='cart-item-price'>
						<p>Precio:</p>
						<div class='cart-item-detail-price'>
							<p class='discount'>$<%= descuento %><p>
							<p>$<%= xCart.getPrecioProd() %></p>
						</div>
					</div>
				</div>
				<a href="ServletCarrito?tipo=EliminarItem&&idUsu=<%= session.getAttribute("idUsuario") %>&&idProd=<%= xCart.getIdProd() %>" 
					class="btn btn-md btn-danger btn-borrar">
					<i class="bi bi-trash"></i>
				</a>
			</div>	
	<%	}
	}
	else { %>
		<div class="alert alert-danger" role="alert">
		  No tienes productos en tu carrito :(
		</div>
	<% } %>
</section>
