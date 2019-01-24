<%@ page import="java.util.*,com.alliance.model.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
				<a class="navbar-brand" href="userdetails.jsp"> Admin </a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<form class="navbar-form navbar-left" method="post" action="SearchController">
					<div class="form-group">
					<select name="stype" class="form-control">
					          <option value="actype">Account Type</option>
  							  <option value="acid">Account ID</option>
   							 <option value="uname">Client Name</option>
 					 </select>
 					 &nbsp;
						<input type="text" name="user" class="form-control">
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
								<li><a href="AdminCitiesRedirectController"><span
										class="glyphicon glyphicon-pencil"></span> Cities & Branch codes </a></li>

							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</nav>
				</div>
			</div>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="panel-heading">Search Details</div>
				<div class="panel-body">

					<%
						List<UserModel> ul = (List<UserModel>) request.getAttribute("ulist");
						String stype = (String) request.getAttribute("stype");
						int a = 0;
						if ("acid".equals(stype)) {
					%>

					<table>
						<tr>
							<th>Account Owner Name</th>
							<th>Account Number</th>
							<th>Account Type</th>
							<th>Balance</th>
							<th>Address</th>
							<td>Branch Name</td>
							<th></th>
						</tr>
						<%
							for (int i = 0; i < ul.size(); i++) {
									a = i;
						%>
						<tr>
							<td><a data-toggle="modal" data-target="#userdetails"><%=ul.get(i).getFirstName()%></a></td>
							<td><a data-toggle="modal" data-target="#accountdetails"><%=ul.get(i).getAccountModel().getAccount_no()%></a></td>
							<td><%=ul.get(i).getAccount_type()%></td>
							<td><%=ul.get(i).getAccountModel().getBalance()%>
							<td><%=ul.get(i).getCity()%>
							<td><%=ul.get(i).getAccountModel().getBranchModel().getBranchCode() %>
						</tr>
						<%
							}
							}
						%>
					</table>

					<%
						if ("uname".equals(stype)) {
					%>

					<table>
						<tr>
							<th>Client Name</th>
							<th>Customer ID</th>
							<th>Account Number</th>
							<th>Address with E-mail</th>
							<th>Contact Number</th>
							<td>Branch Code</td>
							<th></th>
						</tr>
						<%
							for (int i = 0; i < ul.size(); i++) {
									a = i;
						%>

						<tr>
							<td><a data-toggle="modal" data-target="#userdetails"><%=ul.get(i).getFirstName()%></a></td>
							<td><%=ul.get(i).getCustomerID()%></td>
							<td><a data-toggle="modal" data-target="#accountdetails"><%=ul.get(i).getAccountModel().getAccount_no()%></a></td>
							<td><%=ul.get(i).getCity() + " - " + ul.get(i).getEmail()%>
							<td><%=ul.get(i).getContactNumber()%>
							<td><%=ul.get(i).getAccountModel().getBranchModel().getBranchCode()%>
						</tr>

						<%
							}
							}
						%>
					</table>

					<%
						if ("actype".equals(stype)) {
					%>

					<table>
						<tr>
							<th>Client Name</th>
							<th>Customer ID</th>  
							<th>Account Number</th>
							<th>Account Type</th>
							<th>Address with E-mail</th>
							<th>Contact Number</th>
							<td>Branch Code</td>
							<th></th>
						</tr>
						<%
							for (int i = 0; i < ul.size(); i++) {
									a = i;
						%>

						<tr>
							<td><a data-toggle="modal" data-target="#userdetails"><%=ul.get(i).getFirstName()%></a></td>
							<td><%=ul.get(i).getCustomerID()%></td>
							<td><a data-toggle="modal" data-target="#accountdetails"><%=ul.get(i).getAccountModel().getAccount_no()%></a></td>
							<td><%=ul.get(i).getAccount_type()%></td>
							<td><%=ul.get(i).getCity() + " - " + ul.get(i).getEmail()%>
							<td><%=ul.get(i).getContactNumber()%>
							<td><%=ul.get(i).getAccountModel().getBranchModel().getBranchCode() %>
						</tr>

						<%
							}
							}
						%>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="userdetails" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Owner Details</h4>
				</div>
				<div class="modal-body">
					<table style="width: 80%">
						<tr>
							<th>Customer ID:</th>
							<td>&nbsp;&nbsp;<%=ul.get(a).getCustomerID()%></td>
						</tr>
						<tr>
							<th>Name:</th>
							<td>&nbsp;&nbsp;<%=ul.get(a).getFirstName() + " " + ul.get(a).getLastName()%>
							</td>
						</tr>
						<tr>
							<th>Email:</th>
							<td>&nbsp;&nbsp;<%=ul.get(a).getEmail()%></td>
						</tr>
						<tr>
							<th>Date of Birth:</th>
							<td>&nbsp;&nbsp;<%=ul.get(a).getDob()%></td>
						</tr>
						<tr>
							<th>Contact Number:</th>
							<td>&nbsp;&nbsp;<%=ul.get(a).getContactNumber()%></td>
						</tr>
						<tr>
							<th>Occupation:</th>
							<td>&nbsp;&nbsp;<%=ul.get(a).getOccupation()%></td>
						</tr>
						<tr>
							<th>Account Type:</th>
							<td>&nbsp;&nbsp;<%=ul.get(a).getAccount_type()%></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="accountdetails" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Account Details</h4>
				</div>
				<div class="modal-body">
					<table style="width: 80%">
						<tr>
							<th>Account Number:</th>
							<td>&nbsp;&nbsp;<%=ul.get(a).getAccountModel().getAccount_no()%></td>
						</tr>
						<tr>
							<th>Account Type:</th>
							<td>&nbsp;&nbsp;<%=ul.get(a).getAccount_type()%>
							</td>
						</tr>
						<tr>
							<th>Branch Code:</th>
							<td>&nbsp;&nbsp;<%=ul.get(a).getAccountModel().getBranchModel().getBranchCode()%></td>
						</tr>
						<tr>
							<th>Balance:</th>
							<td>&nbsp;&nbsp;<%=ul.get(a).getAccountModel().getBalance()%></td>
						</tr>
						<tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	<%} %>
</body>
</html>