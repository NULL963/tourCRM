<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/4/30
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增雇员</title>
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
<div class="easyui-panel" title="新雇员" style="width:100%;max-width:400px;padding:30px 60px;position: relative;">
        <form id="ff" method="post" action="/employeeAppend.action" style="width: 100%;margin: 0 auto">
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="name" style="width:100%" data-options="label:'姓名:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="gender" style="width:100%" data-options="label:'性别:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="email" style="width:100%" data-options="label:'Email:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="phone" style="width:100%" data-options="label:'手机号：:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="qq" style="width:100%" data-options="label:'qq::',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="hiredate" style="width:100%" data-options="label:'雇佣日期:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="salary" style="width:100%" data-options="label:'工资:'">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="job" style="width:100%" data-options="label:'职位:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="department" label="所属部门" style="width:100%">
                <fn:forEach items="${departmentList}" var="department">
                    <option value="${department.id}">${department.name}</option>
                </fn:forEach>
            </select>
            <%--<input type="hidden" name="">--%>
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
