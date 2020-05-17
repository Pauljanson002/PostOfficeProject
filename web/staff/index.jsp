<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
    <div class="row mt-4 pt-4">
        <div class="col">
            <c:if test="${counter.availableTickets == 0}">
                <h5 class="text-center">There are no tickets to process</h5>
            </c:if>
        </div>
    </div>

</div>
</body>
</html>
