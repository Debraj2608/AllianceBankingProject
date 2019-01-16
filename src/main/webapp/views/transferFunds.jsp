<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer funds</title>
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
<script src="../javascript/regis.js"></script>
</head>
<body style="background-color: lightblue;">
	<%@include file="profileheader.jsp"%>
	<div class="container">
		<div class='text-center'>
			<h1>Transfer to any account here</h1>
		</div>
	</div>
	<div id="fullform">
		<form class="form-horizontal" role="form" 
		 method="post" action="TransactionController">
			<div class="form-group">
				<label for="account_number" class="control-label col-sm-3">Account Number
					</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="account_number"
						id="account_number" placeholder="Enter Account Number" />
					<p id="p1" style="color: red"></p>
				</div>
			</div>
			<div class="form-group">
				<label for="t_amount" class="control-label col-sm-3">Transaction amount</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="t_amount"
						id="t_amount" placeholder="Enter Transaction Amount" />
					<p id="p2" style="color: red"></p>

				</div>
			</div>
				<div class="col-md-12">
				<div class="text-center">
					<div class="form-actions">
						<button type="submit" class="btn btn-success">Transfer Fund</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>