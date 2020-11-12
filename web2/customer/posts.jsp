<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 6/7/2020
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<main class="col-md-9 ml-sm-auto col-lg-10 px-md-4 mt-5">
    <div class="container">
        <div class="row">
            <div class="table-responsive">
                <table class="table table-striped table-sm" id="ticketTable">
                    <thead>
                    <tr>
                        <th>Post Id</th>
                        <th>Timestamp</th>
                        <th>Staff </th>
                        <th>To</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${posts}" var="post">
                        <tr>
                            <td>${post.postId}</td>
                            <td>${post.timestamp}</td>
                            <td>${post.staff.firstName}</td>
                            <td>${post.toAddress}</td>

                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>


    </div>
</main>


<%@include file="footer.jsp"%>
