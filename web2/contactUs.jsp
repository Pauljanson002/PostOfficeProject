<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/14/2020
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Post Office Jaffna</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value='/vendor/bootstrap/bootstrap.css'/>" rel="stylesheet">
    <%--  <link href="<c:url value='/css/sb-admin-2.min.css'/>" rel="stylesheet">--%>
    <link href="<c:url value='/css/frontpage.css'/> " rel="stylesheet">

    <!-- Custom style for tables -->
    <%--  <link href="<c:url value= '/vendor/datatables/dataTables.bootstrap4.min.css'/>" rel="stylesheet">--%>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Post Office Jaffna </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='index.jsp'/> ">Home
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='aboutUs.jsp'/>">About
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value='contactUs.jsp'/> ">Contact</a>
                    <span class="sr-only">(current)</span>
                </li>
            </ul>
        </div>
    </div>
</nav>

<header>
    <h1 >CONTACT US</h1>
</header>

<!-- Page Content -->
<section class="py-5">
    <div class="container">
        <div class="row">
            <div>
                <p class="font1">If you have any queries or clarifications on the services offered by our Department, please feel free to contact us using any of the following methods.</p>
                <ul style="text-shadow: forestgreen;" class="font2">
                    <li><b>Contacts :</b> <span class="glyphicon glyphicon-phone-alt"></span><span>021-2222250 (Tel)</span></li>
                    <li><b>Email : </b><span class="glyphicon glyphicon-envelope"></span> info@slpost.lk / pmg@slpost.lk</li>
                    <li><b>Address :<span class="glyphicon glyphicon-map-marker"></span></b>Post Master General ,<br>
                        <span style="padding-left: 90px;"></span> Head Quarters ,<br>
                        <span style="padding-left: 90px;"></span>KKS Road ,<br>
                        <span style="padding-left: 90px;"></span>Jaffna ,<br>
                        <span style="padding-left: 90px;"></span>Sri Lanka.
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>
<script src="<c:url value='/vendor/jquery/jquery.slim.js'/> "></script>
<script src="<c:url value='/vendor/bootstrap/js/bootstrap.bundle.js'/> "></script>
</body>

</html>

