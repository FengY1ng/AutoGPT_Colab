<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/12/7
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta  charset="UTF-8">
  <title>添加出库</title>
</head>
<body>
<h3>添加出库表数据</h3>
<form action="/outputinsert" method="post">
  材料编号:<input type="text" name="ID"><br>
  材料名称:<input type="text" name="name"><br>
  出库数量:<input type="text" name="num"><br>
  售卖价格:<input type="text" name="sell_price"><br>
  出库时间:<input type="text" name="date_out"><br>
  <input type="submit" value="提交信息">
</form>
</body>
</html>
