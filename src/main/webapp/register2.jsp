<%--
  Created by IntelliJ IDEA.
  User: zjq
  Date: 2018/11/1
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register2</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user2/doRegister" method="post">
    <table width="500px" border="1">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>昵称</td>
            <td><input type="text" name="nickname"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
