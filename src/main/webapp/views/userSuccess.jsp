<%@ page import="com.alliance.model.UserModel, com.alliance.model.AccountModel" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
<%
UserModel currentUser = (UserModel) session.getAttribute("userRecord");
%>
</script>

</head>
<body>
<% if(currentUser == null) 
	{%>
	<div class="overlay"></div>
<div class="terminal">
  <h1>Error <span class="errorcode">404</span></h1>
  
  <p class="output">Please try again </p>

</div>
	<%} else {%>
	<%@include file="header.jsp"%><br><br>
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
							  
								<%	boolean status = currentUser.isFundsTransferStatus();
									if(status==false)
									{%>
								<li><a href="FundTransferRequestController"><span
										class="glyphicon glyphicon-pencil"></span> Request for transfer services </a></li>
										<%} 
										else
										{%>			
								<li><a href="TransferPageRefirectController"><span
										class="glyphicon glyphicon-pencil"></span> Transfer Funds </a></li>
										<% }%>
								<% AccountModel accountModel = currentUser.getAccountModel();
								if(accountModel == null) 
								{%>		
								<li><a href="MyAccountController"><span
										class="glyphicon glyphicon-pencil"></span> My Account </a></li>		
								
								<%} else { %>
								<li><a href="DepositPageRedirectController"><span
										class="glyphicon glyphicon-pencil"></span> Deposit </a></li>		
								<li><a href="MyAccountController"><span
										class="glyphicon glyphicon-pencil"></span> My Account </a></li>		
								
								<%} %>
							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</nav>
				</div>
			</div>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="panel-heading">Success</div>
				<div class="panel-body">
					<% String message = (String)request.getAttribute("message"); %>
					<%= message %>
				
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>

<%} %>
</body>
</html>