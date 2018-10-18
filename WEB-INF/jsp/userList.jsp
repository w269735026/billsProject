<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
                    <li><a href="${pageContext.request.contextPath }/wwl/conditionSelectController/?pageNo=1">账单管理</a></li>
                    <li  id="active"><a href="${pageContext.request.contextPath }/wwl/limitUserList">用户管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/wwl/password">密码修改</a></li>
                    <li><a href="#" class="quit">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
                <span>用户名：</span>
                <input type="text" placeholder="请输入用户名" id="likeName" value="${param.str }"/>
                <input type="button" value="查询" id="like"/>
                <a href="${pageContext.request.contextPath }/wwl/userAdd">添加用户</a>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="15%">用户编码</th>
                    <th width="15%">用户名称</th>
                    <th width="15%">电话</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">用户类型</th>
                    <th width="30%">操作</th>
                </tr>
                <c:forEach items="${requestScope.listUser}" var="list" >
                <tr>
                    <td>${list.usercode}</td>
                    <td>${list.username}</td>
                    <td>${list.phone}</td>
                    <c:if test="${list.gender==2}">
                    <td>女</td>
                    </c:if>
                    <c:if test="${list.gender==1}">
                    <td>男</td>
                    </c:if>
                    <td>${list.age}</td>
                    <c:if test="${list.usertype==0}">
                    <td>管理员</td>
                    </c:if>
                     <c:if test="${list.usertype==1}">
                    <td>经理</td>
                    </c:if>
                     <c:if test="${list.usertype==2}">
                    <td>员工</td>
                    </c:if>
                    <td>
                        <a href="${pageContext.request.contextPath }/wwl/userById?userid=${list.userid}"><img src="${pageContext.request.contextPath }/img/read.png" alt="查看" title="查看" id="showUser"/></a>
                        <a href="${pageContext.request.contextPath }/wwl/userById?userid=${list.userid}&status=update"><img src="${pageContext.request.contextPath }/img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="#" class="removeUser"  ><img src="${pageContext.request.contextPath }/img/schu.png" alt="删除" title="删除" userid="${list.userid}" class="userid"/></a>
                    </td>
                </tr>
               </c:forEach>
            </table>
            <input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
             <a href="#" id="yes">确定</a> 
            <a href="#" id="no">取消</a>
        </div>
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
    <footer class="footer">
    </footer>

<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/js.js"></script>
<script src="${pageContext.request.contextPath }/js/time.js"></script>
<script src="${pageContext.request.contextPath }/js/userList.js"></script>
<script type="text/javascript">
/* 	function userId(o){
		alert(o.attributes["userid"].nodeValue)
	} */
</script>
</body>
</html>