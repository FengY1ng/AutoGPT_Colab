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
    <meta charset="UTF-8">
    <title>添加入库表数据</title>
</head>
<body>

<h3>添加入库表数据</h3>
<form action="/inputinsert" method="post">
    材料编号:<input type="text" name="ID"><br>
    材料名称:<input type="text" name="name"><br>
    入库数量:<input type="text" name="num"><br>
    进货价格:<input type="text" name="trade_price"><br>
    入库时间:<input type="text" name="date_in"><br>
    <input type="submit" value="提交信息">
</form>

</body>
</html>
