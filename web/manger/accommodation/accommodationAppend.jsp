<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/5/6
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/jquery.min.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/jquery.easyui.min.js"
            charset="UTF-8"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/js/jquery-easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui/demo/demo.css"/>
    <script type="text/javascript">
        function submitForm() {
            $('#ff').submit();
        }
        function clearForm() {
            $('#ff').form('clear');
        }
    </script>
</head>
<body>
<div class="easyui-panel" title="新增住宿项" style="width:100%;max-width:400px;padding:30px 60px;">
    <form id="ff" method="post" action="/accommodationAppend.action">
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="level" label="等级" style="width:100%">
                <option value="普通">普通</option>
                <option value="一星">一星</option>
                <option value="二星">二星</option>
                <option value="三星">三星</option>
                <option value="四星">四星</option>
                <option value="五星">五星</option>
                <option value="白金五星">白金五星</option>
            </select>
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="address" style="width:100%" data-options="label:'地址:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="price" style="width:100%" data-options="label:'价格:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="rome_type" label="房间类型" style="width:100%">
                <option value="单人间">单人间</option>
                <option value="标准间">标准间</option>
                <option value="商务间">商务间</option>
                <option value="豪华间">豪华间</option>
                <option value="行政间">行政间</option>
                <option value="套间">套间</option>
                <option value="双套间">双套间</option>
                <option value="组合套间">组合套间</option>
                <option value="多套间">多套间</option>
                <option value="高级套间">高级套间</option>
                <option value="复式套间">复式套间</option>
            </select>
        </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="usable" label="是否可用" style="width:100%">
                <option value="true">是</option>
                <option value="false">否</option>
            </select>
        </div>

        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="supplier_id" label="供应商" style="width:100%">
                <fn:forEach items="${list}" var="supplier">
                    <option value="${supplier.id}">${supplier.name}</option>
                </fn:forEach>
            </select>
        </div>
    </form>
    <div style="text-align:center;padding:5px 0">
        <%--<input type="submit" class="easyui-linkbutton" style="width: 80px" value="submit">--%>
        <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" onclick="submitForm()"
           style="width:80px">Submit</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
    </div>
</div>
</body>
</html>
