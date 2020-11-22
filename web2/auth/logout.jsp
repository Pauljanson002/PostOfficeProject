<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/26/2020
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("../index.jsp");
%>

</body>
</html>
