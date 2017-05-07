<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/5/4
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>供应商管理</title>
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
                url: "/supplier.action",
                onLoadSuccess:function(){
                    $("#dg").datagrid("hideColumn", "id"); // 设置隐藏列
                }
            });
        });
        function removeit() {
            var row = $('#dg').datagrid('getSelected');
            if(row) {
//                alert(row.id);
                $.ajax('/supplierRemove.action', {
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
                self.location.href = "/supplierUpdate.action?id=" + row.id + "&name=" + row.name + "&type=" + row.type + "&address=" + row.address + "&bank_card_number=" + row.bank_card_number + "&bank_of_deposit=" + row.bank_of_deposit + "&phone=" + row.phone + "&email=" + row.email;
            }
        }
    </script>
</head>
<body>
<table id="dg" class="easyui-datagrid" title="部门管理" style="width:auto;height:auto">
    <thead>
    <tr>
        <th data-options="field:'id',width:80">ID</th>
        <th data-options="field:'name',width:80,">名称</th>
        <th data-options="field:'type',width:80,">类型</th>
        <th data-options="field:'address',width:80,">地址</th>
        <th data-options="field:'bank_card_number',width:80,">银行卡号</th>
        <th data-options="field:'bank_of_deposit',width:80,">具体银行</th>
        <th data-options="field:'email',width:80,">电子邮箱</th>
        <th data-options="field:'phone',width:80,">联系电话</th>
    </tr>
    </thead>
</table>
<div id="tb" style="height:auto">
    <a href="/supplierAppend.action"  target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">新增</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" onclick="update()">更新</a>
</div>
</body>
</html>
