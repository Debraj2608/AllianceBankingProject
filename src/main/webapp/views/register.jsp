<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/register.css" /> 
<script src="../js/reg.js">
</script>
<script>
function reg() {
	var fname = document.getElementById("firstname").value;
	var mname = document.getElementById("middlename").value;
	var lname = document.getElementById("lastname").value;
	var email = document.getElementById("email").value;
	var dob = document.getElementById("dob").value;
	var cno = document.getElementById("cno").value;
	var city = document.getElementById("city").value;
	var occ = document.getElementById("occupation").value;
	var pass1 = document.getElementById("password1").value;
	var pass2 = document.getElementById("password2").value;
	var vname = /[a-zA-Z]+/;
	var vdob = /[0-9]{2}\-[0-9]{2}\-[0-9]{4}/;
	var vcno = /[0-9]{10}/;
	var vcity = /[a-zA-Z]+/;
	var vocc = /[a-zA-Z]+/;
	var vpass = /((?=.*[A-Z]+)(?=.*[0-9]+)(?=.*[a-z]+)(?=.*[\@\#\$\&]+)){8,}/;
	var status = false;
	if (vname.test(fname)) {
		document.getElementById("p1").innerHTML = "";
		if (vname.test(mname) || mname=="") {
			document.getElementById("p2").innerHTML = "";
			if (vname.test(lname)) {
				document.getElementById("p3").innerHTML = "";
				if (vname.test(email)) {
					document.getElementById("p4").innerHTML = "";

					if (vdob.test(dob)) {
						document.getElementById("p5").innerHTML = "";

						if (vcno.test(cno)) {
							document.getElementById("p6").innerHTML = "";

							if (vcity.test(city)) {
								document.getElementById("p7").innerHTML = "";

								if (vocc.test(occ)) {
									document.getElementById("p8").innerHTML = "";

									if (vpass.test(pass1)) {
										document.getElementById("p9").innerHTML = "";

										if (pass1 == pass2) {
											status = true;
										} else {
											alert("password not matched");
										}
									} else {
										document.getElementById("p9").innerHTML = "Invalid Password";
									}
								} else {
									document.getElementById("p8").innerHTML = "Alphabets Only in Occupation";
								}
							} else {
								document.getElementById("p7").innerHTML = "Alphabets Only in City Name";
							}
						} else {
							document.getElementById("p6").innerHTML = "Enter a Valid Contact Number";
						}
					} else {
						document.getElementById("p5").innerHTML = "Enter a valid date of birth (DD-MM-YYYY)";
					}
				} else {
					document.getElementById("p4").innerHTML = "Email-ID is Mandatory";
				}
			} else {
				document.getElementById("p3").innerHTML = "Alphabets Only in LastName";
			}
		} else {
			document.getElementById("p2").innerHTML = "Alphabets Only MiddleName";
		}

	} else {
		document.getElementById("p1").innerHTML = "Alphabets Only FirstName";
	}
	return status;

}
</script>
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
			<h1>Register Here</h1>
		</div>
	</div>
	<div id="fullform">
		<form class="form-horizontal" onSubmit="return reg()" role="form"  method="post" action="RegisterController">
			<div class="form-group">
				<label for="firstname" class="control-label col-sm-3">First
					Name:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="firstname"
						id="firstname" placeholder="Enter First Name" />
					<p id="p1" style="color: red"></p>
				</div>
			</div>
			<div class="form-group">
				<label for="middllename" class="control-label col-sm-3">Middle
					Name:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="middlename"
						id="middlename" placeholder="Enter Middle Name" />
					<p id="p2" style="color: red"></p>

				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="control-label col-sm-3">Last
					Name:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="lastname"
						id="lastname" placeholder="Enter Last Name">
					<p id="p3" style="color: red"></p>

				</div>
			</div>
			<div class="form-group">
				<label for="email" class="control-label col-sm-3">Email:</label>
				<div class="col-sm-8">
					<input type="email" class="form-control" name="email" id="email"
						placeholder="Enter Email ID">
											<p id="p4" style="color: red"></p>
						
				</div>
			</div>
			<div class="form-group" class="input-append date form_datetime">
				<label for="dateofbirth" class="control-label col-sm-3">Date
					of Birth:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="dob" id="dob"
						placeholder="DD-MM-YYYY"> <span class="add-on"><i
						class="icon-th"></i></span>
					<p id="p5" style="color: red"></p>
				</div>
			</div>
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
						<button type="submit" class="btn btn-success">Register</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>