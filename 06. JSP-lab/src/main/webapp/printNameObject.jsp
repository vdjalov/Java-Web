<%@page import="entity.Names"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if ((request.getAttribute("name")) != null) {%>
			<h2><%="Our Names!" %></h2>
		<h3><%=String.format("First Name: %s", ((Names)request.getAttribute("name")).getFirstName()) %></h3>
		<h3><%=String.format("Middle Name: %s", ((Names)request.getAttribute("name")).getMiddleName()) %></h3>
		<h3><%=String.format("Last Name: %s", ((Names)request.getAttribute("name")).getLastName()) %></h3>
		<h4><%=String.format("Info: %s", request.getAttribute("user-info")) %></h4>
		
	<% }%>
		<h1><%= "footer" %></h1>
</body>
</html>