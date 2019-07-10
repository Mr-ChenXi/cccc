<%-- 
  Created by IntelliJ IDEA. 
  2018/08/13 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jsp"%>
<html> 
<head>
    <link href="${path}/css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <%--<link rel="stylesheet" type="text/css" href="${path}/css/home.css">--%>
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript"> 
        $(function () {
            $(".addBtn").click(function () {
                window.location.href="${path}/jsp/user/add.jsp";
            })
            $(".delImg").click(function () {
                if(confirm("要删除吗？")){
                    $.ajax({
                        url:"/user/delete.action",
                        data:{uid:this.name},
                        type:"post",
                        success:function (data) {
                            console.log(data)
                            if(data=='Y'){
                                $(location).attr("href","/user/UserList.action");
                            }else{
                                alert("删除失败");
                                return false;
                            }
                        },
                        error:function () {
                            alert("请稍后再试")
                        }
                    })
                }

            })
        })


    </script> 
</head>
<body class="main"> 
    <h1>前台用户列表</h1>
    <div class="search">
        <span>
            <button class="addBtn">增加</button>
        </span>
    </div>
    <center> 
    <table border="1" cellspacing="0" cellpadding="0"> 
        <thead> 
            <td>序号</td> 
            <td>用户名</td> 
            <td>密码</td> 
            <td>邮箱</td>
            <td>性别</td>
            <td>电话号码</td> 
            <td>地址</td> 
            <td>是否激活</td> 
            <td>编辑</td>
            <td>删除</td> 
        </thead> 
        <tbody> 
            <c:forEach var="user" items="${list}" varStatus="index">
                <tr> 
                    <td>${index.index+1}</td>
                    <td>${user.username}</td> 
                    <td>${user.password}</td> 
                    <td>${user.email}</td>
                    <td>${user.sex}</td>
                    <td>${user.phone}</td> 
                    <td>${user.addr}</td>
                    <td>
                        <c:if test="${user.state==1}">已激活</c:if>
                        <c:if test="${user.state==0}">未激活</c:if>
                    </td>
                    <%--<td>${user.activestate}</td>--%>
                    <td>
                        <a href="${path}/user/getUser.action?uid=${user.uid}"><img src="<%=path%>/images/edit.gif"></a>
                    </td> 
                    <td> 
                        <img src="<%=path%>/images/del.gif" name="${user.uid}" class="delImg">
                    </td> 
                </tr> 
            </c:forEach> 
        </tbody> 
    </table>
    </center>
        <hr style="height:1px;border:none;border-top:2px solid #ccc;" />
        <!-- 分页导航栏 -->
        <!-- 分页信息 -->
        <div class="row">
            <!-- 分页文字信息，其中分页信息都封装在pageInfo中 -->
            <div class="col-md-3">
            </div>
            <!-- 分页条 -->
            <div class="pagination" style="padding-left: 700px">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <%--<li><a href="${path}/user/UserList.action?pn=1">首页</a></li>--%>
                        <c:if test="${page.hasPreviousPage }">
                            <li>
                                <a href="${path}/user/UserList.action?pn=${page.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach items="${page.navigatepageNums}" var="page_Num">
                            <c:if test="${page_Num == page.pageNum }">
                                <li class="active"><a href="#">${ page_Num}</a></li>
                            </c:if>
                            <c:if test="${page_Num != page.pageNum }">
                                <li><a href="${path}/user/UserList.action?pn=${ page_Num}">${ page_Num}</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${page.hasNextPage }">
                            <li>
                                <a href="${path}/user/UserList.action?pn=${page.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>

                        </c:if>
                            <li><a>  当前第${page.pageNum}页</a></li>
                            <li><a>共${page.total}条数据
                            <li><a>总共：${page.pages}页</a></li>
                        <%--<li><a href="${path}/user/UserList.action?pn=${page.pages}">末页</a></li>--%>
                    </ul>
                </nav>
            </div>
        </div>
</body> 
</html> 
