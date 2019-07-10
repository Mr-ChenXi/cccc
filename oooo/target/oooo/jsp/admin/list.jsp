<%-- 
  Created by IntelliJ IDEA. 
  2018/08/09 
  To change this template use File | Settings | File Templates. 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/common.jsp" %>
<html>
<head>
    <link href="${path}/css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <%--<link rel="stylesheet" type="text/css" href="<%=path%>/css/home.css">--%>
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${path}/css/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $(function () {
          $("#addBtn").click(function () {
              window.location.href="jsp/admin/add.jsp";
          })

            $(".update").click(function () {
                console.log( this.name);
              location.href="/getAdminUser.action?uid="+this.name;
            })
            $(".delImg").click(function () {
                if(confirm("要删除吗？")){
                    console.log( this.id);
                    $.ajax({
                        url:"/delAdminUser.action",
                        data:{uid:this.id},
                        type:"post",
                        success:function (data) {
                        console.log(data)
                            if(data=="Y"){
                                alert("删除成功！！")
                                location.href="/AdminuserList.action"
                            }
                        },
                        error:function () {
                            alert("请稍后再试")
                        }
                    })
                }

            })
            
            $(".distribute").click(function () {
                location.href="baseRole/distribute.action?uid="+this.name;
            })

            $("#search").click(function () {
                location.href="/findListByName.action?username="+$("#username").val();
            })
      })
    </script>
</head>
<%--<input type="hidden" id="currentPage" value="${pageUtil.currentPage}"> --%>
<%--<input type="hidden" id="totalPage" value="${pageUtil.totalPage}"> --%>
<body class="main">
<h1>后台用户列表</h1>
<div class="search">
       <span>
            用户名：<input type="text" id="username" value="">
        </span>
    <span>
            <button id="search">查询</button>
        </span>
    <span>
            <button class="addBtn"  id="addBtn">增加</button>
        </span>
</div>
<center>
    <table border="1" cellspacing="0" cellpadding="0">
        <thead>
        <td>序号</td>
        <td>用户名</td>
        <td>密码</td>
        <td>性别</td>
        <td>科室</td>
        <td>编辑</td>
        <td>删除</td>
        <td>分配</td>
        </thead>
        <tbody>
        <c:forEach var="adminuser" items="${list}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${adminuser.username}</td>
                <td>${adminuser.password}</td>
                <td>
                    <c:if test="${adminuser.sex==1}">男</c:if>
                    <c:if test="${adminuser.sex==2}">女</c:if>
                    <c:if test="${adminuser.sex==3}">未知</c:if>
                </td>
                <td>${adminuser.baseDept.deptName}</td>
                <td>
                    <img src="<%=path%>/images/edit.gif" class="update" name="${adminuser.uid}"></a>
                </td>
                <td>
                    <img src="<%=path%>/images/del.gif" id="${adminuser.uid}" class="delImg">
                </td>
                <td><img src="${path}/images/distribute.gif" class="distribute" name="${adminuser.uid}"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
<hr style="height:1px;border:none;border-top:2px solid #ccc;"/>
<!-- 分页导航栏 -->
<!-- 分页信息 -->
<div class="row">
    <%--<!-- 分页文字信息，其中分页信息都封装在pageInfo中 -->--%>
    <div class="col-md-3">
    </div>
    <!-- 分页条 -->
    <div class="page text-right" style="margin-top: 40px">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <%--<li><a href="${path}/admin/AdminuserList.action?pn=1">首页--%>
                </a>
                </li>
                <c:if test="${page.hasPreviousPage}">
                    <li>
                        <a href="${path}/admin/AdminuserList.action?pn=${page.pageNum-1}">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach items="${page.navigatepageNums}" var="page_Num">
                    <c:if test="${page_Num == page.pageNum}">
                        <li class="active"><a href="#">${ page_Num}</a></li>
                    </c:if>
                    <c:if test="${page_Num != page.pageNum }">
                        <li><a href="${path}/admin/AdminuserList.action?pn=${ page_Num}">${ page_Num}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.hasNextPage}">
                    <li>
                        <a href="${path}/admin/AdminuserList.action?pn=${page.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
</body>
</html> 
