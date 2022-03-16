
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BMI</title>
    <base href="">
    <%--导入jquery库文件--%>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <%--设置Bmi计算函数--%>
    <script type="text/javascript">
        $(function(){
            $("#btn").click(function (){
                var name = $("#name").val();
                var height = $("#h").val();
                var weight = $("#w").val();
                $.ajax({
                    url:"bmiCompute",
                    data:{"name":name,"height":height,"weight":weight},
                    dataType:"text",
                    success:function (data){
                        $("#BmiResult").text(data)
                                }
                            }
                        )
                    }
                )
            }
        )
    </script>
</head>

<body>
    <h1>请输入以下信息</h1>
    <hr>
        姓名：<input type="text" id="name"/><br>
        身高（m）：<input type="text" id="h"/><br>
        体重（kg）：<input type="text" id="w"/><br>
        <input type="button" value="计算Bmi" id="btn">
    <hr>
    <h1 id="BmiResult">正在计算，请稍等</h1>
</body>
</html>
