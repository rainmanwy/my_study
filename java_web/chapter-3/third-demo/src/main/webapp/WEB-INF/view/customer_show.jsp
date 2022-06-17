<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>客户管理 - 查看客户</title>
</head>
<body>

<h1>查看客户界面</h1>

<table>
    <!--tr>
        <td>客户名称</td>
        <td>联系人</td>
        <td>电话号码</td>
        <td>邮箱地址</td>
        <td>操作</td>
    </tr-->

        <tr>
            <td>客户名称: </td><td>${customer.name}</td>
        </tr>
        <tr>
            <td>联系人: </td><td>${customer.contact}</td>
        </tr>
        <tr>
            <td>电话号码: </td><td>${customer.telephone}</td>
        </tr>
        <tr>
            <td>邮箱: </td><td>${customer.email}</td>
        </tr>
</table>

<h2><a href="${BASE}/customer">返回</a></h2>

</body>
</html>