<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/4/17
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css"/>

</head>
<body>
<div class="homePageSignIn">
    <div class="title">
        <h1>旅游公司</h1>
        <h3>客户关系管理系统</h3>
    </div>
    <div class="lolita">
        <form method="post" action="/login.action">
            <div class="group_input">
                <div ><input class="input_wrapper" type="text" name="name" aria-label="用户名" placeholder="用户名"/></div>
                <div ><input class="input_wrapper" type="password" name="password" aria-label="密码" placeholder="密码"/></div>
                <div><input type="hidden" name="password-real"/></div>
            </div>
            <div>
                <font color="#fff"><button  class="sign_button" type="submit">登陆</button></font>
            </div>
        </form>
    </div>
</div>
</body>
</html>
