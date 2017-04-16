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
<title>忘记密码</title>
<script type="text/javascript" src="style_script/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="style_script/jquery.md5.js"></script>
<script type="text/javascript" src="style_script/user.js"></script>
</head>

<body>
	<form action="<%=request.getContextPath()%>/FindUserPass.action" method="post">
	<div class="forgetwrapbg">
    	<div class="forgetbox">
        	<div class="forgetitle">找回密码</div>
        	<span style="color: red">${msg}</span>
        	<input class="frorgetEmail" name="email" value="邮箱" onfocus="this.value=''" onblur="if(this.value==''){this.value=''}" />
            <input class="forgetUserCode" name="userCode" value="工号" onfocus="this.value=''" onblur="if(this.value==''){this.value=''}" />
            <button type = "submit" class="submit">提交</button>
        </div>
    </div>
</form>


</body>
</html>
