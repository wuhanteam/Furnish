//等比自适应字体
//(function (){
//    document.addEventListener('DOMContentLoaded', function () {
//    var html = document.documentElement;
//    var windowWidth = html.clientWidth;
//    html.style.fontSize = windowWidth /1440*100 + 'px';
//    //设置html标签默认字体,注意放大了100倍 ，1px = 1/100rem px->rem 除以100
//    }, false);
//})();

//页面加载完成后执行
$(document).ready(function(){

    //商品列表全选，取消
    var check_btn =  $("#check_all,#check_all_2");//全选按钮

    check_btn.live("click",function(){
        var status = $(this).prop("checked");
        var pro_id = $("input[name='yyinfoId']"); 

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

 //产品列表，删除按钮提示
$(".close-btn,#fanhui").click(function(){
	$(this).parents(".modal1").css("display","none");
});

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
	    url: "services/DelYiyuanInfosServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	$(this).css("display","none");
	    	$(".modal1").css("display","none");
	    	if(data==0){
	    		alert("删除成功！");
	    		location.reload(false);	
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
	
});

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
		
	
});

 //产品列表，删除按钮提示
$(".close-btn,#fanhui,#queren").click(function(){
	$(this).parents(".modal2").css("display","none");
});
//弹出层
$("#chakan").click(function(){
	$(this).parents().siblings(".modal2").toggle();
});

//
$(".close-btn").click(function(){
	$(this).parents("."updateYyinfo"").css("display","none");
})

 // 新增
$("#queren3").click(function(){
	// $(this).parents(".modal3").css("display","none");
	
	// ajax 请求添加 管理员数据
	// var cusID = $("#cusID").val();
	var gsid = $("#gsid").val().trim();
	var gName = $("#gName").val().trim();
	var gDate = $("#gDate").val().trim();
	var gDetail = $("#gDetail").val().trim();
	var isExpire = $("#isExpire").val().trim();
	var gPrice = $("#gPrice").val().trim();
	var gIMG1 = $("#gIMG1").val().trim();
	var gIMG2 = $("#gIMG2").val().trim();
	var gIMG3 = $("#gIMG3").val().trim();
	var gNumber = $("#gNumber").val().trim();
	var gSYNumber = $("#gSYNumber").val().trim();
	
	
//	var params = {};
//	params.push("",);
	// 需要增加前台校验
	if(gsid == ""){
		alert("请输入产品分类ID");
		return;
	}else if(gName == ""){
		alert("请输入商品名称");
		return;
	}else if(gDate=="" ){
		alert("请输入商品上架日期，如20161212");
		return;
		
	}else if(gDetail == ""){
		alert("请输入商品详情");
		return;
	}else if(gPrice == ""){
		alert("请输入商品价格，如19.00");
		return;
	}else if(gNumber == ""){
		alert("请输入商品所属期号");
		return;
	}else if(gSYNumber == ""){
		alert("请输入商品购买剩余量");
		return;
	}
	
	$("#queren4").css("display","none");
	//alert("ajax");
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"gsid":gsid,"gName":gName,"gDate":gDate,"gDetail":gDetail,"isExpire":isExpire,
	    	"gPrice":gPrice,"gIMG1":gIMG1,"gIMG2":gIMG2,"gIMG3":gIMG3,"gNumber":gNumber,"gSYNumber":gSYNumber},
	    //方法所在页面和方法名      
	    url: "services/AddGoodsInfoServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	if(data == '2'){
	    		$("#queren3").css("display","block");
	    		alert("已有同名用户，请重新输入用户名");
	    	}else if(data == '-1'){
	    		$("#queren3").css("display","block");
		    	 $("#addGoodsInfo").css("display","none");
	    		alert("保存失败！");
	    	}else{
	    		$("#queren3").css("display","block");
		    	 $("#addGoodsInfo").css("display","none");
		    	 alert("保存成功！");
	    	}
	    	
	    },     
	    error: function(err) {  
	    	$("#queren3").css("display","block");
	    	$("#addGoodsInfo").css("display","none");	    	// $(this).parents(".modal3").css("display","none");
	       alert("保存失败！");    
	    }     
	}); 
	
	
})

