<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/profile.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color: lightblue;">
	<%@include file="header.jsp"%>
	<div class="container">
		<div class='text-center'>
			<h1>Welcome to Your Profile</h1>
		</div>
	</div>
	<div id="page">
		<div id="sidebar">
			<div class="box">
				<h3>Options</h3>

				<ul class="list">
					<p>
						<a href="UpdatePageRedirectController" style="text-decoration: none">Update Profile</a>
					</p>

				</ul>
			</div>

		</div>
	</div>

</body>
</html>