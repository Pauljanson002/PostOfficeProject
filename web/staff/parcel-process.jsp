<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 6/6/2020
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<div class="container-fluid" data-content="center">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Parcel </h1>
        <a href="<c:url value='/staff/process'/> " class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" ><i class="fas fa-arrow-left fa-sm text-white-50"></i>Go back</a>
    </div>


    <div class="row">
        <div class="col">
            <form>
                <input name="typeOfPost" hidden value="parcel">
                <div class="form-group row">
                    <label for="inputreceiver" class="col-sm-2 col-form-label">To</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputreceiver" name="toAddress">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputsender" class="col-sm-2 col-form-label">From</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputsender" name="fromAddress">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputweight" class="col-sm-2 col-form-label">Weight</label>
                    <div class="col-sm-10">
                       <input type="number" class="form-control" id="inputweight" name="weight">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">
                        Payment :
                    </div>
                    <div class="col-sm-10">
                        <span>0</span>
                    </div>
                </div>


                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">Process</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!-- Content Row -->
    <div class="row">

        <!-- Content Column -->



    </div>

</div>
<%@include file="footer.jsp"%>
