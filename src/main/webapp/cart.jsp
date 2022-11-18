<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="beans.CarritoDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/cart.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

</head>

<style>
	.cart-items {
		font-family: 'Poppins', sans-serif;;
	}
	
	.cart-item-container {
		display: flex;
		gap: 1.5rem;
		justify-content: flex-start;
		padding: 10px;
		border: 2px solid darkgray;
		border-radius: 10px;
		margin: 20px 0px;
		overflow: hidden;
		width: clamp(330px, 100%, 500px);
		height: clamp(1px, 100%, 3px);
	}
	
	.cart-item-detail {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		width: 55%;
	}
	
	.cart-item-imgcontainer {
		width: 40%;
	}
	
	.cart-item-img {
		transition: transform .5s;
		width: 100%;
		height: auto;
		border-radius: 10px;
		width: clamp(150px, 100%, 400px);
	}
	
	.cart-item-img:hover {
		transform: scale(1.1);
	}
	
	.cart-item-price {
		display: flex;
		flex-direction: column;
		justify-content: flex-end;
	}
	
	.cart-item-detail-price {
		display: flex;
		justify-content: flex-start;
		gap: 3rem;
	}
	
	.discount {
		text-decoration: line-through;
		color: red;
	}
	
	.cart-item-detail-brand {
		font-weight: 400
	}
	
	.cart-item-detail-description {
		font-weight: 700;
	}
</style>
<body>
	<!--/#cart_items-->
	<section class="cart-items">
		<%
			ArrayList<CarritoDTO> lista = (ArrayList<CarritoDTO>) request.getAttribute("data");
		if (lista == null) {

		} else {
			for (CarritoDTO xCart : lista) {
				out.println("<div class='cart-item-container'>");
				out.println("<div class='cart-item-imgcontainer'>");
				out.println("<img class='cart-item-img' src='ServletCarritoIMG?id="+ xCart.getId() +"' alt=''>");
				out.println("</div>");
				out.println("<div class='cart-item-detail'>");
				out.println("<div>");
				out.println("<h3 class='cart-item-detail-brand'>" + xCart.getMarcaProd() + "</h3>");
				out.println("<p class='cart-item-detail-description'>" + xCart.getNomProd() + "</p>");
				out.println("</div>");
				out.println("<div class='cart-item-price'>");
				out.println("<p>Precio:</p>");
				out.println("<div class='cart-item-detail-price'>");
				out.println("<p class='discount'>$0.0<p>");
				out.println("<p> $" + xCart.getPrecioProd() + "</p>");
				out.println("</div>");
				out.println("</div>");
				out.println("</div>");
				out.println("</div>");
			}
		}
		%>
	</section>
	<!--/#cart_items-->
</body>
</html>