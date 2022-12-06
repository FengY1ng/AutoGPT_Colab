<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/12/4
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<h3>修改入库信息</h3>
<form action="/inputupdatebyid" method="post">
    <c:forEach items="${inputlist}" var="e">
        材料编码: <input type="text" name="ID" value="${e.ID}" readonly="true"><br>
        材料名称：<input type="text" name="name" value="${e.name}"><br>
        材料数量：<input type="text" name="num" value="${e.num}"><br>
        进货价格：<input type="text" name="trade_price" value="${e.trade_price}"><br>
        进货时间：<input type="text" name="date_in" value="${e.date_in}"><br>
    </c:forEach>
    <input type="submit" value="提交">
</form>
</body>
</html>
