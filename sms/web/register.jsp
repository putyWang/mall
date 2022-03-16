<%--
  Created by IntelliJ IDEA.
  User: 小哥哥
  Date: 2022/2/5
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账号注册</title>
</head>
<body>
    ${sessionScope.message}<br>
    <form action="${pageContext.request.contextPath}/register" method="post">
        编号:<input type="text" name="id"><br>
        学生账号：<input type="text" name="num"><br>
        登录密码：<input type="password" name="password"><br>
        学生姓名：<input type="text" name="name"><br>
        学生年龄：<input type="text" name="age"><br>
        学生成绩：<input type="text" name="score"><br>
        <input TYPE="submit" value="注册">
    </form>
</body>
</html>
