<%-- 
  Created by IntelliJ IDEA. 
  2018/08/09 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<% 
    String path = request.getContextPath(); 
%> 
<html> 
<head> 
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/home.css"> 
    <script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script> 
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url:"/baseDept/deptList.action",
                type:"post",
                dataType:"json",
                success:function (data) {
                    console.log(data)
                    $("#deptid").append("<option value='0'>请选择科室</option>");
                    $(data).each(function () {
                        $("#deptid").append(
                            "<option value='"+this.deptId+"'>"
                            + this.deptName + "</option>");
                      $("#deptid").val(${adminuser.deptid})
                    })

                },error:function () {
                    alert("错误！！！")
                }
            })

            $("#ok").click(function () {
                var username=$("#username").val();
                var password= $("#password").val();
                var uid=$("#uid").val();
                var sex= $("#sex option:selected").val();
                var deptid= $("#deptid option:selected").val();
                $.ajax({
                    url:"/updateAdminUser.action",
                    data:{
                        uid:uid,
                        username:username,
                        password:password,
                        sex:sex,
                        deptid:deptid
                    },
                    type:"post",
                    success:function (data) {
                        if(data=="Y"){
                            alert("修改成功")
                            window.history.back();
                        }
                    },error:function () {
                        alert("错误")
                    }
                })
            })
        })

    </script>
</head> 

<input type="hidden" id="uid" value="${adminuser.uid}"> 
<body class="main"> 
    <h1>编辑后台用户</h1> 
    <div class="edit"> 
        <div class="editleft"> 
            <span>用户名</span> 
            <input type="text" id="username" value="${adminuser.username}">
        </div> 
        <div class="editright"> 
            <span>密码</span> 
            <input type="text" id="password" value="${adminuser.password}"> 
        </div>
        <div class="editleft">
            <span>性别</span>
            <select id="sex" name="sex">
                <option value="1">男</option>
                <option value="2">女</option>
                <option value="3">未知</option>
            </select>
        </div>
        <div class="editright">
            <span>部门</span>
            <select name="deptid" id="deptid"></select>
        </div>
        <div id="error"></div> 
        <div class="buttons"> 
            <button id="ok">确定</button> <button onclick="history.back()">返回</button> 
        </div> 
    </div> 
</body> 
</html> 
 
