<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/24/2020
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">


    <h1 class="text-center">Welcome to Post Office Jaffna</h1>
    <h5 class="my-3">Please use the following form to open a ticket</h5>


    <div class="my-4">
        <form method="POST" action="ticket">
            <div class="form-group">
                <label for="firstName">Your First Name :</label>
                <input class="form-control" type="text" placeholder="Your Name" name="firstName" id="firstName"><br>
                <label for="lastName">Your Last Name:</label>
                <input class="form-control" type="text" placeholder="Your Last Name" name="lastName" id="lastName"><br>
                <label for="icNumber">Your NIC number:</label>
                <input class="form-control" type="text" placeholder="IC number" name="icNumber" id="icNumber"><br>
                <label for="service">Service required:</label>
                <select class="form-control" id="service" name="service">
                    <option>Send Foreign Post</option>
                    <option>Send Telemail</option>
                    <option>Send Parcel</option>

                </select>
            </div>
            <button class="btn btn-primary" type="submit">Open a ticket</button>

        </form>
    </div>
</div>
</body>
</html>