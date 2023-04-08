<!doctype html>
<html lang="en">
<head>
<title>Facebook-log in or sign up</title>

<%@include file="components/comman_css_js.jsp"%>
</head>
<body>

	<!-- Navbar -->
	<%@include file="components/Navbar.jsp"%>


	<!-- Main Container -->
	<div class="container-fulid p-0 m-0" id="main-con">


		<div class="container">

			<div class="row">

				<div class="col-md-6">

					<p class="lead font-weight-bold p">Facebook helps you connect
						and share with the people in your life.</p>

					<img src="image/facebok.png" class="img-fluid">

				</div>

				<div class="col-md-6">
					
					<h1>Create an account</h1>
					<p class="lead">It's quick and easy.</p>
					
					<%@include file="components/Message.jsp"%>
					
					<form action="UserRegister" method="post">

						<div class="form-row">
							<div class="form-group col-md-6">
								<input type="text" class="form-control" name="fname"
									placeholder="First name" required>
							</div>
							<div class="form-group col-md-6">
								<input type="text" class="form-control" name="surname"
									placeholder="Surname" required>
							</div>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="email"
								placeholder="Email address" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="pass"
								placeholder="New password" required>
						</div>

						<div class="form-row">
							<div class="form-group col-md-12">
								<label for="inputEmail4">Date of birth</label>
							</div>

							<div class="form-group col-md-12">
								<input type="date" name="dateofbirth" class="form-control"
								required>
							</div>
						</div>

						<div class="form-row">
							<div class="form-group col-md-12">
								<label for="inputEmail4">Gender</label>
							</div>
						</div>
						<div class="form-row ml-5">
							<div class="form-group col-md-2">
								<input class="form-check-input" type="radio" name="gender"
									id="exampleRadios1" value="Male" checked> <label
									class="form-check-label" for="exampleRadios1"> Male </label>
							</div>

							<div class="form-group col-md-2">
								<input class="form-check-input" type="radio" name="gender"
									id="exampleRadios2" value="Female"> <label
									class="form-check-label" for="exampleRadios2"> Female </label>
							</div>
						</div>


						<div class="form-check"></div>


						<div class="container text-center mt-4 mb-3">
							<input type="submit" value="Sign Up"
								class="btn btn-success btn-lg">
						</div>
					</form>

				</div>

			</div>

		</div>

		</ul>
	</div>
	</div>

</body>
</html>

