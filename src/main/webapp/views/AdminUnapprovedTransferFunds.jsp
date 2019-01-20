<%@ page import="com.alliance.model.FundTransferRequestModel,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
										class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
								<li><a href="AdminDispController"><span
										class="glyphicon glyphicon-pencil"></span> Link Accounts </a></li>	
								<li><a href="AdminFundTransferActivationController"><span
										class="glyphicon glyphicon-pencil"></span> Transfer Funds Requests </a></li>

							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</nav>
				</div>
			</div>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="panel-heading">Activate Fund Transfer Requests</div>
				<div class="panel-body">
				<%List<FundTransferRequestModel> unApprovedList = (List)request.getAttribute("UnApprovedTransferFunds"); %>
					<table>
					<tr>
					<th>Account Number</th>
					<th>Name</th>
					<th>Customer ID</th>
					<th>Request Time</th>
					<th>Action</th>
				</tr>
				<%
					for(FundTransferRequestModel fr : unApprovedList)
					{
				%>
				<tr>
					<td><%=fr.getUserModel().getAccountModel().getAccount_no() %></td>
					<td><%=fr.getUserModel().getFirstName()+" "+fr.getUserModel().getMiddleName()+" "+fr.getUserModel().getLastName() %>
					<td><%=fr.getUserModel().getCustomerID() %></td>
					<td><%=fr.getRequestTime() %></td>
					<td><a href="AdminLinkTransferFundsController?module=<%= fr.getUserModel().getCustomerID() %>">Activate Transfer Funds</a><br>
</td>
					
				</tr>
				<%
					}
				%>
			</table>
				
				
				
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>


</body>
</html>