<%@ page
	import="com.alliance.model.UserModel,java.util.*,com.alliance.model.*"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Search Details</title>
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
</head>
<body>
	<%@include file="profileheader.jsp"%>

	<h2>User Details</h2>

	<%
		List<UserModel> user = (ArrayList)request.getAttribute("ulist");
	    String stype= (String)request.getAttribute("stype");
	    if("acid".equals(stype))
	    {
	%>

	<table>
		<tr>
			<th>Account Owner Name</th>
			<th>Account Number</th>
			<th> Type </th>
			<th> Balance </th>
			<th> Address </th>
			<td> Branch Name </td>
			<th></th>
		</tr>
		<tr>
			<td><%= user.get(0).getFirstName()+" "+user.get(0).getMiddleName()+" "+user.get(0).getLastName()%></td>
			<td><%= user.get(0).getAccountModel().getAccount_no()  %></td>
			<td><%= user.get(0).getAccountModel().getTransactionList().get(0).getTransaction_type() %></td>
		<td><%= user.get(0).getAccountModel().getBalance() %>
						<td><%= user.get(0).getCity() %>
									<td><%= user.get(0).getAccountModel().getBranch_code() %>
						</tr>
		<%
			}
		%>
								</table>
		
		<%  if("uname".equals(stype)) 
		{ %>
		
			<table>
		<tr>
			<th> Client Name</th>
			<th> Customer ID</th>
			<th> Account Number </th>
			<th> Address with E-mail </th>
			<th> Contact Number</th>
			<td> Branch Code </td>
			<th></th>
		</tr>
		<tr>
			<td><%= user.get(0).getFirstName()+" "+user.get(0).getMiddleName()+" "+user.get(0).getLastName()%></td>
			<td><%= user.get(0).getCustomerID() %></td>
			<td><%= user.get(0).getAccountModel().getAccount_no() %></td>
			<td><%= user.get(0).getCity() +" "+ user.get(0).getEmail() %>
						<td><%= user.get(4).getContactNumber() %>
									<td><%= user.get(0).getAccountModel().getBranch_code() %>
						</tr>
		
		<% } %>
	</table>
		<%@include file="footer.jsp"%>
</body>
</html>