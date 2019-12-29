<%@page import="app.domain.models.view.CarViewModel"%>
<%@page import="java.util.List"%>
<%@page import="app.domain.models.service.CarServiceModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>All Cars</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>

<style><%@include file="/css/style.css"%></style>

<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-background">
        <a class="nav-link text-white active h5" href="/index">Home</a>
        <div class="collapse navbar-collapse d-flex justify-content-end">
            <ul class="navbar-nav row">
                <li class="nav-item col-md-4">
                    <a class="nav-link text-white active font-weight-bold"
                       href="/cars/create">Upload Car</a>
                </li>
                <li class="nav-item col-md-4">
                    <a class="nav-link text-white active font-weight-bold" href="/cars/all">All Cars</a>
                </li>
                <li class="nav-item col-md-4">
                    <a class="nav-link text-white active font-weight-bold" href="/logout">Logout</a>
                </li>
            </ul>
        </div>
    </nav>
    <h2 class="text-center text-white mt-5">West Compass Offers</h2>
    <hr style="width: 50%"/>
    <div class='row mb-4 d-flex justify-content-around'>
    <% for(CarViewModel carModel: ((List<CarViewModel>)request.getAttribute("allCars"))) {%>
        <div class="col-md-4 d-flex flex-column bg-text mb-3">
            <h2>Owner: <%=carModel.getUser().getUsername() %></h2>
            <h2>Brand: <%=carModel.getBrand() %></h2>
            <h4>Model: <%=carModel.getModel() %></h4>
            <h4>Year: <%=carModel.getYear() %></h4>
            <h4>Engine: <%=carModel.getEngine() %></h4>
        </div>
        <%} %>
        
    </div>
</div>
</body>
</html>