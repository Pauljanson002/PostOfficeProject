<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/26/2020
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>

<div class="container-fluid" data-content="center">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Foreign Post</h1>
        <a href="<c:url value='/staff/'/> " class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" ><i class="fas fa-arrow-left fa-sm text-white-50"></i> Go back </a>
    </div>




    <!-- Content Row -->
    <div class="row">

        <div class="col">
            <form method="post" action="<c:url value='/staff/process'/> ">
                <input name="typeOfPost" hidden value="foreign-post">
                <div class="form-group row">
                    <label for="inputcountry" class="col-sm-2 col-form-label">Country</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputcountry" name="country">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputweight" class="col-sm-2 col-form-label">Weight</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="inputweight" name="weight">
                    </div>
                </div>
                <fieldset class="form-group">
                    <div class="row">
                        <legend class="col-form-label col-sm-2 pt-0">Type</legend>
                        <div class="col-sm-10">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="type" id="gridRadios1" value="normalPost" checked>
                                <label class="form-check-label" for="gridRadios1">
                                    Normal Post
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="type" id="gridRadios2" value="speedPost">
                                <label class="form-check-label" for="gridRadios2">
                                    Speed Post
                                </label>
                            </div>
                            <div class="form-check disabled">
                                <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="registerPost" disabled>
                                <label class="form-check-label" for="gridRadios3">
                                    Register Post
                                </label>
                            </div>
                        </div>
                    </div>
                </fieldset>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Payment amount
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

</div>



<%@include file="footer.jsp"%>
