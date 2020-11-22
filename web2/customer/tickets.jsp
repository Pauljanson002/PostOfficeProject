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
                            <th>Ticket Id</th>
                            <th>Staff</th>
                            <th>Reason</th>
                            <th>Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${tickets}" var="ticket">
                            <tr>
                                <td>${ticket.id}</td>
                                <td>${ticket.staff.firstName}</td>
                                <td>${ticket.reason}</td>
                                <td>${ticket.date}</td>
                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row mt-auto">
                <a href="<c:url value='/customer/create_ticket.jsp'/>">
                    <button class="btn btn-success">
                        Create Ticket
                    </button>
                </a>
            </div>

        </div>
    </main>


<%@include file="footer.jsp"%>
