<%@ include file="/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1,user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">	
<!--<link href="style_css/media.css" type="text/css" rel="stylesheet">
--><link href="style_css/basic.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="style_css/my-app.css">
<title>登录页</title>
<script type="text/javascript" src="style_script/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="style_script/jquery.md5.js"></script>
<script type="text/javascript" src="style_script/user.js"></script>
<script type="text/javascript">
function auth(){
	var username =  $("#userName").val().trim();
	var userpwd =  $("#userPwd").val().trim();
	if(username == null || username == ""){
		
		alert("用户名不能为空！");
		return false;
	}
	if(userpwd == null || userpwd == ""){
		alert("密码不能为空！");
		return false;
	}
	
	// 调用ajax请求
	/* $.ajax({
		//要用post方式      
        type: "post",
        data: {"userName":username,"userPwd":userpwd},
        //方法所在页面和方法名      
        url: "${cxt}/login.action",     
           
        dataType: "json",     
        success: function(data) {     
            if(data == 0)
            {
            	//alert(data);
            	// window.location.href="${cxt}/toMenuIndex.action?userName="+userName;
            }else{
            	alert("您输入的账号或密码不正确！");
            	return;
            }    
        },     
        error: function(err) {     
           alert("系统异常，请联系管理员！");    
        }     
	}); */
		
	
}
function forgetPass(){
	window.open("${ctx}/forgetpassword.jsp","_blank");
}
 
</script>
</head>



<body>

	<div class="wrapbg">
    	<div class="loginbox">
        	<div class="logintitle">一元购OA办公系统</div>
        	<form id="form" name="form" method="post" action="<%=request.getContextPath()%>/login.action">
        	<input class="loginname" id="userName" name="userCode" value="请输入用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='请输入用户名'}" />
            <input class="loginpassword" type="password" id="userPwd" name="userPwd" value="请输入密码" onfocus="this.value=''" onblur="if(this.value==''){this.value='请输入密码'}" />
            <span style="color: red">${failreason}</span>
            <div class="rem"><input name="rememberMe" type="checkbox" value="0" onclick="this.value=(this.value==0)?1:0"/>记住密码</div>
            <div class="login" id="loginBnt" onclick="javascript:form.submit();">登录</div>
            <div class="for" onclick="forgetPass()">忘记密码</div>
            </form>
        </div>
    
    </div>



</body>

</html>
