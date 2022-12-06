<%--
  Created by IntelliJ IDEA.
  User: 86182
  Date: 2022/11/27
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>修改员工信息</h3>
    <form action="/update" method="post">
        <c:forEach items="${employees}" var="e">
            id: <input type="text" name="id" value="${e.id}" readonly="true"><br>
            姓名：<input type="text" name="name" value="${e.name}"/><br>
            性别：<input type="radio" name="sex" value="男" <c:if test="${e.sex== '男'}">checked="checked"</c:if> >男
            <input type="radio" name="sex" value="女" <c:if test="${e.sex== '女'}">checked="checked"</c:if>>女
            <br>
            年龄：<input type="number" name="age" value="${e.age}"/><br>
        </c:forEach>
        <input type="submit" value="提交">
    </form>
</body>
</html>
