<%@ page
	import="com.alliance.model.UserModel,java.util.*,com.alliance.model.TransactionModel"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Mini Statement</title>
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

	<h2>Transaction Details</h2>

	<%
		List<TransactionModel> transactionList = (List) request.getAttribute("transactionList");
	%>

	<table>
		<tr>
			<th>Transaction ID</th>
			<th>Transaction Date</th>
			<th>Amount</th>
			<th>Transaction Type</th>
		</tr>
		<%
			for(TransactionModel tm : transactionList)
			{
		%>
		<tr>
			<td><%=tm.getTransaction_id() %></td>
			<td><%=tm.getTransaction_date() %>
			<td><%=tm.getTransaction_amount() %></td>
			<td><%=tm.getTransaction_type()%></td>
		</tr>
		<%
			}
		%>
	</table>
		<%@include file="footer.jsp"%>
</body>
</html>