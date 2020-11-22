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
        <h1 class="h3 mb-0 text-gray-800">Sales Requests </h1>

    </div>




    <!-- Content Row -->
    <div class="row">

        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Request ID</th>
                    <th>Customer ID</th>
                    <th>Amount </th>
                    <th>Date Requested </th>
                    <th>Process</th>

                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Request ID</th>
                    <th>Customer ID</th>
                    <th>Amount </th>
                    <th>Date Requested </th>
                    <th>Process</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="request" items="${requests}">
                    <tr>
                        <td>
                            <c:out value="${request.id}"/>
                        </td>
                        <td><c:out value="${request.customer.id}"/></td>
                        <td><c:out value="${request.amount}"/></td>
                        <td><c:out value="${1+1}"/></td>
                        <td><a href="<c:url value='/sales/view?id=${request.id}'/> "><button class="btn btn-primary"> Process </button></a>  </td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>

        </div>

    </div>
    <div class="row">
        <a href="<c:url value='/sales/addProducts.jsp'/>">
            <button class="btn btn-primary">
                Add new products
            </button>
        </a>
    </div>

</div>

<%@ include file="/staff/footer.jsp"%>
