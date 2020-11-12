<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 6/30/2020
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/staff/header.jsp"%>
<div class="container-fluid" data-content="center">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Sales Request </h1>
        <a href="<c:url value='/sales/'/> " class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" ><i class="fas fa-arrow-left fa-sm text-white-50"></i> Go back </a>
    </div>




    <!-- Content Row -->
    <div class="container">
        <div class="row">
            <div class="col-6">
                <div class="row">
                    id :
                </div>
                <div class="row">
                    Customer:
                </div>
                <div class="row">
                    Amount:
                </div>
                <div class="row">
                    Products:
                </div>

            </div>
            <div class="col-6">
                <div class="row">
                    <c:out value="${request.id}"/>
                </div>
                <div class="row">
                    <c:out value="${request.customer.firstName}"/>
                </div>
                <div class="row">
                    <c:out value="${request.amount}"/>
                </div>
                <div class="row">
                    <div class="container">
                        <c:forEach items="${request.products}" var="product">
                        <div class="row">
                            <div class="col">
                                <c:out value="${product.key}"/>  :
                            </div>
                            <div class="col">
                                <c:out value="${product.value}"/>
                            </div>
                        </div>
                    </c:forEach>
                    </div>

                </div>
            </div>
        </div>
        <div class="row">
            <a href="<c:url value='/sales/process?id=${request.id}' />">
                <button class="btn btn-primary">Process</button>
            </a>
        </div>
    </div>


</div>

<%@ include file="/staff/footer.jsp"%>
