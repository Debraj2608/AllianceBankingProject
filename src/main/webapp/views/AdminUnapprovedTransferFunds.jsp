<%@ page import="com.alliance.model.FundTransferRequestModel,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approve Transfer Funds</title>
</head>
<body>
	<%List<FundTransferRequestModel> unApprovedList = (List)request.getAttribute("UnApprovedTransferFunds"); 
	for(FundTransferRequestModel l: unApprovedList)
	{ %>
	<%= l.getUserModel().getCustomerID() %>-
	<%= l.getRequestTime() %>
	<a href="AdminLinkTransferFundsController?module=<%= l.getUserModel().getCustomerID() %>">Activate Transfer Funds</a><br>
	<%} %>
	
</body>
</html>