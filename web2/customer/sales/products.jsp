<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 6/28/2020
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/customer/header.jsp"%>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Products You can buy </h1>

    </div>

    <h2> Available items  </h2>
    <div class="table-responsive">

            <form  action="<c:url value='/customer/sales'/>" method="post">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Item Name</th>
                        <th>Price </th>
                        <th>Quantity available</th>
                        <th>Amount you want</th>
                    </tr>
                    </thead>
                    <tbody>
                <div class="form-group">
                    <c:forEach items="${products}" var="item">
                        <tr>
                            <td><c:out value="${item.id}"/></td>
                            <td><c:out value="${item.name}"/></td>
                            <td><c:out value="${item.price}"/></td>
                            <td><c:out value="${item.qty}"/></td>
                            <td><input value="0" name="<c:out value='${item.id}'/>" required class="form-control"  ></td>
                        </tr>
                    </c:forEach>
                </div>
                </table>
                <div class="form-group" >
                <button class="btn btn-success form-control" type="submit"> Request Sale </button>
                </div>
            </form>
            </tbody>

    </div>
</main>
<%@include file="/customer/footer.jsp"%>
