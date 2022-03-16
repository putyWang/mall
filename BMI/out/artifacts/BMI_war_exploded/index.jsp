
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BMI</title>
    <base href="">
    <%--导入jquery库文件--%>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <%--设置Bmi计算函数--%>
    <script type="text/javascript">
        function BmiCompute(){
            <%--创建异步对象--%>
            var xmlHttp = new XMLHttpRequest();
            <%--绑定事件--%>
            xmlHttp.onreadystatechange = function(){

                <%--判断执行结果与执行状态--%>
                if(xmlHttp.readState = 4 && xmlHttp.status == 200){

                    <%--获取对象响应数据--%>
                    var data = xmlHttp.responseText;

                    <%--更新BmiResult中的显示结果--%>
                    document.getElementById("BmiResult").innerText = data;
                }
            }

            <%--获取对应doom属性--%>
            var name = $("#name")[0].value;
            var height = $("#h")[0].value;
            var weight = $("#w")[0].value;

            <%--拼接请求与请求参数--%>
            var msg ="bmiCompute?" + "name=" + name + "&height=" + height + "&weight=" + weight;

            <%--初始请求参数--%>
            xmlHttp.open("get", msg , true);

            <%--发起请求--%>
            xmlHttp.send();
        }
    </script>
</head>

<body>
    <h1>请输入以下信息</h1>
    <hr>
        姓名：<input type="text" id="name"/><br>
        身高（m）：<input type="text" id="h"/><br>
        体重（kg）：<input type="text" id="w"/><br>
        <input type="button" value="计算Bmi" onclick="BmiCompute()">
    <hr>
    <h1 id="BmiResult">正在计算，请稍等</h1>
</body>
</html>
