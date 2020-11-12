<%--
  Created by IntelliJ IDEA.
  User: Paul Janson
  Date: 6/7/2020
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</div>
</div>
<script src="<c:url value='/vendor/jquery/jquery.min.js'/> "></script>
<script src="<c:url value='/vendor/jquery-easing/jquery.easing.min.js'/> "></script>
<script src="<c:url value='/vendor/bootstrap/js/bootstrap.bundle.js'/>" ></script>
<script src="<c:url value='/vendor/datatables/jquery.dataTables.min.js'/> "></script>
<script src="<c:url value='/vendor/datatables/dataTables.bootstrap4.min.js'/> "></script>
<script>
    $(document).ready(function () {
        $("#ticketTable").DataTable();
    });
</script>
<script src="./customeradmin_files/feather.min.js.download"></script>
<script src="./customeradmin_files/Chart.min.js.download"></script>
<script src="./customeradmin_files/dashboard.js.download"></script>

</body></html>
