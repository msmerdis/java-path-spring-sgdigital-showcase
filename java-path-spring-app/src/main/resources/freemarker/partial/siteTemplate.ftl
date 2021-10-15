<#macro importantLibraries>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</#macro>

<#macro navbar currentPage>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="/mvc">E-Shop.gr</a>

	<div class="collapse navbar-collapse" id="navbarWithLogOut">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item">
				<a class="nav-link ${(currentPage=='index')?then('active', '')}" href="/mvc/index">Home <span
							class="sr-only">
						(current)</span></a>
			</li>
			<li class="nav-item">
				<a class="nav-link ${(currentPage=='ourProducts')?then('active', '')}" href="/mvc/ourProducts">Our
					Products</a>
			</li>
			<li class="nav-item">
				<a class="nav-link ${(currentPage=='findYourProduct')?then('active', '')}"
				   href="/mvc/findYourProduct">Find
					Your Product</a>
			</li>
			<li class="nav-item">
				<a class="nav-link ${(currentPage=='about')?then('active', '')}" href="/mvc/about">About Us</a>
			</li>
		</ul>
		<a href="/mvc/registerCustomer" class="btn btn-success my-2 my-sm-0" role="button">Register</a>
	</div>
</nav>
<!-- Navbar -->
</#macro>

<#macro footer>
<!-- Footer -->
<footer class="bg-dark text-center text-white fixed-bottom">
	<!-- Copyright -->
	<div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
		© 2021 Copyright:
		<a class="text-white" href="/mvc">E-Shop.gr</a>
	</div>
	<!-- Copyright -->
</footer>
<!-- Footer -->
</#macro>
