<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/12/3
  Time: 14:38
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
    <title>出库表信息！！！</title>
    <script type="text/javascript"></script>
</head>
<body>
<h3>出库表信息</h3>
<a href="addOutput.jsp">添加出库信息</a><br>
<a href="/outputexcel">导出出库信息表</a><br>
<a href="/outputclear">清空出库表</a><br>
<a href="head.jsp">返回首页</a>
<table class="table table-bordered" >
    <tr>
        <td>材料编码</td>
        <td>材料名称</td>
        <td>售货数量</td>
        <td>售货价格</td>
        <td>售货时间</td>
    </tr>
    <c:forEach items="${outputlist}" var="a">
        <tr>
            <td>${a.ID}</td>
            <td>${a.name}</td>
            <td>${a.num}</td>
            <td>${a.sell_price}</td>
            <td>${a.date_out}</td>
            <td>
                <a href="/outputdeletebyid?ID=${a.ID}">删除</a>
                <a href="/outputupdate?ID=${a.ID}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
