<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/login.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color: lightblue;">
	<%@include file="header.jsp"%><br><br>
	<div class="container">
		<div class='text-center'>
			<h1>Login Here</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="Absolute-Center is-Responsive">
				<div id="logo-container"></div>
				<div class="col-sm-12 col-md-10 col-md-offset-1">
					<form action="AdminLoginController" id="loginForm" method="post">
						<div class="form-group input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								class="form-control" type="text" name='username'
								placeholder="username" />
						</div>
						<div class="form-group input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input
								class="form-control" type="password" name='password'
								placeholder="password" />
						</div>
						<div class="col-md-12">
							<div class="text-center">
								<div class="form-actions">
									<button type="submit" class="btn btn-success">Login</button>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="text-center">
								<div class="form-actions">
									<a href="LoginRedirectController">Login as Bank User</a>
								</div>
							</div>
						</div>
					</form>
					<p>
					<p>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>