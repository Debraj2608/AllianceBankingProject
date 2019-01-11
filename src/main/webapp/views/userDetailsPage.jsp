<%@ page import = "com.alliance.model.UserModel" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/register.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

	<% UserModel user = (UserModel)session.getAttribute("userModel");%>
	<%@include file="header.jsp" %>
	
	<h1>Welcome!!</h1><br/>
	<h1>Your Customer ID is : <%= user.getCustomerID() %></h1><br/>
	(Please note your customer ID as it is needed to login)<br/>
	
	<%= user.getFirstName()%>
	<%= user.getMiddleName() %>
	<%= user.getLastName()%><br/>	
	<%= user.getDob() %><br/>
	<%= user.getEmail() %><br/>
	<%= user.getContactNumber() %><br/>
	<%= user.getOccupation() %><br/>
	<%= user.getPassword() %><br/>
	
	<h1><b>YOU WILL RECIEVE AN EMAIL FROM US REGARDING YOUR ACCOUNT INFORMATION. 
			HAPPY BANKING!!!!</b></h1>
			
		
</body>
</html>