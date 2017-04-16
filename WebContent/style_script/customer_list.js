//等比自适应字体
//(function (){
//    document.addEventListener('DOMContentLoaded', function () {
//    var html = document.documentElement;
//    var windowWidth = html.clientWidth;
//    html.style.fontSize = windowWidth /1440*100 + 'px';
//    //设置html标签默认字体,注意放大了100倍 ，1px = 1/100rem px->rem 除以100
//    }, false);
//})();
var mobilePattern = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
var digitalPattern = new RegExp("^[0-9]*$");
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

 //删除按钮提示
$(".close-btn,#fanhui").click(function(){
	$(this).parents(".modal1").css("display","none");
})
$(".close-btn").click(function(){
	$(this).parents(".modal3").css("display","none");
})
//新增客户信息新弹出层
$("#xinzeng").click(function(){
	$(this).parents().siblings("#addCusInfo").toggle();
})


// 删除确认
$("#queren").click(function(){
	alert("确认删除");
	
	// 获取需要删除人员信息的ID
	var chk_value =[]; 
	console.log($(this).parents());
	$('input[name="pro_id"]:checked').each(function(){ 
		alert($(this).val());
		chk_value.push($(this).val()); 
	}); 
	
	// 调用删除接口
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"params":chk_value.toString()},
	    //方法所在页面和方法名      
	    url: "services/DelCustomerServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	$(this).css("display","none");
	    	$(".modal1").css("display","none");
	    	if(data==0){
	    		alert("删除成功！");
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

 //删除按钮提示
$(".close-btn,#fanhui,#queren").click(function(){
	$(this).parents(".modal2").css("display","none");
})

//弹出层
$("#chakan").click(function(){
	$(this).parents().siblings(".modal2").toggle();
})


 // 新增弹出层
$("#queren3").click(function(){
	var cusName = $("#cusName").val().trim();
	var cusPwd = $("#cusPwd").val().trim();
	var ptName = $("#ptName").val().trim();
	var cusAddress = $("#cusAddress").val().trim();
	var qq = $("#qq").val().trim();
	var zhfbNum = $("#zhfbNum").val().trim();
	var phoneNum = $("#phoneNum").val().trim();
	var isJQR = $("input[name='isJQR']").val().trim();
	var yxbNum = $("#yxbNum").val().trim();
	var param1 = $("#param1").val().trim();
	var param2 = $("#param2").val().trim();

//	var params = {};
//	params.push("",);
	// TODO 需要增加前台校验
	if(cusName == ""){
		alert("请输入用户名！");
		return;
	}else if(cusPwd == ""){
		alert("请输入密码");
		return;
	}else if(!chinese.test(cusPwd)){
		alert("密码不能为中文");
		return
	}else if(qq.length>0 && !digitalPattern.test(qq)){
		alert("qq输入不正确");
		return;
	}
	else if(phoneNum.length>0 && !mobilePattern.test(phoneNum)){
			alert("手机号输入不正确");
			return;
	}else if(!digitalPattern.test(yxbNum)){
		alert("游戏币数量为数字");
		return;
	}else if(yxbNum == ""){
		yxbNum = "0";
	}
	
	$("#queren3").css("display","none");
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"cusName":cusName,"cusPwd":cusPwd,"ptName":ptName,"cusAddress":cusAddress,"qq":qq,
	    	"zhfbNum":zhfbNum,"phoneNum":phoneNum,"isJQR":isJQR,"yxbNum":yxbNum,"param1":param1,"param2":param2},
	    //方法所在页面和方法名      
	    url: "services/AddCustomerInfoServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	if(data == '2'){
	    		$("#queren3").css("display","block");
	    		alert("已有同名用户，请重新输入用户名");
	    	}else if(data == '-1'){
	    		$("#queren3").css("display","block");
		    	 $("#addCusInfo").css("display","none");
		    	 location.reload(true);
	    		 alert("保存失败！");
	    	}else{
	    		$("#queren3").css("display","block");
		    	 $("#addCusInfo").css("display","none");
		    	 location.reload(true);
		    	 alert("保存成功！");
	    	}
	    	
	    },     
	    error: function(err) {  
	    	$("#queren3").css("display","block");
	    	$("#addCusInfo").css("display","none");	    	// $(this).parents(".modal3").css("display","none");
	       alert("保存失败！");    
	    }     
	}); 
	
	
})


