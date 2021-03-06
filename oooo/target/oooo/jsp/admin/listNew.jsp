﻿<%-- 
  Created by IntelliJ IDEA. 
  2018/08/09 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jsp"%>
<html> 
<head>
    <link href="${path}/css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <%--<link rel="stylesheet" type="text/css" href="<%=path%>/css/home.css">--%>
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${path}/css/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript"> 
       
    </script> 
</head> 
<%--<input type="hidden" id="currentPage" value="${pageUtil.currentPage}"> --%>
<%--<input type="hidden" id="totalPage" value="${pageUtil.totalPage}"> --%>
<body class="main"> 
    <h1>后台用户列表</h1> 
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
            <td>编辑</td> 
            <td>删除</td>
            <td>分配</td>
        </thead> 
        <tbody> 
            <c:forEach var="adminuser" items="${list}"> 
                <tr> 
                    <td>${adminuser.uid}</td> 
                    <td>${adminuser.username}</td> 
                    <td>${adminuser.password}</td> 
                    <td> 
                        <a href="<%=path%>/AdminuserLoad?uid=${adminuser.uid}"><img src="<%=path%>/images/edit.gif"></a> 
                    </td> 
                    <td> 
                        <img src="<%=path%>/images/del.gif" id="${adminuser.uid}" class="delImg">
                    </td>
                    <td><img src="${path}/images/distribute.gif" class="distribute" name="${baseUser.userId}" ></td>
                </tr> 
            </c:forEach> 
        </tbody> 
    </table>
    </center>
    <hr style="height:1px;border:none;border-top:2px solid #ccc;" />
    <!-- 分页导航栏 -->
    <!-- 分页信息 -->
    <div class="row">
        <%--<!-- 分页文字信息，其中分页信息都封装在pageInfo中 -->--%>
        <div class="col-md-3">
            <nav aria-label="Page navigation">
                当前第：${page.pageNum}页，总共：${page.pages}页，总共：${page.total}条记录
            </nav>
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


    <div id="roleDlg" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">分配角色</h4>
                </div>
                <div class="container">
                    <form class="form-horizontal" id="roleForm"  method="post">

                        <div class="form-group">
                            <label class="col-md-2 control-label">我的角色：</label>
                            <div class="col-md-3 ">
                                <input type="hidden" id="hid" >
                                <select  style= "width:280px" id="rid" name="role" multiple="multiple"  class="form-control form-control-static "></select>
                            </div>
                        </div>
                        <div class="modal-footer col-md-6">
                            <!--用来清空表单数据-->
                            <input type="reset" name="reset" style="display: none;" />
                            <button type="button" class="btn btn-default" onclick="closeDlg()">关闭</button>
                            <button type="button" onclick="saveRole()" class="btn btn-primary">保存</button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

</body> 
</html> 
