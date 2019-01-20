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
<link rel="stylesheet" href="../css/register.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<% UserModel user = (UserModel)request.getAttribute("userModel");%>

<script>
function password() {
	document.getElementById("p1").innerHTML = "<h3>"+"Your password is "+"</h3>"+"<h3>"+
	 <%=user.getPassword() %>+"</h3>";
}	
</script>

</head>
<body>
	<%@include file="header.jsp" %>
	<div class="col-md-12 content">
			<div class="panel panel-default">
				<div class="panel-heading">Your Details</div>
				<div class="panel-body">
				<div class="control-label col-sm-6">
				
				<h4>Customer ID:</h4></div>

				<div class="col-sm-4">

					<h4><%=user.getCustomerID() %></h4>
				</div>		
	
				
	<div class="control-label col-sm-6">
		<h4>Name:</h4></div>
		<div class="col-sm-4">
			<%if(user.getMiddleName().equals(null)) 
			{%>
			<h4><%=user.getFirstName()+" "+user.getLastName() %></h4>
			<%} else { %>
			<h4><%=user.getFirstName()+" "+user.getMiddleName()+" "+user.getLastName() %></h4>
			<%} %>
		</div>
		
	<div class="control-label col-sm-6">

				<h4>Date of Birth:</h4></div>

				<div class="col-sm-4">

					<h4><%=user.getDob() %></h4>
				</div>
	
		
	<div class="control-label col-sm-6">

				<h4>City:</h4></div>

				<div class="col-sm-4">

					<h4><%=user.getCity() %></h4>
				</div>		
				
	<div class="control-label col-sm-6">

				<h4>Contact Number:</h4></div>

				<div class="col-sm-4">

					<h4><%=user.getContactNumber() %></h4>
				</div>			
				
	<div class="control-label col-sm-6">

				<h4>Email:</h4></div>

				<div class="col-sm-4">

					<h4><%=user.getEmail() %></h4>
				</div>
				
	<div class="control-label col-sm-6">

				<h4>Occupation:</h4></div>

				<div class="col-sm-4">

					<h4><%=user.getOccupation() %></h4>
				</div>			
			</div>
	<br>
				&nbsp;<button style="align:center" onclick="password()">View Password</button>
					<p id="p1" style="color: green; text-align : center;"></p>
	
				
				<h4 style = "text-align:center"><b>YOU WILL RECIEVE AN EMAIL FROM US REGARDING YOUR ACCOUNT INFORMATION. 
					HAPPY BANKING!!!!</b></h4>
				<h3 style = "text-align:center"><em>Kindly note your customer ID as you will need it to Login</em></h3>			
				
			
				</div>
		</div>
	
	
			
	<%@include file="footer.jsp"%>
</body>
</html>