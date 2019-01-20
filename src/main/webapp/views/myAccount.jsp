<%@ page import="com.alliance.model.UserModel" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%
	UserModel currentUser = (UserModel) session.getAttribute("userRecord");
%>

</head>
<body>
	<%@include file="profileheader.jsp"%>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button"
					class="navbar-toggle navbar-toggle-sidebar collapsed">
					MENU</button>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="userdetails.jsp"> User Profile </a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<form class="navbar-form navbar-left" method="GET" role="search">
					<div class="form-group">
						<input type="text" name="q" class="form-control"
							placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</form>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="container-fluid main-container">
		<div class="col-md-2 sidebar">
			<div class="row">

				<div class="absolute-wrapper"></div>

				<div class="side-menu">
					<nav class="navbar navbar-default" role="navigation">
						<!-- Main Menu -->
						<div class="side-menu-container">
							<ul class="nav navbar-nav">
								<li class="active"><a href="#"><span
										class="glyphicon glyphicon-dashboard"></span> Dashboard </a></li>
								<li><a href="UpdatePageRedirectController"><span
										class="glyphicon glyphicon-pencil"></span> Update Profile </a></li>
								<li><a href="MyAccountController"><span
										class="glyphicon glyphicon-pencil"></span> My Account </a></li>	
								<%
									boolean status = currentUser.isFundsTransferStatus();
									if (status == false) {
								%>
								<li><a href="FundTransferRequestController"><span
										class="glyphicon glyphicon-pencil"></span> Request for
										transfer services </a></li>
								<%
									} else {
								%>
								<li><a href="TransferPageRefirectController"><span
										class="glyphicon glyphicon-pencil"></span> Transfer Funds </a></li>
								<%
									}
								%>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="panel-heading">Dashboard</div>
				<div class="panel-body">
	<div class="form-group">
	<div class="control-label col-sm-6">

				<h4>Customer ID:</h4></div>

				<div class="col-sm-4">

					<h4><%=currentUser.getCustomerID() %></h4>
				</div>		
	
	<div class="control-label col-sm-6">

				<h4>Account Number:</h4></div>

				<div class="col-sm-4">

					<h4><%=currentUser.getAccountModel().getAccount_no() %></h4>
				</div>
			
	<div class="control-label col-sm-6">
		<h4>Name:</h4></div>
		<div class="col-sm-4">
			<%if(currentUser.getMiddleName().equals(null)) 
			{%>
			<h4><%=currentUser.getFirstName()+" "+currentUser.getLastName() %></h4>
			<%} else { %>
			<h4><%=currentUser.getFirstName()+" "+currentUser.getMiddleName()+" "+currentUser.getLastName() %></h4>
			<%} %>
		</div>
	<div class="control-label col-sm-6">

				<h4>City:</h4></div>

				<div class="col-sm-4">

					<h4><%=currentUser.getCity() %></h4>
				</div>		
	
	
	<div class="control-label col-sm-6">

				<h4>Date of Birth:</h4></div>

				<div class="col-sm-4">

					<h4><%=currentUser.getDob() %></h4>
				</div>
				
	<div class="control-label col-sm-6">

				<h4>Contact Number:</h4></div>

				<div class="col-sm-4">

					<h4><%=currentUser.getContactNumber() %></h4>
				</div>			
				
	<div class="control-label col-sm-6">

				<h4>Email:</h4></div>

				<div class="col-sm-4">

					<h4><%=currentUser.getEmail() %></h4>
				</div>
				
	<div class="control-label col-sm-6">

				<h4>Occupation:</h4></div>

				<div class="col-sm-4">

					<h4><%=currentUser.getOccupation() %></h4>
				</div>			
			</div>
			
	<br>												
		<li><a href="MiniStatementController"><span
			class="glyphicon glyphicon-pencil"></span> Check mini statement </a></li>
			
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>