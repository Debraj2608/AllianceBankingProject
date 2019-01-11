<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>About</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/index.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color: lightblue;">
	<%@include file="header.jsp"%>
	<div>
		<h4>
			We are here to provide best jobs for the jobseekers at our site,</br> as
			the seekers deserve to make their life successful.
		</h4>
		<H1>JOB CATEGORIES</H1>
		<ul>
			<li><span>ACCOUNTING</span></li>
			<li><span>FINANCE</span></li>
			<li><span>SALES</span></li>
			<li><span>MARKETING</span></li>
			<li><span>INFORMATION TECHNOLOGY</span></li>
			<li><span>ENGINEERING</span></li>
		</ul>
	</div>
	<p id="back-to-top">
		<a href="#top"><span></span></a>
	</p>
	<div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>