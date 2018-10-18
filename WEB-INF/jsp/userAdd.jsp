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
        <a href="#" class="quit" >退出</a>
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
<section class="publicMian ">
     <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <%-- <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath }/wwl/conditionSelectController/?pageNo=1">账单管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath }/wwl/limitUserList">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/wwl/password">密码修改</a></li>
                <li><a href="#" class="quit" >退出系统</a></li>
            </ul>
        </nav> --%>
    </div> 
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="${pageContext.request.contextPath }/wwl/userAddController" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="userId">用户账号：</label>
                    <input type="text" name="usercode" id="userId" value="${param.usercode}" />
                    <c:if test="${requestScope.codeNot ==null }">
                    <span>*请输入用户账号，且不能重复</span>
                    </c:if>
                     <c:if test="${requestScope.codeNot !=null }">
                    <span style="color: red">${requestScope.codeNot }</span>
                    </c:if>
                   
                </div>
                <div>
                    <label for="username">用户名称：</label>
                    <input type="text" name="username" id="username" value="${param.username}" />
                    <c:if test="${requestScope.codeNot ==null }">
                    <span>*请输入用户账号，且不能重复</span>
                    </c:if>
                </div>
                 <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="phone" id="userphone" value="${param.phone}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userpassword">用户密码：</label>
                    <input type="text" name="password" id="password"/>
                     <c:if test="${requestScope.pwdNot ==null }">
                    <span>*密码长度必须大于6位小于20位</span>
                    </c:if>
                      <c:if test="${requestScope.pwdNot !=null }">
                    <span style="color: red">${requestScope.pwdNot }</span>
                    </c:if>

                </div>
                <div>
                    <label for="userRemi">确认密码：</label>
                    <input type="text" name="passwordRemi" id="passwordRemi"/>
                    <span>*请输入确认密码</span>
                </div>
                <div>
                    <label >用户性别：</label>

                    <select name="gender">
                     <c:if test="${param.gender==null}">
                        <option value="1" selected="selected" >男</option>
                        <option value="2">女</option>
                     </c:if>
                    <c:if test="${param.gender==1}">
                        <option value="1" selected="selected" >男</option>
                        <option value="2">女</option>
                     </c:if>
                     <c:if test="${param.gender==2}">
                        <option value="1"  >男</option>
                        <option value="2" selected="selected">女</option>
                     </c:if>
                    </select>
                    <span></span>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                     <input id="d12" type="text" name="userbirthdate" readonly="readonly" onclick="WdatePicker()" value="${param.userbirthdate}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">邮箱：</label>
                    <input type="text" name="mail" id="mail" value="${param.mail}" />
                </div>
                <div>
                    <label >用户类别：</label>
                     <c:if test="${param.usertype==null}">
                    <input type="radio" name="usertype" value="0"/>管理员
                    <input type="radio" name="usertype" value="1"/>经理
                    <input type="radio" name="usertype" value="2" checked="checked"/>普通用户
					</c:if>
					<c:if test="${param.usertype==0}">
					<input type="radio" name="usertype" value="0" checked="checked" />管理员
                    <input type="radio" name="usertype" value="1"/>经理
                    <input type="radio" name="usertype" value="2" checked="checked"/>普通用户
					</c:if>
					<c:if test="${param.usertype==1}">
					<input type="radio" name="usertype" value="0"/>管理员
                    <input type="radio" name="usertype" value="1" checked="checked" />经理
                    <input type="radio" name="usertype" value="2" />普通用户
					</c:if>
					<c:if test="${param.usertype==2}">
					<input type="radio" name="usertype" value="0"/>管理员
                    <input type="radio" name="usertype" value="1"/>经理
                    <input type="radio" name="usertype" value="2" checked="checked"/>普通用户
					</c:if>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="button" value="保存" id="save"/>
                    <a href="${pageContext.request.contextPath }/wwl/limitUserList">返回</a>
                </div>
            </form>
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
<input type="hidden" id="addmessage" value="${requestScope.message.status}">
<div id="addsave">
	<div class="remove" id="qx2">
	    <div class="removerChid">
	        <h2>提示</h2>
	        <div class="removeMain">
	            <p>${requestScope.message.message}</p>
	            <c:if test="${requestScope.message.status ==200}">
	            <a href="${pageContext.request.contextPath }/wwl/limitUserList" id="yes">确定</a>
	            </c:if>
	            <c:if test="${requestScope.message.status !=200}">
	            <a href="#" id="no3">确定</a> 
	            </c:if>
	        </div>
	    </div>
	</div>
</div>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath }/js/time.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/js.js"></script>
<script src="${pageContext.request.contextPath }/js/userAdd.js"></script>
<script src="${pageContext.request.contextPath }/calendar/WdatePicker.js"></script>
<script type="text/javascript">


</script>
</body>
</html>