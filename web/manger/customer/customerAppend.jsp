<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/5/3
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增客户</title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/jquery.easyui.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui/demo/demo.css"/>
    <script type="text/javascript">
        function submitForm(){
            $('#ff').submit();
        }
        function clearForm(){
            $('#ff').form('clear');
        }
    </script>
</head>
<body>
<div class="easyui-panel" title="New Topic" style="width:100%;max-width:400px;padding:30px 60px;">
    <form id="ff" method="post" action="/customerAppend.action">
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="name" style="width:100%" data-options="label:'名称:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="id_number" style="width:100%" data-options="label:'客户编号:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="gender" label="性别" style="width:100%">
                <option value="男">男</option>
                <option value="女">女</option>
                <option value="其他">其他</option>
            </select>
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="nation" style="width:100%" data-options="label:'民族:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="email" style="width:100%" data-options="label:'电子邮件:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="phone" style="width:100%" data-options="label:'手机:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="qq" style="width:100%" data-options="label:'qq:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="address" style="width:100%" data-options="label:'地址:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="bank_card_number" style="width:100%" data-options="label:'银行卡号:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="bank_of_deposite" style="width:100%" data-options="label:'具体银行:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="description" style="width:100%" data-options="label:'描述:',required:true">
        </div>
    </form>
    <div style="text-align:center;padding:5px 0">
        <%--<input type="submit" class="easyui-linkbutton" style="width: 80px" value="submit">--%>
        <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
    </div>
</div>
</body>
</html>