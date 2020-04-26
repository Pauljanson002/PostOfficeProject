<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/26/2020
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<section>

    <h1>Login Form</h1>
    <p>Please enter a username and password to continue.</p>
    <form action="j_security_check" method="post">
        <label>Username</label>
        <input type="text" name="j_username"><br>
        <label>Password</label>
        <input type="password" name="j_password"><br>
        <label>&nbsp;</label>
        <input type="submit" value="Login">
    </form>

</section>

</html>
