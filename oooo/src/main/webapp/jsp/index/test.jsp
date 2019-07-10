<%--
  Created by IntelliJ IDEA.
  User: 爸爸
  Date: 2019/6/10
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="foo" att="222"></div>
<script>

   var a= $('#foo').attr('att')
    console.log(a);

</script>
</body>
</html>
