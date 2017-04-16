//等比自适应字体
//(function (){
//    document.addEventListener('DOMContentLoaded', function () {
//    var html = document.documentElement;
//    var windowWidth = html.clientWidth;
//    html.style.fontSize = windowWidth /1440*100 + 'px';
//    //设置html标签默认字体,注意放大了100倍 ，1px = 1/100rem px->rem 除以100
//    }, false);
//})();
var email = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
var mobilePattern = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
var chinese = /^[u4E00-u9FA5]+$/;
//页面加载完成后执行
$(document).ready(function(){
    //商品列表全选，取消
    var check_btn =  $("#check_all,#check_all_2");//全选按钮

    check_btn.live("click",function(){
        var status = $(this).prop("checked");
        var pro_id = $("input[name='pro_id']"); 

        if(status==true){
            pro_id.each(function(i,ele){
                $(ele).prop("checked",true);
            });
            check_btn.prop("checked",true);//选择所有按钮
        }else{
            pro_id.each(function(i,ele){
                $(ele).prop("checked",false);
            });
            check_btn.prop("checked",false);
        }
    });
//用户列表新增,关闭
$(".close-btn").click(function(){
	$(this).parents(".modal3").css("display","none");
})  
 //产品列表，删除按钮提示
$(".close-btn,#fanhui").click(function(){
	$(this).parents(".modal1").css("display","none");
})

// 删除确认
$("#queren").click(function(){
	// 获取需要删除人员信息的ID
	var chk_value =[]; 
	console.log($(this).parents());
	$('input[name="pro_id"]:checked').each(function(){ 
		chk_value.push($(this).val()); 
	}); 
	
	// 调用删除接口
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"params":chk_value.toString()},
	    //方法所在页面和方法名      
	    url: "services/DelUserServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	$(this).css("display","none");
	    	$(".modal1").css("display","none");
	    	if(data==0){
	    		//alert("删除成功！");
	    		location.reload(true);	
	    	}else{
	    		alert("删除失败！");
	    	}
	    	
	    },     
	    error: function(err) {  
	    	$(this).css("display","none");
	       alert("删除失败！");    
	    }     
	}); 
	
	// $(this).parents(".modal1").css("display","none");
	
})

//弹出层  点击删除按钮
$(".del_pro").click(function(){
	var chk_value =[]; 
	$('input[name="pro_id"]:checked').each(function(){ 
		chk_value.push($(this).val()); 
	}); 
	
	// 删除前判断是否选定删除行
	if(chk_value.length>0){
		$(this).parents().siblings(".modal1").toggle();
	}else{
		alert("请选定需要删除行！");
	}
		
	
})

 //产品列表，删除按钮提示
$(".close-btn,#fanhui,#queren").click(function(){
	$(this).parents(".modal2").css("display","none");
})


function usecodePattern(a){
	var reg=/^[0-9a-zA-Z]*$/g;
   return reg.test(a);
}
//校验
$("#adduserinfo #addUserCode").blur(function (){
	var userCode = $(this).val();
	if(!usecodePattern(userCode)){
		alert("帐号只能是数字或字母");
	}
})


 // 新增提交
$("#queren3").click(function(){
	// $(this).parents(".modal3").css("display","none");
	// ajax 请求添加 管理员数据
	var userCode = $("#addUserCode").val();
	var userName = $("#addUserName").val();
	var passwd = $("#addUserPwd").val();
	var params = $("#addParams").val();
	var mobile = $("#addMobile").val();
	var email = $("#addEmail").val();
	if(!usecodePattern(userCode)){
		alert("帐号只能是数字或字母");
		$("#addUserCode").focus();
		$("#queren3").css("display","block");
		return;
	}
	if(!chinese.test(passwd)){
		alert("密码不能为中文");
		return;
	}
	if(!mobilePattern.test(mobile)){
		alert("手机号码输入不正确");
		return;
	}
	if(!email.test(email)){
		alert("邮箱输入不正确");
		return;
	}
	//避免重复提交隐藏
	$("#queren3").css("display","none");
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"userCode":userCode,"userName":userName,"passwd":passwd,"params":params,"mobile":mobile,"email":email},
	    //方法所在页面和方法名      
	    url: "services/AddUserInfoServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	if(data == '2'){
	    		$("#queren3").css("display","block");
	    		alert("已有同名用户，请重新输入用户名");
	    	}else if(data == '1'){
	    		$("#queren3").css("display","block");
		    	 $("#adduserinfo").css("display","none");
		    	 alert("保存成功！");
		    	 location.reload(true);	
	    	}else{
	    		$("#queren3").css("display","block");
		    	 $("#adduserinfo").css("display","none");
		    	 alert("保存失败！");
	    	}
	    	
	    	
	    },     
	    error: function(err) {  
	    	$("#queren3").css("display","block");
	    	// $(this).parents(".modal3").css("display","none");
	       alert("保存失败！");    
	    }     
	}); 
})

