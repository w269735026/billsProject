$(function(){
	
	var userid;
	//删除用户跳转后台操作
	$(".userid").on("click",function(){
		userid=$(this).attr("userid");  //获取到很多值后：获取当前的值
	})
	$("#yes").on("click",function(){
		$(this)[0].href=$("#path").val()+"/wwl/delectUserByIdController?userid="+userid;
		
	})
	
	//模糊查询操作跳转后台    wwl/selectLikeUsersController   预留分页值
	
	$("#like").on("click",function(){
		//用户输入的值
		var userValue=$("#likeName").val();
		window.location.href=$("#path").val()+"/wwl/limitUserList?username="+userValue;
	})
	
	
})