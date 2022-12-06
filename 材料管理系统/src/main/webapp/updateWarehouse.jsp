<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/12/5
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>更新信息</title>
</head>
<body>
<h3>修改信息</h3>
<form action="/warehouseupdatebyid" method="post">
    <c:forEach items="${warehouselist}" var="e">
        材料编码: <input type="text" name="ID" value="${e.ID}" readonly="true"><br>
        材料名称：<input type="text" name="name" value="${e.name}"><br>
        材料数量：<input type="text" name="num" value="${e.num}"><br>
        售卖价格：<input type="text" name="sell_price" value="${e.sell_price}"><br>
    </c:forEach>
    <input type="submit" value="提交">
</form>
</body>
</html>
