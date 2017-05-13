<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/4/30
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/jquery.easyui.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui/demo/demo.css"/>

    <script type="text/javascript">
        $(function ($) {
            $('#dg').datagrid({
                iconCls: 'icon-edit',
                singleSelect: true,
                toolbar: '#tb',
                method: 'get',
                url: "/employee.action",
                onLoadSuccess:function(){
                    $("#dg").datagrid("hideColumn", "id"); // 设置隐藏列
                }
            });
        });
        function removeit() {
            var row = $('#dg').datagrid('getSelected');
            if(row) {
                $.ajax('/employeeRemove.action', {
                    dataType: 'json',
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: JSON.stringify({id : row.id})
                }).done(function (data) {
                    $('#dg').datagrid('reload', data);
                });
            }
        }
        function update() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
//                alert(row.name + row.employee);
                self.location.href = "/employeeUpdate.action?id=" + row.id + "&name=" + row.name + "&gender=" + row.gender + "&email=" + row.email + "&phone=" + row.phone + "&qq=" + row.qq + "&hiredate=" + row.hiredate + "&salary=" + row.salary + "&job=" + row.job + "&department=" + row.department;
            }
        }
    </script>
</head>
<body>
<table id="dg" class="easyui-datagrid" title="雇员管理" style="width:auto;height:auto">
    <thead>
    <tr>
        <th data-options="field:'id',width:80">ID</th>
        <th data-options="field:'name',width:80,">姓名</th>
        <th data-options="field:'gender',width:80">性别</th>
        <th data-options="field:'email',width:200">Email</th>
        <th data-options="field:'phone',width:150">手机号</th>
        <th data-options="field:'qq',width:150">qq</th>
        <th data-options="field:'hiredate',width:80">雇佣日期</th>
        <th data-options="field:'salary',width:80">工资</th>
        <th data-options="field:'job',width:80">职位</th>
        <th data-options="field:'department',width:80">所属部门</th>
    </tr>
    </thead>
</table>
<div id="tb" style="height:auto">
    <a href="/employeeAppend.action"  target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">新增</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" onclick="update()">更新</a>
</div>
</body>
</html>
