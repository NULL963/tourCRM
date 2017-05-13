<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/5/11
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
                url: "/order.action",
                onLoadSuccess:function(){
                    $("#dg").datagrid("hideColumn", "id"); // 设置隐藏列
                }
            });
        });
        function removeit() {
            var row = $('#dg').datagrid('getSelected');
            if(row) {
//                alert(row.id);
                $.ajax('/orderRemove.action', {
                    dataType: 'json',
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: JSON.stringify({id : row.id})
                }).done(function (data) {
                    $('#dg').datagrid("reload", data);
                });
            }
        }
        function detail() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
//                alert(row.id);
                $.ajax('/orderDetail.action', {
                    dataType: 'json',
                    type: 'POST',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({id : row.id})
                }).done(function (data) {
                    $('#dl').datalist('loadData', data);
                }).fail(function (xhr, status) {
                    alert('失败: ' + xhr.status + ', 原因: ' + status);
                });
                $('#w').window('open');
            }
        }
        function update() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
//                alert(row.name + row.employee);
                self.location.href = "/orderUpdate.action?id=" + row.id + "&number=" + row.number + "&conditions=" + row.conditions + "&money=" + row.money + "&pay=" + row.pay + "&mode_of_payment=" + row.mode_of_payment + "&customer_number=" + row.customer_number + "&go_off_time=" + row.go_off_time + "&end_time=" + row.end_time + "&employee_name=" + row.employee_name + "&product_number=" + row.product_number + "&group_number=" + row.group_number;
            }
        }

        function auditing() {
            var row = $('#dg').datagrid('getSelected');
            if(row) {
                $.ajax('/orderAuditing.action', {
                    dataType: 'json',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify({id : row.id})
                }).done(function (data) {
                    $('#dg').datagrid("reload", data);
                });
            }
        }

        function cancelIt() {
            var row = $('#dg').datagrid('getSelected');
            if(row) {
                $.ajax('/orderCancel.action', {
                    dataType: 'json',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify({id : row.id})
                }).done(function (data) {
                    $('#dg').datagrid("reload", data);
                });
            }
        }

    </script>
</head>
<body>
<table id="dg" class="easyui-datagrid" title="订单管理" style="width:auto;height:auto">
    <thead>
    <tr>
        <th data-options="field:'id',width:80">ID</th>
        <th data-options="field:'number',width:80,">产品号</th>
        <th data-options="field:'conditions',width:80,">订单状态</th>
        <th data-options="field:'money',width:80,">价格</th>
        <th data-options="field:'pay',width:80,">是否付款</th>
        <th data-options="field:'mode_of_payment',width:80,">付款方式</th>
        <th data-options="field:'customer_number',width:80,">顾客数量</th>
        <th data-options="field:'go_off_time',width:80,">订单开始时间</th>
        <th data-options="field:'end_time',width:80,">订单结束时间</th>
        <th data-options="field:'employee_name',width:80,">经办员工</th>
        <th data-options="field:'product_number',width:80,">对应产品</th>
        <th data-options="field:'group_number',width:80,">对应团</th>
    </tr>
    </thead>
</table>
<div id="tb" style="height:auto">
    <a href="/orderAppend.action"  target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">新增</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" onclick="update()">更新</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="detail()">明细</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="auditing()">审核</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="cancelIt()">作废</a>
</div>
<div id="w" class="easyui-window" title="订单对应客户" data-options="closed:true,iconCls:'icon-save'" style="width:500px;height:300px;padding:10px;">
    <div id="dl" class="easyui-datalist" style="width:450px;height:250px" data-options="groupField: 'group'"></div>
</div>
</body>
</html>