//弹出层
$("#xinzeng").click(function(){
	$(this).parents().siblings("#addGoodsInfo").toggle();
})

//弹出层
$(".updategoods").click(function(){
	// $(this).parents().siblings(".modal4").toggle();
	var gid = $(this).parents("tr").find("input[name='pro_id']").val();
	alert(gid);
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"gid":gid},
	    //方法所在页面和方法名      
	    url: "services/QueryGoodsByIDServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	// 装填数据
	    	if(data == '-1'){
	    		alert("数据库异常，请稍后操作！");
	    	}else{
	    		console.log(data);
	    			    		
	    		$("#updategid").val(data.gid);
	    		$("#updategsid").val(data.gsid);
	    		$("#updategName").val(data.gName);
	    		$("#updategDate").val(data.gDate);
	    		$("#updategDetail").val(data.gDetail);
	    		$("#updateisExpire").val(data.isExpire);
	    		$("#updategPrice").val(data.gPrice);
	    		$("#updategIMG1").val(data.gIMG1);
	    		$("#updategIMG2").val(data.gIMG2);
	    		$("#updategIMG3").val(data.gIMG3);
	    		$("#updategNumber").val(data.gNumber);
	    		$("#updategSYNumber").val(data.gSYNumber);
	    		$("#updateGoodsInfo").css("display","block");
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
	// 隐藏确认按钮，避免重复提交
	
	var gid = $("#updategid").val().trim();
	var gsid = $("#updategsid").val().trim();
	var gName = $("#updategName").val().trim();
	var gDate = $("#updategDate").val().trim();
	var gDetail = $("#updategDetail").val().trim();
	var isExpire = $("#updateisExpire").val().trim();
	var gPrice = $("#updategPrice").val().trim();
	var gIMG1 = $("#updategIMG1").val().trim();
	var gIMG2 = $("#updategIMG2").val().trim();
	var gIMG3 = $("#updategIMG3").val().trim();
	var gNumber = $("#updategNumber").val().trim();
	var gSYNumber = $("#updategSYNumber").val().trim();
	
	
//	var params = {};
//	params.push("",);
	// 需要增加前台校验
	if(gsid == ""){
		alert("请输入产品分类ID");
		return;
	}else if(gName == ""){
		alert("请输入商品名称");
		return;
	}else if(gDate=="" ){
		alert("请输入商品上架日期，如20161212");
		return;
		
	}else if(gDetail == ""){
		alert("请输入商品详情");
		return;
	}else if(gPrice == ""){
		alert("请输入商品价格，如19.00");
		return;
	}else if(gNumber == ""){
		alert("请输入商品所属期号");
		return;
	}else if(gSYNumber == ""){
		alert("请输入商品购买剩余量");
		return;
	}
	
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"gid":gid,"gsid":gsid,"gName":gName,"gDate":gDate,"gDetail":gDetail,"isExpire":isExpire,
	    	"gPrice":gPrice,"gIMG1":gIMG1,"gIMG2":gIMG2,"gIMG3":gIMG3,"gNumber":gNumber,"gSYNumber":gSYNumber},
	    //方法所在页面和方法名      
	    url: "services/UpdateGoodsInfoServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	if(data == '0'){
	    		$("#queren4").css("display","block");
		    	 $("#updateGoodsInfo").css("display","none");
		    	 alert("修改成功！");
	    	}
	    	
	    },     
	    error: function(err) {  
	    	$("#queren4").css("display","block");
	    	// $(this).parents(".modal3").css("display","none");
	    	$("#updateGoodsInfo").css("display","none");
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
	
	
// 下架按钮JS

$(".xiajia").click(function(){
	var gid = $(this).parents("tr").find("input[name='yyinfoId']").val();
	alert(gid);
	// 调用ajax 
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"gid":gid},
	    //方法所在页面和方法名    
	    url: "services/DelYiyuanInfoServlet.action",     
	       
	    dataType: "json",     
	    success: function(data) {
	    	// 装填数据
	    	if(data == '0'){
	    		alert("该商品已下架！");
	    		location.reload(true);
	    	}else if(data == '0'){
	    		alert("该商品下架失败！");
	    	}else{
	    		console.log(data);
	    		alert("数据库异常，请稍后操作！");
	    		
	    	}
	    	
	    },     
	    error: function(err) {  
	       alert("上架失败！");    
	    }     
	}); 
});

