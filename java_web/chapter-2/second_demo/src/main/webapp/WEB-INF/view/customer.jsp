
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>客户管理</title>
</head>
<body>
    <h1>客户列表</h1>
    <table>
        <tr>
            <td>客户名称</td>
            <td>联系人</td>
            <td>电话号码</td>
            <td>邮箱地址</td>
            <td>操作</td>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.contact}</td>
                <td>${customer.telephone}</td>
                <td>${customer.email}</td>
                <td>
                    <a href="${BASE}/customer_edit?id=${customer.id}">编辑</a>
                    <a href="${BASE}/customer_delete?id=${customer.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
