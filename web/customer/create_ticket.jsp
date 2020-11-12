<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/24/2020
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
<div class="container">


    <h1 class="text-center">Welcome to Post Office Jaffna</h1>
    <h5 class="my-3">Please use the following form to open a ticket</h5>


    <div class="my-4">
        <form method="POST" action="ticket">
            <div class="form-group">
                <label for="firstName">Your First Name :</label>
                <input class="form-control" type="text" placeholder="Your Name" name="firstName" id="firstName" value="${customer.firstName}" ><br>
                <label for="lastName">Your Last Name:</label>
                <input class="form-control" type="text" placeholder="Your Last Name" name="lastName" id="lastName" value="${customer.lastName}"><br>
                <label for="icNumber">Your NIC number:</label>
                <input class="form-control" type="text" placeholder="IC number" name="icNumber" id="icNumber" value="${customer.id}"><br>
                <label for="service">Service required:</label>
                <select class="form-control" id="service" name="reason">
                    <option value="foreign post">Send Foreign Post</option>
                    <option value="telemail">Send Telemail</option>
                    <option value="parcel">Send Parcel</option>

                </select>
            </div>
            <button class="btn btn-primary" type="submit">Open a ticket</button>

        </form>
    </div>
</div>
</main>

<%@include file="footer.jsp"%>