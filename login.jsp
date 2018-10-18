<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
  </head>
  
  <body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>生活账单明细管理系统</h1>
        </header>
        <section class="loginCont">
            <form class="loginForm" action="${pageContext.request.contextPath}/login" method="post">
           		<input id="status" type="hidden" value="${requestScope.error.status }">
           		<input id="message" type="hidden" value="${requestScope.error.message }">
                <div class="inputbox">
                    <label for="user">用户名：</label>
                    <input id="user" type="text" name="phone" placeholder="请输入手机号码" required/>
                </div>
                <div class="inputbox">
                    <label for="mima">密码：</label>
                    <input id="mima" type="password" name="password" placeholder="请输入密码" required/>
                </div>
                <div class="subBtn">
                    <input type="submit" value="登录" />
                    <input type="reset" value="重置"/>
                </div>
			
            </form>
        </section>
    </section>
<div id="message">
	<div class="remove" id="qx2">
	    <div class="removerChid">
	        <h2>提示</h2>
	        <div class="removeMain">
	            <p>${requestScope.error.message }</p>
	             <%-- <a href="${pageContext.request.contextPath }/wwl/removeSession" id="yes">确定</a>  --%>
	            <a href="#" id="no3">取消</a>
	        </div>
	    </div>
	</div>
</div>
</body>
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/js.js"></script>

</html>
