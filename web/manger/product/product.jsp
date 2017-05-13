<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/5/9
  Time: 11:21
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
                url: "/product.action",
                onLoadSuccess:function(){
                    $("#dg").datagrid("hideColumn", "id"); // 设置隐藏列
                }
            });
        });
        function removeit() {
            var row = $('#dg').datagrid('getSelected');
            if(row) {
//                alert(row.id);
                $.ajax('/productRemove.action', {
                    dataType: 'json',
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: JSON.stringify({id : row.id})
                }).done(function (data) {
                    $('#dg').datagrid('reload', data);
                });
            }
        }
        function detail() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
//                alert(row.id);
                $.ajax('/productDetail.action', {
                    dataType: 'json',
                    type: 'POST',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({id : row.id})
                }).done(function (data) {
                    $('#dl').datalist('load', data);
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
                self.location.href = "/productUpdate.action?id=" + row.id + "&name=" + row.name + "&number=" + row.number + "&money=" + row.money + "&description=" + row.description;
            }
        }

    </script>
</head>
<body>
<table id="dg" class="easyui-datagrid" title="产品管理" style="width:auto;height:auto">
    <thead>
    <tr>
        <th data-options="field:'id',width:80">ID</th>
        <th data-options="field:'name',width:80,">名称</th>
        <th data-options="field:'number',width:80,">产品号</th>
        <th data-options="field:'money',width:80,">价格</th>
        <th data-options="field:'description',width:80,">描述</th>
    </tr>
    </thead>
</table>
<div id="tb" style="height:auto">
    <a href="/productAppend.action"  target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">新增</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" onclick="update()">更新</a>
    <a href="javascript:void(0)" target="bottom" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="detail()">明细</a>
</div>
<div id="w" class="easyui-window" title="资源项信息" data-options="closed:true,iconCls:'icon-save'" style="width:500px;height:300px;padding:10px;">
    <div id="dl" class="easyui-datalist" style="width:450px;height:250px" data-options="groupField: 'group'"></div>
</div>
</body>
</html>
