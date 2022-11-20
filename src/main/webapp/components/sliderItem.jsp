<%@ page import="beans.Usuario_DTO" %>

<li id="<%= request.getParameter("idProducto") %>" class="sliderItem-li mt-3 mb-5">
	<figure class="sliderItem">
		<div>
			<img class="sliderItem-img" src="../listarImg?id=<%= request.getParameter("idProducto") %>" alt="cr7" />
		</div>
		<figcaption class="mt-4">
			<p class="sliderItem-category"> <%= request.getParameter("sliderItem-category") %> </p>
			<h1 class="sliderItem-title"> <%= request.getParameter("sliderItem-title") %> </h1>
			<div class="d-flex gap-4">
				<p class="sliderItem-priceCrossed"> <%= request.getParameter("sliderItem-priceCrossed") %> </p>
				<p class="sliderItem-price"> <%= request.getParameter("sliderItem-price") %> </p>
			</div>
		</figcaption>
	</figure>
	<div>
		<a href="${pageContext.request.contextPath}/ServletCarrito?tipo=AgregarACarritoXCod&&cantidad=1&&idProd=<%= request.getParameter("idProducto") %>&&idUsu=<%= session.getAttribute("idUsuario") %>" 
			class="mx-3 d-block btn btn-md btn-info text-white">
			<i class="bi bi-cart"></i>
			<span>Añadir</span>
		</a>
	</div>
</li>