//查看弹出层
$("#chakan").click(function(){
	var userID = $(this).parents("tr").find("input[name='pro_id']").val();
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"userID":userID},
	    //方法所在页面和方法名      
	    url: "services/QueryUserInfoByIDServlet.action",     
	    dataType: "json",     
	    success: function(data) {
	    	// 装填数据
	    	if(data == '-1'){
	    		alert("数据库异常，请稍后操作！");
	    	}else{
	    		var userCode = data.userCode;
	    		var userName = data.userName;
	    		var userPwd = data.userPwd;
	    		var params1 = data.params1;
	    		var status = data.status;
	    		var lastLoginTime = data.lastLoginTime;
	    		var createTime = data.createTime;
	    		var email = data.email;
	    		var mobile = data.mobile;
	    		$("#lookUpUserCode").val(userCode);
	    		$("#lookUpUserName").val(userName);
	    		$("#lookUpUserPwd").val(userPwd);
	    		$("#lookUpUserStatus").val(status=="1"?"启用":"停用");
	    		$("#lookUpParams").val(params1);
	    		$("#lookUpCreatetime").val(createTime);
	    		$("#lookUpLastLoginTime").val(lastLoginTime);
	    		$("#lookUpMobile").val(mobile);
	    		$("#lookUpEmail").val(email);
	    		$("#lookUpUser").css("display","block");
	    	}
	    	
	    },     
	    error: function(err) {  
	    	$(this).css("display","block");
	    	// $(this).parents(".modal3").css("display","none");
	       alert("查看失败！");    
	    }     
	}); 
	//$(this).parents().siblings("#lookUpUser").toggle();
})

//新增用户新弹出层
$("#xinzengUser").click(function(){
	$(this).parents().siblings("#adduserinfo").toggle();
})

//更新用户信息弹出层
$(".updateuser").click(function(){
	var userID = $(this).parents("tr").find("input[name='pro_id']").val();
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"userID":userID},
	    //方法所在页面和方法名      
	    url: "services/QueryUserInfoByIDServlet.action",     
	    dataType: "json",     
	    success: function(data) {
	    	// 装填数据
	    	if(data == '-1'){
	    		alert("数据库异常，请稍后操作！");
	    	}else{
	    		var userName = data.userName;
	    		var useCode = data.userCode;
	    		var userPwd = data.userPwd;
	    		var params1 = data.params1;
	    		var mobile = data.mobile;
	    		var email = data.email;
	    		var status = data.status;
	    		$("#updateUserID").val(userID);
	    		$("#updateUserName").val(userName);
	    		$("#updateUserCode").val(useCode);
	    		$("#updateUserPwd").val(userPwd);
	    		$("#UpdateOldUserPwd").val(userPwd);
	    		$("#updateParams").val(params1);
	    		$("#updateMobile").val(mobile);
	    		$("#updateEmail").val(email);
	    		if(status==1){
	    			$("input[name='status']").eq(0).attr("checked",'checked');
	    		}else{
	    			$("input[name='status']").eq(1).attr("checked",'checked');
	    		}
	    		
	    		$("#updateuserinfo").css("display","block");
	    	}
	    	
	    },     
	    error: function(err) {  
	    	$(this).css("display","block");
	    	// $(this).parents(".modal3").css("display","none");
	       alert("修改失败！");    
	    }     
	}); 
	
})

$("#queren4").click(function(){
	var name = $("#updateUserName").val();
	var userPwd = $("#updateUserPwd").val();
	var oldUserPwd = $("#UpdateOldUserPwd").val();
	var param = $("#updateParams").val();
	var mobile = $("#updateMobile").val();
	var email = $("#updateEmail").val();
	var userID = $("#updateUserID").val();
	var status = $("input[name='status']").val();
	if(userPwd && userPwd.length==0){
		alert("密码不为空");
		return;
	}
	if(!chinese.test(passwd)){
		alert("密码不能为中文");
		return;
	}
	if(!mobilePattern.test(mobile)){
		alert("手机号码输入不正确");
		return;
	}
	if(!email.test(email)){
		alert("邮箱输入不正确");
		return;
	}
	// 隐藏确认按钮，避免重复提交
	$("#queren4").css("display","none");
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"userID":userID,"userName":name,"passwd":userPwd,
	    	   "oldUserPwd":oldUserPwd,"params":param,"mobile":mobile,
	    	   "email":email,"status":status},
	    //方法所在页面和方法名      
	    url: "services/UpdateUserInfoServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	if(data == '0'){
	    		$("#queren4").css("display","block");
		    	 $("#updateuserinfo").css("display","none");
		    	 location.reload(true);	
		    	 alert("修改成功！");
	    	}
	    	
	    },     
	    error: function(err) {  
	    	$("#queren4").css("display","block");
	    	// $(this).parents(".modal3").css("display","none");
	    	$("#updateuserinfo").css("display","none");
	       alert("修改失败！");    
	    }     
	}); 
})

    //产品列表，删除按钮提示
    //$(".del_pro").live("click",function(){
        //全选按钮
      //  var pro_id = $("input[name='pro_id']");
//
        //得到选择的产品id
    //    var pro_id_sec = [];
    //    pro_id.each(function(i,ele){
     //       if($(ele).prop("checked")==true){
     //           pro_id_sec.push($(ele).val());
     //       }
     //   });

     //   if(pro_id_sec.length<=0){
      //      alert("请选择要删除的产品!");
      //  }else{
   //         confirm("确认删除选择的"+pro_id_sec.length+"件商品吗?");
   //     }
 //   });
	
	

	

});//ready() end