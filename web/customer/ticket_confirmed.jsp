<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/25/2020
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Ticket confirmed</title>
</head>
<body>
<div class="container">
    <h1>Your Ticket has been confirmed </h1>
    <div>
        <p> Hello ! ${customer.firstName}<br>
            Ticket Id : ${ticket.id} <br>
            Counter you need to visit : ${counter.number} <br>
            Please wait until your ticket number is called !<br>
        </p>
    </div>
    <div>
        <a href="index.jsp">Create a new ticket </a><br>
        <a href="invalidate.jsp">Clear session</a>
    </div>
</div>

</body>
</html>
