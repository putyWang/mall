<%--
  Created by IntelliJ IDEA.
  User: 小哥哥
  Date: 2022/2/14
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>获取请求参数</h1>
    <hr/>

    <form action="other.do" method="get">
        姓名：<input type="text" name="name" />
        密码：<input type="text" name="password" />
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
