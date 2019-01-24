<%@ page import="com.alliance.model.*, java.util.*, java.text.* " language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Branch codes and cities</title>

<style type="text/css">
table 
{
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th 
{
	border: 1px solid #dddddd;																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) 
{
	background-color: #dddddd;
}
</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<% AdminModel admin = (AdminModel)session.getAttribute("admin"); %>
</head>
<body>
<% if(admin == null) 
	{%>
	<div class="overlay"></div>
<div class="terminal">
  <h1>Error <span class="errorcode">404</span></h1>
  
  <p class="output">Please try again </p>

</div>
	<%} else {%>
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
							<li><a href="AdminDispController"><span
										class="glyphicon glyphicon-pencil"></span> Link Accounts </a></li>	
								<li><a href="AdminFundTransferActivationController"><span
										class="glyphicon glyphicon-pencil"></span> Transfer Funds Requests </a></li>
								<li><a href="AdminCitiesRedirectController"><span
										class="glyphicon glyphicon-pencil"></span> Cities & Branch codes </a></li>		
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="panel-heading">Your Account</div>
				<div class="panel-body">
				<div id="fullform">
		<form class="form-horizontal"  role="form"   action="GenerateBranchCodeController">
			<div class="form-group">
				<label for="firstname" class="control-label col-sm-3">
					City:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="city"
						id="city" placeholder="Enter city" />
					<p id="p1" style="color: red"></p>
				</div>
			</div>

			<div class="col-md-12">
				<div class="text-center">
					<div class="form-actions">
						<button type="submit" class="btn btn-success">Generate Branch code</button>
					</div>
				</div>
			</div>
		</form>
			
			</div>
			</div>
		
			    </div>
			
		</div>
	</div>
	
	<%@include file="footer.jsp"%>
	<%} %>
</body>
</html>