//修改展现
$(".yyinfoModify").click(function(){
	var yyinfoId = $(this).parents("tr").find("input[name='yyinfoId']").val();
	// 调用ajax 
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"yyinfoId":yyinfoId},
	    //方法所在页面和方法名    
	    url: "services/QueryYiyuanInfoServlet.action",     
	    dataType: "json",     
	    success: function(data) {
	    	$(".updateYyinfo").show();
	    	console.info(data);
	    	$("input[name='updateyyid']").val(data.yID);
	    	$("input[name='updateQgrs']").val(data.qgNumber);
	    	$("input[name='updateQgsj']").val(data.qgNumber);
	    	$("input[name='updateQgsysj']").val(data.qgsyTime);
	    	$("input[name='updateJqr']").val(data.jqrNumber);
	    	$("input[name='updateparam']").val(data.params);
	    	if(data.isJQRZJ=='1'){
	    		$("input[name='updateisjiqirenzj']").eq(1).attr("checked","checked");
	    	}else{
	    		$("input[name='updateisjiqirenzj']").eq(0).attr("checked","checked");
	    	}
	    	//是否置顶
	    	if(data.isPagetop=='1'){
	    		$("input[name='updateiszd']").eq(1).attr("checked","checked");
	    	}else{
	    		$("input[name='updateiszd']").eq(0).attr("checked","checked");
	    	}
	    	if(data.recommcolumn=='1'){
	    		$("input[name='updateiszstj']").eq(1).attr("checked","checked");
	    	}else{
	    		$("input[name='updateiszstj']").eq(0).attr("checked","checked");
	    	}
	    	$("input[name='updateparam']").val(data.params);
	    },     
	    error: function(err) {  
	       alert("查询失败！");    
	    }     
	}); 
});

//修改确认
$("#updatequeren3").click(function(){
	var digitalPattern = new RegExp("^[0-9]*$");
	var qgrs = $("input[name='updateQgrs']").val();
	var qgsj = $("input[name='updateQgsj']").val();
	var sysj = $("input[name='updateQgsysj']").val();
	var Jqr = $("input[name='updateJqr']").val();
	var param = $("input[name='updateparam']").val();
	var isJqr = $("input[name='updateisjiqirenzj']").val();
	var iszd =  $("input[name='updateiszd']").val();
	var istj = $("input[name='updateiszstj']").val();
	
	if(!digitalPattern.test(qgrs)){
		alert("抢购人数只能为数字");
		return;
	}
	if(!qgsj.length>0){
		alert("抢购时间不能为空");
		return
	}
	if(!sysj.length>0){
		alert("抢购剩余时间不能为空");
		return
	}
	if(!digitalPattern.test(Jqr)){
		alert("机器人数只能为数字");
		return;
	}
	$("#updatequeren3").hide();
	//提交
	$.ajax({
		//要用post方式      
	    type: "post",
	    data: {"gid":gid,"qgrs":qgrs,"qgsj":qgsj,"Jqr":Jqr,"sysj":sysj,
	    	"param":param,"isJqr":isJqr,"iszd":iszd,"istj":istj},
	    //方法所在页面和方法名    
	    url: "services/MofifyYiyuanInfoServlet.action",     
	    dataType: "json",     
	    success: function(data) {
	    	// 装填数据
	    	if(data == '1'){
	    		alert("修改成功");
	    		location.reload(true);
	    	}else if(data == '0'){
	    		alert("修改失败！");
	    	}
	    	$("#updateYyinfo").hide();
	    	
	    },     
	    error: function(err) {  
	       alert("出错啦！");    
	    }     
	}); 
});
	

});//ready() end