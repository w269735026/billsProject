/**
 * Created by yaling.he on 2015/11/17.
 */

//供应商管理页面上点击删除按钮弹出删除框(providerList.html)
$(function () {
    $('.removeProvider').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeProv').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeProv').fadeOut();
    });
});


//订单管理页面上点击删除按钮弹出删除框(billList.html)
$(function () {
    $('.removeBill').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeBi').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeBi').fadeOut();
    });
});

//用户管理页面上点击删除按钮弹出删除框(userList.html)
$(function () {
    $('.removeUser').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeUse').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeUse').fadeOut();
    });
});

$(function () {
    $('.quit').click(function () {
        $('#exit').css('display', 'block');
        $('#qx').fadeIn();
    });
    $('#no2').click(function () {
        $('#exit').css('display', 'none');
        $('#qx').fadeOut();
    });
});

//通用提示语  save
$(function () {   
	var message=$("#message").val();
	if(message){
    	 $('#message').css('display', 'block');
         $('#qx2').fadeIn();
	}
	$('#no3').click(function () {
	    $('#message').css('display','none');
	    $('#qx2').fadeOut();
	});
});

//添加用户页面提示语
$(function () {   
	var mess=$("#addmessage").val();
	if(mess){
    	 $('#addsave').css('display', 'block');
         $('#qx2').fadeIn();
	}
	$('#no3').click(function () {
	    $('#message').css('display','none');
	    $('#qx2').fadeOut();
	});
});
//修改用户页面提示语
$(function () {   
	var mess=$("#updatemessage").val();
	if(mess){
    	 $('#updatesave').css('display', 'block');
         $('#qx2').fadeIn();
	}
	$('#no3').click(function () {
	    $('#message').css('display','none');
	    $('#qx2').fadeOut();
	});
});
