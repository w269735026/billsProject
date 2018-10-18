<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table style="width:100%;heigh:100%; " border="10" >
		<tr><th rowspan="2">日期</th><th colspan="3">水电煤</th><th colspan="2">生活用品</th><th colspan="2">网上购物</th><th colspan="2">其它</th><th>创建者</th><th>创建时间</th><th>修改者</th><th>修改时间</th><th rowspan="2">总计</th></tr>
		<tr><th>水费</th><th >电费</th><th>煤气费</th><th >描述</th><th>价格</th><th >描述</th><th>价格</th><th >描述</th><th>价格</th><th >姓名</th><th>日期</th><th>姓名</th><th>日期</th></tr>
		<c:forEach var="b" items="${requestScope.billsList}">
		<tr><th><fmt:formatDate value="${b.date}" timeStyle="yyyy-MM-dd"/></th><th>${b.waterBill}</th><th >${b.electricityBill}</th><th>${b.coalBill}</th><th >描述</th><th>${b.lifeGoods}</th><th >描述</th><th>${ b.shoppingOnline}</th><th>描述</th><th>${b.other}</th><th >${ b.creator}</th><th><fmt:formatDate value="${b.cteatorTime}" timeStyle="yyyy-MM-dd"/></th><th>${ b.modified}</th><th><fmt:formatDate value="${b.modifiedTime}" timeStyle="yyyy-MM-dd"/></th><th></th></tr>
		</c:forEach>
	</table>
</body>
</html>