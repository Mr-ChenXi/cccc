<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26 0026
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<html>
<head>

    <title>商城</title>
</head>

<frameset rows="103,*,43" border="1">
    <frame src="jsp/index/top.jsp" name="topFrame" scrolling="NO">
    <frameset cols="159,*" >
        <frame src="jsp/index/left.jsp" name="leftFrame" scrolling="YES">
        <frame src="jsp/index/main.jsp" name="mainFrame" scrolling="YES">
    </frameset>
    <frame src="jsp/index/bottom.jsp" name="bottomFrame" scrolling="NO">
</frameset>


</html>
