<li class="sliderItem-li">
	<figure class="sliderItem">
		<div>
			<img class="sliderItem-img" src="https://res.cloudinary.com/teepublic/image/private/s--c4AeIYEt--/t_Resized%20Artwork/c_crop,x_10,y_10/c_fit,w_470/c_crop,g_north_west,h_626,w_470,x_0,y_0/g_north_west,u_upload:v1462829015:production:blanks:mtl53ofohwq5goqjo9ke,x_-395,y_-325/b_rgb:eeeeee/c_limit,f_auto,h_630,q_90,w_630/v1563382879/production/designs/5340646_0.jpg" alt="cr7" />
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
</li>