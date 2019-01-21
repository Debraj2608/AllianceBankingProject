<%@ page import = "com.alliance.model.UserModel" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/register.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	

</head>
<body>
	<%@include file="header.jsp" %>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<% UserModel user = (UserModel)request.getAttribute("userModel"); %>
	<div class="col-md-12 content">
			<div class="panel panel-default">
				<div class="panel-heading"></div>
				<div class="panel-body">
				
				<h2>Your details:</h2>

				<table style="width:100%">
				<tr>
				  <th>Customer ID:</th>
    			  <td>&nbsp;&nbsp;<%= user.getCustomerID() %></td>
  				</tr>
				<tr>
				  <th>Name:</th>
    			  <td>&nbsp;&nbsp;<%= user.getFirstName()+" "+user.getMiddleName()+" "+user.getLastName() %>  </td>
  				</tr>
  				  <tr>
                  <th>Email:</th>
                  <td>&nbsp;&nbsp;<%= user.getEmail() %></td>
                </tr>
                  <tr>
                  <th>Date of Birth:</th>
                  <td>&nbsp;&nbsp;<%= user.getDob() %></td>
                </tr>
                <tr>
                  <th>Contact Number:</th>
                  <td>&nbsp;&nbsp;<%= user.getContactNumber() %></td>
                </tr>
                <tr>
                  <th>Occupation:</th>
                  <td>&nbsp;&nbsp;<%= user.getOccupation() %></td>
                </tr>
          </table>
			<div style = "text:align=center">
				<h4>Kindly note your customer ID.<br>
				    You will need it to Login.</h4>			
			</div>		
				
				</div>
				</div>
		</div>
	
	
			
	<%@include file="footer.jsp" %>
</body>
</html>