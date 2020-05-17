<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 4/28/2020
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
    <%
        session.invalidate();
        response.sendRedirect("index.jsp");
    %>
    </body>
</html>