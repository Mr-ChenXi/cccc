<%-- 
  Created by IntelliJ IDEA. 
  2019/04/14 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/orders/update.action"> 
    <h1>修改病人信息</h1> 
    <input type="hidden" name="oid" value="${orders.oid}"> 
    <div class="update"> 
        <div class="left"> 
            <span></span> 
            <input type="text" name="total" value="${orders.total}"> 
        </div> 
        <div class="right"> 
            <span></span> 
            <input type="date" name="ordertime" value="${orders.ordertime}"> 
        </div> 
        <div class="left"> 
            <span></span> 
            <input type="text" name="state" value="${orders.state}"> 
        </div> 
        <div class="right"> 
            <span></span> 
            <input type="text" name="name" value="${orders.name}"> 
        </div> 
        <div class="left"> 
            <span></span> 
            <input type="text" name="phone" value="${orders.phone}"> 
        </div> 
        <div class="right"> 
            <span></span> 
            <input type="text" name="addr" value="${orders.addr}"> 
        </div> 
        <div class="left"> 
            <span></span> 
            <input type="text" name="uid" value="${orders.uid}"> 
        </div> 
        <div class="right"> 
        </div> 
        <div id="error"></div> 
        <div class="buttons"> 
            <input type="submit" value="提交"> 
            <input type="button" onclick="history.back()" value="返回"> 
        </div> 
    </div> 
</form> 
</body> 
</html> 
 
