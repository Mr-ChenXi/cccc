<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
   String path = request.getContextPath();
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd E");
    String sdate = format.format(date);
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/home.css">
    <script src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>

    </script>
</head>
<body class="logo">
    <img src="<%=path%>/images/logo.jpg">
    <div class="top">
        <span>${user.username}</span>
        <span><%=sdate%></span><span><a href="#" id="logout">退出</a></span>
        <span><a href="#" id="changePassword">修改密码</a></span>
    </div>

</body>
<script>

    $(function () {
        $("#logout").click(function () {
            window.parent.location.href="/logout.action";

        })
        $("#changePassword").click(function () {
            window.parent.location.href="to_update.jsp";
        })
    })



</script>
</html>
