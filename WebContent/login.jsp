<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Facebook-log in or forget</title>
<style>
#home-body {
	background: #F8F8F8 !important;
}
</style>

<%@include file="components/comman_css_js.jsp"%>
</head>
<body id="home-body">
	<!-- Login Form -->
	<div class="container-fluid">
		<div class="row mt-5">
			<div class="col-lg-4 col-sm-6 offset-lg-4 offset-sm-3">
				<div class="card">
					<div class="cart-header text-center text-white"
						style="background: #43609C;">
						<h1>
							<i class="fa fa-facebook-square" aria-hidden="true"></i><br> Log In !!
						</h1>
					</div>
					
					<%@include file="components/Message.jsp"%>
					<div class="card-body px-5">
						<form action="UserLogin" method="post">
							<div class="form-group">
								<label for="username">User Email</label> <input type="email"
									class="form-control" name="userEmail" placeholder="Enter here" required>
							</div>

							<div class="form-group">
								<label for="userpass">User Password</label> <input type="password"
									class="form-control" name="userPwd" placeholder="Enter here" required>
							</div>

							<div class="container text-center">
								<a href="#">Forgotten password?</a><br>
								<a href="index.jsp">If not register click here</a><br>
								<br> <input type="submit" value="Login"
									class="btn btn-primary btn-lg btn-block">
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>

	</div>
	
</body>
</html>