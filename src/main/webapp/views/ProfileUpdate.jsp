<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Update</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
	<%@ include file="../../css/register.css" %>
	</style>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color: lightblue;">
	<%@include file="header.jsp"%>
	<div class="container">
		<div class='text-center'>
			<h1>Update Details</h1>
		</div>
	</div>
	<div id="fullform">
		<form class="form-horizontal" role="form" action="ProfileUpdateController">
			<div class="form-group">
				<label for="contactnumber" class="control-label col-sm-3">Contact
					Number:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="cno" id="cno"
						placeholder="Enter Contact Number">
					<p id="p6" style="color: red"></p>
				</div>
			</div>
			<div class="form-group">
				<label for="city" class="control-label col-sm-3">City:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="city" id="city"
						placeholder="Enter City">
					<p id="p7" style="color: red"></p>
				</div>
			</div>
			<div class="form-group">
				<label for="occupation" class="control-label col-sm-3">Occupation:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="occupation"
						id="occupation" placeholder="Enter Occupation">
					<p id="p8" style="color: red"></p>
				</div>
			</div>
			<div class="form-group">
				<label for="password1" class="control-label col-sm-3">Password:</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="password1"
						id="password1" placeholder="Enter Password">
					<p id="p9" style="color: red"></p>
				</div>
			</div>
			<div class="form-group">
				<label for="password2" class="control-label col-sm-3">Re-Enter
					Password:</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="password2"
						id="password2" placeholder="Re Enter Password">
					<p id="p10" style="color: red"></p>
				</div>
			</div>
			<div class="col-md-12">
				<div class="text-center">
					<div class="form-actions">
						<button type="submit" class="btn btn-success">Update</button>
					</div>
				</div>
			</div>
		</form>
	</div>
		<%@include file="footer.jsp"%>
	
</body>
</html>