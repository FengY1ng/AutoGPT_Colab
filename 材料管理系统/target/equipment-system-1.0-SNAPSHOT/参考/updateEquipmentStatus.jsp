<%--
  Created by IntelliJ IDEA.
  User: 86182
  Date: 2022/11/27
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>修改设备状态</h3>
    <form action="/updateStatus" method="post">
        <c:forEach items="${equipment}" var="e">
            id: <input type="text" name="equipmentId" value="${e.equipmentId}" readonly="true"><br>
            设备名称：<input type="text" name="equipmentName" value="${e.equipmentName}"/><br>
            设备状态：
            <select name="status">
                <option value="1" <c:if test="${e.status== 1}">selected</c:if> >设备未分配使用人</option>
                <option value="2" <c:if test="${e.status== 2}">selected</c:if> >设备分配使用人</option>
                <option value="3" <c:if test="${e.status== 3}">selected</c:if> >设备报废</option>
            </select>
            <br>
<%--            使用人：<input type="text" name="userName" value="${e.userName}"/><br>--%>
            使用人：
            <select name="userName">
                <c:forEach items="${employees}" var="em">
                    <option value="${em.name}">${em.name}</option>
                </c:forEach>
            </select>
        </c:forEach>
        <input type="submit" value="提交">
    </form>
</body>
</html>
