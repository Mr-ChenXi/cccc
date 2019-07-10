<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <%
        Cookie[] cookies = request.getCookies();
        String username = "";
        String password = "";
        if(cookies!=null && cookies.length>0){
            for (Cookie cookie : cookies){
                if("username".equals(cookie.getName())){
                    username = cookie.getValue();
                }else if("password".equals(cookie.getName())){
                    password = cookie.getValue();
                }
            }
        }
        String path = request.getContextPath();
    %>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
    <style>
        body {
            background: url("<%=path%>/images/a.jpg");
        }
    </style>
    <script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>

</head>

<body>
<div class="login">
    <!--图片 -->
    <%--<div class="photo"></div>--%>

    <div class="form">
        <span style="text-align: center;display: block">用户登录</span>
        <form action="/login.action" method="post" onsubmit="return fun()">
        <div class="content">
            <span>用户名：</span>
            <input type="text" name="username" value="<%=username %>" placeholder="请输入用户名" >

        </div>
        <div class="content">
            <span>密码：</span>
            <input type="password" name="password" value="<%=password %>" placeholder="请输入密码">

        </div>
        <!--错误提示 -->
        <div id="error" style="color: red">
            <span style="color: red">${error}</span>
        </div>
        <!-- 按钮-->
        <div class="btn">
            <button id="register">注册</button>
            <button type="submit" id="login" onclick="ock()">登录</button>
        </div>

        </form>
    </div>
</div>
</body>
<script type="text/javascript">
function fun() {
    var name= $("[name=username]").val();
    var pwd= $("[name=password]").val();
    var error= $("[id=error]");
    if(name==""){
        error.html("用户名不能为空!")
        return false;
    }else if(pwd==""){
        error.html("密码名不能为空!")
        return false;
    } else{
        return  true;
    }
}
function ock() {
    var but= $("[id=login]");
    but.submit();
}
</script>
</html>
