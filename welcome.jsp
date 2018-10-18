<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<c:if test="${sessionScope.sessionUser.username !=null}">
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.sessionUser.username }</span> , 欢迎你！</p>
        <a href="#" class="quit">退出</a>
    </div>
</c:if>
<c:if test="${sessionScope.sessionUser.username ==null}">
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> 游客</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath }/login.jsp">请登录</a>
    </div>
</c:if>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="${pageContext.request.contextPath }/wwl/conditionSelectController">账单管理</a></li>
                <li><a href="${pageContext.request.contextPath }/wwl/limitUserList">用户管理</a></li>
                <li><a href="#" class="quit">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <img class="wColck" src="img/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${sessionScope.sessionUser.username }</h2>
            <p>欢迎来到生活账单管理系统!</p>
        </div>
    </div>
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
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/js.js"></script>
<script src="${pageContext.request.contextPath }/js/time.js"></script>
</body>
</html>