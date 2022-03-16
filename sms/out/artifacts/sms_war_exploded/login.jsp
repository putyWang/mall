<%@ page import="jakarta.servlet.jsp.PageContext" %><%--
  Created by IntelliJ IDEA.
  User: 小哥哥
  Date: 2022/2/5
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登录页面</title>
</head>
<body>
    ${sessionScope.message}<br>
    <h1>欢迎登录</h1>
    <hr>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        学生账号：<input type="text" name="num"><br>
        登录密码：<input type="password" name="password"><br>
        <input TYPE="submit" value="登录">
    </form>

    <a href="/sms/toRegisterServlet">注册</a>

</body>
</html>
