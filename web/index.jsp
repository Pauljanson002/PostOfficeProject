<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/14/2020
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Post Office Jaffna </title>
  </head>
  <body>
  <div class="container">
  <a href="<c:url value='/'/>" style="text-decoration: none">
  <h1 class="mx-auto">Welcome to Post Office Jaffna</h1>
  </a>
  <div class="mx-auto">
    <a href="<c:url value='/customer/index.jsp'/>">
    <button type="button" class="btn btn-primary btn-lg">Create a New Ticket </button>
    </a>
    <a href="<c:url value='staff'/>">
      <button type="button" class="btn btn-primary btn-lg">I'm a staff</button>
    </a>
  </div>
  </div>
  </body>
</html>
