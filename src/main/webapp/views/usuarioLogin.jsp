<jsp:include page="./partials/head.jsp" />

<div class="container-login">
	<img class="sombra-container" src="${pageContext.request.contextPath}/images/geallu_logo.jpeg" alt=""/>
	<div class="sombra-container"></div>
	<div class="container vh-100">
		<div class="subcontainer-login">
			<jsp:include page="../components/formLogin.jsp" />
		</div>
	</div>
</div>

<jsp:include page="./partials/foot.jsp" />
