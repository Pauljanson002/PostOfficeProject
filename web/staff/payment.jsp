<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 7/3/2020
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col">
            <p>
                Invoice to :
            </p>
        </div>
        <div class="col">
            <c:out value="${ticket.customer.firstName}"/>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p>Amount Have to be paid :  </p>

        </div>
        <div class="col">
            <p><c:out value="${price}" /> </p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p>Date : </p>

        </div>
        <div class="col">
            <p><c:out value="${ticket.date}" /> </p>
        </div>
    </div>
    <div class="row">
        <div class="col mx-auto">
            <p> Thank You </p>
        </div>
    </div>
    <div class="row">
        <a href="<c:url value='/staff'/>">
            <button class="btn btn-primary">
                Process
            </button>
        </a>
    </div>
</div>
<%@include file="footer.jsp"%>