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

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.sessionUser.username }</span> , 欢迎你！</p>
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
            <span>账单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="${pageContext.request.contextPath }/wwl/insertDateController"  method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
               
                <div class="">
              	<!-- <input type="text" id="datepicker" name="date" size="30" onClick="WdatePicker()">  -->
                    <label for="billCom">日期：</label>
                    <label for="billName"></label>
                    <input type="text" name="date" id="date" onClick="WdatePicker()" readonly="readonly" required/>
                    <span>*</span>
                </div>
                  <div>
                    <label for="billCom">水电煤：</label>
                     <label for="billName">电费</label>
                    <input type="text" name="electricitybill" value="0" required/>
                    <span >*元</span>
                     <label for="billName">水费</label>
                    <input type="text" name="waterbill" id="waterBill" value="0"/>
                    <span >*</span>
                     <label for="billName">煤气费</label>
                    <input type="text" name="coalbill" id="coalBill" value="0" required/>
                    <span >*</span>
                </div>
                
                <div>
                    <label for="billName">生活用品：</label>
                    <label for="billName">价格</label>
                    <input type="text" name="lifegoods" value="0" required/>
                    <span >*元</span>
                     <label for="billName" >描述</label>
                    <input type="text" name="describes.lifegoodsdescribe" id="describe.lifeGoodsDescribe"  class="describe" required/>
                    <span >*</span>
                    
                </div>
              
                <div>
                    <label for="billNum">网上购物：</label>
                   <label for="billName">价格</label>
                    <input type="text" name="shoppingonline" value="0" required/>
                    <span >*元</span>
                     <label for="billName" >描述</label>
                    <input type="text" name="describes.shoppingonlinedescribe"  class="describe" required/>
                    <span >*描述</span>
                </div>
                <div>
                    <label for="money">其它：</label>
                    <label for="billName">价格</label>
                    <input type="text" name="other" value="0"  required/>
                    <span >*元</span>
                     <label for="billName" >描述</label>
                    <input type="text" name="describes.otherdescribe" id="otherDescribe" class="describe" />
                    <span >*描述</span>
                </div>
               <!--  <div>
                    <label >供应商：</label>
                    <select name="supplier" >
                        <option value="">--请选择相应的提供商--</option>
                        <option value="">北京市粮油总公司</option>
                        <option value="">邯郸市五得利面粉厂</option>

                    </select>
                    <span>*请选择供应商</span>
                </div>
                <div>
                    <label >是否付款：</label>
                    <input type="radio" name="zhifu"checked />未付款
                    <input type="radio" name="zhifu"/>已付款
                </div>  -->
                <div class="providerAddBtn">
                   <!--  <a href="#">保存</a>
                   <a href="billList.html">返回</a> -->
                    <input type="button" value="保存" id="save"/>
                    <a href="${pageContext.request.contextPath }/wwl/conditionSelectController">返回</a>
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
	            <a href="${pageContext.request.contextPath }/wwl/conditionSelectController" id="yes">确定</a>
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
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/js.js"></script>
<script src="${pageContext.request.contextPath }/js/time.js"></script>
<script src="${pageContext.request.contextPath }/js/billAdd.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/calendar/WdatePicker.js"></script>
</body>
</html>