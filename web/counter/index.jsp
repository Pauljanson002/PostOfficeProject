<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/26/2020
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Counter</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <h2>Counter Number : <c:out value="${counter.number}"/></h2>
            <br>
            <h2>Staff Name : <c:out value="${staff.value}"/> </h2>
        </div>
        <div class="col">

        </div>
        <div class="col">
            <h2>Available Tickets: <c:out value="${counter.queueSize}"/> </h2>
            <br>

            <form action="counter" method="post" >
                <button type="button" class="btn btn-primary">Process A ticket</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
