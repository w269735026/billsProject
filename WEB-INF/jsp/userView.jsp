<%@ page pageEncoding="UTF-8"  contentType="text/html; charset=utf-8"%>
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
        <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.sessionUser.username }</span> , 欢迎你！</p>
        <%-- <a href="${pageContext.request.contextPath }/wwl/removeSession">退出</a> --%>
        <a href="#" class="quit">退出</a>
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
        <%-- <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath }/wwl/conditionSelectController/?pageNo=1">账单管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath }/wwl/limitUserList">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/wwl/skipUpdatePassword">密码修改</a></li>
                <li><a href="#" class="quit" >退出系统</a></li>
            </ul>
        </nav> --%>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${requestScope.user.usercode }</span></p>
            <p><strong>用户名称：</strong><span>${requestScope.user.username }</span></p>
            <p><strong>用户性别：</strong>
            <c:if test="${requestScope.user.gender==2}"><span>女</span></c:if>
            <c:if test="${requestScope.user.gender==1}"><span>男</span></c:if>
            </p>
            <p><strong>出生日期：</strong><span><fmt:formatDate value="${requestScope.user.userbirthdate }" timeStyle="yyyy-MM-dd"/></span></p>
            <p><strong>用户电话：</strong><span>${requestScope.user.phone }</span></p>
            <p><strong>用户邮箱：</strong><span>${requestScope.user.mail }</span></p>
            <p><strong>用户类别：</strong>
            <c:if test="${requestScope.user.usertype==0 }"><span>系统管理员</span></c:if>
            <c:if test="${requestScope.user.usertype==1 }"><span>经理</span></c:if>
            <c:if test="${requestScope.user.usertype==2 }"><span>员工</span></c:if>
            </p>
            <a href="${pageContext.request.contextPath }/wwl/limitUserList">返回</a>
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