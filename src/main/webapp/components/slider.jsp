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

.sliderItem {
	width: 100%
}

.sliderItem-img {
	width: 100%;
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

<div class="slider-container">
	<ul class="slider-subcontainer">
		<% for(int i = 0; i < 10; i++) { %>
			<jsp:include page="./sliderItem.jsp">
				<jsp:param value="IGURE" name="sliderItem-category"/>
				<jsp:param value="GREEN MUSCLE FIT POLO SHIRT" name="sliderItem-title"/>
				<jsp:param value="229.00" name="sliderItem-priceCrossed"/>
				<jsp:param value="129.00" name="sliderItem-price"/>
			</jsp:include>
		<% } %>
	</ul>
</div>