<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 6/6/2020
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<div class="container-fluid" data-content="center">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Tele Mail</h1>
        <a href="<c:url value='/staff/process'/> " class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" ><i class="fas fa-arrow-left fa-sm text-white-50"></i>Go back</a>
    </div>


    <div class="row">
        <div class="col">
        <form action="<c:url value='/staff/process'/>" method="post">
            <input name="typeOfPost" hidden value="telemail">
            <div class="form-group row">
                <label for="inputreceiver" class="col-sm-2 col-form-label">To</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputreceiver" name="fromAddress">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputsender" class="col-sm-2 col-form-label">From</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputsender" name="toAddress">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputmessage" class="col-sm-2 col-form-label">Message</label>
                <div class="col-sm-10">
                    <textarea  class="form-control" id="inputmessage" name="message"></textarea>
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
