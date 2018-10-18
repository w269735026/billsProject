$(function(){
	//获取页面的值
	var path=$("#path").val();
	var lifegoodsdescribe=$("input[name=lifegoodsdescribe]");
	var startBirthdate=$("input[name=startBirthdate]");
	var shoppingonlinedescribe=$("input[name=shoppingonlinedescribe]");
	var endBirthdate=$("input[name=endBirthdate]");
	var otherdescribe=$("input[name=otherdescribe]");
	var billsid; //获取订单号
	$(".removeBill").on("click",function(){
		billsid=$(this).attr("billsid");
	})
	var page=$("#thisPage").val(); //当前页
	var totalPage=$("#totalPage").val(); //共几页
	var firstPage=$("#firstPage").val(); //首页
	var prePage=$("#prePage").val(); //上一页
	var nextPage=$("#nextPage").val(); //下一页
	var lastPage=$("#lastPage").val(); //最后一页
	/**
	 * 删除订单
	 */
	$("#yes").on("click",function(){
		this.href=path+"/wwl/deleteBillsAndDescribeController?billsid="+billsid;
	})
	
	/**
	 * 条件查询
	 */
	$("#select").on("click",function(){
		window.location.href=path+"/wwl/conditionSelectController?" +
				"startBirthdate="+startBirthdate.val()+"&endBirthdate="+endBirthdate.val()+"&lifegoodsdescribe="+lifegoodsdescribe.val()+"&otherdescribe="+otherdescribe.val()+"&shoppingonlinedescribe="+shoppingonlinedescribe.val()+"&pageNo=1";
	})
	
	/**
	 * 条件查询消费
	 */
	$("#select2").on("click",function(){
		var str=$("#show");
		$.get(path+"/wwl/conditionSelectTotalController?" +
				"startBirthdate="+startBirthdate.val()+"&endBirthdate="+endBirthdate.val()+"&lifegoodsdescribe="+lifegoodsdescribe.val()+"&otherdescribe="+otherdescribe.val()+"&shoppingonlinedescribe="+shoppingonlinedescribe.val()+"&pageNo=1",
		function(data){
			str.val(data);
			str.show();
		})
	})
	/**
	 * 页面 上一页，下一页等操作
	 * 需要注意地方：首页  上一页   下一页 进行点击了都会进入服务器，然后服务器又重新刷新了网页，所以会造成：js的成员变量又变成默认值
	 * 解决方法：取页面上的值，页面值是由jsp的 param域获取
	 */
	
	$("#index").on("click",function(){
		window.location.href=path+"/wwl/conditionSelectController?" +
		"startBirthdate="+startBirthdate.val()+"&endBirthdate="+endBirthdate.val()+"&lifegoodsdescribe="+lifegoodsdescribe.val()
		+"&otherdescribe="+otherdescribe.val()+"&shoppingonlinedescribe="+shoppingonlinedescribe.val()+"&pageNo="+firstPage;
	})
	$("#up").on("click",function(){
		window.location.href=path+"/wwl/conditionSelectController?" +
		"startBirthdate="+startBirthdate.val()+"&endBirthdate="+endBirthdate.val()+"&lifegoodsdescribe="+lifegoodsdescribe.val()
		+"&otherdescribe="+otherdescribe.val()+"&shoppingonlinedescribe="+shoppingonlinedescribe.val()+"&pageNo="+prePage;
	})
	$("#down").on("click",function(){
		window.location.href=path+"/wwl/conditionSelectController?" +
		"startBirthdate="+startBirthdate.val()+"&endBirthdate="+endBirthdate.val()+"&lifegoodsdescribe="+lifegoodsdescribe.val()
		+"&otherdescribe="+otherdescribe.val()+"&shoppingonlinedescribe="+shoppingonlinedescribe.val()+"&pageNo="+nextPage;
	})
	$("#endPage").on("click",function(){
		window.location.href=path+"/wwl/conditionSelectController?" +
		"startBirthdate="+startBirthdate.val()+"&endBirthdate="+endBirthdate.val()+"&lifegoodsdescribe="+lifegoodsdescribe.val()
		+"&otherdescribe="+otherdescribe.val()+"&shoppingonlinedescribe="+shoppingonlinedescribe.val()+"&pageNo="+lastPage;
	})
	
	//输入数字进行跳转
	$("#thisPage2").change(function(){
		thisPage=this.value; //变回Dom对象了
		if(isNaN(thisPage)){
			alert("请输入数字！");
			this.value="";
			//this.focus();获取焦点，，没用
			return;
		}
		if(this.value>lastPage){
			thisPage=lastPage;
		}
		window.location.href=path+"/wwl/conditionSelectController?" +
		"startBirthdate="+startBirthdate.val()+"&endBirthdate="+endBirthdate.val()+"&lifegoodsdescribe="+lifegoodsdescribe.val()
		+"&otherdescribe="+otherdescribe.val()+"&shoppingonlinedescribe="+shoppingonlinedescribe.val()+"&pageNo="+thisPage;
	})
	
	
	
})