<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
<style>
    *{
        margin: 0px;
        padding: 0px;
    }
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 100vh;
        background: url(image/background.png) no-repeat;
        background-size: cover;
    }
    .All{
        border-radius: 20px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-content: center;
        width: 350px;
        height: 380px;
        border-top: 1px solid rgba(255,255,255,0.5);
        border-left: 1px solid rgba(255,255,255,0.5);
        border-bottom: 1px solid rgba(255,255,255,0.2);
        border-right: 1px solid rgba(255,255,255,0.2);
        backdrop-filter: blur(10px);
        background: rgba(50,50,50,0.3);
    }
    .Login{
        margin-left: 50px;
    }
    h2{
        color: rgba(255,255,255,0.9);
        margin-left: 70px;
        margin-bottom: 20px;
    }
    .input-box{
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: start;
        margin-bottom: 10px;
        width: 350px;
    }
    label {
        margin-bottom: 5px;
        color: rgba(255, 255, 255, 0.9);
        font-size: 13px;
        width: 80px;
    }
    .All .input-box > input {
        box-sizing: border-box;
        color: rgba(255, 255, 255, 0.9);
        font-size: 14px;
        height: 35px;
        width: 250px;
        background: rgba(255, 255, 255, 0.3);
        border: 1px solid rgba(255, 255, 255, 0.5);
        border-radius: 5px;
        transition: 0.2s;
        outline: none;
        padding: 0 10px;
        letter-spacing: 1px;
    }
    .All .input-box > input:focus {
        border: 1px solid rgba(255, 255, 255, 0.8);
    }
    .All .btn-box {
        width: 250px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: start;
        margin-left: -45px;
    }
    .All .btn-box > a {
        font-size: 14px;
        text-decoration: none;
        color: rgba(255, 255, 255, 0.9);
        transition: 0.2s;
        width: 250px;
        text-align: end;
    }
    .All .btn-box > a:hover {
        text-decoration: none;
        color: rgba(255, 255, 255, 0.9);
        transition: 0.2s;
    }
    .All .btn-box > div {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: start;
        margin-top: 20px;
    }
    .All .btn-box > div > button {
        width: 120px;
        height: 35px;
        border: 1px solid rgba(88, 86, 95, 0.8);
        color: rgba(255, 255, 255, 0.9);
        background: rgba(88, 86, 95, 0.5);
        border-radius: 5px;
        transition: 0.2s;
    }
    .All .btn-box >div >input{
        width: 120px;
        height: 35px;
        border: 1px solid rgba(88, 86, 95, 0.8);
        color: rgba(255, 255, 255, 0.9);
        background: rgba(88, 86, 95, 0.5);
        border-radius: 5px;
        transition: 0.2s;
        margin-right: 10px;
    }
    .All .btn-box > div > button:nth-of-type(2) {
        margin-left: 10px;
    }
    .All .btn-box > div > button:hover {
        border: 1px solid rgba(107, 106, 113, 0.8);
        background: rgba(107, 106, 113, 0.5);
    }
</style>
</head>
<body>
<%--<h2>欢迎使用材料管理系统</h2>--%>
<%--<a href="/inputselect">操作入库表信息</a><br>--%>
<%--<a href="/outputselect">操作出库表信息</a><br>--%>
<%--<a href="/selectAllPigeonhole.jsp">查看汇总表信息</a><br>--%>
<%--<a href="/warehousedeletebyid">查看总库存信息</a>--%>
<div class="All">
    <h2>装饰材料管理系统</h2>
    <form action="/login" method="post">
        <div class="Login">
            <div class="input-box">
                <label>用户名</label>
                <input type="text" name="username" class="admin">
            </div>
            <div class="input-box">
                <label>密码</label>
                <input type="password" name="password" class="pwd">
            </div>

            <div class="btn-box">
                <a href="#">忘记密码?</a>
                <div>
                    <input type="submit" value="登录" class="login">
                    <button class="registered">注册</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
