<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/12/6
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>首页</title>
<meta content="IE=edge">
<link rel="stylesheet" href="css/style.css">
<body>
<h2>欢迎使用装饰材料管理系统</h2>
<div class="navigation">
    <div class="menuToggle"></div>
    <ul>
        <li class="list active">
            <a href="#" style="--clr: #f44336;">
                <div class="icon">
                    <span class="iconfont">&#xe603;</span>
                </div>
                <span class="text">Home</span>
            </a>
        </li>
        <li class="list">
            <a href="#" style="--clr: #ffa117;">
                <div class="icon">
                    <span class="iconfont">&#xe61c;</span>
                </div>
                <span class="text">About</span>
            </a>
        </li>
        <li class="list">
            <a href="#" style="--clr: #0fc70f;">
                <div class="icon">
                    <span class="iconfont">&#xe60f;</span>
                </div>
                <span class="text">Message</span>
            </a>
        </li>
        <li class="list">
            <a href="#" style="--clr: #2196f3;">
                <div class="icon">
                    <span class="iconfont">&#xe60e;</span>
                </div>
                <span class="text">Photos</span>
            </a>
        </li>
        <li class="list">
            <a href="#" style="--clr: #088f82;">
                <div class="icon">
                    <span class="iconfont">&#xe657;</span>
                </div>
                <span class="text">Settings</span>
            </a>
        </li>
    </ul>
</div>
<script src="js/scitpt.js"></script>
<a href="/inputselect">操作入库表信息</a>
<a href="/outputselect">操作出库表信息</a><br>
<a href="/selectAllPigeonhole.jsp">查看汇总表信息</a><br>
<a href="/warehousedeletebyid">查看总库存信息</a>
</body>
</html>
