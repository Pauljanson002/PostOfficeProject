<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Customer Login</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i'/>" rel="stylesheet">
    <link href="<c:url value='/vendor/bootstrap/bootstrap.css'/> " rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="<c:url value='/auth/style.css'/>" rel="stylesheet">

</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Sign In</h5>
                    <form class="form-signin" action="<c:url value='j_security_check'/>" method="post">
                        <div class="form-label-group">
                            <input type="text" id="inputUserName" class="form-control" placeholder="UserName" required autofocus name="j_username">
                            <label for="inputUserName">User Name</label>
                        </div>

                        <div class="form-label-group">
                            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="j_password">
                            <label for="inputPassword">Password</label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/vendor/jquery/jquery.slim.js'/> "></script>
<script src="<c:url value='/vendor/bootstrap/js/bootstrap.bundle.js'/>"></script>

</body>

</html>
