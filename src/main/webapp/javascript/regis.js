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