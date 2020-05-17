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
<div class="container mt-4 pt-4">
<div class="row">
    <div class="col">
        <form>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <label for="country">Country: </label>
                    </div>
                    <div class="col">
                        <input type="text" id="country" placeholder="Enter country here" name="country">
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="weight">Weight: </label>
                    </div>
                    <div class="col">
                        <input type="text" id="weight" placeholder="Enter weight here" name="weight">
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="type">Type: </label>
                    </div>
                    <div class="col">
                        <select name="type" id="type" >
                            <option>Normal Post</option>
                            <option>Speed Post</option>
                            <option>Register Post</option>
                        </select>
                    </div>
                </div>

            <div class="row">
                <div class="col">
                    <p>Payment amount :</p>
                </div>
                <div class="col">
                    <span>0</span>
                </div>
            </div>
            </div>

        </form>

    </div>
</div>
</div>
<script src="scripts/main.js"></script>
</body>
</html>
