<%@ page import="com.alliance.model.UserModel,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  


<%  
  List <UserModel> as=new ArrayList<UserModel>();

	as=(List)request.getAttribute("Userdetails");
	for(UserModel um: as)
	{ 
%>
		
	<%= 
		um.getCustomerID()%>-
		<%=um.getFirstName()%>
			<%=um.getMiddleName()%>
				<%=um.getLastName()%>-
					<%=um.getDob()%>-
						<%=um.getCity()%>-
							<%=um.getContactNumber()%>-
								<%=um.getOccupation()%>
								<a href="AdminLinkController?module=<%= um.getCustomerID() %>">Link This User</a>	
								<p>
								<p>
								
	<% 
	}
	
	%>
</body>
</html>