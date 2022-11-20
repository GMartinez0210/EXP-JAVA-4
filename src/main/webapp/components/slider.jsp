<%@ page import="beans.ListProd" %>
<%@ page import="dao.DAO_Factory" %>
<%@ page import="java.util.ArrayList" %>

<style>
.slider-container {
	overflow-x: scroll;
	scroll-snap-type: x mandatory;
}

.slider-subcontainer {
	list-style: none;
	display: flex;
	gap: 1.5rem;	
	
	margin: 0;
	padding: 0 1.5rem;
}

.sliderItem-li {
	min-width: 220px;
	width: 50%;
	max-width: 500px;
}

.sliderItem-container {
	text-decoration: none;
}

.sliderItem {
	width: 100%
}

.sliderItem-img {
	width: 100%;
	aspect-ratio: 1;
	object-fit: contain;
}

.sliderItem-category {
	font-weight: 300;
	font-size: 1rem;
	
	color: #22262A;
}

.sliderItem-title {
	font-weight: 600;
	font-size: 1rem;
	
	color: #22262A;
}

.sliderItem-priceCrossed {
	font-weight: 400;
	font-size: 1rem;
	
	text-decoration: line-through;
	
	color: #22262A;
}

.sliderItem-price {
	font-weight: 400;
	font-size: 1rem;
	
	color: #CF2929;
}
</style>

<div class="slider-container mb-5">
	<ul class="slider-subcontainer">
		<% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
		<% int idCategoria = Integer.parseInt(request.getParameter("idCategoria")); %>
		<% ArrayList<ListProd> productos = factory.getProductoInterface().listarCategoria(idCategoria); %>
		<% for(ListProd producto : productos) { %>
			<jsp:include page="./sliderItem.jsp">
				<jsp:param value="<%= producto.getId_prod() %>" name="idProducto"/>
				<jsp:param value="<%= producto.getCategoria() %>" name="sliderItem-category"/>
				<jsp:param value="<%= producto.getNombre() %>" name="sliderItem-title"/>
				<jsp:param value="<%= producto.getPrecio() + 100 %>" name="sliderItem-priceCrossed"/>
				<jsp:param value="<%= producto.getPrecio() %>" name="sliderItem-price"/>
			</jsp:include>
		<% } %>
	</ul>
</div>