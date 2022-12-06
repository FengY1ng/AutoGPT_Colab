<%--
  Created by IntelliJ IDEA.
  User: 86182
  Date: 2022/11/27
  Time: 21:06
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
<h3>设备详细信息</h3>
<a href="addEquipment.html">添加设备入库</a>
<a href="/excel">导出设备信息</a>
<table border="1px">
    <tr>
        <td>设备id</td>
        <td>设备名称</td>
        <td>设备状态</td>
        <td>设备使用人</td>
        <td>设备采购时间</td>
        <td>设备更改状态时间</td>
        <td>设备价格</td>
    </tr>
    <c:forEach items="${equipment}" var="e">
        <tr>
            <td>${e.equipmentId}</td>
            <td>${e.equipmentName}</td>
            <c:if test="${e.status== 1}"><td>设备尚未分配使用人</td></c:if>
            <c:if test="${e.status== 2}"><td>设备正常使用</td></c:if>
            <c:if test="${e.status== 3}"><td>设备已报废</td></c:if>
            <td>${e.userName}</td>
            <td>${e.createTime}</td>
            <td>${e.updateTime}</td>
            <td>${e.money}</td>
            <td>
                <a href="selectEquipmentById?equipmentId=${e.equipmentId}">增加或修改设备使用人</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>