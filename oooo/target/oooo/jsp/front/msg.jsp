<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="divcontent">
<table width="850px" border="0" cellspacing="0">
  <tr>
    <td style="padding:30px; text-align:center"><table width="60%" border="0" cellspacing="0" style="margin-top:70px">
      <tr>
        <td style="padding-top:30px"><font style="font-weight:bold; color:#FF0000">${message}</font><br />
            <br />
          <a href="${ pageContext.request.contextPath }/index/IndexAction.action">首页</a>
          <a href="${path}/jsp/front/login.jsp">登录</a>
          <a href="${path}/jsp/front/register.jsp">注册</a>
         </td>
      </tr>
    </table>
    <h1>&nbsp;</h1></td>
    </tr>
</table>
</div>
</body>
</html>