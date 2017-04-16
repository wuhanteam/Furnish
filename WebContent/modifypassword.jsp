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
<title>修改密码</title>
<script type="text/javascript" src="style_script/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="style_script/user.js"></script>
<script type="text/javascript">
		var time = 5;
		function modify(){
			var url = "<%=request.getContextPath()%>/UpdateUserPass.action";
			var userId = $("input[name='userId']").val();
			var passwd = $("input[name='passwd']").val();
			var repasswd = $("input[name='repasswd']").val();
			if(!userId.length>0){
				$("#sp").text("没有用户记录");
				return;
			}else if(!passwd==repasswd){
				$("#sp").text("两次密码输入不一致");
				return;
			}
			$("#sp").text("");
			$.ajax({
				type: "post",
				dataType: "json", 
				data:{"userId":userId,"passwd":passwd,"repasswd":repasswd},
				url:url,
				success: function(data) {     
		            if(data == 0)
		            {
		            	$("#sp").text("修改成功请重新登录");
		            	$(".submit").hide();
		            	$(".show").show();
		            	closeWindow();
		            }else{
		            	alert("修改失败！");
		            	return;
		            }    
		        },     
		        error: function(err) {     
		           alert("修改异常，请联系管理员！");    
		        }     
			});
			
		}
		function closeWindow(){
			window.setTimeout('closeWindow()',1000);  
        	if(time>0){  
        	document.getElementById("show").innerHTML=" 倒计时<font color=red>"+time+"</font>秒后关闭当前窗口";  
        	time--;  
        	}  
        	else{  
        	window.opener=null; //关闭窗口时不出现提示窗口  
        	window.close();  
        	}  
		}
		
</script>
</head>

<body>
	<div class="forgetwrapbg">
    	<div class="forgetbox">
        	<div class="forgetitle">修改密码</div>
        	<span style="color: red" id="sp">${msg}</span>
        	<input type="text" name="userId" value="${user.userId}" required="required">
        	<input class="forgetpass" type="password" name="passwd" value="请输入密码" required="required" onfocus="this.value=''" onblur="if(this.value==''){this.value=''}" />
            <input class="forgetpass"  type="password" name="repasswd" value="请确认密码" required="required" onfocus="this.value=''" onblur="if(this.value==''){this.value=''}" />
            <button type = "button" class="submit" onclick="modify()">修改</button>
        </div>
        <div id="show" style="display: none">  
			倒计时5秒后关闭当前窗口  
		</div>  
    </div>

</body>
</html>
