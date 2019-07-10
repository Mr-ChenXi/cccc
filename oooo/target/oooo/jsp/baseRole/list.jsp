<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/25 0025
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>

    <script>
        $(function () {
//            $("#addBtn").click(function () {
//                window.location.href="jsp/admin/add.jsp";
//            })
//
//            $(".update").click(function () {
//                console.log( this.name);
//                location.href="/getAdminUser.action?uid="+this.name;
//            })
//            $(".delImg").click(function () {
//                if(confirm("要删除吗？")){
//                    console.log( this.id);
//                    $.ajax({
//                        url:"/delAdminUser.action",
//                        data:{uid:this.id},
//                        type:"post",
//                        success:function (data) {
//                            console.log(data)
//                            if(data=="Y"){
//                                alert("删除成功！！")
//                                location.href="/AdminuserList.action"
//                            }
//                        },
//                        error:function () {
//                            alert("请稍后再试")
//                        }
//                    })
//                }
//
//            })

            $(".distribute").click(function () {
                location.href="/baseFunction/distribute.action?rid="+this.name;
            })

//            $("#search").click(function () {
//                location.href="/findListByName.action?username="+$("#username").val();
//            })
        })
          
    </script>
</head>
<body class="main">
    <div class="search">
        <span>
           角色：<input type="text" id="cname" value="${searchObject.cname}">
        </span>
        <span>
            <button id="search">查询</button>
        </span>
        <span>
            <button id="addBtn">增加</button>
        </span>
    </div>


    <table>
        <thead>
            <td>序号</td>
            <td>角色</td>
            <td>修改</td>
            <td>删除</td>
            <td>授权</td>
        </thead>
        <c:forEach items="${list}" var="baseRole" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${baseRole.rname}</td>
                <td><img src="${path}/images/edit.gif" class="update" name="${baseRole.rid}"></td>
                <td><img src="${path}/images/del.gif" class="delete" name="${baseRole.rid}"></td>
                <td><img src="${path}/images/distribute.gif" class="distribute" name="${baseRole.rid}"></td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
