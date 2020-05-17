<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/29/2020
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome ${pageContext.request.userPrincipal.name}</title>
    <link rel="stylesheet" href="<c:url value='/styles/bootstrap.css'/>">
</head>
<body>
<h1>Welcome ${pageContext.request.userPrincipal.name}</h1>
<input name="action" hidden type="text" value="show">
<div class="container">
    <div class="row">
        <div class="col">
            <a href="<c:url value='/master?action=show'/>">
                <button class="btn btn-primary">Show all employees</button>
            </a>
        </div>
        <div class="col">
            <button class="btn btn-primary">Create a new employee</button>
        </div>
        <div class="col">
            <button class="btn btn-primary">Update an employee information </button>
        </div>
        <div class="col">
            <button class="btn btn-primary">Remove an employee </button>
        </div>
    </div>
</div>

</body>
</html>
