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
                    <li id="active"><a href="${pageContext.request.contextPath }/wwl/conditionSelectController">账单管理</a></li>
                     <li><a href="${pageContext.request.contextPath }/wwl/limitUserList">用户管理</a></li>
                	<li><a href="#" class="quit">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>账单管理页面</span>
            </div>
            <div class="search">
                <span>开始时间：</span>
                <input type="text" name="startBirthdate" readonly="readonly" value="${param.startBirthdate}" onclick="WdatePicker()"/>
                <span>结束时间：</span>
                <input type="text" name="endBirthdate" readonly="readonly" value="${param.endBirthdate}" onclick="WdatePicker()"/>
                <input type="button" id="select2" value="查询消费"/><input type="button" id="show" value="23" hidden="false"/><br>
                <span>生活用品：</span>
                <input type="text" name="lifegoodsdescribe" value="${param.lifegoodsdescribe}"/>
                <span>网上购物：</span>
                <input type="text" name="shoppingonlinedescribe" value="${param.shoppingonlinedescribe }"/>
                <span>其它：</span>
                <input type="text" name="otherdescribe" value="${param.otherdescribe }"/>
                <input type="button" id="select" value="查询"/>
                <input type="button" id="select3" value="消费总额：${total}"/>
                <a href="${pageContext.request.contextPath}/wwl/billAdd">添加订单</a>
            </div>
            	
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                <th width="5%" rowspan="2">日期</th>
                  <th width="5%" colspan="3">水电煤</th>
                    <th width="20%"colspan="2">生活用品</th>
                    <th width="20%" colspan="2">网上购物</th>
                    <th width="20%" colspan="2">其它</th>
                    <th width="5%">创建者</th>
                    <th width="5%">创建时间</th>
                    <th width="5%">修改者</th>
                    <th width="5%">修改时间</th>
                    <th width="5%" rowspan="2">总计</th>
                    <th width="25%" rowspan="2">操作</th>
                </tr>
                 <tr class="firstTr">
                 	<th width="5%">水费</th>
                    <th width="5%">电费</th>
                    <th width="5%">煤气费</th>
                    <th width="10%">描述</th>
                    <th width="5%">价格</th>
                    <th width="10%">描述</th>
                    <th width="5%">价格</th>
                    <th width="10%">描述</th>
                    <th width="5%">价格</th>
                    <th width="5%">姓名</th>
                    <th width="5%">日期</th>
                    <th width="5%">姓名</th>
                    <th width="5%">日期</th>
                </tr>
        <c:forEach var="b" items="${requestScope.page.list}">
		<tr class="firstTr">
		<th><fmt:formatDate value="${b.date}" timeStyle="yyyy-MM-dd"/></th>
		<th>${b.waterbill}</th>
		<th >${b.electricitybill}</th>
		<th>${b.coalbill}</th>
		<th >${b.describes.lifegoodsdescribe }</th><!-- 描述 -->
		<th>${b.lifegoods}</th>
		<th >${b.describes.shoppingonlinedescribe }</th>
		<th>${b.shoppingonline}</th>
		<th>${b.describes.otherdescribe }</th>
		<th>${b.other}</th>
		<th >${b.creator}</th>
		<th><fmt:formatDate value="${b.cteatortime}" timeStyle="yyyy-MM-dd"/></th>
		<th>${b.modified}</th>
		<th><fmt:formatDate value="${b.modifiedtime}" timeStyle="yyyy-MM-dd"/></th>
		<!-- 取值后两位小数点，不格式化会有很多小数点 -->
		<th><fmt:formatNumber value="${b.waterbill+b.coalbill+b.other+b.shoppingonline+b.lifegoods+b.electricitybill}" pattern="#.00"/></th>
		
		 <td>
        <a href="${pageContext.request.contextPath }/wwl/selectBillsAnddescribesByBillsIdController?billsid=${b.billsid}"><img src="${pageContext.request.contextPath }/img/read.png" alt="查看" title="查看"/></a>

        <a href="${pageContext.request.contextPath }/wwl/selectBillsAnddescribesByBillsIdController?billsid=${b.billsid}&str=update"><img src="${pageContext.request.contextPath }/img/xiugai.png" alt="修改" title="修改"/></a>

        <a href="#" class="removeBill" billsid=${b.billsid }><img src="${pageContext.request.contextPath }/img/schu.png" alt="删除" title="删除"/></a>
         </td>
		</tr>
		</c:forEach>
            </table>
            <div>
            <input type="button" id="index" value="首页">
            <input type="hidden" id="firstPage" value="${page.firstPage }">
            <input type="button" id="up" value="上一页"> 
            <input type="hidden" id="prePage" value="${page.prePage }"> 
            <input type="button" id="down" value="下一页">
            <input type="hidden" id="nextPage" value="${page.nextPage }">
            <input type="button" id="endPage" value="最后一页"> 
            <input type="hidden" id="lastPage" value="${page.lastPage }"> 
                      总共<input type="button" value="${page.totalCount}">条数据、
                          共<input type="button" id="totalPage" value="${page.totalPage}">页，
                       当前第<input type="button" id="thisPage" value="${page.currentPage}">页
            	<input type="text" id="thisPage2" value="">
            </div>
        </div>
          
    </section>
<input type="hidden" id="path" value="${pageContext.request.contextPath}">
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
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
<script src="${pageContext.request.contextPath }/js/time.js"></script>
<script src="${pageContext.request.contextPath }/js/billsList.js"></script>
<script src="${pageContext.request.contextPath }/js/js.js"></script>
<script src="${pageContext.request.contextPath }/calendar/WdatePicker.js"></script>
</body>
</html>