//更新弹出层
$(".updatecus").click(function(){
	// $(this).parents().siblings(".modal4").toggle();
	var cusID = $(this).parents("tr").find("input[name='pro_id']").val();
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"cusID":cusID},
	    //方法所在页面和方法名      
	    url: "services/QueryCusInfoByIDServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	// 装填数据
	    	if(data == '-1'){
	    		alert("数据库异常，请稍后操作！");
	    	}else{
	    		var cusName = data.cusName;
	    		var cusPwd = data.cusPwd;
	    		var ptName = data.ptName;
	    		var cusAddress = data.cusAddress;
	    		var qq = data.qq;
	    		var zhfbNum = data.zhfbNum;
	    		var phoneNum = data.phoneNum;
	    		var isJQR = data.isJQR;
	    		var yxbNum = data.yxbNum;
	    		var param1 = data.param1;
	    		var param2 = data.param2;
	    		
	    		$("#updatecusName").val(cusName);
	    		$("#updatecusPwd").val(cusPwd);
	    		$("#updateptName").val(ptName);
	    		$("#updatecusAddress").val(cusAddress);
	    		$("#updateqq").val(qq);
	    		$("#updatezhfbNum").val(zhfbNum);
	    		$("#updatephoneNum").val(phoneNum);
	    		$("#updateyxbNum").val(yxbNum);
	    		$("#updateparam1").val(param1);
	    		$("#updateparam2").val(param2);
	    		if(isJQR==0){
	    			$("input[name='updateisJQR']").eq(0).attr("checked",'checked');
	    		}else{
	    			$("input[name='updateisJQR']").eq(1).attr("checked",'checked');
	    		}
	    		
	    		
	    		$("#updateCusInfo").css("display","block");
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
	debugger;
	var cusName = $("#updatecusName").val().trim();
	var cusPwd = $("#updatecusPwd").val().trim();
	var ptName = $("#updateptName").val().trim();
	var cusAddress = $("#updatecusAddress").val().trim();
	var qq = $("#updateqq").val().trim();
	var zhfbNum = $("#updatezhfbNum").val().trim();
	var phoneNum = $("#updatephoneNum").val().trim();
	var isJQR = $("input[name='updateisJQR']").val().trim();
	var yxbNum = $("#updateyxbNum").val().trim();
	var param1 = $("#updateparam1").val().trim();
	var param2 = $("#updateparam2").val().trim();
	// TODO 需要增加前台校验
	if(cusName == ""){
		alert("请输入用户名！");
		return;
	}else if(cusPwd == ""){
		alert("请输入密码");
		return;
	}else if(!chinese.test(cusPwd)){
		alert("密码不能为中文");
		return
	}else if(qq.length>0 && !digitalPattern.test(qq)){
		alert("qq输入不正确");
		return;
	}else if(phoneNum.length>0 && !mobilePattern.test(phoneNum)){
			alert("手机号输入不正确");
			return;
	}else if(!digitalPattern.test(yxbNum)){
		alert("游戏币数量为数字");
		return;
	}else if(yxbNum == ""){
		yxbNum = "0";
	}
	
	// 隐藏确认按钮，避免重复提交
	$("#queren4").hide();
	
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"cusName":cusName,"cusPwd":cusPwd,"ptName":ptName,"cusAddress":cusAddress,"qq":qq,
	    	"zhfbNum":zhfbNum,"phoneNum":phoneNum,"isJQR":isJQR,"yxbNum":yxbNum,"param1":param1,"param2":param2},
	    //方法所在页面和方法名      
	    url: "services/UpdateCusInfoServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	if(data == '0'){
	    		$("#queren4").css("display","block");
		    	 $("#updateCusInfo").css("display","none");
		    	 location.reload(true);
		    	 alert("修改成功！");
	    	}
	    	
	    },     
	    error: function(err) {  
	    	$("#queren4").css("display","block");
	    	// $(this).parents(".modal3").css("display","none");
	    	$("#updateCusInfo").css("display","none");
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