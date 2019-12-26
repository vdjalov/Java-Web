<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>names</title>
</head>
<body>

	<% if ((request.getAttribute("names")) != null &&
	((List<String>)request.getAttribute("names")).size() > 0) {%>
			<h2><%="Our Users!" %></h2>
		
	<% for (String user : ((List<String>) request.getAttribute("names"))) {%>
			<p><%= user%></p>
		<%}%>	
	<% }%>
		<h1><%= "footer" %></h1>
</body>
</html>