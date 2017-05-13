<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/5/7
  Time: 8:37
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
                url: "/scenic_spot.action",
                onLoadSuccess:function(){
                    $("#dg").datagrid("hideColumn", "id"); // 设置隐藏列
                }
            });
        });
        function removeit() {
            var row = $('#dg').datagrid('getSelected');
            if(row) {
//                alert(row.id);
                $.ajax('/scenic_spotRemove.action', {
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
                self.location.href = "/scenic_spotUpdate.action?id=" + row.id + "&level=" + row.level + "&address=" + row.address + "&price=" + row.price + "&name=" + row.name + "&usable=" + row.usable;
            }
        }
    </script>
</head>
<body>
<table id="dg" class="easyui-datagrid" title="景点资源项管理" style="width:auto;height:auto">
    <thead>
    <tr>
        <th data-options="field:'id',width:80">ID</th>
        <th data-options="field:'name',width:80,">名称</th>
        <th data-options="field:'level',width:80,">等级</th>
        <th data-options="field:'price',width:80,">价格</th>
        <th data-options="field:'address',width:80,">地址</th>
        <th data-options="field:'usable',width:80,">是否可用</th>
    </tr>
    </thead>
</table>
<div id="tb" style="height:auto">
    <a href="/scenic_spotAppend.action"  target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">新增</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" onclick="update()">更新</a>
</div>
</body>
</html>
