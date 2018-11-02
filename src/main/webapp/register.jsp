<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Please Register</title>
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
<%--background="${pageContext.request.contextPath}/images/1540815393375.jpg"--%>
<div style="margin-top: 100px">
    <h2 style="text-align: center">Register</h2>
</div>
<div class="container" id="formDiv">
    <form action="${pageContext.request.contextPath}/user/doRegister" method="post">
        <span id="userNameSpan" class="text-info"></span>
        <div class="form-group">
            <label for="userName"></label>
            <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter your name"
                   onblur="checkName()">
        </div>
        <span id="passwordSpan" class="text-info"></span>
        <div class="form-group">
            <label for="password"></label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password"
                   onblur="passwordNotNull()">
        </div>
        <span id="passwordCheckSpan" class="text-info"></span>
        <div class="form-group">
            <label for="passwordCheck"></label>
            <input type="password" class="form-control" id="passwordCheck" name="passwordCheck"
                   placeholder="Check your password" onblur="checkPassword()">
        </div>

        <div class="form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember me
            </label>
        </div>
        <br>
        <button type="submit" class="btn">Submit</button>
    </form>
</div>

</body>

<script>
    function checkName() {
        let userName = $("#userName").val();
        console.log(userName);
        userName = userName.trim();
        if (userName === "") {
            $("#userNameSpan").text("用户名不能为空").addClass("text-danger");
            return false;
        }
        else {
            $.ajax({
                type: "post",
                url: "/user/checkName",
                data: {"userName": userName},
                dataType: "json",
                success: function (data) {
                    if (data > 0) {
                        $("#userNameSpan").text("用户名已存在").addClass("text-danger");
                        return false;
                    } else {
                        $("#userNameSpan").text("√").css("color", "green");
                        return true;
                    }
                }
            });
        }
    }

    function passwordNotNull() {
        let password = $("#password").val().trim();
        if (password === "") {
            $("#passwordSpan").text("密码不能为空").addClass("text-danger");
            return false;
        }
        return true;
    }

    function checkPassword() {
        let password = $("#password").val().trim();
        let passwordCheck = $("#passwordCheck").val().trim();

        if (passwordCheck === "") {
            return false;
        }
        if (passwordCheck !== password) {
            $("#passwordSpan").text("密码不一致").addClass("text-danger");
            $("#passwordCheckSpan").text("请重新输入").addClass("text-danger");
            return false;
        }
        else {
            $("#passwordSpan").text("√").css("color", "green");
            $("#passwordCheckSpan").text("√").css("color", "green");
            return true;
        }

    }
</script>
</html>