<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/12/5
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="./bootstrap-3.4.1-dist/css/bootstrap.css">
<head>
    <meta charset="UTF-8">
    <title>总库存信息</title>
    <script type="text/javascript"></script>
</head>
<body>
<h3>总库存信息</h3>
<a href="/warehouseexcel">导出总库信息表</a>(清空入库表)<br>
<a href="index.jsp">返回首页</a>
<table class="table table-bordered" >
    <tr>
        <td>材料编码</td>
        <td>材料名称</td>
        <td>库存数量</td>
        <td>售货价格</td>
    </tr>
    <c:forEach items="${warehouselist}" var="a">
        <tr>
            <td>${a.ID}</td>
            <td>${a.name}</td>
            <td>${a.num}</td>
            <td>${a.sell_price}</td>
            <td>
                <a href="/warehousedeletebyid?ID=${a.ID}">删除</a>
                <a href="/warehouseupdate?ID=${a.ID}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
