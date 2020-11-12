<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 6/19/2020
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register </title>
    <link rel="stylesheet" href="<c:url value='/css/register.css'/>">
    <link rel="stylesheet" href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/> ">
    <link rel="stylesheet" href="<c:url value='/vendor/bootstrap/bootstrap.css'/> ">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-10 col-xl-9 mx-auto">
            <div class="card card-signin flex-row my-5">
                <div class="card-img-left d-none d-md-flex" style="background: url('<c:url value="img/register.jpg"/>')">

                    <!-- Background image for card set in CSS! -->
                </div>
                <div class="card-body">
                    <h5 class="card-title text-center">Register</h5>
                    <form class="form-signin" action="<c:url value='/register'/> " method="post">
                        <div class="form-label-group">
                            <input type="text" id="inputID" class="form-control" placeholder="NIC number" required autofocus name="id">
                            <label for="inputID">ID </label>
                        </div>

                        <div class="form-label-group">
                            <input type="text" id="inputFirstName" class="form-control" placeholder="First Name" required name="firstName">
                            <label for="inputFirstName">First Name</label>
                        </div>
                        <div class="form-label-group">
                            <input type="text" id="inputLastName" class="form-control" placeholder="Last Name" required name="lastName">
                            <label for="inputLastName">Last Name</label>
                        </div>


                        <hr>

                        <div class="form-label-group">
                            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="passWord">
                            <label for="inputPassword">Password</label>
                        </div>

                        <div class="form-label-group">
                            <input type="password" id="inputConfirmPassword" class="form-control" placeholder="Password" required>
                            <label for="inputConfirmPassword">Confirm password</label>
                        </div>

                        <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
                        <a class="d-block text-center mt-2 small" href="<c:url value='/customer'/>">Sign In</a>
                        <hr class="my-4">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/vendor/jquery/jquery.slim.min.js'/> "></script>
<script src="<c:url value='/vendor/bootstrap/js/bootstrap.bundle.min.js'/> "></script>
</body>
</html>
