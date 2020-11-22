<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 7/3/2020
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/staff/header.jsp"%>
<div class="container-fluid">

    <form method="post" action="<c:url value='/sales/add'/>">


        <div class="form-group row">
            <label for="inputFirstName" class="col-sm-2 col-form-label">Product Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputFirstName" placeholder="Product Name" name="name">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputLastName" class="col-sm-2 col-form-label">Price</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="inputLastName" placeholder="Price" name="price">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputUserName" class="col-sm-2 col-form-label">Qty available</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="inputUserName" placeholder="Qty" name="qty">
            </div>
        </div>


        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Add </button>
            </div>
            <div class="col-sm-2">
                <a href="<c:url value='/sales'/>">
                    <button type="button" class="btn btn-primary" >Cancel</button>
                </a>
            </div>
        </div>
    </form>
</div>

<%@ include file="/staff/footer.jsp"%>