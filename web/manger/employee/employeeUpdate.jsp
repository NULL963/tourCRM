<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/5/2
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>雇员更新</title>
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
    <form id="ff" method="post" action="/employeeUpdate.action">

        <div style="margin-bottom:20px">
            <input name="id" type="hidden" value="${vemployee.id}" data-options="required:true">
            <input class="easyui-textbox" name="name" value="${vemployee.name}" style="width:100%" data-options="label:'姓名:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="gender" label="性别" style="width:100%">
                <option value="男">男</option>
                <option value="女">女</option>
                <option value="其他">其他</option>
            </select>
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="email" value="${vemployee.email}" style="width:100%" data-options="label:'电子邮箱:' ">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="phone" value="${vemployee.phone}" style="width:100%" data-options="label:'手机号:' ">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="qq" value="${vemployee.qq}" style="width:100%" data-options="label:'QQ:' ">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-datebox" name="hiredate" value="${vemployee.hiredate}" style="width:100%" data-options="label:'雇佣日期:' ">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="salary" value="${vemployee.salary}" style="width:100%" data-options="label:'薪水:' ">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="job" value="${vemployee.job}" style="width:100%" data-options="label:'职位:' ">
        </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="department" label="所属部门" style="width:100%">
                <fn:forEach items="${deList}" var="de">
                    <option value="${de.id}">${de.name}</option>
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
