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
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value='aboutUs.jsp'/>">About
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='contactUs.jsp'/> ">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<header>
    <h1 >ABOUT US</h1>
</header>

<!-- Page Content -->
<section class="py-5">
    <div class="container">
        <div class="row">
            <div>
                <h2 class="heading">Our Vision</h2>
                <span class="font1">Our vision is to become the most distinctive institution in Asia to provide fully productive and quality Postal service based on modern technology as to customer delight.</span>
            </div>
        </div>
        <div class="row">
            <div>
                <h2 class="heading">Our Mission</h2>
                <p class="font1">Our mission is to provide an attractive postal service locally and internationally using resources efficiently in partnership with the private sector by using resources efficiently, introducing modern technology, motivating the staff in a pleasing working environment while adhering to productivity concepts and winning the trust of customers by creating new services and improving existing services.</p>
            </div>
        </div>
        <div class="row">
            <div>
                <h2 class="heading">Major Functions</h2>
                <ol type="1" class="font1">
                    <li>Provision of an efficient and reliable service in tandem with all stakeholders as a team under any environmental and social condition under the guidance of the leadership and the promotion of income.</li>
                    <li>Formulation and implementation of a strategic plan focused on new technological market and that advances the cause of the postal service in collaboration with the relevant stake holders.</li>
                    <li>Bringing about an attitudinal change for the provision of a dignified service, updating intrinsic value systems of the Sri Lanka Post as a flagship communication entity of the state sector.</li>
                    <li>Deploying the disciplined staff empowered by continuous training and a system of methodical performance appraisal in such a way to consolidate the public trust.</li>
                    <li>Becoming the best postal hub of SriLanka by providing a more efficient service through proper study of work, income-based grading and employee motivation.</li>
                    <li>Making the post office network a commercial center providing multi-purpose services that can attract tourists and win public trust.</li>
                    <li>Converting the postal service which has earned the confidence of the consumer by providing a door to door service into a more qualitative and more efficient service by employing modern marketing strategies.</li>
                    <li>Achieving institutional improvement   by the optimum use of technology with local and foreign assistance.</li>
                    <li>Making the consumer delighted by offering services in a pleasing and attractive office environment.</li>
                    <li>Formulating laws that ensure the monopoly in the delivery of letters and give competitive edge and efficient acceptance, transportation and distribution of postal items.</li>
                    <li>Enhancing quality and effectiveness of services provided by making use of rapidly developing infrastructure facilities.</li>
                    <li>Motivating the staff by implementing a methodical promotion procedure and transferring system for the provision of quality and efficient consumer service.</li>
                    <li>Introducing a viable and transparent technology-based audit and investigation system agreeable to all.</li>
                    <li>Efficiently employing the support services making timely and forthright decisions with the relevant parties, while innovatively absorbing the advantages of the rapidly growing advertising market.</li>
                    <li>Expanding the postal service to satisfy the needs of the Sri Lankans living abroad.</li>
                    <li>Gaining competitive advantage by reorganizing the organizational structure and formulating the relevant laws.</li>
                    <li>Gainfully employing creative contribution of trade unions for the betterment of the institution and establish industrial peace.</li>
                    <li>With the dawn of peace, promoting postal services by effectively deploying the skilled workforce in communication and social welfare activities.</li>
                </ol>
            </div>
        </div>
        <div class="row">
            <div>
                <ul type="square" class="font2" >
                    <li>Currently we have a total of 313 Sub Post Offices in our district.</li>
                    <li>Today it has grown in to a huge organization with more than 1,000 employees. </li>
                    <li>Through the 313 offices we provide a variety of services.</li>
                </ul>
            </div>
        </div>
    </div>
</section>
<script src="<c:url value='/vendor/jquery/jquery.slim.js'/> "></script>
<script src="<c:url value='/vendor/bootstrap/js/bootstrap.bundle.js'/> "></script>
</body>

</html>

