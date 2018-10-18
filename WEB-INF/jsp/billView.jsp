<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>生活账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>生活账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.sessionUser.username}</span> , 欢迎你！</p>
        <a href="#" class="quit" >退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li id="active"><a href="${pageContext.request.contextPath }/wwl/conditionSelectController/?pageNo=1">账单管理</a></li>
                <li><a href="${pageContext.request.contextPath }/wwl/limitUserList">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/wwl/skipUpdatePassword">密码修改</a></li>
                <li><a href="#" class="quit" >退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>日期：</strong><strong>日期：</strong><span><fmt:formatDate value="${requestScope.bills.date }" timeStyle="yyyy-MM-dd"/></span></p>
            <p><strong>水电煤：</strong>
            <strong>水费：</strong><span>${requestScope.bills.waterbill }</span>
            <strong>电费：</strong><span>${requestScope.bills.electricitybill }</span>
            <strong>煤气费：</strong><span>${requestScope.bills.coalbill }</span>
            </p>
            <p><strong>生活用品：</strong>
            <strong>价格：</strong><span>${requestScope.bills.lifegoods }</span>
            <strong>描述：</strong><span>${requestScope.bills.describes.lifegoodsdescribe }</span>
            </p>
            <p><strong>网上购物：</strong>
             <strong>价格：</strong><span>${requestScopebills.shoppingonline }</span>
            <strong>描述：</strong><span>${requestScope.bills.describes.shoppingonlinedescribe }</span>
            </p>
            <p><strong>其它：</strong>
             <strong>价格：</strong><span>${requestScope.bills.other }</span>
            <strong>描述：</strong><span>${requestScope.bills.describes.otherdescribe }</span>
            </p>
            <p><strong>今天总金额：</strong><strong></strong><span>${requestScope.describe.bills.electricityBill }</span></p>
            <p><strong>今天描述：</strong><strong></strong><span>${requestScope.describe.bills.electricityBill }</span></p>
          <!--   <p><strong>是否付款：</strong><span>未付款</span></p> -->

            <a href="${pageContext.request.contextPath }/wwl/conditionSelectController/?pageNo=1">返回</a>
        </div>
    </div>
</section>
<div id="exit"></div>
<div class="remove" id="qx">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要退出吗？</p>
             <a href="${pageContext.request.contextPath }/wwl/removeSession" id="yes">确定</a> 
            <a href="#" id="no2">取消</a>
        </div>
    </div>
</div>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/js.js"></script>
<script src="${pageContext.request.contextPath }/js/time.js"></script>

</body>
</html>