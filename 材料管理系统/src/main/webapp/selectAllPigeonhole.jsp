<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/12/6
  Time: 11:56
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
    <title>汇总表</title>
</head>
<body>
<h3>汇总表信息</h3>
<a href="/pigeonholeselect">导入汇总表</a><br>
<a href="/pigeonholeexcel">打印月汇总信息表</a><br>
<a href="/pigeonholeclear">清空汇总表</a><br>
<a href="head.jsp">返回首页</a>
<table class="table table-bordered" >
    <tr>
        <td>材料编码</td>
        <td>材料名称</td>
        <td>材料数量</td>
        <td>进出类型</td>
        <td>进出时间</td>
    </tr>
    <c:forEach items="${pigeonholelist}" var="a">
        <tr>
            <td>${a.ID}</td>
            <td>${a.name}</td>
            <td>${a.num}</td>
            <td>${a.state}</td>
            <td>${a.date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
