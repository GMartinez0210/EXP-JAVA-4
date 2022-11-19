<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletCarrito?tipo=listarxCod" method="post">
		<button class="btn btn-info">Mostrar Lista</button>
	</form>
	<form action="ServletCarrito?tipo=AgregarACarritoXCod"method="post">
		<button class="btn btn-info">Agregar a Carrito</button>
	</form>
</body>
</html>