<%@ page import="java.util.*,com.alliance.model.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>header</title>
<style type="text/css">
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.header {
	overflow: hidden;
	background-color: black;
	padding: 20px 10px;
}

.para {
	float: left;
	color: white;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 25px;
	line-height: 25px;
	border-radius: 4px;
}

.header a {
	float: left;
	color: white;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 17px;
	line-height: 25px;
	border-radius: 4px;
}

.header a.logo {
	font-size: 20px;
	font-weight: bold;
}

.header a:hover {
	background-color: white;
	color: black;
}

.header-left {
	float: right;
}

@media screen and (max-width: 500px) {
	.header a {
		float: none;
		display: block;
		text-align: left;
	}
	.header-left {
		float: none;
	}
}
</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/header.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header">
		<div class="para">
			<h1>Alliance Bank</h1>
		</div>
		<br />
		<div class="header-left">
			&nbsp;&nbsp;&nbsp; <a href="IndexController">Home</a>
			&nbsp;&nbsp;&nbsp; <a href="ContactButtonController">Contact</a>
			&nbsp;&nbsp;&nbsp; <a href="AboutButtonController">About</a>
			<%
				UserModel um = null;
				AdminModel am = null;
				um = (UserModel) session.getAttribute("userRecord");
				am = (AdminModel) session.getAttribute("admin");
				if (um == null) {
					if (am == null) {
			%>
			&nbsp;&nbsp;&nbsp; <a href="RegisterRedirectController">Register</a>
			&nbsp;&nbsp;&nbsp; <a href="LoginRedirectController">Login</a>
			<%
				} else {
			%>
			&nbsp;&nbsp;&nbsp; <a href="ProfileController">Admin</a>
			&nbsp;&nbsp;&nbsp; <a href="LogoutController">Log Out</a>
			<%
				}
				} else {
			%>
			&nbsp;&nbsp;&nbsp; <a href="ProfileController"><%= um.getFirstName() %></a>
			&nbsp;&nbsp;&nbsp; <a href="LogoutController">Log Out</a>
			<%
				}
			%>
		</div>
	</div>



</body>
</html>