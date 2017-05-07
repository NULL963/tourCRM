<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/5/3
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户管理</title>
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
                url: "/customer.action",
                onLoadSuccess:function(){
                    $("#dg").datagrid("hideColumn", "id"); // 设置隐藏列
                }
            });
        });
        function removeit() {
            var row = $('#dg').datagrid('getSelected');
            if(row) {
//                alert(row.id);
                $.ajax('/customerRemove.action', {
                    dataType: 'json',
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: JSON.stringify({id : row.id})
                }).done(function (data) {
                    $('#dg').datagrid('loadData', data);
                });
            }
        }
        function update() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
//                alert(row.name + row.employee);
                self.location.href = "/customerUpdate.action?id=" + row.id + "&name=" + row.name + "&id_number=" + row.id_number + "&gender=" + row.gender + "&nation=" + row.nation + "&email=" + row.email + "&phone=" + row.phone + "&qq=" + row.qq + "&address=" + row.address + "&bank_card_number=" + row.bank_card_number + "&bank_of_deposit=" + row.bank_of_deposit + "&description=" + row.description;
            }
        }
    </script>
</head>
<body>
<table id="dg" class="easyui-datagrid" title="部门管理" style="width:auto;height:auto">
    <thead>
    <tr>
        <th data-options="field:'id',width:80">ID</th>
        <th data-options="field:'id_number',width:150,">客户号</th>
        <th data-options="field:'name',width:80,">姓名</th>
        <th data-options="field:'gender',width:80,">性别</th>
        <th data-options="field:'nation',width:80,">民族</th>
        <th data-options="field:'email',width:80,">电子邮件</th>
        <th data-options="field:'phone',width:80,">手机号</th>
        <th data-options="field:'qq',width:80,">qq</th>
        <th data-options="field:'address',width:80,">地址</th>
        <th data-options="field:'bank_card_number',width:150,">银行卡号</th>
        <th data-options="field:'bank_of_deposit',width:150,">银行</th>
        <th data-options="field:'description',width:150,">描述</th>
    </tr>
    </thead>
</table>
<div id="tb" style="height:auto">
    <a href="/customerAppend.action"  target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">新增</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" onclick="update()">更新</a>
</div>
</body>
</html>