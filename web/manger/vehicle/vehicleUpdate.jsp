<%--
  Created by IntelliJ IDEA.
  User: LEMON
  Date: 2017/5/6
  Time: 14:58
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
    <form id="ff" method="post" action="/vehicleUpdate.action">

        <div style="margin-bottom:20px">
            <input name="id" type="hidden" value="${vehicle.id}" data-options="required:true">
            <input class="easyui-textbox" name="plate_number" value="${vehicle.plate_number}" style="width:100%" data-options="label:'车牌号:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="price" value="${vehicle.price}" style="width:100%" data-options="label:'价格:' ">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="seat_number" value="${vehicle.seat_number}" style="width:100%" data-options="label:'座位数:' ">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="brand_model" value="${vehicle.brand_model}" style="width:100%" data-options="label:'品牌型号:' ">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-datebox" name="enable_date" value="${vehicle.enable_date}" style="width:100%" data-options="label:'启用日期:' ">
        </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="usable" label="是否可用" style="width:100%">
                <option value="true">是</option>
                <option value="false">否</option>
            </select>
        </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="supplier_id" label="供应商" style="width:100%">
                <fn:forEach items="${list}" var="supplier">
                    <option value="${supplier.id}">${supplier.name}</option>
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
