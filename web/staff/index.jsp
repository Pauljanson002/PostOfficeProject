<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/25/2020
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Counter</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <h5>Available Tickets: <c:out value="${counter.availableTickets}"/> </h5>
            <button type="button" class="btn btn-primary">
                Process a ticket
            </button>
        </div>
        <div class="col">
            <h5>Hello User : <c:out value="${staff.firstName}"/> <c:out value="${staff.lastName}"/></h5>
            <h5>Counter number : <c:out value="${counter.number}"/></h5>
            <h5>Counter name :<c:out value="${counter.reason}"/> </h5>
        </div>
        <div class="row">
            <div class="col">
                <a href=<c:url value="/logout.jsp"/> >
                    <button type="button">Logout</button>
                </a>
            </div>
        </div>

    </div>


</div>
</body>
</html>
