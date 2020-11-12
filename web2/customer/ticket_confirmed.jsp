<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/25/2020
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<div class="container">
    <h1>Your Ticket has been confirmed </h1>
    <div>
        <p> Hello ! ${customer.firstName}<br>
            Ticket Id : ${ticket.id} <br>
            Counter you need to visit : ${ticket.counterId} <br>
            Please wait until your ticket number is called !<br>
        </p>
    </div>
    <div>
        <a href="index.jsp">Back </a><br>
    </div>
</div>
<%@include file="footer.jsp"%>