<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<html>
<head>
    <link rel="stylesheet"  href="<%=path%>/css/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="<%=path%>/ztree/js/jquery-1.4.4.min.js"></script>

    <%--<script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>--%>
    <script type="text/javascript" src="<%=path%>/ztree/js/jquery.ztree.core.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/home.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/zTreeStyle/zTreeStyle.css">
    <script>
        var curMenu = null, zTree_Menu = null;
        var setting = {
            data: {
                simpleData: {
                    enable: true,
                    idKey : "fid",
                    pIdKey : "pid",
                    rootPId : 0
                }
            },
            key:{
                name: "name",
                url:"url",
            }
        };
        //加载ztree
        function onloadZTree() {
            var ztreeNodes;
            var data={uid:${user.uid}};
            $.ajax({
                async: true, //是否异步
                cache: false, //是否使用缓存
                data:data,
                type: 'post', //请求方式,post
                dataType: "json", //数据传输格式
                url: "/baseFunction/functionListByUid.action", //请求链接
                success: function (data) {
                    ztreeNodes=data;
                    $.fn.zTree.init($("#treeDemo"), setting, ztreeNodes);
                    zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
                },
                error: function () {
                    alert('亲，网络有点不给力呀！');
                }
            });
        }
        //初始化操作
        $(document).ready(function () {
            onloadZTree();
        });
    </script>

</head>
<body class="left">
<input type="hidden" id="uid" name="uid" value="${user.uid}">
<div>
    <ul id="treeDemo" class="ztree"></ul>
</div>
</body>
</html>
