<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/4/8
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="../css/hello.css"/>
    <script type="text/javascript" src="/js/jquery-easyui/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/jquery-easyui/jquery.easyui.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui/themes/icon.css"/>

    <script type="text/javascript" src="../js/index.js"></script>
    <script type="text/javascript">
        function firstTest(s) {
            $.ajax(s).done(function (data) {
                $('.asr').attr('src',data);
            }).fail(function () {
                alert("失败");
            });
        }
    </script>
</head>
<body>
<div class="main">

    <div class="title"></div>
    <%--菜单部分--%>
    <div class="smartbar">
        <div class="easyui-panel" style="padding: 5px;">
            <fn:forEach items="${firstList}" var="c">
                <a href="#" class="easyui-menubutton" data-options="menu:'#mm${c.text}'"> ${c.text}</a>
            </fn:forEach>
        </div>
        <fn:forEach var="entry" items="${menuMap}">
            <div id="mm${entry.key}" style="width:100px;">
                <fn:forEach var="b" items="${entry.value}">
                    <div><a href="${b.uri}"  target="bottom"> ${b.text}</a></div>
                </fn:forEach>
            </div>
        </fn:forEach>
    </div>
    <%--消息显示部分--%>
    <%--<iframe class="asr" src="${pageContext.request.contextPath}/manger/employee.jsp" frameborder="0" scrolling="no" width="100%" height="300px"></iframe>--%>
</div>
</body>
</html>
