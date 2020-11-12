<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 6/12/2020
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<div class="container-fluid" data-content="center">
    <input hidden name="action" value="show">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Employees</h1>

    </div>


    <div class="row">

        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>User Name</th>
                    <th>Role</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>User Name</th>
                    <th>Role</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="item" items="${employees}">
                    <tr>
                        <td>
                            <a href="<c:url value='/master/employees?id=${item.id}' />"><c:out value="${item.id}"/></a>
                        </td>
                        <td><c:out value="${item.firstName}"/></td>
                        <td><c:out value="${item.lastName}"/></td>
                        <td><c:out value="${item.userName}"/></td>
                        <td><c:out value="${item.roleName}"/></td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>

        </div>


    </div>
    <div class="row">
        <div class="col mx-auto">
            <a href="<c:url value='/master/addEmployee.jsp'/> ">
                <button class="btn btn-primary">Add a new employee </button>
            </a>
        </div>
    </div>

</div>
<%@include file="footer.jsp"%>