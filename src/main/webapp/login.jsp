<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Please Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style type="text/css">
        #formDiv {
            width: 400px;
            height: 300px;
            margin-top: 100px;
        }
    </style>
</head>
<body>
<h2 style="text-align: center;margin-top: 100px">Login</h2>
<div class="container" id="formDiv">
    <form action="${pageContext.request.contextPath}/user/checkLogin" method="post">
        <div class="form-group">
            <label for="userName"></label>
            <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter your name">
        </div>
        <div class="form-group">
            <label for="password"></label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password">
        </div>
        <div class="form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember me
            </label>
        </div>
        <br>
        <button type="submit" class="btn">Submit</button>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        &emsp;&emsp;&emsp;&ensp;

        <button type="button" class="btn btn-secondary" id="registerBtn">Register</button>
        <a href="${pageContext.request.contextPath}/user2/register">测试</a>
    </form>
</div>
</body>
<script>
    var userName = $("#userName").val();
    var password = $("#password").val();


    $(document).ready(function () {
        $("#registerBtn").click(function () {
            window.location.href = "/user/register";
        });
    });
</script>
</html>