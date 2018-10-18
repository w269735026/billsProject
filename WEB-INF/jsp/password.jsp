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
<body >
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
   <input id="message" type="hidden" value="${requestScope.result.message }">
<!--主体内容-->
    <section class="publicMian ">
        <div class="left">
            <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
           <%--  <nav>
                <ul class="list">
                    <li><a href="${pageContext.request.contextPath }/wwl/conditionSelectController/?pageNo=1">账单管理</a></li>
                    <li><a href="${pageContext.request.contextPath }/wwl/limitUserList">用户管理</a></li>
                    <li id="active"><a href="${pageContext.request.contextPath}/wwl/password">密码修改</a></li>
                    <li><a href="#" class="quit" >退出系统</a></li>
                </ul>
            </nav> --%>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>密码修改页面</span>
            </div>
             
            <div class="providerAdd">
                <form action="${pageContext.request.contextPath}/wwl/updatePasswordController" method="post">
                    <!--div的class 为error是验证错误，ok是验证成功-->
                    <div class="">
                        <label for="oldPassword">旧密码：</label>
                        <input type="password" name="oldPassword" id="oldPwd" required/>
                        <span>*请输入原密码  ${pwdNo }</span>
                    </div>
                    <div>
                        <label for="newPassword">新密码：</label>
                        <input type="password" name="newPassword" id="newPwd" required/>
                        <span >*请输入新密码</span>
                    </div>
                    <div>
                        <label for="reNewPassword">确认新密码：</label>
                        <input type="password" name="reNewPassword" id="reNewPwd" required/>
                        <span >*请输入新确认密码，保证和新密码一致</span>
                    </div>
                    <div class="providerAddBtn">
                        <!--<a href="#">保存</a>-->
                        <input type="button" value="保存" id="save"/><span style="color:green;size: 15px" >${yes}</span>
                        <a href="${pageContext.request.contextPath }/wwl/limitUserList">返回</a>
                    </div>
                </form>
            </div>
        </div>
    </section>
<div id="exit">
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
</div>
<div id="message">
	<div class="remove" id="qx2">
	    <div class="removerChid">
	        <h2>提示</h2>
	        <div class="removeMain">
	            <p>${requestScope.result.message }</p>
	             <%-- <a href="${pageContext.request.contextPath }/wwl/removeSession" id="yes">确定</a>  --%>
	            <a href="#" id="no3">取消</a>
	        </div>
	    </div>
	</div>
</div>
    <footer class="footer">
    </footer>
<script src="${pageContext.request.contextPath }/js/time.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/js.js"></script>
<script src="${pageContext.request.contextPath }/js/userUpdate.js"></script>
<script src="${pageContext.request.contextPath }/js/password.js"></script>
</body>
</html>