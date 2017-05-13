<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/5/9
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core" %>
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
        function submitForm(){
            $('#ff').submit();
        }
        function clearForm(){
            $('#ff').form('clear');
        }

        var cindex = 0;
        var findex = 0;
        var sindex = 0;

    </script>
</head>
<body>
<div class="easyui-panel" title="新增产品" style="width:100%;max-width:400px;padding:30px 60px;">
    <form id="ff" method="post" action="/productAppend.action">
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="name" style="width:100%" data-options="label:'名称:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="money" style="width:100%" data-options="label:'价格:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="number" style="width:100%" data-options="label:'产品号:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="description" style="width:100%;height:60px" data-options="label:'描述:',multiline:true">
        </div>
        <%--<div style="margin-bottom:20px">--%>
            <%--<select class="easyui-combobox" name="usable" label="是否可用" style="width:100%">--%>
                <%--<option value="true">是</option>--%>
                <%--<option value="false">否</option>--%>
            <%--</select>--%>
        <%--</div>--%>

        <div style="margin-bottom:20px">
        <input id="cc1" class="easyui-combobox" name="accommodationSet.id" style="width:100%;" data-options="
					url:'/getAccommodation.action',
					method:'get',
					valueField:'id',
					textField:'text',
					multiple:true,
					panelHeight:'auto',
					label: '住宿资源项:',
					labelPosition: 'top',
					">
    </div>
        <div style="margin-bottom:20px">
            <input class="easyui-combobox" name="foodSet.id" style="width:100%;" data-options="
					url:'/getFood.action',
					method:'get',
					valueField:'id',
					textField:'text',
					multiple:true,
					panelHeight:'auto',
					label: '餐饮资源项:',
					labelPosition: 'top'
					">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-combobox" name="spotSet.id" style="width:100%;" data-options="
					url:'/getSpot.action',
					method:'get',
					valueField:'id',
					textField:'text',
					multiple:true,
					panelHeight:'auto',
					label: '景点资源项:',
					labelPosition: 'top'
					">
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