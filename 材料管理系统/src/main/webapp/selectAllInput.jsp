<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/12/2
  Time: 21:59
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
    <title>入库表信息</title>
      <script type="text/javascript"></script>
  </head>
  <body>
  <h3>入库表信息</h3>
  <a href="addInput.html">添加入库信息</a><br>
  <a href="/inputexcel">导出入库信息表</a><br>
  <a href="/inputclear">清空入库表</a><br>
  <a href="index.jsp">返回首页</a>
  <table class="table table-bordered" >
    <tr>
      <td>材料编码</td>
      <td>材料名称</td>
      <td>材料数量</td>
      <td>进货价格</td>
      <td>进货时间</td>
    </tr>
    <c:forEach items="${inputlist}" var="e">
      <tr>
        <td>${e.ID}</td>
        <td>${e.name}</td>
        <td>${e.num}</td>
        <td>${e.trade_price}</td>
        <td>${e.date_in}</td>
        <td>
          <a href="/inputdeletebyid?ID=${e.ID}">删除</a>
            <a href="/inputupdate?ID=${e.ID}">修改</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
