<%--
  Created by IntelliJ IDEA.
  User: 86182
  Date: 2022/11/27
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
    </script>
</head>
<body>
<h3>员工详细信息</h3>
<a href="addEmployee.html">添加</a>
<table border="1px">
    <tr>
        <td width="200">id</td>
        <td width="200">姓名</td>
        <td width="200">年龄</td>
        <td width="200">性别</td>
        <td width="200">操作</td>
    </tr>
    <c:forEach items="${employees}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.age}</td>
            <td>${e.sex}</td>
            <td>
                <a href="deleteById?id=${e.id}">删除</a>
                <a href="selectById?id=${e.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>