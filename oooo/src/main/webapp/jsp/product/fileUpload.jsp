<%--
  Created by IntelliJ IDEA.
  User: chlove
  Date: 2019-04-11
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp" %>
<html>
<script src="${path}/js/ajaxupload.js"></script>
<head>
    <title>Title</title>

    <%--<script src="${path}/js/jquery-3.3.1.min.js"></script>--%>

    <script>
     
    </script>
</head>
<body>
<img width="100" height="100" id="ImgUrl"/>
<%--<form id="formTag" enctype="multipart/form-data">--%>
<%--<div class="uploadImgBtn" id="uploadImgBtn">--%>
<%--<input class="uploadImg" type="file" name="file" id="tpfile">--%>
<%--</div>--%>
<%--</form>--%>
<%--<form id="test">--%>
<%--选择文件:<input data-role="none" type="file" name="file" width="120px">--%>
<%--<button data-role="none" onclick="testUpload();">测试</button>--%>
<%--</form>--%>
<form id="form" method="post" enctype="multipart/form-data">

<input type="file" id="image" name="file" multiple="multiple">
<%--<input type="button" value="上传文件解析" id="upload"/><br/>--%>
</form>
</body>
</html>
