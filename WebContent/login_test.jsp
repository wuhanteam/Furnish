<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>后台管理系统</title>
	<meta charset="UTF-8">
   <link rel="stylesheet" type="text/css" href="/Furnish/page/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="/Furnish/page/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="/Furnish/page/Css/style.css" />
    <script type="text/javascript" src="/Furnish/page/Js/jquery.js"></script>
    <script type="text/javascript" src="/Furnish/page/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="/Furnish/page/Js/bootstrap.js"></script>
    <script type="text/javascript" src="/Furnish/page/Js/ckform.js"></script>
    <script type="text/javascript" src="/Furnish/page/Js/common.js"></script>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>  
</head>
<body>
<div class="container">

    <form class="form-signin" method="post" action="/Furnish/login.action">
        <h2 class="form-signin-heading">登录系统</h2>
        <input id="username" type="text" name="username" class="input-block-level" placeholder="账号">
        <input id="password" type="password" name="password" class="input-block-level" placeholder="密码">
        <span></span>
        <!-- <input type="text" name="verify" class="input-medium" placeholder="验证码"> -->
       
        <p><button id="submit" class="btn btn-large btn-primary" type="button" onclick="auth();">登录</button></p>
    </form>

</div>
</body>
<script type="text/javascript">
	/* $("#submit").click(function(){
		alert("1111");
		var userName = $("#username").val;
		var userPwd = $("#password").val;
		$.ajax({
			//要用post方式      
            type: "Post",
            data: {'userName':userName,'userPwd':userPwd},
            //方法所在页面和方法名      
            url: "/Furnish/login.action",     
            contentType: "application/json; charset=utf-8",     
            dataType: "json",     
            success: function(data) {     
                //返回的数据用data.d获取内容      
                alert(data.d);     
            },     
            error: function(err) {     
                alert(err);     
            }     
		})
	}); */
	
	function auth(){
		
		var userName = $("#username").val();
		var userPwd = $("#password").val();
		
		// 调用ajax请求
		$.ajax({
			//要用post方式      
            type: "Post",
            data: {"userName":userName,"userPwd":userPwd},
            //方法所在页面和方法名      
            url: "/Furnish/login.action",     
               
            dataType: "json",     
            success: function(data) {     
                if(data == 0)
                {
                	window.location.href="<%=request.getContextPath()%>/toMenuIndex.action?userName="+userName;
                }else{
                	alert("您输入的账号或密码不正确！");
                	return;
                }    
            },     
            error: function(err) {     
               alert("系统异常，请联系管理员！");    
            }     
		})
	}
	
	
</script>
</html>