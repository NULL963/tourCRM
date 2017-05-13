<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/5/12
  Time: 19:26
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
    </script>
</head>
<body>
<div class="easyui-panel" title="New Topic" style="width:100%;max-width:400px;padding:30px 60px;">
    <form id="ff" method="post" action="/orderUpdate.action">

        <div style="margin-bottom:20px">
            <input name="id" type="hidden" value="${order.id}" data-options="required:true">
            <input class="easyui-textbox" name="number" value="${order.number}" style="width:100%" data-options="label:'订单号:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="money" value="${order.money}" style="width:100%" data-options="label:'价格:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="customer_number" value="${order.customer_number}" style="width:100%;height:60px" data-options="label:'对应客户数:'">
        </div>
        <div style="margin-bottom:20px">
            <select id="source" class="easyui-combobox" name="pay" label="是否付款" style="width:100%">
                <option value="true">是</option>
                <option value="false">否</option>
            </select>
        </div>
        <div style="margin-bottom:20px" id="payment">
            <select class="easyui-combobox" name="mode_of_payment" label="付款方式" style="width:100%">
                <option value="支付宝">支付宝</option>
                <option value="网银">网银</option>
                <option value="银行转账">银行转账</option>
                <option value="现金付款">现金付款</option>
            </select>
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-datebox" name="go_off_time" value="${order.go_off_time}" style="width:100%" data-options="label:'开始日期:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-datebox" name="end_time" value="${order.end_time}" style="width:100%" data-options="label:'结束日期:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="product_id" label="对应产品" style="width:100%">
                <fn:forEach items="${productList}" var="product">
                    <option value="${product.id}">${product.name}</option>
                </fn:forEach>
            </select>
        </div>
        <div style="margin-bottom:20px">
            <input id="cc1" class="easyui-combobox" name="customerSet.id" style="width:100%;" data-options="
					url:'/updateGetCustomer.action?id=${order.id}',
					method:'get',
					valueField:'id',
					textField:'text',
					multiple:true,
					panelHeight:'auto',
					label: '对应顾客:',
					labelPosition: 'top',
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
