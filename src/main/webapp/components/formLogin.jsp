<form class="form-login p-5" action="${pageContext.request.contextPath}/Usuario?tipo=login" method="post">
	<h1>Bienvenido</h1>
	<div class="mb-3">
	    <label for="email" class="form-label">Email</label>
	    <input type="email" class="form-control" id="email" name=email>
	</div>
	<div class="mb-3">
	    <label for="clave" class="form-label">Clave</label>
	    <input type="password" class="form-control" id="clave" name="clave">
	</div>
	<div class="d-flex justify-content-center gap-4 mt-5">
		<button type="submit" class="btn btn-primary">Ingresar</button>
		<a href="#" class="btn btn-outline-secondary" >Registrate</a>
	</div>
</form>