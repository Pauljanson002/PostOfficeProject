<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 7/3/2020
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp"%>
<div class="container-fluid" data-content="center">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Add employee </h1>

    </div>


    <div class="row">

        <form method="post" action="<c:url value='/master/employees/add'/>">

            <div class="form-group row">
                <label for="inputid" class="col-sm-2 col-form-label">Staff ID </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputid" placeholder="id " name="id">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputFirstName" class="col-sm-2 col-form-label">First Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputFirstName" placeholder="first Name" name="firstName">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputLastName" class="col-sm-2 col-form-label">Last Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputLastName" placeholder="last Name" name="lastName">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputUserName" class="col-sm-2 col-form-label">User Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputUserName" placeholder="user Name" name="userName">
                </div>
            </div><div class="form-group row">
            <label for="inputStaffRole" class="col-sm-2 col-form-label">Role </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputStaffRole" placeholder="Role" name="roleName"  required>
            </div>
        </div>

            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">Add </button>
                </div>
            </div>
        </form>


    </div>

</div>
<%@ include file="footer.jsp"%>
